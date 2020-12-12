package consola;

import java.net.*;
import java.io.*;

/**
 *
 * @author moral
 */
public class Consola implements Constantes {

    private ServerSocket servidor;
    private Socket pantalla, controlador;
    private BufferedReader entradaControlador;
    private PrintWriter salidaPantalla;

    public Consola() {
        servidor = null;
        pantalla = null;
        controlador = null;
        entradaControlador = null;
        salidaPantalla = null;
    }

    public void iniciarServidor() throws IOException {
        servidor = new ServerSocket(const_serv_puert);
    }

    public void conectarPantalla() throws IOException {
        System.out.println("Esperando conexion a pantalla...");
        pantalla = servidor.accept();
        salidaPantalla = new PrintWriter(pantalla.getOutputStream(), true);
        System.out.println("Pantalla conectada.");
    }

    public void conectarControlador() throws IOException {
        System.out.println("Esperando conexion a controlador...");
        controlador = servidor.accept();
        entradaControlador = new BufferedReader(new InputStreamReader(controlador.getInputStream()));
        System.out.println("Controlador conectado.");
    }
    
    public void desconectar() throws IOException {
        //salidaPantalla.close();
        //pantalla.close();
        entradaControlador.close();
        controlador.close();
        servidor.close();
    }
    
    public void iniciarJuego() throws IOException {
        String mensaje;
        while((mensaje = entradaControlador.readLine()) != null) {
            if(!mensaje.equals("Accion")) {
                System.out.println("Mensaje recibido: " + mensaje);
            } else {
                //TODO: Terminar conexion
                System.out.println("Se recibe Accion.");
                break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Consola c = new Consola();
        try {
            c.iniciarServidor();
            c.conectarControlador();
            c.iniciarJuego();
        } catch (IOException ex) {
            System.out.println("Error en la comunicación.");
            ex.printStackTrace();
            System.exit(1);
        }
    }

}
