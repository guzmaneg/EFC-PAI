/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Map;

/**
 *
 * @author g.guzman
 */
public class DAOFactory {
    
    private static DAOFactory daoFactory;
    public static final String TIPO_DAO = "TIPO_DAO";
    public static final String TIPO_DAO_TXT = "TIPO_DAO_TXT";
    public static final String TIPO_DAO_SQL = "TIPO_DAO_SQL";

    public static final String FULLPATH = "FULLPATH";
    
    public static final String USER_DB = "USER_DB";
    public static final String PWD_DB = "PWD_DB";
    
    private DAOFactory() {
    }
    
    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        
        return daoFactory;
    }
    
    public static DAO createDAO(Map<String, String> config) throws DAOFactoryException {
        String tipoDao = config.get(TIPO_DAO);
        
        try {
            switch (tipoDao) {
                case TIPO_DAO_TXT -> {
                    String pathfile = config.get(FULLPATH);
                    return new AlumnoDAOTXT(pathfile);
                }
                case TIPO_DAO_SQL -> {
                    String user = config.get(USER_DB);
                    String pwd = config.get(PWD_DB);
                    return new AlumnoDAOSQL(user, pwd);
                }
                default -> throw new DAOFactoryException("NO Implementado");
            }
        } catch (DAOException ex) {
            throw new DAOFactoryException(ex.getLocalizedMessage());
        }
    }
}
