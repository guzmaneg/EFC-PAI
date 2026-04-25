/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package testfigura;

import figgeometrica.Circulo;
import figgeometrica.Cuadrado;
import figgeometrica.FigGeometrica;
import figgeometrica.Triangulo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g.guzman
 */
public class TestFigura {

    public static void main(String[] args) {
        FigGeometrica cuadrado = new Cuadrado(5);
        FigGeometrica triangulo = new Triangulo(4, 7);
        
        cuadrado.imprimirNombre();
        System.out.println("Con perimetro = "+cuadrado.calcularPerimetro());
        
        triangulo.imprimirNombre();
        System.out.println("Con perimetro = "+triangulo.calcularPerimetro());
        
        /////////////////////////////////////////
        List<FigGeometrica> figuras = new ArrayList<>();
        figuras.add(new Cuadrado(9));
        figuras.add(new Triangulo(3, 6.5));
        figuras.add(new Circulo(2.33));
        
        System.out.println("===========");
        for (FigGeometrica figura : figuras) {
            figura.imprimirNombre();
            System.out.println("Con perimetro = "+figura.calcularPerimetro());
            System.out.println("Con area = "+figura.calcularArea());
            System.out.println("===========");
        }
    }
}
