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
public class AlumnoModel extends AbstractTableModel{
    private static final String[] COL_NAMES = {"DNI", "Nombre", "Apellido", "Fecha Nac."};
    
    private List<Alumno> alumnos;

    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return COL_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COL_NAMES[column];
    }

    @Override
    public Object getValueAt(int fil, int col) {
        Alumno alu = alumnos.get(fil);
        switch (col) {
            case 0:
                return alu.getDni();
            case 1:
                return alu.getNombre();
            case 2:
                return alu.getApellido();
            case 3:
                return alu.getFechaNac();
        }
        return null;
        
    }
    
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

}
