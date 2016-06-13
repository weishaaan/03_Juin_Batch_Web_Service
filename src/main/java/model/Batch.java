package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"code", "name", "description", "output", "input"})
public class Batch {
    String code;
    String name;
    String description;
    String output;
    Input input;
    
    public Batch(String code, String name, String description, String output, Input input) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.output = output;
        this.input = input;
    }

    public Batch() {
    }

    public HashMap paramList(String code, List<Param> param){
        HashMap<String, List<Param>> map = new HashMap<String, List<Param>>();
        map.put(code, param);
        
        return map;
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

}
