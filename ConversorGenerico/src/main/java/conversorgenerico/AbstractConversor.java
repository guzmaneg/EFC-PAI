/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversorgenerico;

/**
 *
 * @author g.guzman
 */
public abstract class AbstractConversor {
    
    public abstract Double convertirValor1Valor2(Double valor1);
    public abstract Double convertirValor2Valor1(Double valor2);
    
    public abstract String getNombreConversor();
    
    public abstract String getLabel1();
    public abstract String getLabel2();
    
}
