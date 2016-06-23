/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mora.model;

import com.mora.model.Input;
import com.mora.model.Param;
import com.mora.model.Batches;
import com.mora.model.Batch;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author LizSHAN
 */
public class Marshall {

    static Batches batches = new Batches();
    
    static {
        batches.setBatches(new ArrayList<Batch>());

        Batch bth1 = new Batch();
        bth1.setCode("1");
        bth1.setName("1");
        bth1.setDescription("1");
        bth1.setOutput("1");
        Param p1 = new Param("1","1","1");
        Param p2 = new Param("2","2","2");
        Param p3 = new Param("3","3","3");
        Input input1 = new Input();
        Input input2 = new Input();
        List<Param> list1 = new ArrayList<Param>();
        List<Param> list2 = new ArrayList<Param>();
        list1.add(p1);
        list1.add(p2);
        list2.add(p3);
        input1.setParams(list1);
        input2.setParams(list2);
        bth1.setInput(input1);     
        Batch bth2 = new Batch();
        bth2.setCode("2");
        bth2.setName("2");
        bth2.setDescription("2");
        bth2.setOutput("2");
        bth2.setInput(input2);
        batches.getBatches().add(bth1);
        batches.getBatches().add(bth2);
    }
    
    
    public void marshaller() throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(Batches.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(batches, System.out);
        jaxbMarshaller.marshal(batches, new File("out.xml"));
    }
    
    public Batches unmarshaller() throws JAXBException {
        
        //get file path
        Test_property test_property = new Test_property();
        String xmlPath = null; //"batch_catalogue.xml"
        xmlPath = test_property.readProperties("xml");
        
        //UnMarshaller xml file
        JAXBContext jc = JAXBContext.newInstance(Batches.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Batches batches = (Batches) unmarshaller.unmarshal(new File(xmlPath));
        //(new File("src/main/resources/batch_catalogue.xml"));
        
        
        for (int i = 0; i < batches.getBatches().size(); i++) {
            Batch btc = batches.getBatches().get(i);
            System.out.println("Batch ");
            System.out.println("code is " +btc.getCode()+",name is"+btc.getName()+
                    ",description is "+btc.getDescription()+",category is "+btc.getCategory()
                    +",frequency is "+btc.getFrequency()+",input is ");
            if(btc.getInput().getParams() == null){
                 System.out.println(" NULL");
            }else{
                for (int j = 0; j < btc.getInput().getParams().size(); j++) {
                    Param p = btc.getInput().getParams().get(j);
                    System.out.println("-------------------");
                    System.out.println("the " + j + " param is : ");
                    System.out.println("param name is : " + p.PARAMNAME);
                    System.out.println("PARAM DEFAULT : " + p.DEFAULTVALUE);
                    System.out.println("PARAM label : " + p.LABEL);
                    
                }
                System.out.println("*********************************");
            }
        }
        return batches;
    }
}
