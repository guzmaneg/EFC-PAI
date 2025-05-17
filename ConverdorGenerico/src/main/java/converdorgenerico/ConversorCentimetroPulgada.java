/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converdorgenerico;

/**
 *
 * @author g.guzman
 */
public class ConversorCentimetroPulgada extends AbstractConversor {

    private static final double UNA_PULGADA = 2.54;

    @Override
    public Double convertirValor1Valor2(Double centimetros) {
        
        return centimetros / UNA_PULGADA;
    }

    @Override
    public Double convertirValor2Valor1(Double pulgadas) {
        
        return pulgadas * UNA_PULGADA;
    }

    @Override
    public String getTipo() {
        return "Centimetro-Pulgada";
    }

    @Override
    public String getLabel1() {
        return "Centimetros";
    }

    @Override
    public String getLabel2() {
        return "Pulgadas";
    }
    
}
