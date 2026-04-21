/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import exceptions.EdadInvalidaException;
import exceptions.NombreApellidoInvalidoException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author g.guzman
 */
public class Persona {
    public final static int EDAD_PROMEDIO = 70;
    //public final int legajo;
    //public static int STATIC = 800;

    private int dni;
    private String nombre;
    private String apellido;
    private short edad;
    // TODO: agregar fecNac;

    public Persona() {
        nombre = "";
    }

    public Persona(int dni) {
        this.dni = dni;
    }

    public Persona(int dni, String nombre, String apellido) throws NombreApellidoInvalidoException {
        this.dni = dni;
        setNombre(nombre);
        this.apellido = apellido;
    }

    public Persona(int dni, String nombre, String apellido, short edad) throws EdadInvalidaException, NombreApellidoInvalidoException {
        this.dni = dni;
        setNombre(nombre);
        this.apellido = apellido;
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreApellidoInvalidoException {
        if (StringUtils.isBlank(nombre)) {
            throw new NombreApellidoInvalidoException("El nombre es invalido");
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

//    public void setEdad(short edad) throws EdadInvalidaException {
    public void setEdad(short edad) {
        if (edad<=0) {
            //throw new EdadInvalidaException("La edad debe ser mayor a cero");
            throw new IllegalArgumentException("La edad debe ser mayor a cero");
        }
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    
    @Override
    public String toString() {
        return "Persona{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
