/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Mare
 */
public class FinalsItem extends Finals{
    private Long finalsItemID;
    private Finals finals;
    private FinalsType type;
    private int duration;
    private Subject subject;

    public FinalsItem() {
    }

    public FinalsItem(Long finalsItemID, Finals finals, FinalsType type, int duration, Subject subject) {
        this.finalsItemID = finalsItemID;
        this.finals = finals;
        this.type = type;
        this.duration = duration;
        this.subject = subject;
    }

    public Long getFinalsItemID() {
        return finalsItemID;
    }

    public void setFinalsItemID(Long finalsItemID) {
        this.finalsItemID = finalsItemID;
    }

    public Finals getFinals() {
        return finals;
    }

    public void setFinals(Finals finals) {
        this.finals = finals;
    }

    public FinalsType getType() {
        return type;
    }

    public void setType(FinalsType type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    @Override
    public String tableName() {
        return "stavkaPrijaveIspita";
    }

    @Override
    public String columnNames() {
        return "stavkaID,prijavaID,vrstaIspita,trajanje,predmetID";
    }

    @Override
    public String insertParameters() {
        return finalsItemID+ "," +finals.getFinalsID()+ ",'" +type+ "'," +duration+ "," +subject.getSubjectID();
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        return null; //uradi
    }

    @Override
    public String join() {
        return ""; //uradi
    }

    @Override
    public String updateValues() {
        return ""; //uradi
    }
    
    @Override
    public String primaryKey() {
        return "finalsItemID=" +finalsItemID;
    }
}
