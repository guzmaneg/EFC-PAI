/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import exceptions.DniPersonaException;
import java.time.LocalDate;

/**
 *
 * @author g.guzman
 */
public class Alumno extends Persona {

    private Double promedio;
    private Short cantMatAprob;
    private LocalDate fecIng;
    private char estado; // A, B, M

    public Alumno() {
        super();
    }
    
    public Alumno(int dni, String nombre, String apellido, Double promedio) throws DniPersonaException {
        super(dni, nombre, apellido);
        this.promedio = promedio;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Short getCantMatAprob() {
        return cantMatAprob;
    }

    public void setCantMatAprob(Short cantMatAprob) {
        this.cantMatAprob = cantMatAprob;
    }


    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return super.toString(); // + info específica del alumno 
    }
    
    public static Alumno str2Alu(String[] camposAlu) {

        return null;
    }
    
}
