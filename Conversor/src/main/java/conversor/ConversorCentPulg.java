/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor;

/**
 *
 * @author g.guzman
 */
public class ConversorCentPulg extends ConversorGenerico {

    private static final String TIPO = "Centímetro - Pulgada";
    private static final String LABEL_1 = "Centímetro";
    private static final String LABEL_2 = "Pulgadas";
    private static final double UNA_PULGADA = 2.54;
    
    @Override
    public String getTipo() {
        return TIPO; 
    }

    @Override
    public String getLabel1() {
        return LABEL_1;
    }

    @Override
    public String getLabel2() {
        return LABEL_2;
    }

    @Override
    public Double convertirAValor2(Double cent) {
     
        return cent / UNA_PULGADA;
    }
}
