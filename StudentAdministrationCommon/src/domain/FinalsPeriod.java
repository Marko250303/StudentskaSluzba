/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mare
 */
public class FinalsPeriod implements GenericEntity{
    private Long finalsPeriodID;
    private String finalsPeriodName;
    private Date startDate;
    private Date endDate;

    public FinalsPeriod() {
    }

    public FinalsPeriod(Long finalsPeriodID, String finalsPeriodName, Date startDate, Date endDate) {
        this.finalsPeriodID = finalsPeriodID;
        this.finalsPeriodName = finalsPeriodName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getFinalsPeriodID() {
        return finalsPeriodID;
    }

    public void setFinalsPeriodID(Long finalsPeriodID) {
        this.finalsPeriodID = finalsPeriodID;
    }

    public String getFinalsPeriodName() {
        return finalsPeriodName;
    }

    public void setFinalsPeriodName(String finalsPeriodName) {
        this.finalsPeriodName = finalsPeriodName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return finalsPeriodName;
    }

    @Override
    public String tableName() {
        return "ispitniRok";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception {
        List<GenericEntity> list=new ArrayList<>();
        
        while(rs.next()){
            finalsPeriodID=rs.getLong("rokID");
            finalsPeriodName=rs.getString("nazivRoka");
            startDate=rs.getDate("datumPocetka");
            endDate=rs.getTime("datumKraja");
            
            FinalsPeriod fp=new FinalsPeriod(finalsPeriodID, finalsPeriodName, startDate, endDate);
            
            list.add(fp);
        }
        
        return list;
    }

    @Override
    public String columnNames() {
        return "";
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
        return "finalsPeriodID=" +finalsPeriodID;
    }
}
