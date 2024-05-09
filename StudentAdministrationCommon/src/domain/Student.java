/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mare
 */
public class Student implements GenericEntity{
    private Long studentID;
    private String firstName;
    private String lastName;
    private int index;
    private StudentYear year;
    private StudentType studentType;

    public Student() {
    }

    public Student(Long studentID, String firstName, String lastName, int index, StudentYear year, StudentType studentType) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.index = index;
        this.year = year;
        this.studentType = studentType;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public StudentYear getYear() {
        return year;
    }

    public void setYear(StudentYear year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
    @Override
    public String tableName() {
        return "student";
    }

    @Override
    public String join() {
        return " s JOIN tipStudenta ts ON s.tipID=ts.tipID";
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list=new ArrayList<>();
        
        while(rs.next()){
            Long studentTypeID=rs.getLong("ts.tipID");
            String typeName=rs.getString("ts.nazivTipa");
            
            StudentType type=new StudentType(studentTypeID, typeName);
            
            studentID=rs.getLong("s.studentID");
            firstName=rs.getString("s.ime");
            lastName=rs.getString("s.prezime");
            index=rs.getInt("s.indeks");
            year=StudentYear.valueOf(rs.getString("s.godina"));
            
            Student s=new Student(studentID, firstName, lastName, index, year, type);
            
            list.add(s);
        }
        
        return list;
    }

    @Override
    public String columnNames() {
        return "ime,prezime,indeks,godina,tipID";
    }

    @Override
    public String insertParameters() {
        return "'" +firstName+ "','" +lastName+ "'," +index+ ",'" +year+ "'," +studentType.getStudentTypeID();
    }

    @Override
    public String updateValues() {
        return "ime='" +firstName+ "',prezime='" +lastName+ "',indeks=" +index+ ",godina='" +year+ "',tipID=" +studentType.getStudentTypeID();
    }

    @Override
    public String primaryKey() {
        return "studentID=" +studentID;
    }
}
