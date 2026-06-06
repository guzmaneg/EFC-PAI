/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.DniInvalidoException;
import exceptions.NombreInvalidoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
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

    // private static final String CTE = "CTE";
    
    private final RandomAccessFile raf;
    
    AlumnoDAOTXT(String pathfile) throws DAOException {
        try {
            raf = new RandomAccessFile(pathfile, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }
    }

    @Override
    public void create(Alumno alumno) throws DAOException {
        try {
            if (exist(alumno.getDni())) {
                throw new DAOException("El DNI "+alumno.getDni()+" ya existe");
            }
            raf.seek(raf.length()); // Se posiciona al final del archivo
            raf.writeBytes(AlumnoUtils.alu2Str(alumno)+System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getLocalizedMessage());
        }
    }

    @Override
    public Alumno read(Integer dni) throws DAOException {
        try {
            raf.seek(0); // e posiciona al inicio del archivo
            String linea;
            Integer dniFile; 
            String[] campos;
            while((linea = raf.readLine())!=null) {
                campos = linea.split(AlumnoUtils.TAB);
                dniFile = Integer.valueOf(campos[0]);
                if (dniFile.equals(dni)) {
                    return AlumnoUtils.str2Alu(campos);
                }
            }
        } catch (IOException | DniInvalidoException | NombreInvalidoException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public void update(Alumno alumno) throws DAOException {
        // raf.getFilePointer()
        // raf.seek(???)
        // raf.writeBytes(AlumnoUtils.alu2Str(alumno));
        
    }

    @Override
    public void delete(Integer dni) throws DAOException {
        Alumno alu = read(dni);
        alu.setEstado('B');
        update(alu);
    }

    @Override
    public List<Alumno> findAll(boolean incluirEliminados) throws DAOException {
        List<Alumno> alumnos = new ArrayList<>();
        
        try {
            alumnos.add(new Alumno((short)55, 7.33, LocalDate.MIN, 1, "Juan1", "Perez"));
            alumnos.add(new Alumno((short)55, 7.33, LocalDate.MIN, 2, "Juan2", "Perez"));
            alumnos.add(new Alumno((short)55, 7.33, LocalDate.MIN, 3, "Juan3", "Perez"));
            alumnos.add(new Alumno((short)55, 7.33, LocalDate.MIN, 4, "Juan4", "Perez"));
        } catch (DniInvalidoException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
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
            raf.seek(0); // e posiciona al inicio del archivo
            String linea;
            Integer dniFile; 
            String[] campos;
            while((linea = raf.readLine())!=null) {
//                dniFile = Integer.valueOf(linea.substring(0, 8));

                campos = linea.split(AlumnoUtils.TAB);
                dniFile = Integer.valueOf(campos[0]);
                if (dniFile.equals(dni)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoDAOTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getLocalizedMessage());
        }
        return false;
    }
    
}
