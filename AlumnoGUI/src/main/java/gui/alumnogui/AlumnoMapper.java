/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.alumnogui;

import exceptions.NombreApellidoInvalidoException;
import org.apache.commons.lang3.StringUtils;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public final class AlumnoMapper {

    private AlumnoMapper() {
    }

    public static AlumnoDTO entity2Dto(Alumno alu){
        AlumnoDTO dto = new AlumnoDTO();
        dto.setDni(String.valueOf(alu.getDni()));
        dto.setNombre(StringUtils.defaultString(alu.getNombre()).trim());
        dto.setFecIng(alu.getFecIng());
        
        
        return dto;
    }
    
    public static Alumno dto2Entity(AlumnoDTO dto) throws NombreApellidoInvalidoException{
        Alumno alu = new Alumno();
        alu.setDni(Integer.valueOf(dto.getDni()));
        alu.setNombre(dto.getNombre());
        
        
        
        return alu;
    }
    
}
