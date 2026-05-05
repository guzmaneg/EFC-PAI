/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import exceptions.EdadInvalidaException;
import exceptions.NombreApellidoInvalidoException;
import exceptions.PromedioInvalidoException;
import java.time.LocalDate;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author g.guzman
 */
public class Alumno extends Persona {
    
    private static final String EMPTY_STRING = "";
    private static final String SLASH = "/";
    
    private double promedio;
    private LocalDate fecIng;
    private short cantMatAprob;
    private char estado; // A o B

    public Alumno() {
    }
    public Alumno(int dni) {
        super(dni);
        //System.out.println("Alumno con dni: "+this.dni);
    }
    
    public Alumno(int dni, String nombre, String apellido) throws NombreApellidoInvalidoException {
        super(dni, nombre, apellido);
    }

    public Alumno(double promedio, LocalDate fecIng, short cantMatAprob) {
        this.promedio = promedio;
        this.fecIng = fecIng;
        this.cantMatAprob = cantMatAprob;
    }

    public Alumno(int dni, String nombre, String apellido, short edad,
            double promedio, LocalDate fecIng, short cantMatAprob) 
            throws EdadInvalidaException, PromedioInvalidoException, NombreApellidoInvalidoException {
        super(dni, nombre, apellido, edad);
        setPromedio(promedio);
        this.fecIng = fecIng;
        this.cantMatAprob = cantMatAprob;
    }
    
    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) throws PromedioInvalidoException {
        if (promedio<0 || promedio > 10) {
            throw new PromedioInvalidoException("El promedio es invalido");
        }
        this.promedio = promedio;
    }

    public String getFecIngStr() {
        if (fecIng==null) {
            return EMPTY_STRING;
        }
        String dayOfMonth = StringUtils.leftPad(String.valueOf(fecIng.getDayOfMonth()), 2, "0");
        return EMPTY_STRING+dayOfMonth+SLASH+fecIng.getMonthValue()+SLASH+fecIng.getYear();
    }
    
    public LocalDate getFecIng() {
        return fecIng;
    }
    
    public void setFecIng(LocalDate fecIng) {
        // TODO validar contra fecNac, 18 años
        // TODO Lanzar FecIngInvalidaException
        this.fecIng = fecIng;
    }

    public short getCantMatAprob() {
        return cantMatAprob;
    }

    public void setCantMatAprob(short cantMatAprob) {
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
        return super.toString() +
                " Alumno{" + "promedio=" + promedio + ", fecIng=" + getFecIngStr() + ", cantMatAprob=" + cantMatAprob + '}';
    }

}
