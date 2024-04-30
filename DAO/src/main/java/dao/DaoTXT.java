/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import gui.persona.Alumno;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g.guzman
 */
public class DaoTXT extends DAO<Alumno, Integer>{

    private RandomAccessFile raf;
    
    public DaoTXT(String fullpath) throws DaoException {
        try {
            raf = new RandomAccessFile(fullpath, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> Archivo no encontrado");
        }
        System.out.println("Se conectó OK al TXT ==> "+fullpath);
    }
    
    @Override
    public void create(Alumno alu) throws DaoException {
        try {
            if (exist(alu.getDni())) {
                throw new DaoException("Alumno duplicado ==> "+ alu.getDni());
            }
            raf.seek(raf.length()); // Se posiciona al final del archivo
            raf.writeBytes(alu.toString()+System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo crear el alumno"+ "("+ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public Alumno read(Integer dni) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Alumno alu) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer dni) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno findById(Integer dni) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void closeConnection() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean exist(Integer id) throws DaoException {
        return false;
    }
    
}
