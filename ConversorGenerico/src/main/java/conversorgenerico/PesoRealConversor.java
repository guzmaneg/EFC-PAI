/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversorgenerico;

/**
 *
 * @author g.guzman
 */
public class PesoRealConversor extends AbstractConversor {

    private static final double UN_REAL_EN_PESOS = 211.34;

    @Override
    public Double convertirValor1Valor2(Double pesos) {
        
        return pesos / UN_REAL_EN_PESOS;
    }
    
    @Override
    public Double convertirValor2Valor1(Double reales) {
        
        return reales * UN_REAL_EN_PESOS;
    }

    @Override
    public String getNombreConversor() {
        return "Peso-Real";
    }

    @Override
    public String getLabel1() {
        return "Pesos";
    }

    @Override
    public String getLabel2() {
        return "Reales";
    }
}
