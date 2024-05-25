/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import gui.persona.Alumno;
import gui.persona.Persona;
import gui.persona.PersonaException;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author g.guzman
 */
public final class AlumnoUtils {

    public static Alumno str2Alu(String aluStr) throws PersonaException {
        Alumno alu = new Alumno();
        String[] lineasStr = aluStr.split(String.valueOf(Persona.DELIM));
        alu.setDni(Integer.valueOf(lineasStr[0]));
        alu.setNombre(lineasStr[1]);
        alu.setApellido(lineasStr[2]);

        String fechaNac = lineasStr[3]; // "05/11/1999"
        String[] fechaNacArr = fechaNac.split("/");
        int year = Integer.valueOf(fechaNacArr[2]);
        int month = Integer.valueOf(fechaNacArr[1]);
        int dayOfMonth = Integer.valueOf(fechaNacArr[0]);
        alu.setFechaNac(LocalDate.of(year, month, dayOfMonth));
        
        return alu;
    }
    
    public static Date localDate2SqlDate(LocalDate localDate) {
        
        return Date.valueOf(localDate);
    }

    public static LocalDate sqlDate2LocalDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }
}
