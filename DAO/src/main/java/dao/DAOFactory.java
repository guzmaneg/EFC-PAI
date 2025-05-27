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
    
    private static DAOFactory instance;
    public static final String TIPO_DAO = "TIPO_DAO";
    public static final String TIPO_DAO_TXT = "TIPO_DAO_TXT";
    public static final String TIPO_DAO_SQL = "TIPO_DAO_SQL";
    
    public static final String FILENAME = "FILENAME";
    public static final String URL = "URL";
    public static final String USER = "USER";
    public static final String PWD = "PWD";
    
    private DAOFactory() {
    }
    
    public static DAOFactory getInstance() {
        if (instance==null) {
            instance = new DAOFactory();
        }
        return instance;
    }
    
    public static DAO crearDao(Map<String, Object> config) throws DAOFactoryException {
        try {
            String tipo = (String) config.get(TIPO_DAO);
            
            switch (tipo) {
                case TIPO_DAO_TXT:
                    String filename = (String) config.get(FILENAME);
                    return new AlumnoDAOTxt(filename);
                case TIPO_DAO_SQL:
                    String url = (String) config.get(URL);
                    String user = (String) config.get(USER);
                    String pwd = (String) config.get(PWD);
                    return new AlumnoDAOSQL(url, user, pwd);
                default:
                    throw new DAOFactoryException("NO implementado");
            }
        } catch (DAOException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOFactoryException(ex.getMessage());
        }
    }
    
}
