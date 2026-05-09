/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversorgenerico;

/**
 *
 * @author g.guzman
 */
public class CentPulgConversor extends ConversorAbstracto {
    private static final double UNA_PULGADA = 2.54;

    @Override
    public double convertirValor1Valor2(double cent) {
        return cent / UNA_PULGADA;
    }

    @Override
    public double convertirValor2Valor1(double pulg) {
        return pulg * UNA_PULGADA;
    }

    @Override
    public String getNombre() {
        return "Cent-Pulg";
    }

    @Override
    public String getLabel1() {
        return "Centímetros:";
    }

    @Override
    public String getLabel2() {
        return "Pulgadas:";
    }
    
}
