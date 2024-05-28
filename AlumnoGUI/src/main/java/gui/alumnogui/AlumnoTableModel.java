/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.alumnogui;

import gui.persona.Alumno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author g.guzman
 */
public class AlumnoTableModel extends AbstractTableModel {

    private static final String[] COLUMNAS = {"DNI", "NOMBRE", "APELLIDO", "FEC. NAC."};
            
    private List<Alumno> alumnos;

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

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
        return COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int fil, int col) {
        Alumno alumno = alumnos.get(fil);
        switch (col){
            case 0: return alumno.getDni();
            case 1: return alumno.getNombre();
            case 2: return alumno.getApellido();
            case 3: return alumno.getFechaNac(); // TODO con formaro dd/MM/aaaa
            // TODO: agregar estado del alumno
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNAS[column];
    }
   
}
