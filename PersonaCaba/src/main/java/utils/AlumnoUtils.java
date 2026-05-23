/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import exceptions.DniInvalidoException;
import exceptions.NombreInvalidoException;
import java.time.LocalDate;
import org.apache.commons.lang3.StringUtils;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public final class AlumnoUtils {

    public static final String TAB = "\t";
    private static final int NOMBRE_MAX_LENGTH = 15;
    
    private AlumnoUtils() {
    }
    
    public static String alu2Str(Alumno alu) {
        String dni = StringUtils.leftPad(String.valueOf(alu.getDni()), 8, '0');
        
        String nombreTrunc = alu.getNombre().length()>NOMBRE_MAX_LENGTH?
                alu.getNombre().substring(0, NOMBRE_MAX_LENGTH):
                alu.getNombre();
        /*
        if (alu.getNombre().length()>NOMBRE_MAX_LENGTH) {
            nombreTrunc = alu.getNombre().substring(0, NOMBRE_MAX_LENGTH);
        }
        else {
            nombreTrunc = alu.getNombre();
        }*/
        
        String nombre = StringUtils.leftPad(nombreTrunc, NOMBRE_MAX_LENGTH);
        String apellido = StringUtils.leftPad(alu.getApellido(), 15);
        
        return dni+TAB+nombre+TAB+apellido+TAB+alu.getFecIngStr();
    }
    
    public static Alumno str2Alu(String[] campos) throws DniInvalidoException, NombreInvalidoException {
        Alumno alu = new Alumno();
        int index = 0;
        alu.setDni(Integer.valueOf(campos[index++]));
        alu.setNombre(campos[index++].trim());
        alu.setApellido(campos[index++].trim());
        
        String[] fecIng = campos[index++].split(Alumno.SLASH);
        
        // 02/05/2026
        int year = Integer.valueOf(fecIng[2]);
        int month = Integer.valueOf(fecIng[1]);
        int day = Integer.valueOf(fecIng[0]);
        alu.setFecIng(LocalDate.of(year, month, day));
        
        return alu;
    }
}
