/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mare
 */
public class Finals implements GenericEntity{
    private Long finalsID;
    private Date applicationDate;
    private int totalApplied;
    private Student student;
    private FinalsPeriod finalsPeriod;
    private ArrayList<FinalsItem> items;

    public Finals() {
    }

    public Finals(Long finalsID, Date applicationDate, int totalApplied, Student student, FinalsPeriod finalsPeriod, ArrayList<FinalsItem> items) {
        this.finalsID = finalsID;
        this.applicationDate = applicationDate;
        this.totalApplied = totalApplied;
        this.student = student;
        this.finalsPeriod = finalsPeriod;
        this.items = items;
    }

     public Long getFinalsID() {
        return finalsID;
    }

    public void setFinalsID(Long finalsID) {
        this.finalsID = finalsID;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public int getTotalApplied() {
        return totalApplied;
    }

    public void setTotalApplied(int totalApplied) {
        this.totalApplied = totalApplied;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public FinalsPeriod getFinalsPeriod() {
        return finalsPeriod;
    }

    public void setFinalsPeriod(FinalsPeriod finalsPeriod) {
        this.finalsPeriod = finalsPeriod;
    }

    public ArrayList<FinalsItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<FinalsItem> items) {
        this.items = items;
    }

    @Override
    public String tableName() {
        return "prijavaIspita";
    }

    @Override
    public String join() {
        return " p JOIN student s ON p.studentID=s.studentID JOIN ispitniRok i ON p.rokID=i.rokID JOIN tipStudenta t ON t.tipID=s.tipID";
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        ArrayList<GenericEntity> list=new ArrayList<>();
        
        while(rs.next()){
            Long typeID=rs.getLong("t.tipID");
            String typeName=rs.getString("t.nazivTipa");
            
            StudentType type=new StudentType(typeID, typeName);
            
            Long studentID=rs.getLong("s.studentID");
            String firstName=rs.getString("s.ime");
            String lastName=rs.getString("s.prezime");
            int index=rs.getInt("s.indeks");
            StudentYear year=StudentYear.valueOf(rs.getString("s.godina"));
                    
            Student s=new Student(studentID, firstName, lastName, index, year, type);
            
            Long periodID=rs.getLong("i.rokID");
            String periodName=rs.getString("i.nazivRoka");
            Date startDate=rs.getDate("i.datumPocetka");
            Date endDate=rs.getDate("i.datumKraja");
            
            FinalsPeriod fp=new FinalsPeriod(periodID, periodName, startDate, endDate);
            
            finalsID=rs.getLong("p.prijavaID");
            applicationDate=rs.getDate("p.datumPrijave");
            totalApplied=rs.getInt("p.prijavljenoIspita");
            
            Finals finals=new Finals(finalsID, applicationDate, totalApplied, s, fp, null);
            
            list.add(finals);
        }
        
        return list;
    }

    @Override
    public String columnNames() {
        return "datumPrijave,prijavljenoIspita,studentID,rokID";
    }

    @Override
    public String insertParameters() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        return "'" +sdf.format(applicationDate)+ "'," +totalApplied+ "," +student.getStudentID()+ "," +finalsPeriod.getFinalsPeriodID();
    }

    @Override
    public String updateValues() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        return "datumPrijave='" +sdf.format(applicationDate)+ "',studentID=" +student.getStudentID() + ",rokID=" +finalsPeriod.getFinalsPeriodID();
    }

    @Override
    public String primaryKey() {
        return "prijavaID=" +finalsID;
    }
}
