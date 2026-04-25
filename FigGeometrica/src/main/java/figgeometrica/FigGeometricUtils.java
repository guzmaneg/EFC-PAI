/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figgeometrica;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author g.guzman
 */
public final class FigGeometricUtils {
    
    private static final int DEFAULT_SCALE = 2;

    private FigGeometricUtils() {
    }
    
    public static double roundedValue(double valor, int scale) {
        BigDecimal bg = BigDecimal.valueOf(valor);
        final BigDecimal setScale = bg.setScale(scale, RoundingMode.HALF_UP);
        
        return setScale.doubleValue();
    }
    
    public static double roundedValue(double valor) {
        return roundedValue(valor, DEFAULT_SCALE);
    }
}
