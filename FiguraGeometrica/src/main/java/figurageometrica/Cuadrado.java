/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figurageometrica;

import java.math.BigDecimal;
import utils.FiguraGeometricUtils;

/**
 *
 * @author g.guzman
 */
public class Cuadrado extends FiguraGeometrica {

    private final double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
        nombre = "Cuadrado";
    }
    
    @Override
    public double calcularPerimetro() {
        BigDecimal rounded = FiguraGeometricUtils.numberRounding(lado*4);
        
        return rounded.doubleValue();
    }

    @Override
    public double calcularArea() {
        BigDecimal rounded = FiguraGeometricUtils.numberRounding(lado*lado);
        
        return rounded.doubleValue();
    }
    
}
