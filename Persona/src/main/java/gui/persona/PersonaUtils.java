/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.persona;

import java.time.LocalDate;

/**
 *
 * @author g.guzman
 */
public final class PersonaUtils {
    
    public static final String getFechaNacStr(Persona persona) {
        LocalDate fechaNac = persona.getFechaNac();
        return "FechaNac en formato dd/MM/aaaa = "+fechaNac.getDayOfMonth()+"/"+fechaNac.getMonthValue()+
                "/"+fechaNac.getYear();
    }
    
}
