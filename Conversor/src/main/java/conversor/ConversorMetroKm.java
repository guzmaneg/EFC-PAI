/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor;

/**
 *
 * @author g.guzman
 */
public class ConversorMetroKm extends ConversorGenerico {

    @Override
    public String getLabel1() {
        return "Metro:";
    }
    
    @Override
    public String getLabel2() {
        
        return "KM:";
    }
    
    @Override
    public String getTipo() {
        return "Metro/Km";
    }

    @Override
    public Double convertirValor1Valor2(Double metros) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double convertirValor2Valor1(Double kms) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
