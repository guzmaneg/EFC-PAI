/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.alumnogui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public class AlumnosTableModel extends AbstractTableModel {
    
    private static final int DNI_COL = 0;
    private static final int NAME_COL = 1;
    private static final int FEC_NAC_COL = 2;
    
    private static final String[] CABECERAS = {"DNI", "Nombre", "Fecha Nac."};

    private List<Alumno> alumnos;
    

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    @Override
    public int getRowCount() {
        if (alumnos==null) return 0;
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        
        return CABECERAS.length;
    }

    @Override
    public String getColumnName(int column) {
        return CABECERAS[column];
    }

    
    
    @Override
    public Object getValueAt(int fila, int col) {
        Alumno alu = alumnos.get(fila);
        switch (col) {
            case DNI_COL:
                return alu.getDni();
            case NAME_COL:
                return alu.getNombre();
            case FEC_NAC_COL:
                return alu.getFecNacStr();
            default:
                break;
        }
        
        return null;
    }
    
}
