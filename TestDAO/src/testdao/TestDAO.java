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
        try {
            //AlumnoDAOTXT dao = new AlumnoDAOTXT("alumnos.txt");
            Map<String, String> config = new HashMap<>();
            DAO dao = DAOFactory.getIntance().createDAO(config);

            MiCalendario fechaNac = new MiCalendario(23, 8, 1992);
            MiCalendario fechaIng = new MiCalendario(1, 3, 1993);
            Alumno alu = new Alumno(24004601, "nombre", "apellido", fechaNac, fechaIng, 55, 7.33, 'M', true);
            alu.setSexo('M');

            dao.create(alu);
            
        } catch (DAOException | PersonaException | MiCalendarioException | DAOFactoryException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
