/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persona.test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.MiCalendario;
import persona.MiCalendarioException;
import persona.Persona;
import persona.PersonaDniException;
import persona.PersonaException;
import persona.PersonaNombreException;

/**
 *
 * @author g.guzman
 */
public class PersonaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Persona unaPersona = new Persona();
        try {
            unaPersona.setDni(24004600);
            unaPersona.setNombre("   José   ");
            MiCalendario fecNac = new MiCalendario(40, 1, 2023);
/*            fecNac.set(Calendar.DAY_OF_MONTH, 31);
            fecNac.set(Calendar.MONTH, 1);
            fecNac.set(Calendar.YEAR, 2024);*/
            //Calendar fecNac = Calendar.getInstance();
            unaPersona.setFecNac(fecNac);
            System.out.println("Persona creada ==> "+unaPersona);
            /*
            Persona otraPersona = new Persona(-24004601);
            otraPersona.setNombre("Pepe");
            System.out.println("Perona creada ==> "+otraPersona);
            */
        } catch (PersonaDniException | PersonaNombreException | MiCalendarioException ex) {
            Logger.getLogger(PersonaTest.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        System.out.println("Ejecutado OK!!!");
    }
    
}
