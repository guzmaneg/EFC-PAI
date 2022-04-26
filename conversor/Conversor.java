/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 *
 * @author gguzm
 */
public abstract class Conversor {
    
    public abstract String getTipo();
    /**
     * Obtiene el rótulo para la text field 1
     * @return El rótulo
     */
    public abstract String getLabel1();
    public abstract String getLabel2();
    
    public abstract Double convertirValorUnoValorDos(Double valorUno);
    public abstract Double convertirValorDosValorUno(Double valorDos);
}
