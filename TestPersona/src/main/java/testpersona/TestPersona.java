/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testpersona;

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
        
        Persona unaPersona = new Persona(1234); // método constructor
        
        Persona otraPersona = new Persona(); // método constructor
        try {
            otraPersona.setDni(-12345678);
        } catch (Exception ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
            //return;
        }
        
        Persona personaNula = null; // método constructor
        
        System.out.println("unaPersona: "+unaPersona);
        System.out.println("otraPersona: "+otraPersona);
        System.out.println("personaNula: "+personaNula);
        
        
        Persona fullPersona = new Persona(-222333444, "Juan", "Perez");
        
        short edad = 50;
        fullPersona.setEdad(edad);
        
        System.out.println("fullPersona con edad: "+fullPersona.getEdad());
        
        Alumno unAlumno = new Alumno();
        try {
            unAlumno.setDni(656565656);
        } catch (Exception ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        unAlumno.setNombre("Ana");
        unAlumno.setApellido("Gomez");
        System.out.println("unAlumno con dni: "+unAlumno.getDni());


        int dni = -95959595;
        Alumno fullAlumno = new Alumno(dni, "Carlos", "Gimenez", 7.25);
        System.out.println("fullAlumno con dni: "+fullAlumno.getDni()+" - Nombre: "+
                fullAlumno.getNombre() + ", con Promedio= "+fullAlumno.getPromedio());

        System.out.println("unAlumno toString: "+unAlumno.toString());
        System.out.println("========================");
        System.out.println("========================");
        System.out.println("fullAlumno toString: "+fullAlumno);
    }

    
}
