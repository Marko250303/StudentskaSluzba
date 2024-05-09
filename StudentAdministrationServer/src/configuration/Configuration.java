/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mare
 */
public class Configuration {
    private static Configuration instance;
    
    private Properties properties;

    private Configuration() {
        try {
            properties=new Properties();
            
            properties.load(new FileInputStream("D:\\PS\\Projekat\\Projekat\\StudentAdministrationServer\\config\\dbconfig.properties.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Configuration getInstance() {
        if(instance==null){
            instance=new Configuration();
        }
        
        return instance;
    }
    
    public String getProperty(String parameter){
        return properties.getProperty(parameter,"NA");
    }
    
    public void setProperty(String key,String value){
        properties.setProperty(key, value);
    }
    
    public void saveInPropertyFile(){
        try {
            properties.store(new FileOutputStream("D:\\PS\\Projekat\\Projekat\\StudentAdministrationServer\\config\\dbconfig.properties.txt"), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
