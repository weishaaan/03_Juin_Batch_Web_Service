package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class ParamPost {
    public String paramCode;
    public String paramPostValue;

    public ParamPost() {
    }

    public ParamPost(String paramCode, String paramPostValue) {
        this.paramCode = paramCode;
        this.paramPostValue = paramPostValue;
    }
    
}
