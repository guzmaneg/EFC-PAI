/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import exceptions.PersonaException;
import java.time.LocalDate;

/**
 *
 * @author g.guzman
 */
public class Alumno extends Persona {

    private Double promedio;
    private Integer cantMatAprob;
    private LocalDate fecIng;
    private char estado; // A - M - B

    public Alumno() {
        super();
        promedio = 0.0;
    }

    public Alumno(Double promedio, Integer dni) throws PersonaException {
        super(dni);
        this.promedio = promedio;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    
    
    @Override
    public String toString() {
        return super.toString() + String.format("", null, null); 
    }
    
    public static Alumno str2Alu(String[] camposAlu) throws PersonaException {

        int index = 0;
        Alumno alumno = new Alumno();
        alumno.setDni(Integer.valueOf(camposAlu[index++]));
        alumno.setNombre(camposAlu[index++]);
        
        alumno.setApellido(camposAlu[index++]);
        
        String[] fecNacStr = camposAlu[index++].split("/"); // por ej: "23/05/2025"
        int year = Integer.valueOf(fecNacStr[2]);
        int month = Integer.valueOf(fecNacStr[1]);
        int day = Integer.valueOf(fecNacStr[0]);
        LocalDate fecNac = LocalDate.of(year,  month, day);
        alumno.setFecNac(fecNac);
        
        return alumno;
    }

}
