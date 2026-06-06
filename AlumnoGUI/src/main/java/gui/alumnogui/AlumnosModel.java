/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.alumnogui;

import java.time.LocalDate;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public class AlumnosModel extends AbstractTableModel {
    
    private static final int COL_DNI = 0;
    private static final int COL_NOMBRE = 1;
    private static final int COL_APEELIDO = 2;
    private static final int COL_FEC_NAC = 3;
    
    private static final String[] ENCABEZADOS = {"DNI", "NOMBRE", "APELLIDO", "FEC_NAC"};
    
    private List<Alumno> alumnos;

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public int getRowCount() {
        if (alumnos==null) {
            return 0;
        }
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return ENCABEZADOS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno alu = alumnos.get(rowIndex);
        
        switch (columnIndex) {
            case COL_DNI -> {
                return alu.getDni();
            }
            case COL_NOMBRE -> {
                return alu.getNombre();
            }
            case COL_APEELIDO -> {
                return alu.getApellido();
            }
            case COL_FEC_NAC -> {
                return LocalDate.now().plusYears(rowIndex);
            }
            default -> throw new AssertionError();
        }
        
        
    }

    @Override
    public String getColumnName(int column) {
        return ENCABEZADOS[column];
    }
    
}
