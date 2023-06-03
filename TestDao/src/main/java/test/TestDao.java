/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import dao.AlumnoDaoSql;
import dao.AlumnoDaoTxt;
import dao.Dao;
import dao.DaoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.AlumnoException;
import persona.MiCalendario;
import persona.MiCalendarioException;
import persona.PersonaDniException;
import persona.PersonaNombreException;

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
            // Dao<Alumno, Integer> dao = new AlumnoDaoTxt("alumnos.txt");
            Dao<Alumno, Integer> dao = new AlumnoDaoSql("jdbc:mysql://localhost:3306/universidad_caba", 
                    "root", "root");
            MiCalendario fecNac = new MiCalendario(10, 8, 1987);
            MiCalendario fecIng = new MiCalendario(1, 3, 2020);
            Alumno alumno = new Alumno(fecIng, 22, 7.33, 'F', 3, 
                    "Mariana", "Gomez", fecNac);
            
            // dao.create(alumno);
            //dao.update(alumno);
            
            List<Alumno> alumnos = dao.findAll(true);
            for (Alumno alumno1 : alumnos) {
                System.out.println("Alumno: "+alumno1);
            }
        } catch (DaoException | MiCalendarioException | PersonaNombreException | AlumnoException | PersonaDniException ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
