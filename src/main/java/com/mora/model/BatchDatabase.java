package com.mora.model;

import java.io.IOException;
import java.util.ArrayList;
import com.mora.model.Batch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlException;

public class BatchDatabase {
    private static Map<String,Batch> catalogue = new HashMap<String,Batch>();

    public static Map<String,Batch> getBatches(){
        return catalogue;
    }
    
    public List<Batch> getAllBatches() {
        
        //logger.info("successfully get all batch files");
        
        return new ArrayList<Batch>(catalogue.values());
        
    }

    public Batch getBatch(String code) throws XmlException, IOException {
        Batch b = catalogue.get(code);
        
        if(b!= null)
            return b;
        else 
            return null;
    }
}
