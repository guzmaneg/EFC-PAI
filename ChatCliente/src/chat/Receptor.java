/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Administrador
 */
public class Receptor extends Thread {

    public Receptor(JTextArea mensajesTextArea, BufferedReader entrada, String nickname) {
        this.mensajesTextArea = mensajesTextArea;
        this.entrada = entrada;
        this.nickname = nickname;
    }

    @Override
    public void run() {
        String mensaje;

        try {
            while (true) {
                mensaje = entrada.readLine();
                
                mensajesTextArea.append(mensaje.replace(nickname+":", "Tú:") + System.lineSeparator());
            }
        } catch (IOException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private final JTextArea mensajesTextArea;
    private String nickname;
    private final BufferedReader entrada;
}
