package com.mora.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.bind.JAXBException;
import org.apache.xmlbeans.XmlException;
 
public class MyServlet implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent arg0){
        System.out.println("servlet for loading batch info.");
        try {
            BatchService batchService = new BatchService();
        } catch (XmlException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent arg0){
        System.out.print("servlet context destroyed.");
    }
}