/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author Sergio Cruz
 * @param <T> dato génerico
 */
public interface contratoDAO<T>{
    boolean create(T obj);
    public List<T> readAll();
    public T read (T filter);
    public boolean update(T obj);
    public boolean delete(T obj);
}
