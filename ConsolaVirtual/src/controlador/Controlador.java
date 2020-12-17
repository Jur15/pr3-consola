package controlador;

import comms.SocketCliente;
import consola.Constantes;
//Comunicacion
import java.io.*;
//Interfaz
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.netbeans.lib.awtextra.*;

/**
 *
 * @author moral
 */
public class Controlador extends JFrame implements Constantes {

    //Comunicacion
    private SocketCliente consola;

    //Interfaz
    private JButton btnArriba, btnAbajo, btnIzq, btnDer, btnAccion, btnConectar, btnDesconectar;
    private JTextField txtDir, txtPuerto;

    public Controlador() {
        consola = new SocketCliente();
        iniciarComponentes();
        setVisible(true);
    }

    private void iniciarComponentes() {
        setResizable(false);
        //Acciones antes de terminar el programa
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                desconectarConsola();
                dispose();
                System.exit(0);
            }
        });
        //----Panel Conexion----
        JPanel panConex = new JPanel();
        panConex.setBackground(new Color(26, 26, 26));
        panConex.setPreferredSize(new Dimension(500, 222));
        panConex.setLayout(new AbsoluteLayout());
        //Labels
        //  Titulo
        JLabel labTitulo = new JLabel("Consola Virtual - Controlador");
        labTitulo.setFont(new Font("Tahoma", 1, 18));
        labTitulo.setForeground(new Color(255, 0, 0));
        panConex.add(labTitulo, new AbsoluteConstraints(110, 20, -1, -1));
        //  Servidor
        JLabel labServ = new JLabel("IP del servidor:");
        labServ.setHorizontalAlignment(SwingConstants.CENTER);
        labServ.setForeground(Color.WHITE);
        panConex.add(labServ, new AbsoluteConstraints(135, 70, -1, 19));
        //  Puerto
        JLabel labPuerto = new JLabel("Puerto:");
        labPuerto.setForeground(Color.WHITE);
        panConex.add(labPuerto, new AbsoluteConstraints(180, 110, -1, 19));
        //Campos de texto
        //  Servidor
        txtDir = new JTextField();
        txtDir.setPreferredSize(new Dimension(120, 19));
        panConex.add(txtDir, new AbsoluteConstraints(230, 70, -1, -1));
        //  Puerto
        txtPuerto = new JTextField();
        txtPuerto.setPreferredSize(new Dimension(70, 19));
        panConex.add(txtPuerto, new AbsoluteConstraints(230, 110, -1, -1));
        //Boton Conectar
        btnConectar = new JButton("Conectar");
        panConex.add(btnConectar, new AbsoluteConstraints(210, 160, -1, -1));
        btnConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conectarConsola();
            }
        });

        //----Panel Controlador----
        JPanel panControl = new JPanel();
        panControl.setLayout(new AbsoluteLayout());
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
        panControl.add(btnArriba, new AbsoluteConstraints(113, 36, 56, 47));
        //  Izquierda
        btnIzq = new BotonControlador();
        btnIzq.setContentAreaFilled(false);
        btnIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionarIzq();
            }
        });
        panControl.add(btnIzq, new AbsoluteConstraints(67, 83, 47, 56));
        //  Derecha
        btnDer = new BotonControlador();
        btnDer.setContentAreaFilled(false);
        btnDer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionarDer();
            }
        });
        panControl.add(btnDer, new AbsoluteConstraints(169, 83, 48, 56));
        //  Abajo
        btnAbajo = new BotonControlador();
        btnAbajo.setContentAreaFilled(false);
        btnAbajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionarAbajo();
            }
        });
        panControl.add(btnAbajo, new AbsoluteConstraints(113, 140, 56, 48));
        //  Accion
        btnAccion = new BotonControlador();
        btnAccion.setContentAreaFilled(false);
        btnAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presionarAccion();
            }
        });
        panControl.add(btnAccion, new AbsoluteConstraints(344, 65, 94, 94));
        //  Desconectar
        btnDesconectar = new JButton("Desconectar");
        btnDesconectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desconectarConsola();
            }
        });
        panControl.add(btnDesconectar, new AbsoluteConstraints(210, 190, -1, -1));
        //Fondo
        JLabel labFondo = new JLabel();
        labFondo.setIcon(new ImageIcon(const_fondoControl));
        panControl.add(labFondo, new AbsoluteConstraints(0, 0, -1, -1));

        //----Frame principal----
        setLayout(new CardLayout());
        add(panConex, "cardConexion");
        add(panControl, "cardControl");
        pack(); //Ajustar tamaño
    }

    private void conectarConsola() {
        try {
            consola.conectar(txtDir.getText(), Integer.valueOf(txtPuerto.getText()));
            JOptionPane.showMessageDialog(this, "Conectado a la consola con éxito.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            CardLayout layoutMgr = (CardLayout) this.getContentPane().getLayout();
            layoutMgr.show(this.getContentPane(), "cardControl");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar a la consola.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void desconectarConsola() {
        try {
            consola.desconectar();
            CardLayout layoutMgr = (CardLayout) this.getContentPane().getLayout();
            layoutMgr.show(this.getContentPane(), "cardConexion");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al desconectarse de la consola.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void presionarArriba() {
        consola.getSalida().println("Arriba");
        System.out.println("Se ha presionado Arriba");
    }

    private void presionarAbajo() {
        consola.getSalida().println("Abajo");
        System.out.println("Se ha presionado Abajo");
    }

    private void presionarIzq() {
        consola.getSalida().println("Izquierda");
        System.out.println("Se ha presionado Izquierda");
    }

    private void presionarDer() {
        consola.getSalida().println("Derecha");
        System.out.println("Se ha presionado Derecha");
    }

    private void presionarAccion() {
        consola.getSalida().println("Accion");
        System.out.println("Se ha presionado Accion");
    }
    
    public static void main(String[] args) {
        Controlador c = new Controlador();
    }
}
