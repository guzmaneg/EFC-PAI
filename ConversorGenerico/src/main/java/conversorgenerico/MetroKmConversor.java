/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversorgenerico;

/**
 *
 * @author g.guzman
 */
public class MetroKmConversor extends AbstractConversor{

    private static final double UN_KM = 1000;

    @Override
    public Double convertirValor1Valor2(Double metros) {
        
        return metros / UN_KM;
    }
    
    @Override
    public Double convertirValor2Valor1(Double km) {
        
        return km * UN_KM;
    }

    @Override
    public String getNombreConversor() {
        return "Metro-KM";
    }

    @Override
    public String getLabel1() {
        return "Metros";
    }

    @Override
    public String getLabel2() {
        return "KM";
    }
}
