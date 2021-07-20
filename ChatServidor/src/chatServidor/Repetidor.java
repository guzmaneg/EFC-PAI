/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Repetidor extends Thread {

    public Repetidor(List<PrintWriter> listaSalidas, BufferedReader entrada) {
        this.listaSalidas = listaSalidas;
        this.entrada = entrada;
    }

    @Override
    public void run() {
        String mensaje;

        try {
            while (true) {
                mensaje = entrada.readLine();

                for (PrintWriter salida : listaSalidas) {
                    salida.println(mensaje);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    private final List<PrintWriter> listaSalidas;
    private final BufferedReader entrada;
}
