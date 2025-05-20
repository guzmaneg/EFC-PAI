/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author g.guzman
 */
public class PersonaException extends Exception {

    public PersonaException() {
        super();
        System.out.println("Es una PersonaException");
    }

    
    
    public PersonaException(String message) {
        super(message);
        System.out.println("Es una PersonaException con parámetro");
    }
    
    
    
}
