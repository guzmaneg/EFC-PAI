/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author g.guzman
 * @param <T>
 * @param <K>
 */
public abstract class DAO<T,K> {
    
    public abstract void create(T entity) throws DAOException ;
    public abstract T read(K id) throws DAOException;
    public abstract void update(T entity) throws DAOException;
    public abstract void delete(K id) throws DAOException;            
    
    public abstract List<T> findAll(boolean includeDeleted) throws DAOException;
    public abstract boolean exist(K id) throws DAOException;
    
    public abstract void closeConnection() throws DAOException;

}
