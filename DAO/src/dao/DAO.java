/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author gguzm
 * @param <T>
 * @param <K> Tipo de dato para la clave
 */
public abstract class DAO<T,K> {
    // CRUD
    public abstract void create(T entidad) throws DAOException;
    public abstract T read(K clave) throws DAOException;
    public abstract void update(T entidad) throws DAOException;
    public abstract void delete(K clave) throws DAOException;    
    
    public abstract boolean existe(K clave) throws DAOException;
}

