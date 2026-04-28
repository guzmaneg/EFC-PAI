/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor;

/**
 *
 * @author g.guzman
 */
public class MetrosKmConversor extends AbstractConversor {
    private static final double UNA_KM = 1000;

    @Override
    public Double convertirAValor2(Double metros) {
        return metros / UNA_KM; 
    }

    @Override
    public Double convertirAValor1(Double km) {
        return km * UNA_KM; 
    }
    
    @Override
    public String getNombre() {
        return "Metros-KM";
    }

    @Override
    public String getLabel1() {
        return "Metros:";
    }

    @Override
    public String getLabel2() {
        return "KM:";
    }
    
}
