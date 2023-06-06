/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import calendario.MiCalendario;
import calendario.MiCalendarioException;
import dao.AlumnoDaoSQL;
import dao.AlumnoDaoTXT;
import dao.DAO;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoFactoryException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.PersonaInvalidaException;
import persona.PersonaNombreException;

/**
 *
 * @author g.guzman
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try {
            // Singleton
            DaoFactory daoFactory  = DaoFactory.getInstance();
            
            
            Alumno alumno = null;
            DAO<Alumno, Integer> dao;
            alumno = new Alumno(24004608);
            Map<String, String> configMap = new HashMap<>();

            configMap.put(DaoFactory.TIPO_DAO, DaoFactory.TIPO_DAO_TXT);
            configMap.put(DaoFactory.FILE_PATH, "alumnos.txt");
/*
            configMap.put(DaoFactory.TIPO_DAO, DaoFactory.TIPO_DAO_SQL);
            configMap.put(DaoFactory.URL_DB, "jdbc:mysql://localhost:3306/universidad");
            configMap.put(DaoFactory.USER_DB, "root");
            configMap.put(DaoFactory.PASS_DB, "root");
*/
            dao = daoFactory.createDao(configMap);
            
            //dao = new AlumnoDaoSQL();

            alumno.setApellido("Romero");
            alumno.setNombre("Chiquito ");
            alumno.setSexo('M');
            alumno.setFechaNac(new MiCalendario(10, 12, 1988));
            dao.create(alumno);

            
            Alumno alumno2 = alumno = new Alumno(24004602);
            alumno2.setApellido("Martinez Cuarta");
            alumno2.setNombre("Juana la Loca");
            alumno2.setSexo('F');
            alumno2.setFechaNac(new MiCalendario(5, 1, 1995));
            dao.update(alumno2);

            List<Alumno> alumnos = dao.findAll(true);
            for (Alumno alumno1 : alumnos) {
                System.out.println("Alumno ==> "+ alumno1.getDni() + " - " + alumno1.getNombre() + 
                        " - " + alumno1.getFechaNac());
            }

        } catch (DaoException | PersonaInvalidaException | PersonaNombreException | MiCalendarioException | DaoFactoryException ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
