/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import test.Alumno;

/**
 *
 * @author laboratorios
 */
public class AlumnoDaoSql extends DAO<Alumno, Integer>{
	private Connection conn;
    private PreparedStatement insertPS;
    private PreparedStatement selectPS;
    
    AlumnoDAOSQL(String url, String usuario, String password) throws DAOException {
        
        try {
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al conectarse con la BD ==> "+ex.getMessage());
        }
        String insertSQL = "INSERT INTO alumnos\n" +
                "(DNI,\n" +
                "NOMBRE,\n" +
                "APELLIDO,\n" +
                "FEC_NAC,\n" +
                "SEXO,\n" +
                "PROMEDIO)\n" +
                "VALUES\n" +
                "(?,?,?,?,?,?);";
        
        try {
            insertPS = conn.prepareStatement(insertSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear sentencia para INSERT ==> "+ex.getMessage());
        }
         
        String selectSQL = "SELECT * FROM alumnos where DNI = ?";
        
        try {
            selectPS = conn.prepareStatement(selectSQL);
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear sentencia para SELECT ==> "+ex.getMessage());
        }

    }

    @Override
    public void create(Alumno alu) throws DAOException {
        try {
            int index = 1;
            insertPS.setInt(index++, alu.getDni());
            insertPS.setString(index++, alu.getNombre());
            insertPS.setString(index++, alu.getApellido());
            insertPS.setDate(index++, alu.getFechaNac().toSQLDate());
            insertPS.setString(index++, String.valueOf(alu.getSexo()));
            insertPS.setDouble(index++, alu.getPromedio());
            
            insertPS.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al insertar en le BD ==>"+ex.getMessage());
        }
    }

    @Override
    public Alumno read(Long dni) throws DAOException {
        Alumno alu = null;
        try {
            selectPS.setInt(1, dni);
            ResultSet rs = selectPS.executeQuery();
            if (rs.next()) {
                alu = new Alumno();
                alu.setDni(dni);
                alu.setNombre(rs.getString("NOMBRE"));
                alu.setApellido(rs.getString("APELLIDO"));
                alu.setFechaNac(new MiCalendario(rs.getDate("FEC_NAC")));
                alu.setSexo(rs.getString("SEXO").charAt(0));
                alu.setPromedio(rs.getDouble("PROMEDIO"));
            }
            
        } catch (SQLException | PersonaException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            // TODO throw new DAOException...
        }
        
        return alu;
    }

    @Override
    public void update(Alumno entidad) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer clave) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Integer clave) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> findAll(Boolean activos) throws DAOException {
        List<Alumno> alumnos = new ArrayList<>();
        
        alumnos.add(read(24004601));
        alumnos.add(read(24004602));
        
        return alumnos;
    }

    @Override
    public void close() throws DAOException {

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al cerrar la BD ==> "+ex.getMessage());
        }
    }
    
}
