
import figurageometrica.Circulo;
import figurageometrica.Cuadrado;
import figurageometrica.FiguraGeometrica;
import figurageometrica.Triangulo;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author g.guzman
 */
public class TestFiguraGeometrica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        FiguraGeometrica figuraGeometrica = new Cuadrado(20);
        double area = figuraGeometrica.calcularArea();
        System.out.println("Area de la figura: "+area);

        figuraGeometrica = new Triangulo(15, 10);
        area = figuraGeometrica.calcularArea();
        System.out.println("Area de la figura: "+area);
        */
        List<FiguraGeometrica> lista = new ArrayList<>();
        
        FiguraGeometrica cuadrado = new Cuadrado(20);
        lista.add(cuadrado);
        
        FiguraGeometrica triangulo = new Triangulo(15, 10);
        lista.add(triangulo);
        
        //lista.add(new Circulo("Círculo"));
        // lista.add(new Circulo());
        
        /*
        Cuadrado cuadrado1 = new Cuadrado(99);
        lista.add(cuadrado1);
        */
        lista.add(new Cuadrado(99));
        
        for (FiguraGeometrica figuraGeometrica : lista) {
            System.out.println("Nombre figura = "+figuraGeometrica.mostrarNombre());
            System.out.println("Área figura = "+figuraGeometrica.calcularArea());
            System.out.println("Perímetro figura = "+figuraGeometrica.calcularPerimetro());
            System.out.println("=========================");
            //System.out.println("PI_VALUE = "+figuraGeometrica.PI_VALUE);
        }
        
        System.out.println("PI_VALUE = "+FiguraGeometrica.PI_VALUE);
        System.out.println("PI_VALUE = "+Math.PI);
        
        /////////////////////////////////////////////////////
        ////////////////////////////////////////////////////
        
        List<FiguraGeometrica> lista2 = new ArrayList<>();
        
        FiguraGeometrica figura = new Cuadrado(25);
        lista2.add(figura);
        figura = new Cuadrado(75);
        lista2.add(figura);
        figura.setNombre("Nuevo Nombre");

        System.out.println("TestFiguraGeometrica.main()");
    }
    
}
