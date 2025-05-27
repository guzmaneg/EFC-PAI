/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdao;

import dao.AlumnoDAOSQL;
import dao.AlumnoDAOTxt;
import dao.DAO;
import dao.DAOException;
import dao.DAOFactory;
import dao.DAOFactoryException;
import exceptions.DniPersonaException;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public class TestDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //AlumnoDAOTxt dao = new AlumnoDAOTxt("alumnos.txt");
            String url = "jdbc:mysql://localhost:3306/universidad";
            //DAO<Alumno, Integer> dao = new AlumnoDAOSQL(url, "root", "root");
            DAO<Alumno, Integer> dao = null;

            // Factory
            DAOFactory factory = DAOFactory.getInstance();
//        DAOFactory factory2 = DAOFactory.getInstance();
//        DAOFactory factory3 = DAOFactory.getInstance();

            Map<String, Object> config = new HashMap<>();
            // config.put(DAOFactory.TIPO_DAO, DAOFactory.TIPO_DAO_TXT);
            // config.put(DAOFactory.FILENAME, "alumnos.txt");

            config.put(DAOFactory.TIPO_DAO, DAOFactory.TIPO_DAO_SQL);
            config.put(DAOFactory.URL, url);
            config.put(DAOFactory.USER, "root");
            config.put(DAOFactory.PWD, "root");
            
            try {
                dao = factory.crearDao(config);
            } catch (DAOFactoryException ex) {
                Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            Alumno alu = new Alumno(35, "Juan Erensto Estinis", "Perez", 6.35);
            LocalDate fecNac = LocalDate.of(1974, Month.AUGUST, 23);
            alu.setFecNac(fecNac);
            dao.create(alu);
            Alumno aluRread = dao.read(28);
            System.out.println("aluRread: " + aluRread);
        } catch (DAOException | DniPersonaException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
