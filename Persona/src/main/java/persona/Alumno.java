/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import calendario.MiCalendario;
import java.util.Calendar;

/**
 *
 * @author g.guzman
 */
public class Alumno extends Persona {
    
    private Calendar fechaIng;
    private int cantMatAprob;
    private double promedio;
    private boolean activo;

    // Suite de contructores

    public Alumno() {
        super();
        //this.email = "";
    }

    public Alumno(int dni) throws PersonaInvalidaException {
        super(dni);
    }

    public Alumno(int dni, String nombre, String apellido, char sexo, MiCalendario fechaNac) throws PersonaInvalidaException, PersonaNombreException {
        super(dni, nombre, apellido, sexo, fechaNac);
    }

    public Alumno(Calendar fechaIng, int cantMatAprob, double promedio, boolean activo, int dni, String nombre, String apellido, char sexo, MiCalendario fechaNac) throws PersonaInvalidaException, PersonaNombreException {
        super(dni, nombre, apellido, sexo, fechaNac);
        this.fechaIng = fechaIng;
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
        this.activo = activo;
    }
    
    public Calendar getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Calendar fechaIng) {
        this.fechaIng = fechaIng;
    }

    public int getCantMatAprob() {
        return cantMatAprob;
    }

    public void setCantMatAprob(int cantMatAprob) {
        // TODO validar que está entre 0 y 50
        this.cantMatAprob = cantMatAprob;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        // TODO validar que está entre 0 y 10
        this.promedio = promedio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String getInfoPersona() {
        return "";
    }

    @Override
    public String toString() {
        // TODO completar
        return super.toString();
    }
  
}
