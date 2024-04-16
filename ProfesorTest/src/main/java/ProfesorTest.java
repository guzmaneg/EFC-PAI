
import gui.persona.Profesor;
import gui.persona.ProfesorSuplente;
import gui.persona.ProfesorTitular;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author g.guzman
 */
public class ProfesorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Profesor> profesores = new ArrayList<>();
        ProfesorTitular profesorTitular = new ProfesorTitular();
        profesorTitular.setNombre("Juan Perez");
        profesorTitular.setLegajo(1);
        profesores.add(profesorTitular);
        
        ProfesorSuplente profesorSuplente = new ProfesorSuplente();
        profesorSuplente.setNombre("Juana Perez");
        profesorSuplente.setLegajo(2);
        profesores.add(profesorSuplente);
        
        Profesor profe = new ProfesorTitular();
        profe.setNombre("Profe Perez");
        profe.setLegajo(1234);
        profesores.add(profe);
        
        //int i = 0;
        for (Profesor profesor : profesores) {
            
            //profesor.setNombre("Nombre del profesor: "+ ++i);
            System.out.println("Nombre del profesor: "+profesor.getNombre()+" con legajo "+profesor.printLegajo());
        }
        
    }
    
}
