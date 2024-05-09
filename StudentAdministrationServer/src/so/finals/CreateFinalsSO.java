/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.finals;

import domain.Finals;
import domain.FinalsItem;
import domain.GenericEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import repository.db.DBConnection;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class CreateFinalsSO extends AbstractSO {

    @Override
    public void validate(GenericEntity entity) throws Exception {
        if (entity == null || !(entity instanceof Finals)) {
            throw new Exception("Nije poslata prijava ispita");
        }

        Finals finals = (Finals) entity;

        //validacija
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        Finals finals = (Finals) entity;

        Connection connection = DBConnection.getInstance().getConnection();

        try {
            String query = "INSERT INTO " + finals.tableName()
                    + " (" + finals.columnNames()
                    + ") VALUES (" + finals.insertParameters() + ")";

            System.out.println(query);
            PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                long id = rs.getLong(1);
                finals.setFinalsID(id);
            }

            ps.close();
            rs.close();

            for (FinalsItem item : finals.getItems()) {
                item.setFinals(finals);

                broker.create(item);
            }

            connection.commit();
        } catch (Exception ex) {
            connection.rollback();
            throw new Exception("Ne moze da se sacuva");
        }
    }
}


