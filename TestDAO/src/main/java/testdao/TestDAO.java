/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdao;

import dao.AlumnoDAOSql;
import dao.AlumnoDAOTxt;
import dao.DAO;
import dao.DAOException;
import dao.DAOFactory;
import dao.DAOFactoryException;
import exceptions.PersonaException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public class TestDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAO<Alumno, Integer> dao = null;
        try {
            DAOFactory factory = DAOFactory.getInstance();
            // DAOFactory factory2 = DAOFactory.getInstance();
            // DAOFactory factory3 = DAOFactory.getInstance();
            
            //dao = new AlumnoDAOTxt("alumnos.txt");
            //dao = new AlumnoDAOSql(null, null, null);
            String url = "jdbc:mysql://localhost:3306/caba";
            
            Map<String, String> config = new HashMap<>();
            // config.put(DAOFactory.TIPO_DAO, "TIPO_DAO_TXT");
            // config.put(DAOFactory.FULLPATH, "alumnos.txt");

            config.put(DAOFactory.TIPO_DAO, "TIPO_DAO_SQL");
            config.put(DAOFactory.URL_SQL, url);
            
            
            dao = factory.buildDAO(config);
            Alumno alu = new Alumno();
            alu.setDni(111);
            alu.setNombre("Juan");
            alu.setApellido("Perez");
            
            LocalDate fecNac = LocalDate.now();
            alu.setFecNac(fecNac);
            dao.create(alu);

            Alumno alu2 = new Alumno();
            alu2.setDni(12345679);
            alu2.setNombre("Ernesto");
            alu2.setApellido("Gonzalez");
            
            alu2.setFecNac(LocalDate.of(1999, 5, 10));
            dao.create(alu2);

        } catch (DAOException | PersonaException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOFactoryException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            ////////////////////
        
        try {
            Alumno aluRead = dao.read(12345678);
            System.out.println("Alumno leído OK: "+aluRead);
        } catch (DAOException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Alumno> alumnos;
        try {
            alumnos = dao.findAll(true);
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno leído con findAll: "+alumno);
        }
        } catch (DAOException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
