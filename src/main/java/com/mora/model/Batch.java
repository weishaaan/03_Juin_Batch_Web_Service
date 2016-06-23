package com.mora.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"code", "name", "description", "output", "input","category"})
public class Batch {
    String code;
    String name;
    String description;
    String output;
    String category;
    Input input;
    Map<String,Param> paralist;

    public Batch(String code, String name, String description, String output, Input input,String category) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.output = output;
        this.input = input;
        this.category = category;
    }
    

    public Batch() {
    }


    public void setParalist(Map<String, Param> paralist) {
        this.paralist = paralist;
    }
    
    @XmlElement(name = "CODE")
    public String getCode() {
        return code;
    }

    @XmlElement(name = "NAME")
    public String getName() {
        return name;
    }

    @XmlElement(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @XmlElement(name = "OUTPUT")
    public String getOutput() {
        return output;
    }

    @XmlElement(name = "INPUT")
    public Input getInput() {
        return input;
    }
    
    @XmlElement(name = "CATEGORY")
    public String getCategory() {
        return category;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    

}
