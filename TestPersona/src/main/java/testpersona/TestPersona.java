/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package testpersona;

import exceptions.DniInvalidoException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            otraPersona = new Persona(-24004600);
        } catch (DniInvalidoException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        otraPersona.setNombre("Juan");
        
        Persona maria = new Persona();
        try {
            maria.setDni(1);
        } catch (DniInvalidoException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("FIN!");
        
    }
}
