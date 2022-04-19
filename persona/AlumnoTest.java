package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.MiCalendarioExcpetion;
import exceptions.PersonaException;
import exceptions.PersonaNombreException;

public class AlumnoTest {

	@Test
	public void testAlumno() {
		Alumno alu = new Alumno();
		
		assertNotNull(alu);
		
		System.out.println(alu.toString());
	}

	@Test
	public void testAlumnoDni() {
		Alumno alu = new Alumno(12345678);
		
		assertNotNull(alu);
		assertNotNull(alu.getDni());
		assertEquals(Integer.valueOf(12345678), alu.getDni());
		System.out.println(alu.toString());
	}

	@Test
	public void testAlumnoFull() {
		Persona persona;
		Alumno alu = null;
		try {
			persona = new Persona(123245789, "Miguel", "Gomez", 
					new MiCalendario(23, 8, 1974));

			MiCalendario fecIng = new MiCalendario();
			alu = new Alumno(persona, fecIng, 55, 7.3);
		} catch (PersonaException | PersonaNombreException | MiCalendarioExcpetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(alu.toString());
	}

	@Test
	public void testAlumnoPersonaMiCalendarioIntegerDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFecIng() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFecIng() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCantMatAprob() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCantMatAprob() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPromedio() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPromedio() {
		fail("Not yet implemented");
	}

}
