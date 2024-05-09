/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.Objects;

/**
 *
 * @author Mare
 */
public class Administrator implements GenericEntity{
    private Long administratorID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public Administrator() {
    }

    public Administrator(Long administratorID, String username, String password, String firstName, String lastName) {
        this.administratorID = administratorID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.username);
        hash = 37 * hash + Objects.hashCode(this.password);
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
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
    @Override
    public String tableName() {
        return "administrator";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws Exception{
        List<GenericEntity> admins=new ArrayList<>();
        
        while(rs.next()){
            administratorID=rs.getLong("administratorID");
            username=rs.getString("korisnickoIme");
            password=rs.getString("sifra");
            firstName=rs.getString("ime");
            lastName=rs.getString("prezime");
            
            Administrator admin=new Administrator(administratorID, username, password, firstName, lastName);
            admins.add(admin);
        }
        
        return admins;
    }

    @Override
    public String columnNames() {
        return "administratorID,korisnickoIme,sifra,ime,prezime";
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
        return "administratorID=" +administratorID;
    }
}
