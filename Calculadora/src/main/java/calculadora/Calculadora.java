/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

/**
 *
 * @author g.guzman
 */
public final class Calculadora {

    Calculadora() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Calculadora(String nombreCalc) {
        System.out.println(nombreCalc);
    }
    
    
    public static double sumar(int a, int b) {
        return a+b;
    }
    
    public static double sumar(int a, int b, int c) {
        return a+b+c;
    }

    static double sumar(double a, int b, int c) {
        return a+b+c;
    }

}
