/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mare
 */
public class Subject implements GenericEntity{
    private Long subjectID;
    private String subjectName;
    private int esbp;
    private Semester semester;

    public Subject() {
    }

    public Subject(Long subjectID, String subjectName, int esbp, Semester semester) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.esbp = esbp;
        this.semester = semester;
    }
    
    public Long getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getEsbp() {
        return esbp;
    }

    public void setEsbp(int esbp) {
        this.esbp = esbp;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return subjectName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.subjectName);
        hash = 89 * hash + this.esbp;
        hash = 89 * hash + Objects.hashCode(this.semester);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Subject other = (Subject) obj;
        if (this.esbp != other.esbp) {
            return false;
        }
        if (!Objects.equals(this.subjectName, other.subjectName)) {
            return false;
        }
        return this.semester == other.semester;
    }
    
    
    
    @Override
    public String tableName() {
        return "predmet";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list=new ArrayList<>();
        
        while(rs.next()){
            subjectID=rs.getLong("predmetID");
            subjectName=rs.getString("nazivPredmeta");
            esbp=rs.getInt("espb");
            semester=Semester.valueOf(rs.getString("semestar"));
            
            Subject s=new Subject(subjectID, subjectName, esbp, semester);
            
            list.add(s);
        }
        
        return list;
    }

    @Override
    public String columnNames() {
        return "nazivPredmeta,espb,semestar";
    }

    @Override
    public String insertParameters() {
        return "'" +subjectName+ "'," +esbp+ ",'" +semester+"'";
    }

    @Override
    public String updateValues() {
        return "";
    }

    @Override
    public String primaryKey() {
        return "subjectID=" +subjectID;
    }

    
    
}
