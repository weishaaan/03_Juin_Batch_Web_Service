package com.mora.model;

import com.mora.model.Batch;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "CATALOG")
@XmlAccessorType (XmlAccessType.FIELD)
public class Batches{
    @XmlElement(name = "BATCH")
    private List<Batch> batches = null;

    public List<Batch> getBatches() {
        return batches;
    }
 
    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }
}
