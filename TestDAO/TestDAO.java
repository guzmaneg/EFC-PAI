/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package efc.testdao;

import dao.DAO;
import dao.DAOException;
import dao.DAOFactory;
import dao.DAOFactoryException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.Alumno;

/**
 *
 * @author laboratorios
 */
public class TestDAO {
    
    public static void main(String[] args) {
        DAOFactory factory = DAOFactory.getInstance();
        Map<String, String> config = new HashMap<String, String>();
//        config.put(DAOFactory.TIPO_DAO, DAOFactory.TIPO_DAO_TXT);
//        config.put(DAOFactory.PATH_FILE, "alumnos.txt");
        config.put(DAOFactory.TIPO_DAO, DAOFactory.TIPO_DAO_SQL);
        config.put(DAOFactory.SQL_CONN, "root:@localhost:3306:");
        try {
            DAO dao = factory.crearDAO(config);
            dao.create(new Alumno());
        } catch (DAOFactoryException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("OK");
    }
    
}
