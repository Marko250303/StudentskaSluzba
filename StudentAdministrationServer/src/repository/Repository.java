/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Mare
 */
public interface Repository<T> {
    List<T> getAll(T parameter, String search) throws Exception;
    List<T> getAll(T parameter) throws Exception;
    void create(T parameter) throws Exception;
    void update(T parameter) throws Exception;
    void delete(T parameter) throws Exception;
}
