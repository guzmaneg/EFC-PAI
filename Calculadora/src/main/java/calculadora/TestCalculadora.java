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
        System.out.println("calculadora.TestCalculadora.main() " + Calculadora.sumar(5, 25)); 
        System.out.println("calculadora.TestCalculadora.main() " + Calculadora.sumar(5, 25, 30)); 
        
        System.out.println("calculadora.TestCalculadora.main() " + Calculadora.sumar(5.25, 25.00, 30.33)); 
        
        //Calculadora cal = new Calculadora();
        //System.out.println("calculadora.TestCalculadora.main() " + cal.sumar(5.25, 25.00, 30.33)); 
    }
    
}
