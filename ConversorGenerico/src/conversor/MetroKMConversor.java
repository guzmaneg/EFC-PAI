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
public class MetroKMConversor extends Conversor {

    @Override
    public String getLabelValor1() {
        
        return "Metros";
    }

    @Override
    public String getLabelValor2() {
        
        return "KM";
    }

    @Override
    public String toString() {
        return "Metros - KM";
    }

    @Override
    public Double convertirValor1Valor2(Double valor1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double convertirValor2Valor1(Double valor2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
