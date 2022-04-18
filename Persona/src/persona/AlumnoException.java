/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

/**
 * PersonaException
 * @author gguzm
 */
public class AlumnoException extends PersonaException {

    /**
     * Constructor para manejar una excepción del un Alumno
     * 
     */
    public AlumnoException() {
        super("");
    }

    /**
     * Constructor para manejar una excepción del un Alumno
     * @param mensaje El detalle del mensaje
     */
    public AlumnoException(String mensaje) {
        super(mensaje);
    }
    
}
