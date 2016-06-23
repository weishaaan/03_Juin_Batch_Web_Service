package com.mora.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

public class Test_property {

	public Test_property() {
            /*Test_property r = new Test_property();          
            r.createProperties();        
            String filepath = r.readProperties();
            System.out.println(filepath);
            r.runBatFile(filepath);
            */
        }
        public String readProperties(String property){
            Properties prop = new Properties();
            String path = null;
            try (InputStream in = new FileInputStream("src/main/resources/bat.properties")) 
            {
		prop.load(in);
            }
	    catch (IOException e) {
		e.printStackTrace();
	    }
            catch (Exception e) {
		e.printStackTrace();
	    }
            
            if(property.equals("text")){
                path = prop.getProperty("text.bat");
            }
            if(property.equals("xml")){
                path = prop.getProperty("xml.bat");
            }
            if(property.equals("batch_name.bat")){
                path = prop.getProperty("batch_name.bat");
            }
            
            
            
            
            return path;
        }

        public void createProperties(){
            try (OutputStream out = new FileOutputStream("created_bat.properties")) {
                //file will be created in the root dictionary
		Properties properties = new Properties();
                //create variabls in .properties file
		properties.setProperty("text.bat", "src\\main\\resources\\text.bat");
		properties.store(out, "This is a sample for java properties");
            } catch (IOException e) {
		e.printStackTrace();
            }
        }
        
        public String runBatFile(String filepath){
            String s = "";
            try {
                String line;
                Process p = Runtime.getRuntime().exec(filepath);
                BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));

	        while ((line = bri.readLine()) != null) {
	            System.out.println(line);
	            s = s + line + ",";
	        }
	        bri.close();
	        //System.out.println("end of getInputStream.");
	            
                p.waitFor();

                if((String.format("%02d",p.exitValue()).equals("02")))
                    s = s + "Exited with error code 02,and now it is after midi";
                else{
                    s = s + "Exited with error code 01,and now it is before midi";      
                }
            }
            catch (Exception err) {
                err.printStackTrace();
            }
            return s;
            
        }
}
