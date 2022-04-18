/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import dao.AlumnoDAOTXT;
import dao.DAO;
import dao.DAOException;
import dao.DAOFactory;
import dao.DAOFactoryException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.MiCalendario;
import persona.MiCalendarioException;
import persona.PersonaException;

/**
 *
 * @author gguzm
 */
public class TestDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAO<Alumno, Long> dao = null;
        try {
            //AlumnoDAOTXT dao = new AlumnoDAOTXT("alumnos.txt");
            Map<String, String> config = new HashMap<>();
            config.put(DAOFactory.TIPO_DAO, "SQL");
            
            config.put(DAOFactory.URL_DB, "jdbc:mysql://localhost:3306/efc");
            config.put(DAOFactory.USUARIO_DB, "root");
            config.put(DAOFactory.PASS_DB, "root");
                    
            dao = DAOFactory.getIntance().createDAO(config);

            MiCalendario fechaNac = new MiCalendario(23, 8, 1992);
            MiCalendario fechaIng = new MiCalendario(1, 3, 1993);
            Alumno alu = new Alumno(24004612, "nombre2", "apellido2", fechaNac, fechaIng, 55, 7.33, 'M', true);
            alu.setSexo('M');

            dao.create(alu);
            Alumno aluRead = dao.read(alu.getDni());
            if (aluRead!=null) {
                System.out.println("Alumno encontrado ==> "+aluRead);
            }
            
        } catch (DAOException | PersonaException | MiCalendarioException | DAOFactoryException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (dao!=null) {
                try {
                    dao.close();
                } catch (DAOException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       
        }
    }
    
}
