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
public class Alumno extends Persona {
    
    private MiCalendario fechaIng;
    
    private Integer cantMatAprob;
    
    private Double promedio;
    
    private boolean activo = true;

    public Alumno() {
        super();
    }

    public Alumno(MiCalendario fechaIng, Integer cantMatAprob, Double promedio) {
        this.fechaIng = fechaIng;
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
    }

    public Alumno(long dni, MiCalendario fechaIng, Integer cantMatAprob, Double promedio) throws PersonaException {
        super(dni);
        this.fechaIng = fechaIng;
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
    }

    public Alumno(long dni, String nombre, String apellido, MiCalendario fechaIng, Integer cantMatAprob, Double promedio) 
            throws PersonaException {
        super(dni, nombre, apellido);
        this.fechaIng = fechaIng;
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
    }

    public Alumno(long dni, String nombre, String apellido, MiCalendario fechaNac, MiCalendario fechaIng, Integer cantMatAprob, Double promedio) 
            throws PersonaException {
        super(dni, nombre, apellido, fechaNac);
        setFechaIng(fechaIng);
        this.cantMatAprob = cantMatAprob;
        this.promedio = promedio;
    }
    

    public MiCalendario getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(MiCalendario fechaIng) throws AlumnoException {
        if (fechaNac==null) {
            throw new AlumnoException("Se debe setear la fecha de Nacimiento");
        }
        if (fechaIng.before(fechaNac)) {
            throw new AlumnoException("La fecha de Ingreso deber ser mayor a la fecha de Nacimineto");
        }

        // fechaIng.add(0, 0);
        
        this.fechaIng = fechaIng;
    }

    public Integer getCantMatAprob() {
        return cantMatAprob;
    }

    public void setCantMatAprob(Integer cantMatAprob) {
        // TODO validar negativos (lanzar AlumnoException("..."))
        this.cantMatAprob = cantMatAprob;
    }

    /**
     * Devuelve el promedio del alumno
     * @return El Promedio
     */
    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        // TODO validar >=0 <=10
        this.promedio = promedio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    @Override
    public String toString() {
        return super.toString() + DELIM +
                fechaIng + DELIM + 
                String.format("%2d", cantMatAprob) + DELIM +
                String.format("%5.2f", promedio) + DELIM +
                (activo?'A':'B');
    }
 
}
