/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuenta;

/**
 *
 * @author g.guzman
 */
public class TestCuenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta(100);
        Cuenta c2 = new Cuenta(200);
        Cuenta c3 = new Cuenta(300);
        c3.setTasa(33.55);
        
        System.out.println("cuenta.TestCuenta.main()");
        System.out.println("Constantes:"+Cuenta.ARS_MONEDA + " - "+Cuenta.USD_MONEDA);
        //System.out.println("Constantes:"+c3.ARS_MONEDA + " - "+c2.USD_MONEDA);
    }
    
}
