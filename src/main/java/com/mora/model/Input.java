package com.mora.model;

import com.mora.model.Param;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

public class Input {

    private List<Param> params = null;
    
    public Input(List<Param> params){
        this.params = params;
    }
    
    public Input(){
        
    }
       
    @XmlElement(name = "PARAM")
    public List<Param> getParams() {
        return params;
    }
    
    public void setParams(List<Param> params) {
        this.params = params;
    }
}
