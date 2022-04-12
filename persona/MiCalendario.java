package test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import exceptions.MiCalendarioExcpetion;

public class MiCalendario extends GregorianCalendar {
	
	public MiCalendario(int dia, int mes, int anio) throws MiCalendarioExcpetion {
		super(anio, mes-1, dia);
		setLenient(false);
		
		try {
			this.get(Calendar.YEAR);
		} catch (Exception e) {
			throw new MiCalendarioExcpetion("Le fecha es inválida");
		}
	}

}
