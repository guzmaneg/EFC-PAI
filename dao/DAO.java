/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author laboratorios
 */
public abstract class DAO <T,K>{
    
    // CRUD
    public abstract void create(T entity) throws DAOException;
    public abstract T read(K pk) throws DAOException;
    public abstract void update(T entity) throws DAOException;
    public abstract void hardDelete(K pk) throws DAOException;
    public abstract void softDelete(K pk) throws DAOException;
    public abstract List<T> findAll(boolean includeDeleted) throws DAOException;
    public abstract boolean exist(K pk) throws DAOException;
    public abstract void close() throws DAOException;
}
