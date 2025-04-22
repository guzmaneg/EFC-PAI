/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figurageometrica;

/**
 *
 * @author g.guzman
 */
public class Triangulo extends FiguraGeometrica {
    protected double lado;
    protected double altura;

    public Triangulo(double lado, double altura) {
        super("Triángulo");
        this.lado = lado;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        
        return (lado*altura)/2;
    }

    @Override
    public double calcularPerimetro() {
        
        return lado*3;
    }
    
}
