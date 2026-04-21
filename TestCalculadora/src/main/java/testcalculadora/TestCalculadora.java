/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package testcalculadora;

import calculadora.Calculadora;

/**
 *
 * @author g.guzman
 */
public class TestCalculadora {

    public static void main(String[] args) {
        //Calculadora cal = new Calculadora();
        System.out.println("La suma es "+Calculadora.sumar(1, 2)); 
        System.out.println("La suma es "+Calculadora.sumar(1.25, 2.50, 3.75)); 
    }
}
