/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.PersonaException;
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
public class AlumnoDAOTxt extends DAO<Alumno, Integer> {

    private RandomAccessFile raf;
    
    public AlumnoDAOTxt(String fullpath) throws DAOException {
        try {
            raf = new RandomAccessFile(fullpath, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de E/S ("+ex.getMessage()+")");
        }
    }

    
    @Override
    public void create(Alumno alu) throws DAOException {
        if (exist(alu.getDni())){
            throw new DAOException("El alumno con DNI "+alu.getDni()+" ya existe");
        }
        
        try {
            raf.seek(raf.length()); // Se posicion al final del archivo
            raf.writeBytes(alu.toString()+System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al intentar crear el alumno ("+ex.getMessage()+")");
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        try {
            raf.seek(0);
            String lineaAlu;
            String[] camposAlu;
            while ((lineaAlu = raf.readLine())!=null) {
                camposAlu = lineaAlu.split(Persona.DELIM);
                if (Integer.valueOf(camposAlu[0]).equals(dni) ) {
                    return Alumno.str2Alu(camposAlu);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de E/S ("+ex.getMessage()+")");
        } catch (PersonaException ex) {
            Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error al instanciar el Alumno ("+ex.getMessage()+")");
        }

        return null;
    }

    @Override
    public void update(Alumno alu) throws DAOException {
        try {
            raf.seek(0);
            String lineaAlu;
            String[] camposAlu;
            while ((lineaAlu = raf.readLine())!=null) {
                camposAlu = lineaAlu.split(Persona.DELIM);
                if (Integer.valueOf(camposAlu[0]).equals(alu.getDni()) ) {
                    // lo encontré
                    // habría que reposicionarse (ver el uso de raf.getFilePointer())
                    raf.writeBytes(alu.toString());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de E/S ("+ex.getMessage()+")");
        }
    }

    @Override
    public void delete(Integer dni) throws DAOException {
        // Baja lógica
        Alumno alu = read(dni);
        alu.setEstado('B');
        update(alu);
    }

    @Override
    public boolean exist(Integer dni) throws DAOException {
        
        try {
            raf.seek(0);
            String lineaAlu;
            String[] camposAlu;
            while ((lineaAlu = raf.readLine())!=null) {
                camposAlu = lineaAlu.split(Persona.DELIM);
                if (Integer.valueOf(camposAlu[0]).equals(dni) ) {
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de E/S ("+ex.getMessage()+")");
        }
        
        return false;
    }

    @Override
    public List<Alumno> findAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
