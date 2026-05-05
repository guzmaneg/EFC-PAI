/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package testdao;

import dao.AlumnoDAOTXT;
import dao.DAO;
import dao.DAOException;
import exceptions.NombreApellidoInvalidoException;
import exceptions.PromedioInvalidoException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public class TestDAO {

    public static void main(String[] args) {
        try {
//            DAO<Alumno, Integer> dao = new AlumnoDAOTXT("alumnos.txt");
            DAO dao = new AlumnoDAOTXT("alumnos.txt");
            
            Alumno alu = new Alumno(12777777);
            alu.setNombre("Gabriel");
            alu.setPromedio(10);
            alu.setFecIng(LocalDate.of(1993, 3, 15));
            dao.create(alu);
            
            alu = new Alumno(3999);
            alu.setNombre("Gabriela");
            alu.setPromedio(9.25);
            alu.setFecIng(LocalDate.of(2010, 1, 2));
            dao.create(alu);
            
            Alumno aluRead = (Alumno) dao.read(9);
            System.out.println("Alumno leído: "+aluRead);
            //Alumno aluRead = dao.read(12345679);
            
        } catch (DAOException | NombreApellidoInvalidoException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PromedioInvalidoException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
