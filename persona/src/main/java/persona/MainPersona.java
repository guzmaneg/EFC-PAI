/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package persona;

import exceptions.EdadInvalidaException;

/**
 *
 * @author g.guzman
 */
public class MainPersona {

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        Persona unaPersona = new Persona();
        unaPersona.setNombre("John");
        unaPersona.setApellido("Doe");
        try {
            unaPersona.setEdad((short) 15);
        } catch (EdadInvalidaException e) {
            System.out.println("Error setting age: " + e.getMessage());
        }
        unaPersona.setDni(12345678);
        System.out.println("First Name: " + unaPersona.getNombre());

        Persona otraPersona = new Persona(24046000);
        otraPersona.setNombre("Jane");
        otraPersona.setApellido("Smith");
        try {
            otraPersona.setEdad((short) 25);
        } catch (EdadInvalidaException e) {
            throw new RuntimeException(e);
        }
        System.out.println("otraPersona: " + otraPersona.toString());
        System.out.println("otraPersona: " + otraPersona);

        Persona jose = new Persona(24046001, "Jose", "Perez");
        try {
            jose.setEdad((short) 40);
        } catch (EdadInvalidaException e) {
            throw new RuntimeException(e);
        }

        Persona maria = null;
        try {
            maria = new Persona(24046002, "Maria", "Gomez", (short) 30);
        } catch (EdadInvalidaException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Edad de Maria: " + maria.getEdad());

    }
}
