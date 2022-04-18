/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class ChatServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(30001);
            Socket socket;
            PrintWriter salida;
            BufferedReader entrada;

            listaSalidas = new ArrayList<>();

            while (true) {
                socket = serverSocket.accept();
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                salida = new PrintWriter(socket.getOutputStream(), true);

                listaSalidas.add(salida);

                new Repetidor(listaSalidas, entrada).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static List<PrintWriter> listaSalidas;
}
