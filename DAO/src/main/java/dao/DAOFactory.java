/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public class DAOFactory {
    
    private static DAOFactory instance;
    
    public static final String TIPO_DAO = "TIPO_DAO";
    public static final String FULLPATH = "FULLPATH";
    public static final String URL_SQL = "URL_SQL";
    
    private DAOFactory() {
        
    }
    
    public static DAOFactory getInstance() {
        if (instance==null) {
            instance =new DAOFactory();
        }
        return instance;
    }
    
    public static DAO<Alumno, Integer> buildDAO(Map<String, String> config) throws DAOFactoryException {
        String tipoDAO = config.get(TIPO_DAO);
        switch (tipoDAO) {
            case "TIPO_DAO_TXT":
            {
                try {
                    String fullpath = config.get(FULLPATH);
                    return new AlumnoDAOTxt(fullpath);
                } catch (DAOException ex) {
                    Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DAOFactoryException("Error en la factory ("+ex.getMessage()+")");
                }
            }
            case "TIPO_DAO_SQL":
            {
                try {
                    String url = config.get(URL_SQL);
                    return new AlumnoDAOSql(url, "root", "root");
                } catch (DAOException ex) {
                    Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DAOFactoryException("Error en la factory ("+ex.getMessage()+")");
                }
            }
            default:
                throw new DAOFactoryException("Tipo de DAO NO implemantado");
        }
    }
    
}
