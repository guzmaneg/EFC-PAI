/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor;

/**
 *
 * @author g.guzman
 */
public class ConversorMetrosKm extends ConversorGenerico {

    private static final String TIPO = "Metro - Km";
    private static final String LABEL_1 = "Metro";
    private static final String LABEL_2 = "KM";
    private static final int UN_KM = 1000;
    
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
    public Double convertirAValor2(Double metros) {
        
        return metros / UN_KM;
    }
}
