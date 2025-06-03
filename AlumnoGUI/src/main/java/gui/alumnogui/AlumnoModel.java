/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.alumnogui;

import dto.AlumnoDTO;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import persona.Alumno;

/**
 *
 * @author g.guzman
 */
public class AlumnoModel extends AbstractTableModel {

    private List<AlumnoDTO> alumnos;
    private final String[] encabezados = {"DNI", "Nombre", "Apellido", "Fec. Nac."};

    public void setAlumnos(List<AlumnoDTO> alumnos) {
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
        return encabezados.length;
    }

    @Override
    public String getColumnName(int column) {
        return encabezados[column];
    }

    @Override
    public Object getValueAt(int fila, int col) {
        AlumnoDTO alumno = alumnos.get(fila);
        switch (col) {
            case 0:
                return alumno.getDni();
            case 1:
                return alumno.getNombre();
            case 2:
                return alumno.getApellido();
            case 3:
                return alumno.getFecNac();
        }
        return null;
    }
    
}
