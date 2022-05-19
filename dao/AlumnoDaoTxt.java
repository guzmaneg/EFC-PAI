/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.Alumno;
import test.Persona;

/**
 *
 * @author laboratorios
 */
public class AlumnoDaoTxt extends DAO<Alumno, Integer>{

    private RandomAccessFile raf;
            
    public AlumnoDaoTxt(String fullPath) throws DAOException {
        File file = new File(fullPath);
        
        try {
            raf = new RandomAccessFile(file, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Archivo no encontrado ==> "+ex.getMessage());
        }
    }
    
    @Override
    public void create(Alumno alu) throws DAOException {
        
        try {
            
            if (exist(alu.getDni())) {
                throw new DAOException("El alumno ya existe (DNI ="+alu.getDni()+")");
            }
            raf.seek(raf.length());
            raf.writeBytes(alu.toString()+System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al insertar el alumno  ==> "+ex.getMessage());
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Alumno alu) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hardDelete(Integer dni) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void softDelete(Integer dni) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> findAll(boolean includeDeleted) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exist(Integer dni) throws DAOException {
        try {        
            raf.seek(0);
            // recorrer
            String linea;
            String[] campos;
            while((linea = raf.readLine())!=null) {
                 campos = linea.split(Persona.DELIM);
                 if (dni.equals(Integer.valueOf(campos[0])))
                     return true;
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de I/O  ==> "+ex.getMessage());
        }
        return false;
    }
    
}
