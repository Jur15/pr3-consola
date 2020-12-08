package pantalla;

import consola.Constantes;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author moral
 */
public class Pantalla extends JFrame implements Constantes {

    public Pantalla() {
        iniciarComponentes();
        setVisible(true);
    }

    private void iniciarComponentes() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(50, 50));
        for (int i = 0; i < const_tamPantalla; i++) {
            for (int j = 0; j < const_tamPantalla; j++) {
                JPanel pixel = new JPanel();
                pixel.setPreferredSize(new Dimension(10, 10));
                getContentPane().add(pixel);
            }
        }
        pack();
    }

    public static void main(String[] args) {
        Pantalla p = new Pantalla();
    }
}
