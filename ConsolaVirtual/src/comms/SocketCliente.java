package comms;

import java.io.*;
import java.net.*;

/**
 *
 * @author moral
 */
public class SocketCliente {

    private Socket cliente;
    private BufferedReader entrada;
    private PrintWriter salida;

    public SocketCliente() {
        cliente = null;
        entrada = null;
        salida = null;
    }

    public void conectar(String dirServ, int ipServ) throws Exception {
        cliente = new Socket(dirServ, ipServ);
        salida = new PrintWriter(cliente.getOutputStream(), true);
        entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
    }

    public void desconectar() throws IOException {
        if (cliente != null) {
            entrada.close();
            salida.close();
            cliente.close();
        }
    }

    public BufferedReader getEntrada() {
        return entrada;
    }

    public PrintWriter getSalida() {
        return salida;
    }
}
