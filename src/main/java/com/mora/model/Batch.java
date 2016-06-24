package com.mora.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"code", "name", "description", "output", "input","category","frequency","batpath"})
public class Batch {
    String code;
    String name;
    String description;
    String output;
    String category;
    String frequency;
    String batpath;
    Input input;
    Map<String,Param> paralist;

    public Batch(String code, String name, String description, String output, Input input,String category,String frequency,String batpath) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.output = output;
        this.input = input;
        this.category = category;
        this.frequency = frequency;
        this.batpath = batpath;
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
    
    @XmlElement(name = "FREQUENCY")
    public String getFrequency() {
        return frequency;
    }

    @XmlElement(name = "BATPATH")
    public String getBatpath() {
        return batpath;
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

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setBatpath(String batpath) {
        this.batpath = batpath;
    }
    
    
    
}
