package controlador;

import consola.Constantes;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author moral
 */
public class BotonControlador extends JButton implements MouseListener, Constantes {

    private Timer temporizador = null;

    public BotonControlador() {
        super();
        addMouseListener(this);
    }

    @Override
    public void addActionListener(ActionListener l) {
        super.addActionListener(l);
        temporizador = new Timer(const_delayRepetir, l);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (temporizador != null) {
            temporizador.start();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (temporizador != null) {
            temporizador.stop();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
