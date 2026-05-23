/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package persona;

import exceptions.DniInvalidoException;
import exceptions.NombreInvalidoException;
import java.time.LocalDate;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author g.guzman
 */
public class Persona {
    
    public static final int MIN_EDAD = 0;
    public static final int MAX_EDAD = 100;
    
    private int dni;
    private String nombre;
    private String apellido;
    private short edad;
    //private long cuil;
    private LocalDate fecNac;

    public Persona() {
    }

    public Persona(int dni) throws DniInvalidoException {
        setDni(dni);
    }

    public Persona(int dni, String nombre, String apellido) throws DniInvalidoException {
        setDni(dni);
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) throws DniInvalidoException {
        if (dni <=0) {
            throw new DniInvalidoException("El DNI "+dni+" es inválido");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreInvalidoException {
        // if (nombre==null || nombre.isBlank()) {
        if (StringUtils.isBlank(nombre)) {
            throw new NombreInvalidoException("El nombre no tiene contenido");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        if (edad<MIN_EDAD || edad>MAX_EDAD) {
            throw new IllegalArgumentException("La edad "+edad+" es invalida");
        }
        
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
        //return super.toString();
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    

}
