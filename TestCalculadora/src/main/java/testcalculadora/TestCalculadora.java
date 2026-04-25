/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package testcalculadora;

import calculadoracaba.CalculadoraCaba;

/**
 *
 * @author g.guzman
 */
public class TestCalculadora {

    public static void main(String[] args) {
        // CalculadoraCaba calc = new CalculadoraCaba();
        // CalculadoraCaba calc2 = new CalculadoraCaba();
        System.out.println("La suma es = "+CalculadoraCaba.sumar(1, 2));
        System.out.println("La suma es = "+CalculadoraCaba.sumar(1, 2, 3));
        System.out.println("La suma es = "+CalculadoraCaba.sumar(1, 2, 3.75));
    }
}
