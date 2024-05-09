/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Administrator;
import domain.Finals;
import domain.FinalsPeriod;
import domain.Student;
import domain.StudentType;
import domain.Subject;
import java.util.ArrayList;
import java.util.List;
import so.administrator.LoginSO;
import so.finals.CreateFinalsSO;
import so.finals.GetAllFinalsPeriodsSO;
import so.finals.GetAllFinalsSO;
import so.finals.UpdateFinalsSO;
import so.student.CreateStudentSO;
import so.student.GetAllStudentTypesSO;
import so.student.UpdateStudentSO;
import so.subject.CreateSubjectSO;
import so.student.DeleteStudentSO;
import so.student.GetAllStudentsSO;
import so.subject.GetAllSubjectsSO;
import thread.Server;

/**
 *
 * @author Mare
 */
public class ServerController {
    private static ServerController instance;
    
    private Server server;
    private List<Administrator> loggedAdmins;

    private ServerController() {
        loggedAdmins=new ArrayList<>();
    }

    public static ServerController getInstance() {
        if(instance==null){
            instance=new ServerController();
        }
        
        return instance;
    }
    
    public Administrator login(Administrator forLogin) throws Exception {
        if(loggedAdmins.contains(forLogin)){
            throw new Exception("VEC JE LOGOVAN");
        }
        
        LoginSO login=new LoginSO();
        
        login.execute(new Administrator());
        
        List<Administrator> admins=login.getAdmins();
        
        for (Administrator admin : admins) {
            if(admin.getUsername().equals(forLogin.getUsername()) && admin.getPassword().equals(forLogin.getPassword())){
                loggedAdmins.add(admin);
                
                return admin;
            }
        }
        
        return null;
    }
    
    public void logout(Administrator forLogout) {
        loggedAdmins.remove(forLogout);
    }
    
    public ArrayList<StudentType> getStudentTypes() throws Exception {
        GetAllStudentTypesSO getAllStudentTypes=new GetAllStudentTypesSO();
        
        getAllStudentTypes.execute(new StudentType());
        
        return getAllStudentTypes.getStudentTypes();
    }
    
    public void createStudent(Student student) throws Exception {
        CreateStudentSO createStudent=new CreateStudentSO();
        
        createStudent.execute(student);
    }
    
    public ArrayList<Student> getStudents() throws Exception {
        GetAllStudentsSO getAllStudents=new GetAllStudentsSO();
        
        getAllStudents.execute(new Student());
        
        return (ArrayList<Student>) getAllStudents.getStudents();
    }
    
    public void updateStudent(Student forUpdate) throws Exception {
        UpdateStudentSO updateStudent=new UpdateStudentSO();
        
        updateStudent.execute(forUpdate);
    }
    
    public void deleteStudent(Student forDelete) throws Exception {
        DeleteStudentSO deleteStudent=new DeleteStudentSO();
        
        deleteStudent.execute(forDelete);
    }
    
    public void createSubject(Subject toCreate) throws Exception {
        CreateSubjectSO createSubject=new CreateSubjectSO();
        
        createSubject.execute(toCreate);
    }
    
    public ArrayList<Subject> getAllSubjects() throws Exception {
        GetAllSubjectsSO getAllSubjects=new GetAllSubjectsSO();
        
        getAllSubjects.execute(new Subject());
        
        return (ArrayList<Subject>) getAllSubjects.getSubjects();
    }
    
    public ArrayList<FinalsPeriod> getAllFinalsPeriods() throws Exception {
        GetAllFinalsPeriodsSO getAllFinalsPeriods=new GetAllFinalsPeriodsSO();
        
        getAllFinalsPeriods.execute(new FinalsPeriod());
        
        return (ArrayList<FinalsPeriod>) getAllFinalsPeriods.getPeriods();
    }
    
    public void createFinals(Finals finals) throws Exception {
        CreateFinalsSO createFinals=new CreateFinalsSO();
        
        createFinals.execute(finals);
    }
    
    public ArrayList<Finals> getFinals() throws Exception {
        GetAllFinalsSO getFinals=new GetAllFinalsSO();
        
        getFinals.execute(new Finals());
        
        return getFinals.getFinals();
    }
    
    public void updateFinals(Finals forUpdateF) throws Exception {
        UpdateFinalsSO uf=new UpdateFinalsSO();
        
        uf.execute(forUpdateF);
    }

    public void startServer() {
        if (server == null || !server.isAlive()) {
            server = new Server();
            server.start();
        }
    }

    public void stopServer() {
        if (server.getServerSocket() != null) {
            server.stopServer();
            /*  try {
                server.ukloniKlijenete();
                server.getSs().close();
            } catch (IOException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    } 
}
