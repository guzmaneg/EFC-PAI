/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figurageometrica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import utils.FiguraGeometricUtils;

/**
 *
 * @author g.guzman
 */
public class Circulo extends FiguraGeometrica {
    
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
        nombre = "Circulo";
    }
    
    @Override
    public double calcularPerimetro() {
        final double perimetroDouble = Math.PI*(2*radio);
        BigDecimal rounded = FiguraGeometricUtils.numberRounding(6, perimetroDouble);
        
        return rounded.doubleValue();
    }

    @Override
    public double calcularArea() {
        final double areaDouble = Math.PI*Math.pow(radio, 2);
        BigDecimal rounded = FiguraGeometricUtils.numberRounding(areaDouble);
        
        return rounded.doubleValue();
    }
    
}
