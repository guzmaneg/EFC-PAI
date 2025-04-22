/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

/**
 *
 * @author g.guzman
 */
public class TestCalculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("suma entre dos nros: "+Calculadora.sumar(5, 8));
        System.out.println("suma entre 3 nros: "+Calculadora.sumar(5, 8, 20));
        System.out.println("suma entre 3 nros: "+Calculadora.sumar(5.50, 8, 20));
        
        Calculadora calc = new Calculadora();
        System.out.println("suma entre 3 nros: "+calc.sumar(5.50, 8, 20));
    }
    
}
