/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import exceptions.NombreNullException;
import exceptions.NombreVacioException;
import exceptions.PersonaException;
import java.rmi.AccessException;

/**
 *
 * @author g.guzman
 */
public class Persona {
    
    private Integer dni;
    private String nombre;
    private String apellido;
    private Short edad;
    //private Long cbu;

    public Persona() {
        nombre = "";
    }
    
    public Persona(Integer dni) throws PersonaException {
        setDni(dni);
    }

    public Persona(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) throws PersonaException {
        if (dni==null || dni <=0) {
            throw new PersonaException("El DNI "+dni+" es inválido");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    //public void setNombre(String nombre) throws NombreNullException, NombreVacioException {
    public void setNombre(String nombre) throws PersonaException {
        if (nombre==null) {
            throw new NombreNullException("El nombre es nulo");
        }
        String nombreTrim = nombre.trim();
        if (nombreTrim.length()==0) {
            throw new NombreVacioException("El nombre no tiene contenido");
        }
        this.nombre = nombreTrim;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getFullName() {
        return nombre + " "+apellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
    
}
