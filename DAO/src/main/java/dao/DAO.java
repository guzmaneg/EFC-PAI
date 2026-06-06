/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dao;

import java.util.List;

/**
 *
 * @author g.guzman
 */
public abstract class DAO<T,K> {
    
    public abstract void create(T entidad) throws DAOException;
    public abstract T read(K id) throws DAOException;
    public abstract void update(T entidad) throws DAOException;
    public abstract void delete(K id) throws DAOException;
    
    public abstract boolean exist(K id) throws DAOException;
    
    public abstract List<T> findAll(boolean incluirEliminados) throws DAOException;
    public abstract void close() throws DAOException;
}
