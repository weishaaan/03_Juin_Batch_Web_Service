package model;

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

public class BatchService {

    private Map<Long, Batch> catalogue = BatchDatabase.getBatches();

    public BatchService() throws XmlException, IOException, JAXBException {

        Marshall m = new Marshall();
        Batches batches = m.unmarshaller();

        for (int i = 0; i < batches.getBatches().size(); i++) {
            Batch batch = batches.getBatches().get(i);
            catalogue.put(Long.valueOf(i), batch);
        }
    }

    public List<Batch> getAllBatches() {
        return new ArrayList<Batch>(catalogue.values());
    }

    public Batch getBatch(String code) throws XmlException, IOException {
        List<Batch> bts = new ArrayList<Batch>(catalogue.values());
        for (int i = 0; i < bts.size(); i++) {
            Batch batch_ = bts.get(i);
            if ((batch_.getCode()).equals(code)) {
                return batch_;
            }
        }
        return null;
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
