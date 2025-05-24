/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdao;

import dao.AlumnoDAOTxt;
import dao.DAO;
import dao.DAOException;
import exceptions.PersonaException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
            dao = new AlumnoDAOTxt("alumnos.txt");
            Alumno alu = new Alumno();
            alu.setDni(10);
            alu.setNombre("Juan");
            alu.setApellido("Perez");
            
            LocalDate fecNac = LocalDate.now();
            alu.setFecNac(fecNac);
            dao.create(alu);

            Alumno alu2 = new Alumno();
            alu2.setDni(12345678);
            alu2.setNombre("Juanapppppppppppppppqwqwqwssasaas");
            alu2.setApellido("Gonzalez");
            
            alu2.setFecNac(LocalDate.of(1999, 5, 10));
            dao.create(alu2);

        } catch (DAOException | PersonaException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            ////////////////////
        
        try {
            Alumno aluRead = dao.read(12345678);
            System.out.println("Alumno leído OK: "+aluRead);
        } catch (DAOException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
