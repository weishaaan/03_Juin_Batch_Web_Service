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
import java.util.List;
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
import org.apache.xmlbeans.XmlException;
import org.eclipse.jetty.server.Request;
import static org.glassfish.jersey.server.model.Parameter.Source.PATH;

@Path("home")
public class GenericResource {
    
    BatchService batchService;
    Test_property r = new Test_property();  

    public GenericResource() throws JAXBException, IOException, XmlException {
        this.batchService = new BatchService();
    }

    
    /*
    
    @GET
    @Produces(MediaType.APPLICATION_XML) //MediaType.APPLICATION_XML
    public List<Message> getMessages(){
        return messageService.getAllMessagges();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId){
        return messageService.getMessage(messageId);
    }
    
    
*/
   
  /*  
    @PUT
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Message updateMessage(@PathParam("messageId") long messageId,Message message){
        message.setId(messageId);
        return messageService.updateMessage(message);
    }
    
    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message delectMessage(@PathParam("messageId") long messageId){
        return messageService.removeMessage(messageId);
    }
  
    
    @OPTIONS
    public Response getOptions() {
      return Response.ok()
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
        .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
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
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBatchByCode(){
        return "2:51pm";
    }
    
    @GET
    @Path("getAllBatch")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Batch> getAllBatch() throws IOException{
        return batchService.getAllBatches();
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
    public String runBat(Batch batch) throws XmlException, IOException{            
        //r.createProperties();     
        System.out.println("input code of Batch file is " + batch.code);
        Batch bbatch = batchService.getBatch("08M");
        
        String filepath = r.readProperties("text");
        //System.out.println(filepath);
        String result = r.runBatFile(filepath);
	return    "run batch, then get the result is : "+result;       
   }
    
    
}
    
    
 

