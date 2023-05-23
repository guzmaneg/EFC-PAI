/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 * Clase abstracta para la gestión de un CRUD
 * @param <T> Tipo de dato a persistir
 * @param <K> Clave
 * @author g.guzman
 */
public abstract class DAO<T,K> {
    
    public abstract void create(T entidad) throws DaoException;
    public abstract T read(K id)throws DaoException;
    public abstract void update(T entidad)throws DaoException;
    public abstract void deleteById(K id)throws DaoException;
    public abstract void delete(T entidad)throws DaoException;
    
    public abstract boolean exist(K id) throws DaoException;
    
    public abstract List<T> findAll(boolean onlyActive) throws DaoException;
    public abstract void close() throws DaoException;
}
