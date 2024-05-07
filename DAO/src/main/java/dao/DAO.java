/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author g.guzman
 */
public abstract class DAO<T,K>{
    
    public abstract void create(T entity) throws DaoException;
    public abstract T read(K id) throws DaoException;
    public abstract void update(T entity) throws DaoException;
    public abstract void delete(K id) throws DaoException;
    
    public abstract T findById(K id) throws DaoException;
    public abstract List<T> findAll(boolean solaActivos) throws DaoException;
    
    public abstract boolean exist(K id) throws DaoException;
    
    public abstract void closeConnection() throws DaoException;
}
