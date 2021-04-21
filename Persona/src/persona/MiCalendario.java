/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author gguzm
 */
public class MiCalendario extends GregorianCalendar{

    public MiCalendario() {
    }

    public MiCalendario(int dia, int mes, int anio) 
            throws MiCalendarioException {
        super(anio, mes-1, dia);
        setLenient(false);
        
        try {
            get(Calendar.YEAR);
        }
        catch (Exception ex) {
            throw new MiCalendarioException("Error en la fecha");
        }
        
    }
    
    
    
}
