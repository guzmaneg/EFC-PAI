package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import exceptions.MiCalendarioExcpetion;
import exceptions.PersonaException;
import exceptions.PersonaNombreException;

public class PersonaTest {

	private static final int UN_DNI = 12345678;

	@Test
	public void testPersona() {
		Persona p = new Persona();

		assertNotNull(p);
	}

	@Test
	public void testPersonaDni() {
		Persona p = new Persona(UN_DNI);

		assertNotNull(p);
		assertEquals(Integer.valueOf(UN_DNI), p.getDni());
	}

	@Test
	public void testPersonaFull() {
		Persona p = null;
		try {
			p = new Persona(10, "", "Perez", null);
			fail();
		} catch (PersonaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersonaNombreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// assertNotNull(p);
	}


	@Test
	public void testSetDniException() {
		Persona p = new Persona();
		try {
			p.setDni(0);
			fail();
		} catch (PersonaException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testSetNombre() {
		Persona p = new Persona();
		try {
			p.setNombre("Juana");
			assertEquals("Juana", p.getNombre());
		} catch (PersonaNombreException ex) {
			fail();
		}
	}
	@Test
	public void testSetNombreExc() {
		Persona p = new Persona();
		try {
			p.setNombre("		");
			fail();
		} catch (PersonaNombreException ex) {
			
		}
	}

	@Test
	public void testSetFechaNac() {
		Persona p = new Persona();
		MiCalendario fecNac;
		try {
			fecNac = new MiCalendario(11, 4, 2022);
			p.setFecNac(fecNac);
		} catch (MiCalendarioExcpetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), 
				p.getFecNac().get(Calendar.YEAR));
	}

	@Test
	public void testSetWrongFechaNac() {
		Persona p = new Persona();
		MiCalendario fecNac;
		try {
			fecNac = new MiCalendario(11, 4, 2022);
			p.setFecNac(fecNac);
		} catch (MiCalendarioExcpetion e) {
			e.printStackTrace();
			fail();
		}
		
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), 
				p.getFecNac().get(Calendar.YEAR));
	}

}
