/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package testpersona;

import exceptions.DniInvalidoException;
import exceptions.NombreInvalidoException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.Persona;

/**
 *
 * @author g.guzman
 */
public class TestPersona {

    public static void main(String[] args) {
        Persona unaPersona = new Persona();
        try {
            unaPersona.setDni(12345678);
        } catch (Exception ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Persona otraPersona;
        try {
            otraPersona = new Persona(24004600);
            otraPersona.setNombre("    Juan    ");
            //otraPersona.setNombre("");
            //otraPersona.setNombre(null);
            //otraPersona.setNombre("	");
            
            //System.out.println("otraPersona: "+otraPersona);
            System.out.println("otraPersona: "+otraPersona.toString());
            
        } catch (DniInvalidoException | NombreInvalidoException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Persona maria = new Persona();
        try {
            maria.setDni(1);
        } catch (DniInvalidoException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        short edadMaria = Persona.MAX_EDAD;
        maria.setEdad(edadMaria);
        
        Persona personaNula = null;
        //personaNula.getDni();
        try {
            // Alumno
            short cantMatAprob = 15;
            LocalDate fecIng = LocalDate.of(1993, Month.MARCH, 1);
            Alumno alu = new Alumno(cantMatAprob, 7.50, fecIng, 
                    12345678, "Juan", "Garcia");
            //System.out.println("Alumno instanciado OK: "+alu.toString());
            System.out.println("Alumno instanciado OK: "+alu);
        } catch (DniInvalidoException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("FIN!");
        
    }
}
