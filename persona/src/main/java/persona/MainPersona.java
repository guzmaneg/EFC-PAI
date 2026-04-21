/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package persona;

import exceptions.EdadInvalidaException;
import exceptions.NombreApellidoInvalidoException;
import exceptions.PromedioInvalidoException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g.guzman
 */
public class MainPersona {

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        Persona unaPersona = new Persona();
        try {
            unaPersona.setNombre("John");
        } catch (NombreApellidoInvalidoException ex) {
            Logger.getLogger(MainPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        unaPersona.setApellido("Doe");
//        try {
            unaPersona.setEdad((short) 15);
//        } catch (EdadInvalidaException e) {
  //          System.out.println("Error setting age: " + e.getMessage());
    //    }
        unaPersona.setDni(12345678);
        System.out.println("First Name: " + unaPersona.getNombre());

        Persona otraPersona = new Persona(24046000);
        try {
            otraPersona.setNombre("	Federico     Matias    ");
        } catch (NombreApellidoInvalidoException ex) {
            Logger.getLogger(MainPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        otraPersona.setApellido("Smith");
//        try {
            otraPersona.setEdad((short) 0);
  //      } catch (EdadInvalidaException e) {
    //        throw new RuntimeException(e);
      //  }
        System.out.println("otraPersona: " + otraPersona.toString());
        System.out.println("otraPersona: " + otraPersona);

        Persona jose = null;
        try {
            jose = new Persona(24046001, "Jose", "Perez");
        } catch (NombreApellidoInvalidoException ex) {
            Logger.getLogger(MainPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
            jose.setEdad((short) 40);
  //      } catch (EdadInvalidaException e) {
    //        throw new RuntimeException(e);
      //  }

        Persona maria = null;
        try {
            maria = new Persona(24046002, "Maria", "Gomez", (short) 30);
        } catch (EdadInvalidaException e) {
            throw new RuntimeException(e);
        } catch (NombreApellidoInvalidoException ex) {
            Logger.getLogger(MainPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Edad de Maria: " + maria.getEdad());
        
        ////////////////////////////////////////////////
        // Alumno
        ////////////////////////////////////////////////
        Persona alu = new Alumno();
        System.out.println(alu);
        
        Alumno alu2 = new Alumno(8888888);
        System.out.println(alu2);
                
        Alumno alu3 = null;
        try {
            alu3 = new Alumno(8888888, "Ernesto", "García");
        } catch (NombreApellidoInvalidoException ex) {
            Logger.getLogger(MainPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(alu3);
        
        short edad = Persona.EDAD_PROMEDIO;
        short cantMatAprob = 50;
        // LocalDate fecIng = LocalDate.now();
        LocalDate fecIng = LocalDate.of(2025, Month.AUGUST, 1);
        try {
            Alumno alu4 = new Alumno(44444444, "Carla", "Gonzalez", edad, 1, fecIng, cantMatAprob);
            System.out.println("alu4 "+alu4);
        } catch (EdadInvalidaException | PromedioInvalidoException ex) {
            Logger.getLogger(MainPersona.class.getName()).log(Level.WARNING, null, ex);
            return;
        } catch (Exception ex) {
            Logger.getLogger(MainPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            System.out.println("finally!!!");
        }
        
        System.out.println("FIN OK!!!");
    }
}
