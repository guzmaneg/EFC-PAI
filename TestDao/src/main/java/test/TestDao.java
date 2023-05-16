/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import calendario.MiCalendario;
import calendario.MiCalendarioException;
import dao.AlumnoDaoTXT;
import dao.DAO;
import dao.DaoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.PersonaInvalidaException;
import persona.PersonaNombreException;

/**
 *
 * @author g.guzman
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Alumno alumno = null;
        DAO<Alumno, Integer> dao;
        try {
            alumno = new Alumno(24004602);
            dao = new AlumnoDaoTXT("alumno.txt");
            alumno.setApellido("Gonzalez Martinez Cuarta");
            alumno.setNombre("Juana");
            alumno.setSexo('F');
            alumno.setFechaNac(new MiCalendario(5, 1, 1990));
            dao.create(alumno);
            
            Alumno alumno2 = alumno = new Alumno(24004601);
            alumno2.setApellido("Gonzalez Martinez Cuarta");
            alumno2.setNombre("Juana la Loca");
            alumno2.setSexo('F');
            alumno2.setFechaNac(new MiCalendario(5, 1, 1990));
            alumno2.setNombre(alumno.getNombre());
            dao.update(alumno2);
        } catch (DaoException | PersonaInvalidaException | PersonaNombreException | MiCalendarioException ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
