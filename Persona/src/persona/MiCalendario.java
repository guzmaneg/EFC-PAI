/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author gguzm
 */
public class MiCalendario extends GregorianCalendar {

    public MiCalendario() {
    }

    public MiCalendario(int dia, int mes, int anio) throws MiCalendarioException {
        super(anio, mes-1, dia);
        setLenient(false);
        
        try {
            get(Calendar.YEAR);
        }
        catch (Exception ex) {
            throw new MiCalendarioException("Error en la fecha");
        }
        
    }
    
    public int getAnio(){

        return get(Calendar.YEAR);
    }
        
    public int getMes(){

        return get(MONTH)+1;
    }
    
    public int getDia(){

        return get(DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return String.format("%2d/%2d/%4d", getDia(), getMes(), getAnio());
    }
    
}
