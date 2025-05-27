/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.DniPersonaException;
import exceptions.NombreNullException;
import exceptions.NombreVacioException;
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
import utils.DateUtils;

/**
 *
 * @author g.guzman
 */
public class AlumnoDAOSQL extends DAO<Alumno, Integer>{

    private Connection connection;
    private PreparedStatement insertPS;
    private PreparedStatement readPS;
    private PreparedStatement findAllPS;
    
    AlumnoDAOSQL(String url, String user, String password) throws DAOException {
        try {
            // jdbc:mysql://localhost:3306/universidad?user=root
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al conectarse a la BD ("+ex.getMessage()+")");
        }
        
        String insertSQL = "INSERT INTO alumnos\n" +
                            "(DNI, NOMBRE, APELLIDO, FEC_NAC)\n" +
                            "VALUES (?, ?, ?, ?);";
        try {
            insertPS = connection.prepareStatement(insertSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear SQL INSERT ("+ex.getMessage()+")");
        }

        // SELECT * FROM universidad.alumnos where DNI = 27;
        String readSQL = "SELECT * FROM alumnos where DNI = ?";
        String findAllSQL = "SELECT * FROM alumnos";
        try {
            readPS = connection.prepareStatement(readSQL);
            findAllPS = connection.prepareStatement(findAllSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear SQL SELECT ("+ex.getMessage()+")");
        }
    }

    @Override
    public void create(Alumno alu) throws DAOException {
        try {
            int index = 1;
            insertPS.setInt(index++, alu.getDni());
            insertPS.setString(index++, alu.getNombre());
            insertPS.setString(index++, alu.getApellido());
            insertPS.setDate(index++, DateUtils.localDate2SqlDate(alu.getFecNac()));
            insertPS.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al insertar ("+ex.getMessage()+")");
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        try {
            readPS.setInt(1, dni);
            ResultSet resultSet = readPS.executeQuery();
            if (resultSet.next()) {
                return getAlumnoFromDB(resultSet);
            }
        } catch (SQLException | DniPersonaException | NombreNullException | NombreVacioException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al leer ("+ex.getMessage()+")");
        }
        
        return null;
    }

    private Alumno getAlumnoFromDB(ResultSet resultSet) throws SQLException, NombreVacioException, NombreNullException, DniPersonaException {
        Alumno alu = new Alumno();
        alu.setDni(resultSet.getInt("DNI"));
        alu.setNombre(resultSet.getString("NOMBRE"));
        alu.setApellido(resultSet.getString("APELLIDO"));
        Date fecNac = resultSet.getDate("FEC_NAC");
        alu.setFecNac(fecNac.toLocalDate());
        return alu;
    }

    @Override
    public void update(Alumno entity) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
     * Baja lógica (marca de borrado en el campo 'estado')
     */
    public void delete(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll(boolean includeDeleted) throws DAOException {
        List<Alumno> alumnos = new ArrayList<>();
        
        try {
            ResultSet resultSet = findAllPS.executeQuery();
            while (resultSet.next()) {
                Alumno alumnoFromDB = getAlumnoFromDB(resultSet);
                if (includeDeleted || alumnoFromDB.getEstado()!='B') {
                    alumnos.add(alumnoFromDB);
                }
            }
        } catch (SQLException | DniPersonaException | NombreNullException | NombreVacioException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al leer ("+ex.getMessage()+")");
        }
        
        return alumnos;
    }

    @Override
    public boolean exist(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
