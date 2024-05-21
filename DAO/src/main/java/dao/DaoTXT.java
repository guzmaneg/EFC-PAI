/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import gui.persona.Alumno;
import gui.persona.PersonaException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.AlumnoUtils;

/**
 *
 * @author g.guzman
 */
public class DaoTXT extends DAO<Alumno, Integer>{

    private RandomAccessFile raf;
    
    DaoTXT(String fullpath) throws DaoException {
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
        try {
            raf.seek(0);
            String lineaAlu;
            Integer dniAlu;
            while ((lineaAlu = raf.readLine())!=null) {
                dniAlu = Integer.valueOf(lineaAlu.substring(0, 8));
                if (dniAlu.equals(dni)) {
                    return AlumnoUtils.str2Alu(lineaAlu);
                }
            }
            return null;
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo leer el archivo"+ "("+ex.getLocalizedMessage()+")");
        } catch (PersonaException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al construir el alumno"+ "("+ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public void update(Alumno alu) throws DaoException {
        try {
            long filePointer = 0;
            raf.seek(filePointer);
            String lineaAlu;
            Integer dniAlu;
            while ((lineaAlu = raf.readLine())!=null) {
                dniAlu = Integer.valueOf(lineaAlu.substring(0, 8));
                if (dniAlu.equals(alu.getDni())) {
                    raf.seek(filePointer);
                    raf.writeBytes(alu.toString());
                    return;
                }
                filePointer = raf.getFilePointer();
            }
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo leer el archivo"+ "("+ex.getLocalizedMessage()+")");
        }        
    }

    @Override
    public void delete(Integer dni) throws DaoException {
        Alumno alu = read(dni);
        alu.setEstado('B');
        update(alu);
    }

    @Override
    public Alumno findById(Integer dni) throws DaoException {
        return read(dni);
    }

    @Override
    public List<Alumno> findAll(boolean solaActivos) throws DaoException {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            raf.seek(0);
            String lineaAlu;
            while ((lineaAlu = raf.readLine())!=null) {
                // TODO solaActivos ??
                alumnos.add(AlumnoUtils.str2Alu(lineaAlu));
            }
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo leer el archivo"+ "("+ex.getLocalizedMessage()+")");
        } catch (PersonaException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al construir el alumno"+ "("+ex.getLocalizedMessage()+")");
        }
        
        return alumnos;
    }

    @Override
    public void closeConnection() throws DaoException {
        try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo cerrar el archivo"+ "("+ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public boolean exist(Integer dni) throws DaoException {
        try {
            raf.seek(0);
            String lineaAlu;
            Integer dniAlu;
            while ((lineaAlu = raf.readLine())!=null) {
                dniAlu = Integer.valueOf(lineaAlu.substring(0, 8));
                if (dniAlu.equals(dni)) {
                    return true;
                }
            }
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo leer el archivo"+ "("+ex.getLocalizedMessage()+")");
        }
    }
}
