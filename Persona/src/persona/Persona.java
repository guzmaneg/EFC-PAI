/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

/**
 *
 * @author gguzm
 */
public class Persona {
    
    public static final String DELIM = "\t";
    
    private long dni;
    
    private String nombre;
    
    private String apellido;
    
    protected MiCalendario fechaNac;
    
    private char sexo;

    // Suits de constructores
    public Persona() {
    }

    public Persona(long dni) throws PersonaException {
        setDni(dni);
    }

    public Persona(long dni, String nombre, String apellido) throws PersonaException {
        setDni(dni);
        setNombre(nombre);
        this.apellido = apellido;
    }

    public Persona(long dni, String nombre, String apellido, MiCalendario fechaNac) 
            throws PersonaException {
        setDni(dni);
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) throws PersonaException {
        if (dni<=0) {
            throw new PersonaException("El DNI debe ser positivo ("+dni+")");
        } 
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws PersonaException {
        if (nombre==null || nombre.trim().equals("")) {
            throw new PersonaException("El nombre no debe estar vacio");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public MiCalendario getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(MiCalendario fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) throws PersonaException {
        sexo = Character.toUpperCase(sexo);
        if (sexo!='F' && sexo!='M') {
            throw new PersonaException("El sexo debe ser F o M (o f o m)"); 
        }
        this.sexo = sexo;
        
        
        /*
        if (sexo=='f' || sexo=='F' || sexo=='m' || sexo=='M') {
            this.sexo = Character.toUpperCase(sexo);
        }
        else {
           throw new PersonaException("El sexo debe ser F o M (o f o m)"); 
        }
        */
        
        
    }

    @Override
    public String toString() {
        String nombreStr = nombre.length()>20?nombre.substring(0, 20):nombre;
        
        return String.format("%8d", dni) + DELIM +
                String.format("%20s", nombreStr) + DELIM +
                String.format("%15s", apellido) + DELIM +
                fechaNac;
    }

    
    
}
