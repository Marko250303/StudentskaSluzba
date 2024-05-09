/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import communication.ClientRequest;
import communication.Communication;
import communication.Operation;
import communication.ServerResponse;
import domain.Administrator;
import domain.Finals;
import domain.FinalsItem;
import domain.FinalsPeriod;
import domain.Student;
import domain.StudentType;
import domain.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mare
 */
public class ClientController {
    private static ClientController instance;

    private ClientController() {
        Communication.getInstance().connect();
    }

    public static ClientController getInstance() {
        if(instance==null){
            instance=new ClientController();
        }
        
        return instance;
    }

    public Administrator login(Administrator forLogin) throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(forLogin);
        request.setOperation(Operation.LOGIN);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null && response.getResponse()!=null){
            return (Administrator) response.getResponse();
        } else{
            throw response.getException();
        }
    }

    public void logout(Administrator logged) throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(logged);
        request.setOperation(Operation.LOGOUT);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            System.out.println("Uspesna odjava");
        }else{
            throw response.getException();
        }
    }
    
    public ArrayList<StudentType> getAllStudentTypes() throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(null);
        request.setOperation(Operation.GET_ALL_STUDENT_TYPES);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            return (ArrayList<StudentType>) response.getResponse();
        } else{
            throw response.getException();
        }
    }
    
    public Student createStudent(Student create) throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(create);
        request.setOperation(Operation.CREATE_STUDENT);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            return (Student) response.getResponse();
        } else{
            throw response.getException();
        }
    }
    
    public ArrayList<Student> getAllStudents() throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(null);
        request.setOperation(Operation.GET_ALL_STUDENTS);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            return (ArrayList<Student>) response.getResponse();
        } else{
            throw response.getException();
        }
    }
    
    public void updateStudent(Student forUpdate) throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(forUpdate);
        request.setOperation(Operation.UPDATE_STUDENT);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            System.out.println("Uspesna izmena podataka o studentu");
        } else{
            throw response.getException();
        }
    }
    
    public void deleteStudent(Student s) throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(s);
        request.setOperation(Operation.DELETE_STUDENT);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            System.out.println("Uspesno brisanje studenta");
        } else{
            throw response.getException();
        }
    }

    public Subject createSubject(Subject subject) throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(subject);
        request.setOperation(Operation.CREATE_SUBJECT);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            return (Subject) response.getResponse();
        } else{
            throw response.getException();
        }
    }

    public ArrayList<Subject> getAllSubjects() throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(null);
        request.setOperation(Operation.GET_ALL_SUBJECTS);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            return (ArrayList<Subject>) response.getResponse();
        } else{
            throw response.getException();
        }
    }

    public ArrayList<FinalsPeriod> getAllFinalsPeriods() throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(null);
        request.setOperation(Operation.GET_ALL_FINALS_PERIODS);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            return (ArrayList<FinalsPeriod>) response.getResponse();
        } else{
            throw response.getException();
        }
    }

    public ArrayList<FinalsItem> getAllFinalsItems(Finals f) throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(f);
        request.setOperation(Operation.GET_ALL_FINALS_ITEMS);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            return (ArrayList<FinalsItem>) response.getResponse();
        } else{
            throw response.getException();
        }
    }

    public Finals createFinals(Finals finals) throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(finals);
        request.setOperation(Operation.CREATE_FINALS);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            return (Finals) response.getResponse();
        } else{
            throw response.getException();
        }
    }

    public ArrayList<Finals> getAllFinals(Object object) throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(object);
        request.setOperation(Operation.GET_ALL_FINALS);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            return (ArrayList<Finals>) response.getResponse();
        } else{
            throw response.getException();
        }
    }

    public void updateFinals(Finals finals) throws Exception {
        ClientRequest request=new ClientRequest();
        
        request.setArgument(finals);
        request.setOperation(Operation.UPDATE_FINALS);
        
        Communication.getInstance().getSender().send(request);
        
        ServerResponse response=(ServerResponse) Communication.getInstance().getReceiver().receive();
        
        if(response.getException()==null){
            System.out.println("Uspesna izmena podataka o prijavi");
        } else{
            throw response.getException();
        }
    }

    

    

    

    
    
    
    
}
