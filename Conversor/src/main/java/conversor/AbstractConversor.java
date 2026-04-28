/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor;

/**
 *
 * @author g.guzman
 */
public abstract class AbstractConversor {
    
    public abstract String getNombre();
    
    public abstract String getLabel1();
    public abstract String getLabel2();
    
    public abstract Double convertirAValor2(Double valor1);
    public abstract Double convertirAValor1(Double valor2);
    
}
