/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.administrator;

import domain.Administrator;
import domain.GenericEntity;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class LoginSO extends AbstractSO{
    private List<Administrator> admins;

    @Override
    public void validate(GenericEntity entity) throws Exception {
        if(entity==null || !(entity instanceof Administrator)){
            throw new Exception("Nije poslat admin");
        }
        
        Administrator admin= (Administrator) entity;
        
//        if (admin.getUsername().isBlank()) {
//            throw new Exception("Korisnicko ime ne sme da bude prazno");
//        } else if (admin.getUsername().length() < 3 || admin.getUsername().length() > 20) {
//            throw new Exception("Korisnicko ime mora da ima duzinu izmedju 3 i 20 znakova");
//        }
//
//        if (admin.getPassword().isBlank()) {
//            throw new Exception("Sifra ne sme da bude prazna");
//        } else if (admin.getPassword().length() < 3 || admin.getPassword().length() > 20) {
//            throw new Exception("Sifra mora imati duzinu izmedju 3 i 20 znakova");
//        }
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        admins=broker.getAll(entity);
    }

    public List<Administrator> getAdmins() {
        return admins;
    }
}
