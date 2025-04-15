/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testpersona;

import exceptions.DniPersonaException;
import exceptions.NombreNullException;
import exceptions.NombreVacioException;
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
        System.out.println("Ejecuta OK !!!");
        
        Persona unaPersona = null;
        try {
            unaPersona = new Persona(-1234); // método constructor
        } catch (DniPersonaException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Frenado OK !!!");
            //return;
        }
        finally {
            // siempre se ejecuta
            System.out.println("Finally ejecutado !!!");
        }
        
        Persona otraPersona = new Persona(); // método constructor
        try {
            otraPersona.setDni(12345678);
        } catch (Exception ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        Persona personaNula = null; // método constructor
        
        //System.out.println("unaPersona: "+unaPersona);
        System.out.println("otraPersona: "+otraPersona);
        System.out.println("personaNula: "+personaNula);
        
        
        Persona fullPersona = null;
        try {
            fullPersona = new Persona(222333444, "Juan", "Perez");
        } catch (Exception ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        short edad = 50;
        fullPersona.setEdad(edad);
        
        System.out.println("!!! fullPersona con edad: "+fullPersona.getEdad() + " con DNI:"+fullPersona.getDni());
        
        Alumno unAlumno = new Alumno();
        try {
            unAlumno.setDni(656565656);
        } catch (Exception ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            unAlumno.setNombre(null);
        } catch (NombreNullException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, "Error null", ex);
        } catch (NombreVacioException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, "Error vacio", ex);
        }
/*
        try {
            unAlumno.setNombre("");
        } catch (PersonaException ex) {
            if (ex instanceof NombreNullException) {
                Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, "Error null", ex);    
            }
            else if (ex instanceof NombreVacioException) {
                Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, "Error vacio", ex);
            }
        } 
*/
        unAlumno.setApellido("Gomez");
        System.out.println("unAlumno con dni: "+unAlumno.getDni());


        int dni = 95959595;
        Alumno fullAlumno = null;
        try {
            fullAlumno = new Alumno(dni, "Carlos", "Gimenez", 7.25);
        } catch (Exception exc) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, exc);
        }
        System.out.println("fullAlumno con dni: "+fullAlumno.getDni()+" - Nombre: "+
                fullAlumno.getNombre() + ", con Promedio= "+fullAlumno.getPromedio());

        System.out.println("unAlumno toString: "+unAlumno.toString());
        System.out.println("========================");
        System.out.println("========================");
        System.out.println("fullAlumno toString: "+fullAlumno);
    }

    
}
