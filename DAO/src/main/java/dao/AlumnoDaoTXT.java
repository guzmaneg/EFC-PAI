/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.Persona;

/**
 *
 * @author g.guzman
 */
public class AlumnoDaoTXT extends DAO<Alumno,Integer>{

    private static final String RWS_MODE = "rws";
    
    private RandomAccessFile raf;
    
    AlumnoDaoTXT(String pathFilename) throws DaoException {
        try {
            raf = new RandomAccessFile(new File(pathFilename), RWS_MODE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error de I/O =>"+ex.getLocalizedMessage());
        }
    }

    
    @Override
    public void create(Alumno alumno) throws DaoException {
        
        try {
            if (exist(alumno.getDni())) {
                throw new DaoException("El alumno ya existe (DNI="+alumno.getDni()+")");
            }
            raf.seek(raf.length());
            raf.writeBytes(alumno.toString()+System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al crear el alumno =>"+ex.getLocalizedMessage());
        }
    }

    @Override
    public boolean exist(Integer buscarDni) throws DaoException {
        try {
            raf.seek(0);
            String linea;
            String[] campos;
            Integer dni;
            while ((linea = raf.readLine())!=null) {
                campos = linea.split(Persona.DELIM);
                dni = Integer.valueOf(campos[0]);
                if (buscarDni.equals(dni)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S =>"+ex.getLocalizedMessage());
        }
        return false;
    }

    @Override
    public Alumno read(Integer dni) {
        Alumno alu = new Alumno();



        
        return alu;
    }

    @Override
    public void update(Alumno alumno) throws DaoException {
        try {
            raf.seek(0);
            String linea;
            String[] campos;
            int dni;
            long pos = 0;
            while ((linea = raf.readLine())!=null) {
                campos = linea.split(Persona.DELIM);
                dni = Integer.valueOf(campos[0]);
                if (alumno.getDni()==dni) {
                    //raf.seek(raf.getFilePointer()-linea.length());
                    raf.seek(pos);
                    raf.writeBytes(alumno.toString());
                    return;
                }
                pos = raf.getFilePointer();
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al actualizar =>"+ex.getLocalizedMessage());
        }
    }

    @Override
    public void deleteById(Integer dni) {
        System.out.println("DNI: "+dni);
    }

    @Override
    public void delete(Alumno entidad) {
        // TODO borrado lógico
    }

    @Override
    public List<Alumno> findAll(boolean onlyActive) {
        
        return new ArrayList<>();
    }

    @Override
    public void close() throws DaoException {
        try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al cerrar el archivo");
        }
    }

}
