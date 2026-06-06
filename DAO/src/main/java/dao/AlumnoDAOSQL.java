/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.DniInvalidoException;
import exceptions.NombreInvalidoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import utils.DateUtils;

/**
 *
 * @author g.guzman
 */
public class AlumnoDAOSQL extends DAO<Alumno,Integer> {

    private final Connection connection;
    private final PreparedStatement prepareStatementInsert;
    private final PreparedStatement prepareStatementRead;
    
    AlumnoDAOSQL(String url, String user, String pwd) throws DAOException {
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            
            String insertSQL = "INSERT INTO alumnos VALUES (?, ?, ?, ?);";
            prepareStatementInsert = connection.prepareStatement(insertSQL);
            
            String readSQL = "SELECT * FROM alumnos where DNI = ?;";
            prepareStatementRead = connection.prepareStatement(readSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }
    }

    @Override
    public void create(Alumno alumno) throws DAOException {
        try {
            int index = 1;
            prepareStatementInsert.setInt(index++, alumno.getDni());
            prepareStatementInsert.setString(index++, alumno.getNombre());
            prepareStatementInsert.setString(index++, alumno.getApellido());
            prepareStatementInsert.setDate(index++, DateUtils.localDate2SqlDate(alumno.getFecNac()));
            
            prepareStatementInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        try {
            prepareStatementRead.setInt(1, dni);
            final ResultSet rs = prepareStatementRead.executeQuery();
            if (rs.next()) {
                Alumno alu = new Alumno();
                alu.setDni(rs.getInt("DNI"));
                alu.setNombre(rs.getString("NOMBRE"));
                alu.setApellido(rs.getString("APELLIDO"));
                alu.setFecNac(DateUtils.sqlDate2LocalDate(rs.getDate("FEC_NAC")));
                
                return alu;
            }
        } catch (SQLException | DniInvalidoException | NombreInvalidoException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }
        
        return null;
    }

    @Override
    public void update(Alumno alumno) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer dni) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll(boolean incluirEliminados) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws DAOException {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }
    }

    @Override
    public boolean exist(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
