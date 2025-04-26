/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta;

/**
 *
 * @author g.guzman
 */
public class Cuenta {
    
    private final int nroCuenta;
    
    private static double tasa;
    
    public static final String ARS_MONEDA = "ARS MONEDA";
    public final static String USD_MONEDA = "USD MONEDA";

    public Cuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
    
    public int getNroCuenta() {
        return nroCuenta;
    }

    public static double getTasa() {
        return tasa;
    }

    public static void setTasa(double tasa) {
        Cuenta.tasa = tasa;
    }

}
