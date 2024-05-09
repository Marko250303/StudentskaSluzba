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
public class StudentType implements GenericEntity{
    private Long studentTypeID;
    private String typeName;

    public StudentType() {
    }

    public StudentType(Long studentTypeID, String typeName) {
        this.studentTypeID = studentTypeID;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getStudentTypeID() {
        return studentTypeID;
    }

    public void setStudentTypeID(Long studentTypeID) {
        this.studentTypeID = studentTypeID;
    }

    @Override
    public String toString() {
        return typeName;
    }

    @Override
    public String tableName() {
        return "tipStudenta";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list=new ArrayList<>();
        
        while(rs.next()){
            studentTypeID=rs.getLong("tipID");
            typeName=rs.getString("nazivTipa");
            
            StudentType st=new StudentType(studentTypeID, typeName);
            
            list.add(st);
        }
        
        return list;
    }

    @Override
    public String columnNames() {
        return "tipID,nazivTipa";
    }

    @Override
    public String insertParameters() {
        return "";
    }

    @Override
    public String updateValues() {
        return "";
    }

    @Override
    public String primaryKey() {
        return "studentTypeID=" +studentTypeID;
    }
}
