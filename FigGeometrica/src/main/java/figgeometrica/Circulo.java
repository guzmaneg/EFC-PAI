/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figgeometrica;

/**
 *
 * @author g.guzman
 */
public class Circulo extends FigGeometrica {
    private final double radio;

    public Circulo(double radio) {
        this.radio = radio;
        this.nombre = "Circulo";
    }

    @Override
    public double calcularPerimetro() {
        final double perimetro = Math.PI*(radio*2);
        
        return FigGeometricUtils.roundedValue(perimetro);
    }

    @Override
    public double calcularArea() {
        final double area = Math.PI * Math.pow(radio, 2);
        return FigGeometricUtils.roundedValue(area, 3);
    }

}
