/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.implementation;

import domain.GenericEntity;
import java.util.List;
import repository.db.DBRepository;
import java.sql.*;
import java.util.ArrayList;
import repository.db.DBConnection;

/**
 *
 * @author Mare
 */
public class DBBroker implements DBRepository<GenericEntity> {

    @Override
    public List<GenericEntity> getAll(GenericEntity parameter, String search) throws Exception {
        List<GenericEntity> list = new ArrayList<>();

        String query = "SELECT * FROM " + parameter.tableName() + parameter.join() + search;

        System.out.println(query);

        Statement s = DBConnection.getInstance().getConnection().createStatement();

        ResultSet rs = s.executeQuery(query);
        
        list=parameter.getList(rs);

        rs.close();
        s.close();

        return list;
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity parameter) throws Exception {
        List<GenericEntity> list = new ArrayList<>();
        
        String query = "SELECT * FROM " + parameter.tableName() + parameter.join();

        System.out.println(query);

        Statement s = DBConnection.getInstance().getConnection().createStatement();

        ResultSet rs = s.executeQuery(query);

        list=parameter.getList(rs);
        
        rs.close();
        s.close();

        return list;
    }

    @Override
    public void create(GenericEntity parameter) throws Exception {
        String query = "INSERT INTO " + parameter.tableName() + "(" + parameter.columnNames() + ") VALUES("
                + parameter.insertParameters() + ")";

        System.out.println(query);

        Statement s = DBConnection.getInstance().getConnection().createStatement();

        s.executeUpdate(query);

        s.close();
    }

    @Override
    public void update(GenericEntity parameter) throws Exception {
        String query = "UPDATE " + parameter.tableName() + " SET " + parameter.updateValues() + " WHERE " + parameter.primaryKey();

        System.out.println(query);

        Statement s = DBConnection.getInstance().getConnection().createStatement();
        s.executeUpdate(query);
        s.close();
    }

    @Override
    public void delete(GenericEntity parameter) throws Exception {
        String query = "DELETE FROM " + parameter.tableName() + " WHERE " + parameter.primaryKey();

        System.out.println(query);

        Statement s = DBConnection.getInstance().getConnection().createStatement();
        s.executeUpdate(query);
        s.close();
    }
}
