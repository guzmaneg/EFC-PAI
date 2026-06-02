/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dao;

import java.util.List;

/**
 *
 * @author g.guzman
 * @param <T> Entidad a persistir
 * @param <K> ID Entidad
 */
public abstract class DAO<T,K> {

    // CRUD Operations
    public abstract void create(T entidad) throws DAOException;
    public abstract T read(K id) throws DAOException;
    public abstract void update(T entidad) throws DAOException;
    public abstract void delete(K id) throws DAOException;
    
    
    public abstract boolean exist(K id) throws DAOException;
    public abstract List<T> findAll(boolean all) throws DAOException;
    public abstract void close() throws DAOException;
}
