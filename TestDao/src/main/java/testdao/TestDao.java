/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdao;

import dao.DAO;
import dao.DaoException;
import dao.DaoTXT;
import gui.persona.Alumno;
import gui.persona.Carrera;
import gui.persona.PersonaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g.guzman
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DAO dao = new DaoTXT("alumnos.txt");
            LocalDate fecNac = LocalDate.of(1999, 11, 5);
            LocalDate fecIng = LocalDate.of(2015, 3, 1);
            List<Carrera> carreras = new ArrayList<>();
            int legajo = 1;
            int dni = 2345678;
            short cantMatAprb = 2;
            Alumno alu = new Alumno(legajo, cantMatAprb, 8, fecIng, carreras, dni, "Juana Mariela", "Perez Gomez", 
                    fecNac);
            dao.create(alu);
            
        } catch (DaoException | PersonaException ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
