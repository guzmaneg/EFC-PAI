/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import calendario.MiCalendario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.PersonaInvalidaException;
import persona.PersonaNombreException;

/**
 *
 * @author g.guzman
 */
public class AlumnoDaoSQL extends DAO<Alumno,Integer>{

    private Connection conn;
    private PreparedStatement psSelect;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    
    public AlumnoDaoSQL() throws DaoException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al conectarse a la BD ==>"+ex.getLocalizedMessage());
        }
        
        try {
            psSelect = conn.prepareStatement("SELECT * FROM alumnos");
            
            psInsert = conn.prepareStatement("INSERT INTO alumnos (DNI, NOMBRE, APELLIDO, SEXO, FEC_NAC)\n" +
                    "VALUES (?, ?, ?, ?, ?);");
            
            psUpdate = conn.prepareStatement("UPDATE alumnos"
                    + " SET NOMBRE = ?, APELLIDO = ?, SEXO = ?, FEC_NAC = ? "
                    + " WHERE DNI = ?;");
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error en PreparedStatement ==>"+ex.getLocalizedMessage());
        }
    }

    @Override
    public void create(Alumno alumno) throws DaoException {
        int index = 1;
        try {
            psInsert.setInt(index++, alumno.getDni());
            psInsert.setString(index++, alumno.getNombre());
            psInsert.setString(index++, alumno.getApellido());
            psInsert.setString(index++, String.valueOf(alumno.getSexo()));
            psInsert.setDate(index++, MiCalendario.toSql(alumno.getFechaNac()));
            
            psInsert.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error en create ==>"+ex.getLocalizedMessage());
        }
    }

    @Override
    public Alumno read(Integer dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Alumno alumno) throws DaoException {
        int index = 1;
        try {
            psUpdate.setString(index++, alumno.getNombre());
            psUpdate.setString(index++, alumno.getApellido());
            psUpdate.setString(index++, String.valueOf(alumno.getSexo()));
            psUpdate.setDate(index++, MiCalendario.toSql(alumno.getFechaNac()));

            psUpdate.setInt(index++, alumno.getDni());
            
            psUpdate.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error en create ==>"+ex.getLocalizedMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Alumno entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll(boolean onlyActive) throws DaoException{
        List<Alumno> alumnos = new ArrayList<>();
        Alumno alumno;
        try {
            ResultSet executeQuery = psSelect.executeQuery();
            while(executeQuery.next()) {
                alumno = new Alumno();
                alumno.setDni(executeQuery.getInt("DNI"));
                alumno.setNombre(executeQuery.getString("NOMBRE"));
                
                alumno.setFechaNac(new MiCalendario(executeQuery.getDate("FEC_NAC")));
                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error en findAll ==> "+ex.getLocalizedMessage());
        } catch (PersonaInvalidaException | PersonaNombreException ex) {
            Logger.getLogger(AlumnoDaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex.getLocalizedMessage());
        }
        
        return alumnos;
    }

    @Override
    public void close() {
        try {
            psSelect.close();
            psInsert.close();
            psUpdate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean exist(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
