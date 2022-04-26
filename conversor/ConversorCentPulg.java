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
public class ConversorCentPulg extends Conversor {

    private static final double UNA_PULGADA = 2.54;
    private static final String CENTIMETROS = "Centímetros";
    private static final String PULGADAS = "Pulgadas";

    @Override
    public String getTipo() {
        return CENTIMETROS+" a "+PULGADAS;
    }
    
    @Override
    public String getLabel1() {
        
        return CENTIMETROS;
    }
    
    @Override
    public String getLabel2() {
        
        return PULGADAS;
    }

    @Override
    public Double convertirValorUnoValorDos(Double valorUno) {
        return valorUno / UNA_PULGADA;        
    }

    @Override
    public Double convertirValorDosValorUno(Double valorDos) {
        return valorDos * UNA_PULGADA;        
    }
}
