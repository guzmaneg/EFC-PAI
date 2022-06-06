/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.AlumnoException;
import persona.MiCalendario;
import persona.PersonaException;
import persona.PersonaNombreException;

/**
 *
 * @author gguzm
 */
public class AlumnoDaoSql extends DAO<Alumno, Integer> {

    private Connection conn;
    private PreparedStatement insertPS;
    private PreparedStatement selectPS;

    public AlumnoDaoSql(String conexion, String usuario, String clave) throws DAOException {
        try {
            conn = DriverManager.getConnection(conexion, usuario, clave);
        } catch (SQLException ex) {
            throw new DAOException("Error al conectarse a la BD => " + ex.getMessage());
        }

        System.out.println("Conexión OK!!!");

        String insertSQL = "INSERT INTO alumnos\n"
                + "(DNI,\n"
                + "NOMBRE,\n"
                + "APELLIDO,\n"
                + "FEC_NAC,\n"
                + "SEXO,\n"
                + "CANT_MAT_APROB,\n"
                + "PROMEDIO)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?,?);";

        try {
            insertPS = conn.prepareStatement(insertSQL);
        } catch (SQLException ex) {
            throw new DAOException("Error al crear sentencia para INSERT ==> " + ex.getMessage());
        }

        String selectSQL = "select * from alumnos where DNI = ?";
        
        try {
            selectPS = conn.prepareStatement(selectSQL);
        } catch (SQLException ex) {
            throw new DAOException("Error al crear sentencia para SELECT ==> " + ex.getMessage());
        }
    }

    @Override
    public void create(Alumno alu) throws DAOException {
        try {
            int index = 1;
            insertPS.setInt(index++, alu.getDni());
            insertPS.setString(index++, alu.getNombre());
            insertPS.setString(index++, alu.getApellido());
            insertPS.setDate(index++, alu.getFecNac().toSQLDate());
            insertPS.setString(index++, String.valueOf("M"));
            insertPS.setInt(index++, alu.getCantMatAprob());
            insertPS.setDouble(index++, alu.getPromedio());

            insertPS.execute();

        } catch (SQLException ex) {
            throw new DAOException("Error al insertar en le BD ==>" + ex.getMessage());
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        try {
            selectPS.setInt(1, dni);
            
            final ResultSet rs = selectPS.executeQuery();
            if (rs.next()) {
                Alumno alu = new Alumno();
                alu.setDni(rs.getInt("DNI"));
                alu.setNombre(rs.getString("NOMBRE"));
                alu.setApellido(rs.getString("APELLIDO"));
                alu.setFecNac(new MiCalendario(rs.getDate("FEC_NAC")));
                alu.setCantMatAprob(rs.getInt("CANT_MAT_APROB"));
                alu.setPromedio(rs.getDouble("PROMEDIO"));
                
                return alu;
            }
        } catch (SQLException | PersonaException | PersonaNombreException | AlumnoException ex) {
            throw new DAOException("Error al leer el alumno ==> "+ ex.getMessage());
        }
        
        return null;
    }

    @Override
    public void update(Alumno entity) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hardDelete(Integer pk) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void softDelete(Integer pk) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> findAll(boolean includeDeleted) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exist(Integer pk) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws DAOException {
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new DAOException("Error al cerrar la conexión " + ex.getMessage());            
        }
    }

}
