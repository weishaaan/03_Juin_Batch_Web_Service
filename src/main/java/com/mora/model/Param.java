package com.mora.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class Param {

    public String PARAMNAME;
    public String DEFAULTVALUE;
    public String LABEL;
    public String INPUTVALUE;
    
    public Param(String PARAMNAME, String DEFAULTVALUE, String LABEL) {
        this.PARAMNAME = PARAMNAME;
        this.DEFAULTVALUE = DEFAULTVALUE;
        this.LABEL = LABEL;
    }

    public Param() {
    }

    /* we dont need this, if we include this, 
     this will give twice variable in out output.
    
     @XmlElement(name = "PARAMNAME")
     public String getParamName() {
     return PARAMNAME;
     }
     @XmlElement(name = "DEFAULTVALUE")
     public String getParamDefaultValue(){
     return DEFAULTVALUE;
     }
     @XmlElement(name = "LABEL")
     public String getParamLabel() {
     return LABEL;
     }
     */
    public void setPARAMNAME(String PARAMNAME) {
        this.PARAMNAME = PARAMNAME;
    }

    public void setDEFAULTVALUE(String DEFAULTVALUE) {
        this.DEFAULTVALUE = DEFAULTVALUE;
    }

    public void setLABEL(String LABEL) {
        this.LABEL = LABEL;
    }
}
