/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package figurageometrica;

/**
 *
 * @author g.guzman
 */
public abstract class FiguraGeometrica {
    protected String nombre;
    
    public abstract double calcularPerimetro();
    public abstract double calcularArea();
    
    public void imprimirNombre(){
        System.out.println("Mi nombres es "+nombre);
    }
}
