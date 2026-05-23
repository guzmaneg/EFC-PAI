/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package testdao.testalumnodao;

import dao.AlumnoDAOTXT;
import dao.DAO;
import dao.DAOException;
import exceptions.DniInvalidoException;
import java.time.LocalDate;
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
            DAO<Alumno, Integer> dao = new AlumnoDAOTXT("alumnos.txt");
            
            //LocalDate fecIng = LocalDate.now();
            LocalDate fecIng = LocalDate.now().minusYears(35);
            Alumno alu = new Alumno((short)25, 7.25, fecIng, 88888888, "Lionel", "Messi");
            //dao.create(alu);
            
//            Alumno aluRead = (Alumno) dao.read(29);
            Alumno aluRead = dao.read(88888888);
            System.out.println("aluRead = "+ aluRead);
            
        } catch (DAOException | DniInvalidoException ex) {
            Logger.getLogger(TestAlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
