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

    private static final double UNA_PULGADA = 2.54;
    
    @Override
    public String getLabel1() {
        return "Centímetros:"; 
    }

    @Override
    public String getLabel2() {
        
        return "Pulgadas:";
    }

    @Override
    public String getTipo() {
        return "Centímetro/Pulgada";
    }

    @Override
    public Double convertirValor1Valor2(Double cent) {
        
        return cent / UNA_PULGADA;
    }

    @Override
    public Double convertirValor2Valor1(Double pulg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
