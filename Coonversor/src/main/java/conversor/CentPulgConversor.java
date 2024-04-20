/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor;

/**
 *
 * @author g.guzman
 */
public class CentPulgConversor extends AbstractConversor {

    private static final double UNA_PULGADA = 2.54;

    @Override
    public Double convertirUnidad1Unidad2(Double cent) {
        
        return cent/UNA_PULGADA;
    }
    @Override
    public Double convertirUnidad2Unidad1(Double pulg) {
        
        return pulg*UNA_PULGADA;
    }
    
}
