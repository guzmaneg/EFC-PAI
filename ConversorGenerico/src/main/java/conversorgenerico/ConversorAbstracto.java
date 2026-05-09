/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversorgenerico;

/**
 *
 * @author g.guzman
 */
public abstract class ConversorAbstracto {
    
    public abstract double convertirValor1Valor2(double valor1);
    public abstract double convertirValor2Valor1(double valor2);
    
    public abstract String getNombre();
    
    public abstract String getLabel1();
    public abstract String getLabel2();
    
}
