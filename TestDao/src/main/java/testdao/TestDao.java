/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdao;

import dao.DAO;
import dao.DAOFactory;
import dao.DaoException;
import gui.persona.Alumno;
import gui.persona.Carrera;
import gui.persona.PersonaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static dao.DAOFactory.TIPO_DAO;
import static dao.DAOFactory.TIPO_DAO_TXT;
import static dao.DAOFactory.TIPO_DAO_SQL;
import static dao.DAOFactory.FULL_PATH;
import static dao.DAOFactory.URL_DB;
import static dao.DAOFactory.USER_DB;
import static dao.DAOFactory.PWD_DB;
import dao.DaoFactoryException;

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
            DAOFactory factory = DAOFactory.getInstance();
            //DAOFactory factory2 = DAOFactory.getInstance();
            
            //DAO dao = new DaoTXT("alumnos.txt");
            //dao = new DaoSQL("jdbc:mysql://localhost:3306/universidad", "root", "root");
            Map<String, String> configMap = new HashMap<>();
            /*configMap.put(TIPO_DAO, TIPO_DAO_TXT);
            configMap.put(FULL_PATH, "alumnos.txt");*/
            configMap.put(TIPO_DAO, TIPO_DAO_SQL);
            configMap.put(URL_DB, "jdbc:mysql://localhost:3306/universidad");
            configMap.put(USER_DB, "root");
            configMap.put(PWD_DB, "root");

            DAO dao = factory.crearDAO(configMap);
            
            //DaoTXT daoTxt = (DaoTXT)dao;
            LocalDate fecNac = LocalDate.of(1972, 3, 20);
            LocalDate fecIng = LocalDate.of(2024, 3, 1);
            List<Carrera> carreras = new ArrayList<>();
            int legajo = 1;
            int dni = 12;
            short cantMatAprb = 2;
            Alumno alu = new Alumno(legajo, cantMatAprb, 8, fecIng, carreras, dni, "Juan Carlos", "Perez", 
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
        } catch (DaoException | PersonaException | DaoFactoryException ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
