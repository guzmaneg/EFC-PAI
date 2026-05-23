/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import exceptions.DniInvalidoException;
import java.time.LocalDate;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author g.guzman
 */
public class Alumno extends Persona {
    
    public static final String SLASH = "/";
    
    private short cantMatAprob;
    private double promedio;
    private LocalDate fecIng;
    private char estado; // 'A' o 'B'

    public Alumno() {
    }

    
    public Alumno(short cantMatAprob, double promedio, LocalDate fecIng) {
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
        this.fecIng = fecIng;
    }

    public Alumno(short cantMatAprob, double promedio, LocalDate fecIng, int dni) 
            throws DniInvalidoException {
        super(dni);
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
        this.fecIng = fecIng;
    }

    public Alumno(short cantMatAprob, double promedio, LocalDate fecIng, int dni, String nombre, String apellido) 
            throws DniInvalidoException {
        super(dni, nombre, apellido);
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
        this.fecIng = fecIng;
    }
    
    public short getCantMatAprob() {
        return cantMatAprob;
    }

    public void setCantMatAprob(short cantMatAprob) {
        this.cantMatAprob = cantMatAprob;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public LocalDate getFecIng() {
        return fecIng;
    }

    public void setFecIng(LocalDate fecIng) {
        // TODO validar diferencia de 18 años vs fecNac
        this.fecIng = fecIng;
    }
    
    public String getFecIngStr() {
        String dia = StringUtils.leftPad(String.valueOf(fecIng.getDayOfMonth()), 2, '0');
        String mes = StringUtils.leftPad(String.valueOf(fecIng.getMonthValue()), 2, '0');
        return dia+SLASH+mes+SLASH+fecIng.getYear();
    }

    @Override
    public String toString() {
        return super.toString() +
                " - Alumno{" + "cantMatAprob=" + cantMatAprob + ", promedio=" + promedio + ", fecIng=" + this.getFecIngStr() + '}';
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    
}
