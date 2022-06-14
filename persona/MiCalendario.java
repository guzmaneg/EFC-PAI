package test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import exceptions.MiCalendarioExcpetion;
import java.sql.Date;

public class MiCalendario extends GregorianCalendar {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MiCalendario() {
        super();
    }

    public MiCalendario(int dia, int mes, int anio) throws MiCalendarioExcpetion {
        super(anio, mes - 1, dia);
        setLenient(false);

        try {
            this.get(Calendar.YEAR);
        } catch (Exception e) {
            throw new MiCalendarioExcpetion("Le fecha es inv�lida");
        }
    }

    public MiCalendario(Calendar cal) {
        setTime(cal.getTime());
    }

    public MiCalendario(Date sqlDate) {
        setTimeInMillis(sqlDate.getTime());
    }

    public int getDia() {
        return this.get(Calendar.DAY_OF_MONTH);
    }

    public int getMes() {
        return this.get(Calendar.MONTH) + 1;
    }

    public int getAnio() {
        return this.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return getDia() + "/"
                + getMes() + "/"
                + getAnio();
    }

    public Date toSQLDate() {
        return new Date(this.getTimeInMillis());
    }
}
