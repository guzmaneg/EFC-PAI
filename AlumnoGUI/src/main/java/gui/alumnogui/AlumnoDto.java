/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.alumnogui;

import persona.MiCalendario;

/**
 *
 * @author g.guzman
 */
public class AlumnoDto {
    
    private int dni;
    
    private String nombre;
    
    private MiCalendario fecNac;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MiCalendario getFecNac() {
        return fecNac;
    }

    public void setFecNac(MiCalendario fecNac) {
        this.fecNac = fecNac;
    }
    
}
