/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.ClientRequest;
import communication.Receiver;
import communication.Sender;
import communication.ServerResponse;
import domain.Administrator;
import domain.Finals;
import domain.FinalsPeriod;
import domain.Student;
import domain.StudentType;
import domain.Subject;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.ServerController;

/**
 *
 * @author Mare
 */
public class ClientHandler extends Thread {
    private Socket client;
    private final Server server;
    private final Sender sender;
    private final Receiver receiver;

    private boolean end;

    public ClientHandler(Socket client, Server server) {
        this.client = client;
        this.server = server;

        sender = new Sender(client);
        receiver = new Receiver(client);
    }

    @Override
    public void run() {
        end = false;

        while (!end) {
            ClientRequest request = (ClientRequest) receiver.receive();
            ServerResponse response = new ServerResponse();

            try {
                switch (request.getOperation()) {
                    case LOGIN -> {
                        Administrator forLogin = (Administrator) request.getArgument();

                        Administrator logged = ServerController.getInstance().login(forLogin);

                        response.setResponse(logged);
                        response.setException(null);

                    }
                    case LOGOUT -> {
                        Administrator forLogout=(Administrator) request.getArgument();
                        
                        ServerController.getInstance().logout(forLogout);
                    }
                    case GET_ALL_STUDENT_TYPES -> {
                        ArrayList<StudentType> studentTypes=ServerController.getInstance().getStudentTypes();
                        
                        response.setResponse(studentTypes);
                    }
                    case CREATE_STUDENT -> {
                        Student student=(Student) request.getArgument();
                        
                        try {
                            ServerController.getInstance().createStudent(student);
                            
                            response.setResponse(student);
                            response.setException(null);
                        } catch (Exception e) {
                            response.setResponse(null);
                            response.setException(e);
                        }
                    }
                    case GET_ALL_STUDENTS -> {
                        ArrayList<Student> students=ServerController.getInstance().getStudents();
                        
                        response.setResponse(students);
                    }
                    case UPDATE_STUDENT -> {
                        Student forUpdate=(Student) request.getArgument();
                        
                        ServerController.getInstance().updateStudent(forUpdate);
                        
                        response.setResponse(forUpdate);
                        response.setException(null);
                    }
                    case DELETE_STUDENT -> {
                        Student forDelete=(Student) request.getArgument();
                        
                        ServerController.getInstance().deleteStudent(forDelete);
                        
                        response.setResponse(forDelete);
                        response.setException(null);
                    }
                    case CREATE_SUBJECT -> {
                        Subject toCreate=(Subject) request.getArgument();
                        
                        try {
                            ServerController.getInstance().createSubject(toCreate);
                            
                            response.setResponse(toCreate);
                            response.setException(null);
                        } catch (Exception e) {
                            response.setResponse(null);
                            response.setException(e);
                        }
                    }
                    case GET_ALL_SUBJECTS -> {
                        ArrayList<Subject> subjects=ServerController.getInstance().getAllSubjects();
                        
                        response.setResponse(subjects);
                    }
                    case GET_ALL_FINALS_PERIODS -> {
                        ArrayList<FinalsPeriod> finalsPeriods=ServerController.getInstance().getAllFinalsPeriods();
                        
                        response.setResponse(finalsPeriods);
                    }
                    case GET_ALL_FINALS_ITEMS -> {
                    }
                    case CREATE_FINALS -> {
                        Finals finals=(Finals) request.getArgument();
                        
                        try {
                            ServerController.getInstance().createFinals(finals);
                            
                            response.setResponse(finals);
                            response.setException(null);
                        } catch (Exception e) {
                            response.setResponse(null);
                            response.setException(e);
                        }
                    }
                    case GET_ALL_FINALS -> {
                        ArrayList<Finals> finals=ServerController.getInstance().getFinals();
                        
                        response.setResponse(finals);
                    }
                    case UPDATE_FINALS -> {
                        Finals forUpdateF=(Finals) request.getArgument();
                        
                        ServerController.getInstance().updateFinals(forUpdateF);
                        
                        response.setResponse(forUpdateF);
                        response.setException(null);
                    }
                    
                    default ->
                        throw new AssertionError(request.getOperation().name());

                }
            } catch (Exception e) {
                e.printStackTrace();
                response.setException(e);
            }

            sender.send(response);
        }
    }

    void stopThread() {
        end = true;

        try {
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
