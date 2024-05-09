/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import configuration.Configuration;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Mare
 */
public class Server extends Thread {

    private ServerSocket serverSocket;
    private List<ClientHandler> clients;

    public Server() {
        try {
            int port = Integer.parseInt(Configuration.getInstance().getProperty("port"));
            serverSocket = new ServerSocket(port);

            clients = new ArrayList<>();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            while (!serverSocket.isClosed()) {
                System.out.println("Cekanje na klijenta");
                Socket client = serverSocket.accept();
                System.out.println("Klijent je povezan");

                ClientHandler ch = new ClientHandler(client, this);
                clients.add(ch);
                
                System.out.println("Klijent je dodat u listu");
                
                ch.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
    public void stopServer(){
        try {
            for (ClientHandler client : clients) {
                client.stopThread();
            }
            
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
