/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Mare
 */
public interface GenericEntity extends Serializable{

    public String tableName();

    public String join();

    public List<GenericEntity> getList(ResultSet rs) throws Exception;

    public String columnNames();

    public String insertParameters();

    public String updateValues();

    public String primaryKey();
}
