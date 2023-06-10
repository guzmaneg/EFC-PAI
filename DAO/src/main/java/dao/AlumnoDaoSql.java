/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import persona.Alumno;
import persona.AlumnoException;
import persona.MiCalendario;
import persona.PersonaDniException;
import persona.PersonaNombreException;

/**
 *
 * @author g.guzman
 */
public class AlumnoDaoSql extends Dao<Alumno, Integer>{

    private Connection conn;
    private PreparedStatement psInsert;
    private PreparedStatement psSelect;
    
    AlumnoDaoSql(String url, String user, String pwd) throws DaoException {
        try {
            try {
                // jdbc:mysql://localhost:3306/universidad_caba
                conn = DriverManager.getConnection(url, user, pwd);
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
                throw new DaoException("Error al conectarnos a la BD ==> "+
                        ex.getLocalizedMessage());
            }
            String sqlInsert = "INSERT INTO alumnos(DNI, NOMBRE, APELLIDO, FECHA_NAC, SEXO, PROMEDIO)\n" +
"			 VALUES(?, ?, ?, ?, ?, ?);";
            psInsert = conn.prepareStatement(sqlInsert);
            
            String sqlSelect = "SELECT * FROM alumnos";
            psSelect = conn.prepareStatement(sqlSelect);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void create(Alumno alumno) throws DaoException{
        try {
            int index = 1;
            psInsert.setInt(index++, alumno.getDni());
            psInsert.setString(index++, alumno.getNombre());
            psInsert.setString(index++, alumno.getApellido());
            psInsert.setDate(index++, alumno.getFecNac().toSqlDate());
            psInsert.setString(index++, String.valueOf(alumno.getSexo()));
            psInsert.setDouble(index++, alumno.getPrmedio());
            psInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex.getLocalizedMessage());
        }
    }

    @Override
    public Alumno read(Integer id)  throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Alumno entity) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll(boolean isOnlyActive) throws DaoException {
        try {
            List<Alumno> alumnos = new ArrayList<>();
            Alumno alumno;
            
            ResultSet rs = psSelect.executeQuery();
            while(rs.next()){
                alumno = new Alumno();
                alumno.setDni(rs.getInt("DNI"));
                alumno.setNombre(rs.getString("NOMBRE"));
                alumno.setApellido(rs.getString("APELLIDO"));
                alumno.setFecNac(new MiCalendario(rs.getDate("FECHA_NAC")));
                
                alumno.setFecIng(new MiCalendario(rs.getDate("FECHA_NAC")));
                alumno.setCantMatAprob(15);
                
                alumnos.add(alumno);
            }
            
            return alumnos;
        } catch (SQLException | AlumnoException | PersonaDniException | PersonaNombreException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex.getLocalizedMessage());
        }
    }

    @Override
    public void close() throws DaoException {
        try {
            psInsert.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDaoSql.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(""+ex.getLocalizedMessage());
        }
    }

    @Override
    public boolean exist(Integer id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
