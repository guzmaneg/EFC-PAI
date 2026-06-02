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
    
    private List<Alumno> alumnos;
    private static final String[] ENCABEZADOS = {"DNI", "NOMBRE", "APELLIDO", "FECHA NAC."};

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno alu = alumnos.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return alu.getDni();
            }
            case 1 -> {
                return alu.getNombre();
            }
            case 2 -> {
                return alu.getApellido();
            }
            case 3 -> {
                // return alu.getFecNac(); // TODO
                return LocalDate.now().plusYears(rowIndex); // simulación
            }
            default -> throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return ENCABEZADOS[column];
    }
    
    
}
