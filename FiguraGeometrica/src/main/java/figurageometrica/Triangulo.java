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
public class Triangulo extends FiguraGeometrica {

    private final double base;
    private final double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        nombre = "Triangulo";
    }
    
    
    
    @Override
    public double calcularPerimetro() {
        BigDecimal rounded = FiguraGeometricUtils.numberRounding(base*3);
        return  rounded.doubleValue();
    }

    @Override
    public double calcularArea() {
        BigDecimal rounded = FiguraGeometricUtils.numberRounding((base*altura)/2);
        return  rounded.doubleValue();
    }
}
