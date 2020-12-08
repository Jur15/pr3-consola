package controlador;

import consola.Constantes;
import java.awt.event.*;
import javax.swing.*;
import org.netbeans.lib.awtextra.*;

/**
 *
 * @author moral
 */
public class Controlador extends JFrame implements Constantes {

    private JButton btnArriba, btnAbajo, btnIzq, btnDer, btnAccion;

    public Controlador() {
        iniciarComponentes();
        setVisible(true);
    }

    private void iniciarComponentes() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        System.out.println("Se ha presionado Arriba");
    }

    private void presionarAbajo() {
        System.out.println("Se ha presionado Abajo");
    }

    private void presionarIzq() {
        System.out.println("Se ha presionado Izquierda");
    }

    private void presionarDer() {
        System.out.println("Se ha presionado Derecha");
    }

    private void presionarAccion() {
        System.out.println("Se ha presionado Accion");
    }

    public static void main(String[] args) {
        Controlador c = new Controlador();
    }
}
