/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor;

/**
 *
 * @author g.guzman
 */
public class MetroKmConversor extends AbstractConversor {

    private static final int KM = 1000;
    
    @Override
    public Double convertirUnidad1Unidad2(Double metros) {
        
        return metros / KM;
    }
    
    @Override
    public Double convertirUnidad2Unidad1(Double km) {
        
        return km * KM;
    }

    @Override
    public String getName() {
        return "Metro-Km";
    }
    
    @Override
    public String getLabel1() {
        return "Metros:";
    }
    @Override
    public String getLabel2() {
        return "Km:";
    }
}
