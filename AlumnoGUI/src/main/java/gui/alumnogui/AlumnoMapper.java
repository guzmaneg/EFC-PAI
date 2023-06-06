/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.alumnogui;

import persona.Alumno;
import persona.PersonaInvalidaException;
import persona.PersonaNombreException;

/**
 *
 * @author g.guzman
 */
public final class AlumnoMapper {
    
    public static Alumno dto2Alu(AlumnoDTO dto) throws PersonaInvalidaException, PersonaNombreException {
        
        return new Alumno(null, 0, 0, true, dto.getDni(), dto.getNombre(), "", 'F', dto.getFechaNac());
    }
    
    public static AlumnoDTO alu2Dto(Alumno alu) {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setDni(alu.getDni());
        dto.setNombre(alu.getNombre());
        dto.setFechaNac(alu.getFechaNac());
        
        return dto;
    }
}
