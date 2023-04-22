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
    
    private MiCalendario fecNac; // 40/04/2023 ==> 10/05/2023

    private char sexo;

    public Persona() {
    }
    
    public Persona(int dni) throws PersonaDniException {
        setDni(dni);
    }

    public Persona(int dni, String nombre, String apellido, MiCalendario fecNac, char sexo) 
            throws PersonaNombreException, PersonaDniException {
        setDni(dni);
        setNombre(nombre);
        this.apellido = apellido;
        this.fecNac = fecNac;
        this.sexo = sexo;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(final int dni) throws PersonaDniException {
        if (dni <=0) {
            throw new PersonaDniException("El DNI ("+dni+") debe ser positivo");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre==null?null:nombre.trim();
    }

    public void setNombre(String nombre) throws PersonaNombreException {
        if (StringUtils.isBlank(nombre)) {
            throw new PersonaNombreException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public MiCalendario getFecNac() {
        return fecNac;
    }

    public void setFecNac(MiCalendario fecNac) {
        this.fecNac = fecNac;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "DNI: "+dni + "- Nombre: "+nombre + 
                " - Fecha Nac.: "+fecNac; 
    }
    
    
}
