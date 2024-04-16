/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.persona;

/**
 *
 * @author g.guzman
 */
public class Carrera {
    
    private String codigo;
    private String nombre;

    public Carrera() {
    }

    public Carrera(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
