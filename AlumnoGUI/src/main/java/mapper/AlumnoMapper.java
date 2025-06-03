/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.AlumnoDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public class AlumnoMapper {
    
    public static AlumnoDTO alu2Dto(Alumno alu) {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setDni(alu.getDni());
        dto.setNombre(alu.getNombre());
        dto.setApellido(alu.getApellido());
        
        LocalDate fecNac = alu.getFecNac();
        dto.setFecNac(fecNac.getDayOfMonth()+"/"+fecNac.getMonthValue()+"/"+fecNac.getYear());
        
        return dto;
    }

    public static List<AlumnoDTO> alumnos2Dtos(List<Alumno> alumnos) {
        List<AlumnoDTO> alumnosDto = new ArrayList<>();
        
        for (Alumno alu : alumnos) {
            AlumnoDTO dto = new AlumnoDTO();
            dto.setDni(alu.getDni());
            dto.setNombre(alu.getNombre());
            dto.setApellido(alu.getApellido());

            LocalDate fecNac = alu.getFecNac();
            dto.setFecNac(fecNac.getDayOfMonth()+"/"+fecNac.getMonthValue()+"/"+fecNac.getYear());
            alumnosDto.add(dto);
        }
        
        
        return alumnosDto;
    }

}
