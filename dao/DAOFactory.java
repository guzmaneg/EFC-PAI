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
 * @author laboratorios
 */
public class DAOFactory {

    public static final String TIPO_DAO = "TIPO_DAO";
    public static final String TIPO_DAO_TXT = "TIPO_DAO_TXT";
    public static final String TIPO_DAO_SQL = "TIPO_DAO_SQL";
    
    public static final String PATH_FILE = "PATH_FILE";
    public static final String SQL_CONN = "SQL_CONN";
    
    private static DAOFactory instance;

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance() {
        
        if (instance==null) {
            instance = new DAOFactory();
        }
        
        return instance;
    }
    
    
    public DAO crearDAO(Map<String, String> config) throws DAOFactoryException {
        try {
            String tipoDAO = config.get(TIPO_DAO);
            switch (tipoDAO) {
                case TIPO_DAO_TXT:
                    String path = config.get(PATH_FILE);
                    return new AlumnoDaoTxt(path);
                case TIPO_DAO_SQL:
                    return new AlumnoDaoSql(config.get(SQL_CONN), null, null);
            }
            return null;
        } catch (DAOException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOFactoryException("Error al obtener el DAO ==> "+ex.getMessage());
        }
    }
    
    
}
