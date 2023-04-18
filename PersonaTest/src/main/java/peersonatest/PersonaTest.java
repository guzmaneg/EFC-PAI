/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peersonatest;

import calendario.MiCalendario;
import calendario.MiCalendarioException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.Persona;
import persona.PersonaInvalidaException;
import persona.PersonaNombreException;

/**
 *
 * @author g.guzman
 */
public class PersonaTest {
    
    public static void main(String[] args) throws PersonaNombreException {
        /*
        Persona unaPersona = new Alumno();
        try {
            unaPersona.setDni(1);
            ((Alumno)unaPersona).setActivo(true);
        } catch (PersonaInvalidaException ex) {
            Logger.getLogger(PersonaTest.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        System.out.println("DNI de la persona: "+unaPersona.getDni());

        Persona otraPersona;
        try {
            otraPersona = new Alumno(24004600);
            otraPersona.setNombre("José");
        } catch (PersonaInvalidaException ex) {
            Logger.getLogger(PersonaTest.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        System.out.println("DNI de la persona: "+otraPersona.getDni());
            
        Persona maria;
        Calendar fechaNac;
        try {
            fechaNac = new GregorianCalendar();
            maria = new Alumno(24004601, "MAria", "", 'F', fechaNac);
        } catch (PersonaNombreException | PersonaInvalidaException ex) {
            Logger.getLogger(PersonaTest.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        System.out.println("DNI de la persona "+maria.getNombre()+" es "+maria.getDni() + " - "+ fechaNac);

        Persona pepe;
        Calendar fechaNacPepe = Calendar.getInstance();
        try {
            pepe = new Alumno(24004602);
            pepe.setFechaNac(fechaNacPepe);
        } catch (PersonaInvalidaException ex) {
            Logger.getLogger(PersonaTest.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        System.out.println("DNI de la persona "+pepe.getNombre()+" es "+pepe.getDni());
        System.out.println("Fecha NAc PEPE "+
                pepe.getFechaNac().get(Calendar.DAY_OF_MONTH) + "/"+
                pepe.getFechaNac().get(Calendar.MONTH) + "/"+
                pepe.getFechaNac().get(Calendar.YEAR));

        
        */
        Persona manuela;
        
        try {
            Calendar fechaNacManu = new MiCalendario(17, 55, 2023);
            manuela = new Alumno(24004603);
            manuela.setFechaNac(fechaNacManu);
        } catch (PersonaInvalidaException | MiCalendarioException ex) {
            Logger.getLogger(PersonaTest.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        System.out.println("Datos de Manuela "+manuela);

    }
}
