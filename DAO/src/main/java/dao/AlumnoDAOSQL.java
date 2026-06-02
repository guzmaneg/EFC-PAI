/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.NombreApellidoInvalidoException;
import exceptions.PromedioInvalidoException;
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
    private final PreparedStatement insertPrepareStatement;
    private final PreparedStatement readPrepareStatement;
    
    AlumnoDAOSQL(String user, String password) throws DAOException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", user, password);
            System.out.println("dao.AlumnoDAOSQL.<init>() OK!!!");

            String insertSql = "INSERT INTO alumnos\n" +
                        "(DNI, NOMBRE, APELLIDO, FECNAC, FECING, PROMEDIO)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?);";
            insertPrepareStatement = connection.prepareStatement(insertSql);
            
            String readSql = "SELECT * FROM alumnos WHERE DNI = ?";
            readPrepareStatement = connection.prepareStatement(readSql);
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error I/O: "+ex.getLocalizedMessage());
        }
        
    }
    
    @Override
    public void create(Alumno alumno) throws DAOException {
        try {
            int index = 1;
            insertPrepareStatement.setInt(index++, alumno.getDni());
            insertPrepareStatement.setString(index++, alumno.getNombre());
            insertPrepareStatement.setString(index++, alumno.getApellido());
            insertPrepareStatement.setDate(index++, null);
            insertPrepareStatement.setDate(index++, DateUtils.localDate2SqlDate(alumno.getFecIng()));
            insertPrepareStatement.setDouble(index++, alumno.getPromedio());

            insertPrepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error AL INSERTAR: "+ex.getLocalizedMessage());
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        try {
            readPrepareStatement.setInt(1, dni);
            final ResultSet rs = readPrepareStatement.executeQuery();
            if (rs.next()) {
                Alumno alu = new Alumno();
                alu.setDni(rs.getInt("DNI"));
                alu.setNombre(rs.getString("NOMBRE"));
                alu.setApellido(rs.getString("APELLIDO"));
                alu.setFecIng(DateUtils.sqlDate2LocalDate(rs.getDate("FECING")));
                alu.setPromedio(rs.getDouble("PROMEDIO"));
                
                return alu;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error AL LEER: "+ex.getLocalizedMessage());
        } catch (NombreApellidoInvalidoException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Erro al setear datos del alumno: "+ex.getLocalizedMessage());
        } catch (PromedioInvalidoException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void update(Alumno entidad) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll(boolean all) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws DAOException {
        try {
            if(connection!=null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Erro al cerrar la conexión:" + ex.getLocalizedMessage());
        }
        
    }

    @Override
    public boolean exist(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
