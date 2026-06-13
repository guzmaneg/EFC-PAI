/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.alumnogui;

import exceptions.DniInvalidoException;
import exceptions.NombreInvalidoException;
import java.time.LocalDate;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public final class AlumnoMapper {
    
    private AlumnoMapper(){}
    
    public static Alumno dto2Alu(AlumnoDto dto) throws DniInvalidoException, NombreInvalidoException {
        Alumno alu = new Alumno();
        alu.setDni(Integer.valueOf(dto.getDni()));
        alu.setNombre(dto.getNombre());
        alu.setFecNac(dto.getFecNac());
        
        return alu;
    }
    
    public static AlumnoDto alu2Dto(Alumno alu) {
        AlumnoDto dto = new AlumnoDto();
        dto.setDni(String.valueOf(alu.getDni()));
        dto.setNombre(alu.getNombre());
        dto.setFecNac(alu.getFecNac());
        
        return dto;
    }
    
}
