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
public class ConversorMetroKM extends Conversor {

    @Override
    public String getTipo() {
        return "";
    }
    
    @Override
    public String getLabel1() {
        
        return "Metros";
    }

    @Override
    public String getLabel2() {
        return "";
    }

    @Override
    public Double convertirValorUnoValorDos(Double valorUno) {
        return 0D;
    }

    @Override
    public Double convertirValorDosValorUno(Double valorDos) {
        return 0D;
    }
    
}
