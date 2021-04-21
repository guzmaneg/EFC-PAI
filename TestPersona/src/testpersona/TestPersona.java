/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpersona;

import java.util.logging.Level;
import java.util.logging.Logger;
import persona.MiCalendario;
import persona.MiCalendarioException;
import persona.Persona;
import persona.PersonaException;

/**
 *
 * @author gguzm
 */
public class TestPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona persona = new Persona();
        try {
            persona.setDni(10);
            persona.setNombre("   José  Maria ");
            persona.setApellido("Garcia");
            
            persona.setFechaNac(new MiCalendario(29, 2, 2020));
            System.out.println(persona.getFechaNac());
            
            
            Persona maria = new Persona(20);
            maria.setNombre("María");
            maria.setApellido("Gomez");

            Persona otraPersona = new Persona(30, "Juana", "Martinez");

            Persona otraPersona2 = new Persona(40, "Miguel", "Juarez", null);
        } catch (PersonaException | MiCalendarioException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        System.out.println("TODO OK");
    }
    
}
