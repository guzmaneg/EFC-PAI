/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figurageometrica;

/**
 *
 * @author g.guzman
 */
public abstract class FiguraGeometrica {
    public static final double PI_VALUE = Math.PI;

    protected String nombre;
    
    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    
    public String mostrarNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
