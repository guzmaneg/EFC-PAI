/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import exceptions.NombreNullException;
import exceptions.DniPersonaException;
import exceptions.NombreVacioException;
import java.time.LocalDate;


/**
 *
 * @author g.guzman
 */
public class Persona {

    public static final char DELIM = '\t';
    private static final int NOMBRE_MAX_LENGHT = 20;
    
    private Integer dni;
    private String nombre;
    private String apellido;
    private LocalDate fecNac;
    private char estado; // A, B, M

    public Persona() {
        //cbu = 1L;
    }

    public Persona(int dni) throws DniPersonaException {
        setDni(dni);
    }

    public Persona(int dni, String nombre, String apellido) throws DniPersonaException {
        setDni(dni);
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) throws DniPersonaException {
        if (dni<=0) {
            // Error
            throw new DniPersonaException("El dni deber ser positivo");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    // public void setNombre(String nombre) throws PersonaException {
    public void setNombre(String nombre) throws NombreNullException, NombreVacioException {
        if (nombre==null) {
            throw new NombreNullException("El nombre NO debe ser null");
        }
        if (nombre.length()==0) {
            throw new NombreVacioException("El nombre NO debe ser estar vacío");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /*
    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }
*/

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }
    
    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    
    
    @Override
    public String toString() {
        String nombreTrunc = nombre.length()>NOMBRE_MAX_LENGHT?nombre.substring(0, NOMBRE_MAX_LENGHT):
                                                nombre;
        
        return String.format("%08d%c%"+NOMBRE_MAX_LENGHT+"s%c%02d/%02d/%4d", dni, DELIM, nombreTrunc, DELIM,
                fecNac.getDayOfMonth(), fecNac.getMonthValue(),fecNac.getYear());
    }

    
    
}
