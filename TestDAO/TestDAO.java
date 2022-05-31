/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import dao.AlumnoDaoSql;
import dao.DAO;
import dao.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.AlumnoException;
import persona.MiCalendario;
import persona.MiCalendarioExcpetion;
import persona.Persona;
import persona.PersonaException;
import persona.PersonaNombreException;

/**
 *
 * @author gguzm
 */
public class TestDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DAO<Alumno, Integer> dao = new AlumnoDaoSql("jdbc:mysql://localhost:3306/efc", "root", "root");
            Persona persona = new Persona(5, "Javier Carlos", "Ramirez", new MiCalendario(1, 1, 2001));
            dao.create(new Alumno(persona, new MiCalendario(1, 1, 2020), 2, 2.25));
            
            Alumno alu = dao.read(24004621);
            System.out.println("Alumno leído ==> "+ alu);
        } catch (DAOException | MiCalendarioExcpetion | PersonaException | PersonaNombreException | AlumnoException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
