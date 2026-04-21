/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.experimental.UtilityClass;

/**
 *
 * @author g.guzman
 */
@UtilityClass
public class FiguraGeometricUtils {
    
    private static final int DEFAULT_SCALE = 2;
    
    
    public BigDecimal numberRounding(double number) {
        return numberRounding(DEFAULT_SCALE, number);
    }

    public BigDecimal numberRounding(int scale, double number) {
        if (scale < 0) throw new IllegalArgumentException();
        
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(scale, RoundingMode.HALF_UP);
        
        return bd;
    }
}
