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
    private final double base;
    private final double altura;

    public Triangulo(double base, double altura) {
        super("Triángulo");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularPerimetro() {
        
        return base*3;
    }

    @Override
    public double calcularArea() {
        return (base*altura)/2;
    }
    
}
