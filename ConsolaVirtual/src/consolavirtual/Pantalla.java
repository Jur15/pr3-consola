package consolavirtual;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

/**
 *
 * @author moral
 */
public class Pantalla extends JFrame implements Constantes {
    
    public Pantalla() {
        iniciarComponentes();
        this.setVisible(true);
    }
    
    private void iniciarComponentes() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(50, 50));
        for(int i = 0; i < tamPantalla; i++) {
            for(int j = 0; j < tamPantalla; j++) {
                JPanel pixel = new JPanel();
                pixel.setPreferredSize(new Dimension(10, 10));
                pixel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                getContentPane().add(pixel);
            }
        }
        pack();
    }
    
    public static void main(String[] args) {
        Pantalla p = new Pantalla();
    }
}
