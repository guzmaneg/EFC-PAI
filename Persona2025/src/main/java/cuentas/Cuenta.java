/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentas;

/**
 *
 * @author g.guzman
 */
public class Cuenta {
    
    private final int nroCuenta;
    private static Double tasaInteres = 15.5; 

    public static Double getTasaInteres() {
        return tasaInteres;
    }

    public static void setTasaInteres(Double tasaInteres) {
        Cuenta.tasaInteres = tasaInteres;
    }
    private final static String PERSONA_HUMANA = "PERSONA_HUMANA";
    private static final String PERSONA_JURIDICA = "PERSONA_JURIDICA";

    public Cuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
        //PERSONA_HUMANA = "PERSONA_HUMANA";
    }
    
    
}
