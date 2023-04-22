/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

/**
 *
 * @author g.guzman
 */
public class Alumno extends Persona {
    
    private MiCalendario fecIng;
    
    private int cantMatAprob;
    
    private double prmedio;
    
    private boolean activo = true;
    
    public static final int MAX_CANT_MAT_APROB = 50;

    public Alumno() {
        super();
    }

    public Alumno(MiCalendario fecIng, int cantMatAprob, double prmedio, char sexo, int dni, 
            String nombre, String apellido, MiCalendario fecNac) 
            throws PersonaNombreException, AlumnoException, PersonaDniException {
        super(dni, nombre, apellido, fecNac, sexo);
        this.fecIng = fecIng;
        setCantMatAprob(cantMatAprob);
        this.prmedio = prmedio;
    }
    
    

    public MiCalendario getFecIng() {
        return fecIng;
    }

    public void setFecIng(MiCalendario fecIng) {
        this.fecIng = fecIng;
    }

    public int getCantMatAprob() {
        return cantMatAprob;
    }

    public void setCantMatAprob(int cantMatAprob) throws AlumnoException {
        if (cantMatAprob < 0 || cantMatAprob > MAX_CANT_MAT_APROB) {
            throw new AlumnoException("La cant. de materias aprobadas es incorrecta");
        }
        this.cantMatAprob = cantMatAprob;
    }

    public double getPrmedio() {
        return prmedio;
    }

    public void setPrmedio(double prmedio) {
        this.prmedio = prmedio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Cant. Mat. Aprob = "+cantMatAprob; 
    }
    
    
}
