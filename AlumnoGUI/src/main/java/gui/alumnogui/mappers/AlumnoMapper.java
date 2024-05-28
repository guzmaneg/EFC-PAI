/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.alumnogui.mappers;

import gui.alumnogui.dto.AlumnoDTO;
import gui.persona.Alumno;
import gui.persona.PersonaException;

/**
 *
 * @author g.guzman
 */
public final class AlumnoMapper {
    
    public static AlumnoDTO alumno2Dto(Alumno alu){
        
        AlumnoDTO dto = new AlumnoDTO();
        dto.setDni(alu.getDni());
        dto.setNombre(alu.getNombre());
        dto.setFecNac(alu.getFechaNac());
        
        return dto;
    }
    
    public static Alumno dto2Alumno(AlumnoDTO dto) throws PersonaException{
        
        Alumno alu = new Alumno();
        alu.setDni(dto.getDni());
        alu.setNombre(dto.getNombre());
        alu.setFechaNac(dto.getFecNac());
        
        return alu;
    }
}
