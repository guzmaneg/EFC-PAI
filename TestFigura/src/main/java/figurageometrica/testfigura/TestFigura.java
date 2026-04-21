/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package figurageometrica.testfigura;

import figurageometrica.Circulo;
import figurageometrica.Cuadrado;
import figurageometrica.FiguraGeometrica;
import figurageometrica.Triangulo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g.guzman
 */
public class TestFigura {

    public static void main(String[] args) {
        FiguraGeometrica figura = new Cuadrado(8);
        figura.imprimirNombre();
        System.out.println("Con perimetro = "+figura.calcularPerimetro());
        System.out.println("Con area = "+figura.calcularArea());
        
        //////////////////
        figura = new Triangulo(5, 9);
        figura.imprimirNombre();
        System.out.println("Con perimetro = "+figura.calcularPerimetro());
        System.out.println("Con area = "+figura.calcularArea());
        
        System.err.println("========================");
        System.err.println("========================");
        
        ////////////////////
        List<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(new Cuadrado(11));
        figuras.add(new Triangulo(7, 9));
        figuras.add(new Circulo(2.33));
        
        for (FiguraGeometrica figuraGeometrica : figuras) {
            figuraGeometrica.imprimirNombre();
            System.out.println("Con perimetro = "+figuraGeometrica.calcularPerimetro());
            System.out.println("Con area = "+figuraGeometrica.calcularArea());
            System.out.println("========================");
        }
    }
}
