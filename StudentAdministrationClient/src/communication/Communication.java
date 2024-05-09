/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mare
 */
public class Communication {
    private static Communication instance;
    
    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    private Communication(){
        
    }

    public static Communication getInstance() {
        if(instance==null){
            instance=new Communication();
        }
        return instance;
    }
    
    public void connect(){
        try {
            socket=new Socket("localhost", 9000);
            sender=new Sender(socket);
            receiver=new Receiver(socket);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sender getSender() {
        return sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }
    
    
}
