package test;

import exceptions.AlumnoException;
import exceptions.PersonaException;
import exceptions.PersonaNombreException;

public class Alumno extends Persona {

	private MiCalendario fecIng;
	
	private Integer cantMatAprob;
	
	private Double promedio;

	
	public Alumno() {
		super();
	}
	
	public Alumno(Integer dni) {
		super(dni);
	}

	public Alumno(Integer dni, String nombre, String apellido, MiCalendario fecNac,
			MiCalendario fecIng, Integer cantMatAprob, Double promedio)
			throws PersonaException, PersonaNombreException {
		super(dni, nombre, apellido, fecNac);
		this.fecIng = fecIng;
		setCantMatAprob(cantMatAprob);
		setPromedio(promedio);
	}

	public Alumno(Persona persona,
			MiCalendario fecIng, Integer cantMatAprob, Double promedio)
			throws PersonaException, PersonaNombreException {
		super(persona.getDni(), persona.nombre, persona.apellido, persona.fecNac);
		this.fecIng = fecIng;
		setCantMatAprob(cantMatAprob);
		setPromedio(promedio);
	}


	public MiCalendario getFecIng() {
		return fecIng;
	}

	public void setFecIng(MiCalendario fecIng) {
		this.fecIng = fecIng;
	}

	public Integer getCantMatAprob() {
		return cantMatAprob;
	}

	public void setCantMatAprob(Integer cantMatAprob) {
		this.cantMatAprob = cantMatAprob;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) throws AlumnoException {
		if (promedio<0 || promedio>10)  {
			throw new AlumnoException("El promedio es inválido");
		}
		
		this.promedio = promedio;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Promedio = "+getPromedio()+System.lineSeparator()+
				"Fecha de Ingreso = "+fecIng;
	}
}
