/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.NombreApellidoInvalidoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import utils.AlumnoUtils;

/**
 *
 * @author g.guzman
 */
public class AlumnoDAOTXT extends DAO<Alumno,Integer> {

    private RandomAccessFile raf;
    
    AlumnoDAOTXT(String pathfile) throws DAOException {
        try {
            raf = new RandomAccessFile(pathfile, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error I/O: "+ex.getLocalizedMessage());
        }
    }
    
    @Override
    public void create(Alumno alumno) throws DAOException {
        try {
            if (exist(alumno.getDni())) {
                throw new DAOException("El alumno con DNI "+alumno.getDni()+" ya existe");
            }
            raf.seek(raf.length()); // Se posiciona al final del archivo
            
            final String alumno2String = AlumnoUtils.alumno2String(alumno);
            raf.writeBytes(alumno2String+System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException("Error I/O: "+ex.getLocalizedMessage());
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        try {
            raf.seek(0); // Se posiciona al comienzo
            String linea;
            while((linea = raf.readLine())!=null) {
                String dniTxt = linea.substring(0, 8);
                if (Integer.valueOf(dniTxt).equals(dni)) {
                    return AlumnoUtils.string2Alumno(linea);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getLocalizedMessage());
        } catch (NombreApellidoInvalidoException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Alumno alu) throws DAOException {
        // raf.getFilePointer() para poder posicionarse al inicio del alumno a 
        // actualizar
    }

    @Override
    public void delete(Integer dni) throws DAOException {
        Alumno alu2Delete = read(dni);
        alu2Delete.setEstado('B');
        update(alu2Delete);
    }

    @Override
    public List<Alumno> findAll(boolean all) throws DAOException {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            alumnos.add(new Alumno(1, "Juan", "Perez"));
            alumnos.add(new Alumno(2, "Juana", "Gonzalez"));
            alumnos.add(new Alumno(3, "Ines", "Garcia"));
            alumnos.add(new Alumno(4, "Marcos", "Rojo"));
        } catch (NombreApellidoInvalidoException ex) {
            throw new DAOException(ex.getLocalizedMessage());
        }
        
        return alumnos;
    }

    @Override
    public void close() throws DAOException {
        try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getLocalizedMessage());
        }
    }

    @Override
    public boolean exist(Integer dni) throws DAOException {
        try {
            raf.seek(0); // Se posiciona al comienzo
            String linea;
            while((linea = raf.readLine())!=null) {
                String dniTxt = linea.substring(0, 8);
                if (Integer.valueOf(dniTxt).equals(dni)) {
                    return true;
                }
            }
            return false;
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getLocalizedMessage());
        }
    }
    
}
