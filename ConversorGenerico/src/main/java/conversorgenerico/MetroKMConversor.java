/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversorgenerico;

/**
 *
 * @author g.guzman
 */
public class MetroKMConversor extends ConversorAbstracto {
    private static final int UN_KM = 1000;

    @Override
    public double convertirValor1Valor2(double metros) {
        return metros / UN_KM;
    }

    @Override
    public double convertirValor2Valor1(double km) {
        return km * UN_KM;
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
