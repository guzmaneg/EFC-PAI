/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.DniPersonaException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.Month;
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
public class AlumnoDAOTxt extends DAO<Alumno,Integer>{

    private final RandomAccessFile raf;
            
    AlumnoDAOTxt(String fullpath) throws DAOException {
        try {
            raf = new RandomAccessFile(fullpath, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de E/S ("+ex.getMessage()+")");
        }
    }
    
    
    @Override
    public void create(Alumno alu) throws DAOException {
        if (exist(alu.getDni())) {
            throw new DAOException("El alumno con DNI "+alu.getDni()+" ya existe");
        }
        
        try {
            // insertar en TXT
            raf.seek(raf.length()); // Me posocionó al final del archivo
            //raf.writeBytes(alu+System.lineSeparator());
            raf.writeBytes(alu.toString()+System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de escritura ("+ex.getMessage()+")");
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        try {
            raf.seek(0); // Me posocionó al incio
            String linea;
            String[] camposAlu;
            while ((linea = raf.readLine())!=null) {
                camposAlu = linea.split(String.valueOf(Persona.DELIM));
                if (Integer.valueOf(camposAlu[0]).equals(dni)) {
                    return Alumno.str2Alu(camposAlu);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error de E/S ("+ex.getMessage()+")");
        }
        
        return null;
    }

    @Override
    public void update(Alumno alu) throws DAOException {
        // Buscar y posicionar en el deseado
        //raf.getFilePointer()
        //raf.writeBytes(alu.toString());
    }

    @Override
    public void delete(Integer dni) throws DAOException {
        // Baja lógica
        Alumno alu2Read = read(dni);
        if (alu2Read!=null) {
            alu2Read.setEstado('B');
            update(alu2Read);
        }
        else {
            throw new DAOException("El alumno a actualizar no existe");
        }
        
    }

    @Override
    public List<Alumno> findAll(boolean includeDeleted) throws DAOException {
            List<Alumno> alumnos = new ArrayList<>();
        try {
            alumnos.add(new Alumno(1, "Juan", "Perez", 7.66));
            alumnos.add(new Alumno(2, "María", "Gomez", 7.33));
            alumnos.add(new Alumno(3, "Juana", "De Arco", 7.25));
            
            Alumno alumno = new Alumno(4, "Martín", "Palermo", 7.00);
            alumno.setFecNac(LocalDate.of(1974, Month.AUGUST, 23));
            alumnos.add(alumno);
        } catch (DniPersonaException ex) {
            Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
        }

        return alumnos;
    }

    @Override
    public boolean exist(Integer dni) throws DAOException {
        try {
            raf.seek(0); // Me posocionó al incio
            String linea;
            String[] camposAlu;
            while ((linea = raf.readLine())!=null) {
                camposAlu = linea.split(String.valueOf(Persona.DELIM));
                if (Integer.valueOf(camposAlu[0]).equals(dni)) {
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
    public void closeConnection() throws DAOException {
        if (raf!=null) {
            try {
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(AlumnoDAOTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
