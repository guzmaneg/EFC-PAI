/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.alumnogui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public class AlumnoModel extends AbstractTableModel {

    private static final int DNI = 0;
    private static final int NOMBRE = 1;
    
    private static final String[] ENCABEZADOS = {"DNI", "Nombre", "Apellido", "Fecha Nac."};
    
    private List<Alumno> alumnos;

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    public AlumnoModel() {
        alumnos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return ENCABEZADOS.length;
    }

    @Override
    public String getColumnName(int column) {
        return ENCABEZADOS[column];
    }

    @Override
    public Object getValueAt(int fila, int col) {
        Alumno alu = alumnos.get(fila);
        
        switch (col) {
            case DNI:
                return alu.getDni();
            case NOMBRE:
                return alu.getNombre();
            case 2:
                return alu.getApellido();
            case 3:
                return alu.getFecNac();
            default:
                return null;
        }        
    }
    
}
