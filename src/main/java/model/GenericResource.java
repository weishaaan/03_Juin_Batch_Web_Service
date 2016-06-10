package model;

import model.Batch;
import model.BatchService;
import model.Test_property;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import javax.management.monitor.Monitor;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.JAXBException;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.eclipse.jetty.server.Request;
import static org.glassfish.jersey.server.model.Parameter.Source.PATH;
import com.google.gson.Gson;
import java.util.ArrayList;

@Path("home")
public class GenericResource {
    
    BatchService batchService;
    Test_property r = new Test_property();  
    MessageService messageService = new MessageService();  
    private static Logger logger = Logger.getLogger(BatchService.class);
    QuartzTrigger trigger = new QuartzTrigger();
    
    public GenericResource() throws JAXBException, IOException, XmlException {
        this.batchService = new BatchService();
    }
    
  
    /***************************TEXT PLAIN**************************************/
    @POST
    @Path("code")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Batch postBatchByCode(@PathParam("code") String code) throws XmlException, IOException{
        System.out.println("input code of Batch file is " + code);
        
        return batchService.getBatch(code);
    }  
    
    /*************************** JSON **************************************/
    @GET
    @Path("getOneBatch/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Batch getBatchByCode(@PathParam("code") String code)throws IOException, XmlException{
        return batchService.getBatch(code);
    }
    
    @GET
    @Path("getAllBatch")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Batch> getAllBatch() throws IOException{
        return batchService.getAllBatches();
    }
    @POST
    @Path("postMessage")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Message> postMessage(Message message) throws IOException{
        messageService.addMessage(message);
        return messageService.getAllMessagges();
    }
    @GET
    @Path("Batch")
    @Produces(MediaType.TEXT_PLAIN)
    public String doGetBat(){            
        //r.createProperties();        
        String filepath = r.readProperties("test");
        //System.out.println(filepath);
        String result = r.runBatFile(filepath);                        
	return result + " ! it works!!! ";      
    }
    
    @POST
    @Path("runBatch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String runBat(Batch batch){            
        //r.createProperties();     
        
        try {
            batch = batchService.getBatch("08M");
            
        } catch (XmlException ex) {
            java.util.logging.Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
            logger.error("Wrong, can't $POST successfully to web service."); 
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
            logger.error("Wrong, can't $POST successfully to web service.");  
        }
            String filepath = r.readProperties("text");
            String result = r.runBatFile(filepath);
            
            logger.info("Run batch file successsfully!");
            logger.info("The batch code is: "+ batch.code + ".");
            logger.info("This batch file doesn't have any params.");
            logger.info("The running result is: "+ result + ".");
            
            return    "Run batch, and the result is : "+result; 
    }
        
    @POST
    @Path("postBatchParam")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postBatchParam(List<ParamPost> paramPosts){    
        
        Batch btc= new Batch();
        
        try {
            btc = batchService.getBatch(paramPosts.get(0).paramCode);
                
        } catch (XmlException ex) {
            java.util.logging.Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
            logger.error("Wrong, can't get the batch file."); 
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
            logger.error("Wrong, can't get the batch file"); 
        }
        
        Gson gson = new Gson();
        String paramPostList = gson.toJson(paramPosts);
        
        logger.info("Successfully $POST params to web service!");
        logger.info("The batch code is " + btc.code);
        logger.info("Those params are: "+ paramPostList); 

        System.out.println("Successfully $POST params to web service!");
        System.out.println("The batch code is " + paramPosts.get(0).paramCode);
        System.out.println("web service receives list (in Json format): " + paramPostList);

        for(int j = 1 ;j< paramPosts.size(); j++){
            System.out.println("paramPosts.get(j).paramPostValue :" + paramPosts.get(j).paramPostValue);
            btc.getInput().getParams().get(j-1).setDEFAULTVALUE(paramPosts.get(j).paramPostValue);
        }
                

        return  "Post succesfully! the changed default value is :"+ btc.getInput().getParams().get(0).DEFAULTVALUE;  
        
    }
    
    @GET
    @Path("quartz")
    @Produces(MediaType.TEXT_PLAIN)
    public String doQuartzTrigger(){           
        try {
            trigger.QuartzTrigger();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	return "Quartz works!!! ";      
    }
    
    @POST
    @Path("postTestBatchParam")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postNameRunBat(List<ParamPost> paramPosts){    
        
        Batch btc= new Batch();
        
        try {
            btc = batchService.getBatch(paramPosts.get(0).paramCode);
                
        } catch (XmlException ex) {
            java.util.logging.Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
            logger.error("Wrong, can't get the batch file."); 
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
            logger.error("Wrong, can't get the batch file"); 
        }
        
        Gson gson = new Gson();
        String paramPostList = gson.toJson(paramPosts);
        
        logger.info("Successfully $POST params to web service!");
        logger.info("The batch code is " + btc.code);
        logger.info("Those params are: "+ paramPostList); 

        System.out.println("Successfully $POST params to web service!");
        System.out.println("The batch code is " + paramPosts.get(0).paramCode);
        System.out.println("web service receives list (in Json format): " + paramPostList);

        for(int j = 1 ;j< paramPosts.size(); j++){
            System.out.println("paramPosts.get(j).paramPostValue :" + paramPosts.get(j).paramPostValue);
            btc.getInput().getParams().get(j-1).setDEFAULTVALUE(paramPosts.get(j).paramPostValue);
        }
        
        String filepath = r.readProperties("batch_name.bat");
        System.out.println(filepath);
        filepath = filepath +"  \"" + btc.getInput().getParams().get(0).DEFAULTVALUE + "\"" ;
        String result = r.runBatFile(filepath);                        
	return  result ; 

        //return  "Post succesfully! the changed default value is :"+ btc.getInput().getParams().get(0).DEFAULTVALUE;  
        
    }
    
}
    
    
 

