/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdao;

import dao.DAO;
import dao.DaoException;
import dao.DaoSQL;
import dao.DaoTXT;
import gui.persona.Alumno;
import gui.persona.Carrera;
import gui.persona.PersonaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g.guzman
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //DAO dao = new DaoTXT("alumnos.txt");
            DAO dao = new DaoSQL("jdbc:mysql://localhost:3306/", "root", "root");
            //DaoTXT daoTxt = (DaoTXT)dao;
            LocalDate fecNac = LocalDate.of(1990, 10, 22);
            LocalDate fecIng = LocalDate.of(2024, 3, 1);
            List<Carrera> carreras = new ArrayList<>();
            int legajo = 1;
            int dni = 00000007;
            short cantMatAprb = 2;
            Alumno alu = new Alumno(legajo, cantMatAprb, 8, fecIng, carreras, dni, "Enzo pepe", "Perez", 
                    fecNac);
            dao.create(alu);
            Alumno aluRead = (Alumno) dao.read(dni);
            System.out.println("Alumno leído ==> "+aluRead.toString());
            //Alumno aluRead = daoTxt.read(dni);
            
            List<Alumno> alumnos = dao.findAll(true);
            for (Alumno alumno : alumnos) {
                System.out.println("Alumno leído findAll ==> "+alumno.toString());
            }
            
            alu.setEstado('M');
            alu.setNombre(alu.getNombre()+" Manuel");
            dao.update(alu);
            
            System.out.println("Alumno modificado ==> "+alu.toString());
        } catch (DaoException | PersonaException ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
