/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui.personatest;

import gui.persona.Persona;
import gui.persona.PersonaException;
import gui.persona.PersonaUtils;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g.guzman
 */
public class PersonaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("TODO OK !!!");
        
        Persona persona = new Persona();
        persona.setDni(24004600);
        System.out.println("Persona con DNI = "+persona.getDni());
        
        Persona persona2 = new Persona(24004601);
        System.out.println("Persona2 con DNI = "+persona2.getDni());
        persona2.setDni(24004602);
        
        Persona persona3;
        try {
            persona3 = new Persona(15, null, "Perez", LocalDate.MIN);
        } catch (PersonaException ex) {
            Logger.getLogger(PersonaTest.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        System.out.println("Persona3 = "+persona3);
        persona3.setFechaNac(LocalDate.now());
        System.out.println("Persona3 con now() = "+persona3.toString());
        System.out.println("Persona3 con now() = "+PersonaUtils.getFechaNacStr(persona3));
        
        System.out.println("Fin !!!");
        
        // Sobre carga
        // System.out.println(Integer.valueOf("10"));
        // System.out.println(Integer.valueOf(20));
        
        PersonaUtils.getFechaNacStr(persona);
    }
    
}
