/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import java.util.Calendar;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author g.guzman
 */
public abstract class Persona {
    
    private int dni;
    private String nombre;
    private String apellido;
    private char sexo;
    private Calendar fechaNac;

    public Persona() {
    }

    public Persona(int dni) throws PersonaInvalidaException {
        setDni(dni);
    }

    public Persona(int dni, String nombre, String apellido, char sexo, Calendar fechaNac) 
            throws PersonaInvalidaException, PersonaNombreException {
        setDni(dni);
        setNombre(nombre);
        this.apellido = apellido;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) throws PersonaInvalidaException {
        if (dni<=0) {
            throw new PersonaInvalidaException("El DNI deber se positivo.");
        }
        this.dni = dni;
    }

    public String getNombre() {
        if (StringUtils.isNotBlank(nombre)) {
            return nombre.trim();    
        }
        return StringUtils.EMPTY;
    }

    public void setNombre(String nombre) throws PersonaNombreException, PersonaInvalidaException {
        if (nombre==null) {
            throw new PersonaNombreException("El Nombre no puede ser nulo.");
        }
        if (StringUtils.isBlank(nombre)) {
            throw new PersonaInvalidaException("El Nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        // TODO Validar
        this.apellido = apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        // TODO: validar (M, F, m, f)
        this.sexo = sexo;
    }

    public Calendar getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Calendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", fechaNac=" + fechaNac + '}';
    }
    
    
}
