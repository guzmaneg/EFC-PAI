package test;

import exceptions.PersonaException;
import exceptions.PersonaNombreException;

public class Persona {

    public static String DELIM = "\t";

    private Integer dni;

    protected String nombre;

    protected String apellido;

    protected MiCalendario fecNac;
    
    protected char sexo;

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Persona() {
    }

    public Persona(Integer dni) {
        super();
        this.dni = dni;
    }

    public Persona(Integer dni, String nombre, String apellido, MiCalendario fecNac)
            throws PersonaException, PersonaNombreException {
        super();
        setDni(dni);
        setNombre(nombre);
        this.apellido = apellido;
        this.fecNac = fecNac;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) throws PersonaException {
        if (dni == null || dni <= 0) {
            // lanzo una Exception
            throw new PersonaException("El dni debe ser positivo");
        }
        this.dni = dni;
/////////////////////////////////////////////////////////////
//		if (dni != null && dni > 0) {
//			this.dni = dni;
//		}
//		else {
//			// lanzo una Exception
//			throw new Exception("El dni debe ser positivo");
//		}
    }

    public String getNombre() {
        if (nombre == null) {
            return nombre;
        }
        return nombre.trim();
    }

    public void setNombre(String nombre) throws PersonaNombreException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new PersonaNombreException("El nombre no puede estar vacio");
        }
        // Validar que solo contenga letras (a-z / A-Z)
//		if (false) {// usar expresion regular
//			
//		}
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public MiCalendario getFecNac() {
        return fecNac;
    }

    public void setFecNac(MiCalendario fecNac) {
        this.fecNac = fecNac;
    }

    @Override
    public String toString() {
        return "DNI = " + dni + System.lineSeparator()
                + "Nombre = " + getNombre() + " - " + getApellido() + System.lineSeparator();
    }

}
