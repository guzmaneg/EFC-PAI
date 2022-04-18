/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 *
 * @author Gabriel
 */
public abstract class Conversor {
    
    public abstract String getLabelValor1();
    public abstract String getLabelValor2();
    
    public abstract Double convertirValor1Valor2(Double valor1);
    public abstract Double convertirValor2Valor1(Double valor2);

    @Override
    public String toString() {
        return "Conversor{" + '}';
    }
    
}
