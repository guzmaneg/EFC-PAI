/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testpersona;

import java.rmi.AccessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.Persona;

/**
 *
 * @author g.guzman
 */
public class TestPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ejecuta OK");
        Persona unaPersona = new Persona();
        try {
            unaPersona.setDni(656565);
        } catch (IllegalArgumentException e) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, e);
            return;
        }

        // System.out.println("Persona: "+unaPersona);
        System.out.println("Persona con DNI: " + unaPersona.getDni());

        //////////////////////////////
        Persona otraPersona = new Persona(555666777);
        System.out.println("Otra Persona con DNI: " + otraPersona.getDni());
        //////////////////////////////

        //////////////////////////////
        Persona fullPersona = new Persona(555666777);

        try {
            fullPersona.setNombre("Juan   ");
        } catch (Exception ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        fullPersona.setApellido("Perez   ");
        /*
        System.out.println("Full Persona con DNI: "+fullPersona.getDni() + " con nombre = "+
        fullPersona.getNombre() + " "+fullPersona.getApellido());
         */
        System.out.println("Full Persona con DNI: " + fullPersona.getDni() + " con nombre = "
                + fullPersona.getFullName());
        //////////////////////////////

        Persona fullPersona2 = new Persona(555666777, "Carlos   ", "    Gomez");
        System.out.println("Full Persona2 con DNI: " + fullPersona2.getDni() + " con nombre = "
                + fullPersona2.getFullName());

        ////////////////////////
        Persona personaConNombreNull = new Persona(95959595);

        try {
            //personaConNombreNull.setNombre(null);
            //personaConNombreNull.setNombre("");
            personaConNombreNull.setNombre("peep");
            ////////////////////////
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } catch (AccessException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.WARNING, null, ex);
            return;
        }

            
        ////////////////////////
        Persona alu = new Alumno();
        Persona aluDni = new Alumno(7.25, 1551515);
        
        ////////////////////////
        System.out.println("Ejecuta FIN OK");

    }
}
