/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

/**
 *
 * @author g.guzman
 */
public class Persona {

    private Integer dni;
    private String nombre;
    private String apellido;
    private Short edad;
    private Long cbu;

    public Persona() {
        cbu = 1L;
    }

    public Persona(int dni) {
        this.dni = dni;
    }

    public Persona(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) throws Exception {
        if (dni<=0) {
            // Error
            throw new Exception("El dni deber ser positivo");
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

    /**
     * @return the edad
     */
    public Short getEdad() {
        return edad;
    }
    
    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cbu=" + cbu + '}';
    }

    
    
}
