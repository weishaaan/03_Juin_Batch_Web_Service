package com.mora.model;

import com.mora.model.Batch;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.xmlbeans.XmlException;
import org.apache.log4j.Logger;

public class BatchService {

    private Map<String, Batch> catalogue = BatchDatabase.getBatches();
    
    private static Logger logger = Logger.getLogger(BatchService.class);
    
    public BatchService() throws XmlException, IOException, JAXBException {

        Marshall m = new Marshall();
        Batches batches = m.unmarshaller();
        

        for (int i = 0; i < batches.getBatches().size(); i++) {
            
            Batch batch = batches.getBatches().get(i);
            catalogue.put(batch.getCode(), batch);
            
            Map<String,Param> pl = new HashMap();
            
            if(batch.input.getParams() != null){
                for(int j = 0; j < batch.input.getParams().size();j++){
                    Param param = batch.input.getParams().get(j);
                    String paramName = param.PARAMNAME;
                    pl.put(paramName, param);
                }
            }
            catalogue.get(batch.getCode()).setParalist(pl);
        }
        
        //logger.info("Batch file info have been saved from Marshaller");
        
    }

    

    /*
     public List<Batch> addBatch(Batch batch){
     catalogue.put(Long.valueOf(batch.getCode()), batch);
     return new ArrayList<Batch>(catalogue.values());
     }
    
     public List<Batch> removeBatch(String code){
     catalogue.remove(Long.valueOf(code));     
     return new ArrayList<Batch>(catalogue.values());
     }
     */
}
