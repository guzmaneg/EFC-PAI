/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g.guzman
 */
public class DAOFactory {
    
    private static DAOFactory factory;
    
    public static final String TIPO_DAO_TXT = "TIPO_DAO_TXT";
    public static final String TIPO_DAO_SQL = "TIPO_DAO_SQL";
    public static final String TIPO_DAO = "TIPO_DAO";
    public static final String PATH_FILE = "PATH_FILE";
    public static final String URL_DB = "URL_DB";
    public static final String USER_DB = "USER_DB";
    public static final String PWD_DB = "PWD_DB";
    
    
    private DAOFactory() {}
    
    public static DAOFactory getInstance() {
        if (factory==null) {
            factory = new DAOFactory();
        }
        
        return factory;
    }
    
    public static DAO createDAO(Map<String, String> config) throws DAOFactoryException {
        String tipoDAO = config.get(TIPO_DAO);
        try {
            switch (tipoDAO) {
                case TIPO_DAO_TXT -> {
                    String pathfile = config.get(PATH_FILE);
                    return new AlumnoDAOTXT(pathfile);
                }
                case TIPO_DAO_SQL -> {
                    String url = config.get(URL_DB);
                    String user = config.get(USER_DB);
                    String pwd = config.get(PWD_DB);
                    return new AlumnoDAOSQL(url, user, pwd);
                }
                default -> {
                    throw new DAOFactoryException("No implementado");
                }
            }
        } catch (DAOException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOFactoryException(ex.getLocalizedMessage());
        }
    }
    
}
