/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import cuentas.Cuenta;

/**
 *
 * @author g.guzman
 */
public class TestCuenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta(1234);
        Cuenta c2 = new Cuenta(5678);
        Cuenta c3 = new Cuenta(555666);
        System.out.println("SET TASA");
        c1.setTasaInteres(99.75);
        
        System.out.println("FIN");
    }
    
}
