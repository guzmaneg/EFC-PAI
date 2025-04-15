/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

/**
 *
 * @author g.guzman
 */
public class Alumno extends Persona {

    private Double promedio;
    
    public Alumno() {
        super();
    }
    
    public Alumno(int dni, String nombre, String apellido, Double promedio) throws Exception {
        super(dni, nombre, apellido);
        this.promedio = promedio;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return super.toString() + ", con Promedio = "+promedio; 
    }
    
    
}
