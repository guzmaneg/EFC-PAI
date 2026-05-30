/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package testdao.testalumnodao;

import dao.DAO;
import dao.DAOException;
import dao.DAOFactory;
import static dao.DAOFactory.PATH_FILE;
import static dao.DAOFactory.PWD_DB;
import static dao.DAOFactory.TIPO_DAO;
import static dao.DAOFactory.TIPO_DAO_SQL;
import static dao.DAOFactory.TIPO_DAO_TXT;
import static dao.DAOFactory.URL_DB;
import static dao.DAOFactory.USER_DB;
import dao.DAOFactoryException;
import exceptions.DniInvalidoException;
import exceptions.NombreInvalidoException;
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
public class TestAlumnoDAO {

    public static void main(String[] args) throws DniInvalidoException {
        try {
            //DAO dao = new AlumnoDAOTXT("alumnos.txt");
            DAOFactory factory = DAOFactory.getInstance();
            // DAOFactory factory2 = DAOFactory.getInstance();
            // DAOFactory factory3 = DAOFactory.getInstance();
            
            Map<String ,String> config = new HashMap<>();
            // config.put(TIPO_DAO, TIPO_DAO_TXT);
            // config.put(PATH_FILE, "alumnos.txt");
            config.put(TIPO_DAO, TIPO_DAO_SQL);
            config.put(URL_DB, "jdbc:mysql://localhost:3306/universidad_caba");
            config.put(USER_DB, "root");
            config.put(PWD_DB, "root");
            
            DAO<Alumno, Integer> dao = factory.createDAO(config);
            // DAO<Alumno, Integer> dao = new AlumnoDAOTXT("alumnos.txt");
            //DAO<Alumno, Integer> dao = new AlumnoDAOSQL("jdbc:mysql://localhost:3306/universidad_caba", 
              //      "root", "root");
            
            //LocalDate fecIng = LocalDate.now();
            LocalDate fecIng = LocalDate.now().minusYears(35);
//            Alumno alu = new Alumno((short)25, 7.25, fecIng, 88888888, "Lionel", "Messi");
            Alumno alu = new Alumno();
            alu.setDni(888888);
            alu.setNombre("LIONEL");
            alu.setApellido("MESSI");
            alu.setFecNac(LocalDate.now().minusYears(35));
            //dao.create(alu);
            
//            Alumno aluRead = (Alumno) dao.read(29);
            Alumno aluRead = dao.read(2);
            System.out.println("aluRead = "+ aluRead);
            
        } catch (DAOException | DniInvalidoException ex) {
            Logger.getLogger(TestAlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NombreInvalidoException ex) {
            Logger.getLogger(TestAlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOFactoryException ex) {
            Logger.getLogger(TestAlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
