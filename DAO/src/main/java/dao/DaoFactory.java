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
    
    public static final String TIPO_DAO = "TIPO_DAO";
    public static final String TIPO_DAO_TXT = "TIPO_DAO_TXT";
    public static final String TIPO_DAO_SQL = "TIPO_DAO_SQL";
    
    public static final String PATH_FILE = "PATH_FILE";
    
    public static final String URL_BD = "URL_BD";
    public static final String USR_BD = "USR_BD";
    public static final String PWD_BD = "PWD_BD";
    
    private static DaoFactory instance;
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        
        if (instance==null) {
            instance = new DaoFactory();
        }
        
        return instance;
    }
    
    public Dao crearDao(Map<String, String> config) throws DaoFactoryException {
        String tipoDao = config.get(TIPO_DAO);
        try {
            switch (tipoDao){
                case TIPO_DAO_TXT:
                   return new AlumnoDaoTxt(config.get(PATH_FILE));
                case TIPO_DAO_SQL:
                    String url = config.get(URL_BD);
                    String usr = config.get(USR_BD);
                    String pwd = config.get(PWD_BD);
                    return new AlumnoDaoSql(url, usr, pwd);
                default:
                    throw new DaoFactoryException("No implementado aún");
            }
        } catch (DaoException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoFactoryException("Error al crear Dao ==> "+ex.getLocalizedMessage());
        }
    }
    
}
