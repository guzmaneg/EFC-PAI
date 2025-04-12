/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

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
    
    public Persona(Integer dni) {
        this.dni = dni;
    }

    public Persona(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) throws IllegalArgumentException {
        if (dni==null || dni <=0) {
            throw new IllegalArgumentException("El DNI "+dni+" es inválido");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws IllegalArgumentException, AccessException {
        if (nombre==null) {
            throw new IllegalArgumentException("El nombre es nulo");
        }
        if (nombre.length()==0) {
            throw new AccessException("El nombre no tiene contenido");
        }
        this.nombre = nombre.trim();
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
