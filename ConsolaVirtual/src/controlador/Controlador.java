package controlador;

import consola.Constantes;
//Comunicacion
import java.net.*;
import java.io.*;
//Interfaz
import java.awt.event.*;
import javax.swing.*;
import org.netbeans.lib.awtextra.*;

/**
 *
 * @author moral
 */
public class Controlador extends JFrame implements Constantes {

    //Comunicacion
    private Socket consola;
    private PrintWriter salida;

    //Interfaz
    private JButton btnArriba, btnAbajo, btnIzq, btnDer, btnAccion;

    public Controlador() {
        consola = null;
        salida = null;
        iniciarComponentes();
        setVisible(true);
    }

    public void conectarConsola(String dirIP, int puerto) throws IOException {
        consola = new Socket(dirIP, puerto);
        salida = new PrintWriter(consola.getOutputStream(), true);
    }

    public void desconectarConsola() {
        try {
            if (consola != null) {
                salida.close();
                consola.close();
            }
        } catch (IOException ex) {
            System.out.println("Error al desconectarse de la consola.");
        }
    }

    private void iniciarComponentes() {
        //Acciones antes de terminar el programa
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                desconectarConsola();
                dispose();
                System.exit(0);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());
        //Botones
        //  Arriba
        btnArriba = new BotonControlador();
        btnArriba.setContentAreaFilled(false);
        btnArriba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionarArriba();
            }
        });
        getContentPane().add(btnArriba, new AbsoluteConstraints(113, 36, 56, 47));
        //  Izquierda
        btnIzq = new BotonControlador();
        btnIzq.setContentAreaFilled(false);
        btnIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionarIzq();
            }
        });
        getContentPane().add(btnIzq, new AbsoluteConstraints(67, 83, 47, 56));
        //  Derecha
        btnDer = new BotonControlador();
        btnDer.setContentAreaFilled(false);
        btnDer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionarDer();
            }
        });
        getContentPane().add(btnDer, new AbsoluteConstraints(169, 83, 48, 56));
        //  Abajo
        btnAbajo = new BotonControlador();
        btnAbajo.setContentAreaFilled(false);
        btnAbajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionarAbajo();
            }
        });
        getContentPane().add(btnAbajo, new AbsoluteConstraints(113, 140, 56, 48));
        //  Accion
        btnAccion = new BotonControlador();
        btnAccion.setContentAreaFilled(false);
        btnAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionarAccion();
            }
        });
        getContentPane().add(btnAccion, new AbsoluteConstraints(344, 65, 94, 94));
        //Fondo
        JLabel labFondo = new JLabel();
        labFondo.setIcon(new ImageIcon(const_fondoControl));
        getContentPane().add(labFondo, new AbsoluteConstraints(0, 0, -1, -1));
        //Ajustar tamaño
        pack();
    }

    private void presionarArriba() {
        if (consola != null) {
            salida.println("Arriba");
        }
        System.out.println("Se ha presionado Arriba");
    }

    private void presionarAbajo() {
        if (consola != null) {
            salida.println("Abajo");
        }
        System.out.println("Se ha presionado Abajo");
    }

    private void presionarIzq() {
        if (consola != null) {
            salida.println("Izquierda");
        }
        System.out.println("Se ha presionado Izquierda");
    }

    private void presionarDer() {
        if (consola != null) {
            salida.println("Derecha");
        }
        System.out.println("Se ha presionado Derecha");
    }

    private void presionarAccion() {
        if (consola != null) {
            salida.println("Accion");
        }
        System.out.println("Se ha presionado Accion");
    }

    public static void main(String[] args) {
        Controlador c = new Controlador();
        try {
            c.conectarConsola(const_serv_ip, const_serv_puert);
        } catch (IOException ex) {
            System.out.println("Error al conectar al servidor.");
            System.exit(1);
        }
    }
}
