/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figgeometrica;

/**
 *
 * @author g.guzman
 */
public class Cuadrado extends FigGeometrica {
    private final double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
        this.nombre = "Cuadrado";
    }
    
    @Override
    public double calcularPerimetro() {
        
        return lado*4;
    }

    @Override
    public double calcularArea() {
        return lado*lado;
    }

    @Override
    public void imprimirNombre() {
        System.out.println("Hola! ");
        super.imprimirNombre();
    }
    
    
}
