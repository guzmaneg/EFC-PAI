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
public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    public static final String TIPO_DAO = "TIPO_DAO";
    public static final String FILE_PATH = "FILE_PATH";
    public static final String URL_DB = "URL_DB";
    public static final String USER_DB = "USER_DB";
    public static final String PASS_DB = "PASS_DB";
    
    public static final String TIPO_DAO_TXT = "DAO_TXT";
    public static final String TIPO_DAO_SQL = "DAO_SQL";

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }
    
    public static DAO createDao(Map<String, String> configMap) throws DaoFactoryException {
        try {
            String tipoDao = configMap.get(TIPO_DAO);
            switch (tipoDao) {
                case TIPO_DAO_TXT:
                    String filePath = configMap.get(FILE_PATH);
                    return new AlumnoDaoTXT(filePath);
                case TIPO_DAO_SQL:
                    String url = configMap.get(URL_DB);
                    String user = configMap.get(USER_DB);
                    String pwd = configMap.get(PASS_DB);
                    return new AlumnoDaoSQL(url, user, pwd);
                default:
                    throw new DaoFactoryException("No implementado aún!");
            }
        } catch (DaoException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoFactoryException("Error al obtener DAO ==> "+ex.getLocalizedMessage());
        }
    }
}
