/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.persona;

import java.time.LocalDate;

/**
 *
 * @author g.guzman
 */
public class Persona {
    public static final char DELIM = '\t';
    
    private int dni;
    private String nombre;
    private String apellido;
    protected LocalDate fechaNac;

    // Suite de Contructores
    public Persona() {
        nombre = "";
    }
    
    public Persona(int dni) {
        this.dni = dni;
    }
    public Persona(int dni, String nombre, String apellido) throws PersonaException {
        this.dni = dni;
        setNombre(nombre);
        this.apellido = apellido;
    }
    public Persona(int dni, String nombre, String apellido, LocalDate fechaNac) throws PersonaException {
        this.dni = dni;
        setNombre(nombre);
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }
    
    // Getters and Setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        if (nombre==null) {
            return nombre;
        }
        return nombre.trim();
    }

    public final void setNombre(String nombre) throws PersonaException {
        if (nombre==null) {
            throw new PersonaException("El nombre NO puede ser null");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }
    /*
    public String getFechaNacStr() {
        return "FechaNac en formato dd/MM/aaaa = "+fechaNac.getDayOfMonth()+"/"+fechaNac.getMonthValue()+"/"+fechaNac.getYear();
    }
    */

    /**
     * Setea la fecha de Nacimiento de la persona
     * @param fechaNac La fecha de Nacimiento
     */
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * toString de Persona
     */    
    @Override
    public String toString() {
        return String.format("%08d%c%20s%c%20s%c%02d/%02d/%04d", this.dni, DELIM, this.getNombre(), DELIM, this.apellido, DELIM,
                this.fechaNac.getDayOfMonth(), this.fechaNac.getMonthValue(), this.fechaNac.getYear()); 
    }
    
}
