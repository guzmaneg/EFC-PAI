/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package persona;

import exceptions.DniInvalidoException;

/**
 *
 * @author g.guzman
 */
public class Persona {
    
    private int dni;
    private String nombre;
    private String apellido;
    private short edad;
    private long cuil;

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) throws Exception {
        if (edad<0 || edad>100) {
            throw new Exception("La edad "+edad+" es inválida");
        }
        
        this.edad = edad;
    }

    public long getCuil() {
        return cuil;
    }

    public void setCuil(long cuil) {
        this.cuil = cuil;
    }

    public Persona() {
    }

    public Persona(int dni) throws DniInvalidoException {
        setDni(dni);
    }

    public Persona(int dni, String nombre, String apellido) {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
