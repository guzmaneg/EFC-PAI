/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.persona;

/**
 *
 * @author g.guzman
 */
public class ProfesorSuplente extends Profesor {

    @Override
    public String printLegajo() {
        return String.format("%08d", legajo);
    }
    
}
