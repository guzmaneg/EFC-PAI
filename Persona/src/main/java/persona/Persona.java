/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import calendario.MiCalendario;
import java.util.Calendar;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author g.guzman
 */
public abstract class Persona {
    
    public static final String DELIM = "\t";
    private static final int NAME_MAX_LENGTH = 20;
    
    private int dni;
    private String nombre;
    private String apellido;
    private char sexo;
    private MiCalendario fechaNac;
    // protected String email;

    public Persona() {
    }

    public Persona(int dni) throws PersonaInvalidaException {
        setDni(dni);
    }

    public Persona(int dni, String nombre, String apellido, char sexo, MiCalendario fechaNac) 
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

    public MiCalendario getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(MiCalendario fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        String nombreStr = this.nombre.length()>NAME_MAX_LENGTH?this.nombre.substring(0, 20):
                this.nombre;
        String apellidoStr = this.apellido.length()>NAME_MAX_LENGTH?this.apellido.substring(0, 20):
                this.apellido;
        
        return StringUtils.leftPad(String.valueOf(dni), 8, '0') + DELIM + 
                StringUtils.rightPad(nombreStr, NAME_MAX_LENGTH, StringUtils.SPACE) + DELIM + 
                StringUtils.rightPad(apellidoStr, NAME_MAX_LENGTH, StringUtils.SPACE) + DELIM + 
                sexo + DELIM + 
                fechaNac;
    }
    
    public abstract String getInfoPersona();
    /*
    public String getInfoPersona() {
        
        return "getInfoPersona";
    }
    */
}
