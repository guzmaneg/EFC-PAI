/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdao;

import dao.AlumnoDAOTxt;
import dao.DAO;
import dao.DAOException;
import exceptions.DniPersonaException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
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
        try {
            AlumnoDAOTxt dao = new AlumnoDAOTxt("alumnos.txt");
            Alumno alu = new Alumno(27, "Juan Erensto Estinis", "Perez", 6.35);
            LocalDate fecNac = LocalDate.of(1974, Month.AUGUST, 23);
            alu.setFecNac(fecNac);
            dao.create(alu);
        } catch (DAOException | DniPersonaException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
