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
    
    public abstract Double convertirUnidad1Unidad2(Double valor1);
    public abstract Double convertirUnidad2Unidad1(Double valor2);
    public abstract String getName();
    
    public abstract String getLabel1();
    public abstract String getLabel2();
}
