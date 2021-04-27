/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;

/**
 *
 * @author gguzm
 */
public class AlumnoDAOTXT extends DAO<Alumno, Long>{

    private RandomAccessFile raf;
    
    public AlumnoDAOTXT(String filename) throws DAOException {
        try {
            raf = new RandomAccessFile(filename, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear el DAO ==> "+ex.getMessage());
        }
    }
    
    @Override
    public void create(Alumno alumno) throws DAOException{
        
        try {
            if (existe(alumno.getDni())) {
                throw new DAOException("El alumno ya existe");
            }
            
            raf.seek(raf.length()); // Va al final del archivo
            raf.writeBytes(alumno.toString()+System.lineSeparator());
            
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al crear el alumno ==> "+ex.getMessage());
        }
    }

    @Override
    public Alumno read(Long dni) throws DAOException {
        
        return null;
    }

    @Override
    public void update(Alumno entidad) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long clave) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Long dni) throws DAOException {
        try {
            raf.seek(0); // Se posiciona al inicio
            String linea;
            String[] campos; 
            while((linea = raf.readLine())!=null) {
                campos = linea.split(persona.Persona.DELIM);
//                if (Long.valueOf(campos[0].trim()).equals(dni)) {
                if (campos[0].trim().equals(String.valueOf(dni))) {
                //if (campos[0].trim().equals(dni.toString())) {
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
