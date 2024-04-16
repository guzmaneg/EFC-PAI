/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.persona;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author g.guzman
 */
public class Alumno extends Persona {
    
    private int legajo;
    private short cantMatAprob;
    private double promedio;
    private LocalDate fechaIng;
    
    private List<Carrera> carreras;

    public Alumno() {
        super();
    }

    public Alumno(int legajo, short cantMatAprob, double promedio, LocalDate fechaIng, 
            List<Carrera> carreras) {
        this.legajo = legajo;
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
        this.fechaIng = fechaIng;
        this.carreras = carreras;
    }

    public Alumno(int legajo, short cantMatAprob, double promedio, LocalDate fechaIng, 
            List<Carrera> carreras, int dni) {
        super(dni);
        this.legajo = legajo;
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
        this.fechaIng = fechaIng;
        this.carreras = carreras;
    }    

    public Alumno(int legajo, short cantMatAprob, double promedio, LocalDate fechaIng, 
            List<Carrera> carreras, int dni, String nombre, String apellido, LocalDate fechaNac) throws PersonaException {
        super(dni, nombre, apellido, fechaNac);
        this.legajo = legajo;
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
        setFechaIng(fechaIng);
        this.carreras = carreras;
    }
    
    
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
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

    public LocalDate getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(LocalDate fechaIng) throws PersonaException {
        if (fechaIng==null) {
            throw new PersonaException("La fecha de ingreso no puede ser nula");
        }
        if (fechaIng.isBefore(fechaNac)) {
            throw new PersonaException("La fecha de ingreso debe ser mayor a la fecha de nacimiento");
        }
        this.fechaIng = fechaIng;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    
    
    
}
