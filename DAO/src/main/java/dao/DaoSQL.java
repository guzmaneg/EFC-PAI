/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import gui.persona.Alumno;
import gui.persona.PersonaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.AlumnoUtils;

/**
 *
 * @author g.guzman
 */
public class DaoSQL extends DAO<Alumno, Integer>{

    private final Connection connection;

    private final PreparedStatement insertPS;
    private final PreparedStatement readPS;
    
    DaoSQL(String url, String user, String password) throws DaoException {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado OK a la BBDD");

            String insertSql = "INSERT INTO alumnos\n" +
                    "(`DNI`, `NOMBRE`, `APELLIDO`, `FEC_NAC`, `ESTADO`)\n" +
                    "VALUES(?, ?, ?, ?, ?);";
            insertPS = connection.prepareStatement(insertSql);

            String readSql = "SELECT * FROM alumnos WHERE DNI = ?;";
            readPS = connection.prepareStatement(readSql);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo conectar a la BBDD");
        }
    }
    
    @Override
    public void create(Alumno alu) throws DaoException{
        try {
            int index = 1;
            insertPS.setInt(index++, alu.getDni());
            insertPS.setString(index++, alu.getNombre());
            insertPS.setString(index++, alu.getApellido());
            insertPS.setDate(index++, AlumnoUtils.localDate2SqlDate(alu.getFechaNac()));
            insertPS.setString(index++, String.valueOf(alu.getEstado()));
            
            insertPS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo insertar el alumno");
        }
    }

    @Override
    public Alumno read(Integer dni) throws DaoException {
        try {
            readPS.setInt(1, dni);
            ResultSet rs = readPS.executeQuery();
            if (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setDni(rs.getInt("DNI"));
                alumno.setNombre(rs.getString("NOMBRE"));
                alumno.setFechaNac(AlumnoUtils.sqlDate2LocalDate(rs.getDate("FEC_NAC")));
                
                return alumno;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo leer el alumno ("+ex.getLocalizedMessage()+")");
        } catch (PersonaException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al crear el alumno ("+ex.getLocalizedMessage()+")");
        }
        return null;
    }

    @Override
    public void update(Alumno alu) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer dni) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno findById(Integer dni) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll(boolean solaActivos) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void closeConnection() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean exist(Integer id) throws DaoException {
        // TODO count(*)
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
