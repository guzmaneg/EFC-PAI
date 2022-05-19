/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import test.Alumno;
import test.MiCalendario;

/**
 *
 * @author laboratorios
 */
public class AlumnoDaoTxtTest {
    
    public AlumnoDaoTxtTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    /**
     * Test of create method, of class AlumnoDaoTxt.
     */
    @org.junit.jupiter.api.Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Alumno alu = new Alumno(24004603, "Juanita", "Perez gonzalez gonzalez", 
                new MiCalendario(2, 12, 74), null, 55, 7D);
        DAO dao = new AlumnoDaoTxt("alumno.txt");
        dao.create(alu);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of read method, of class AlumnoDaoTxt.
     */
    @org.junit.jupiter.api.Test
    public void testRead() throws Exception {
        System.out.println("read");
        Integer dni = null;
        AlumnoDaoTxt instance = null;
        Alumno expResult = null;
        Alumno result = instance.read(dni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class AlumnoDaoTxt.
     */
    @org.junit.jupiter.api.Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Alumno alu = null;
        AlumnoDaoTxt instance = null;
        instance.update(alu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hardDelete method, of class AlumnoDaoTxt.
     */
    @org.junit.jupiter.api.Test
    public void testHardDelete() throws Exception {
        System.out.println("hardDelete");
        Integer dni = null;
        AlumnoDaoTxt instance = null;
        instance.hardDelete(dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of softDelete method, of class AlumnoDaoTxt.
     */
    @org.junit.jupiter.api.Test
    public void testSoftDelete() throws Exception {
        System.out.println("softDelete");
        Integer dni = null;
        AlumnoDaoTxt instance = null;
        instance.softDelete(dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class AlumnoDaoTxt.
     */
    @org.junit.jupiter.api.Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        boolean includeDeleted = false;
        AlumnoDaoTxt instance = null;
        List<Alumno> expResult = null;
        List<Alumno> result = instance.findAll(includeDeleted);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class AlumnoDaoTxt.
     */
    @org.junit.jupiter.api.Test
    public void testClose() throws Exception {
        System.out.println("close");
        AlumnoDaoTxt instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exist method, of class AlumnoDaoTxt.
     */
    @org.junit.jupiter.api.Test
    public void testExist() throws Exception {
        System.out.println("exist");
        Integer dni = null;
        AlumnoDaoTxt instance = null;
        boolean expResult = false;
        boolean result = instance.exist(dni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
