/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package testdao;

import dao.AlumnoDAOSQL;
import dao.AlumnoDAOTXT;
import dao.DAO;
import dao.DAOException;
import dao.DAOFactory;
import dao.DAOFactoryException;
import exceptions.NombreApellidoInvalidoException;
import exceptions.PromedioInvalidoException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public class TestDAO {

    public static void main(String[] args) throws DAOException {
        DAO dao = null;
        try {
//            DAO<Alumno, Integer> dao = new AlumnoDAOTXT("alumnos.txt");
            //DAO dao = new AlumnoDAOTXT("alumnos.txt");
            DAOFactory factory = DAOFactory.getInstance();
            // DAOFactory factory2 = DAOFactory.getInstance();
            // DAOFactory factory3 = DAOFactory.getInstance();
            
            Map<String, String> config = new HashMap<>();
//            config.put(DAOFactory.TIPO_DAO, DAOFactory.TIPO_DAO_TXT);
//            config.put(DAOFactory.FULLPATH, "alumnos.txt");
            
            config.put(DAOFactory.TIPO_DAO, DAOFactory.TIPO_DAO_SQL);
            config.put(DAOFactory.USER_DB, "root");
            config.put(DAOFactory.PWD_DB, "root");
            dao = factory.createDAO(config);
            
            Alumno alu = new Alumno(77789999);
            alu.setNombre("Sandra Juana");
            alu.setApellido("GARCIA");
            alu.setPromedio(7.33);
            alu.setFecIng(LocalDate.of(1993, 3, 15));
            dao.create(alu);
            
            alu = new Alumno(3999);
            alu.setNombre("Gabriela");
            alu.setPromedio(9.25);
            alu.setFecIng(LocalDate.of(2010, 1, 2));
            //dao.create(alu);
            
            Alumno aluRead = (Alumno) dao.read(7778999);
            System.out.println("Alumno leído: "+aluRead);
            //Alumno aluRead = dao.read(12345679);

        } catch (DAOException | NombreApellidoInvalidoException | PromedioInvalidoException | DAOFactoryException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            dao.close();
        }
        
    }
}
