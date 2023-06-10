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
import persona.Alumno;
import persona.Persona;

/**
 *
 * @author g.guzman
 */
public class AlumnoDaoTxt extends Dao<Alumno, Integer>{

    private RandomAccessFile raf;
    
    AlumnoDaoTxt(String fullPath) throws DaoException {
        try {
            raf = new RandomAccessFile(new File(fullPath), "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al instanciar Dao => "+ex.getLocalizedMessage());
        }
    }
    
    @Override
    public void create(Alumno alumno) throws DaoException{

        if (exist(alumno.getDni())) {
            throw new DaoException("El alumno con dni "+ alumno.getDni() +" ya existe.");
        }
        
        try {
            raf.seek(raf.length());
            raf.writeBytes(alumno.toString()+System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al insertar. "+ex.getLocalizedMessage());
        }
        
    }

    @Override
    public boolean exist(Integer dni) throws DaoException {
        
        try {
            raf.seek(0);
            String linea;
            String[] campos;
            
            while((linea = raf.readLine())!=null) {
                campos = linea.split(Persona.DELIM);
                if (Integer.valueOf(campos[0]).equals(dni)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public Alumno read(Integer id)  throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Alumno alumno) throws DaoException {
        try {
            raf.seek(0);
            String linea;
            String[] campos;
            long pos = 0;
            while((linea = raf.readLine())!=null) {
                campos = linea.split(Persona.DELIM);
                
                if (Integer.valueOf(campos[0]).equals(alumno.getDni())) {
                    raf.seek(pos);
                    raf.writeBytes(alumno.toString());
                    return;
                }
                pos = raf.getFilePointer();
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer dni) throws DaoException {
        Alumno alumno = read(dni);
        alumno.setActivo(false);
        update(alumno);
    }

    @Override
    public List<Alumno> findAll(boolean isOnlyActive) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws DaoException {
        try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
