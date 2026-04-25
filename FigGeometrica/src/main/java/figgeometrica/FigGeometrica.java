/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package figgeometrica;

/**
 *
 * @author g.guzman
 */
public abstract class FigGeometrica {
    
    protected String nombre;
    
    public abstract double calcularPerimetro();
    public abstract double calcularArea();
    
    public void imprimirNombre() {
        System.out.println("Mi nombre es "+nombre);
    }

}
