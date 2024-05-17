package cecchetto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JuegoDeLaVida extends JFrame {

    private PanelControl panelControl;
    Celula[][] celulas;
    private int tamanio = 12;
    static int size = 600;

    public JuegoDeLaVida() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.DARK_GRAY);
        this.setSize(new Dimension(size, size));
        this.setLocationRelativeTo(null);       //cosas para que el Frame sea usable
        panelControl = new PanelControl(this);

        celulas = new Celula[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                celulas[i][j] = new Celula(new Point(i, j), tamanio);
            }
        }

        this.add(new JPanel() {         //clase anónima para detectar el mouse y dibujar la escena y detectar el mouse
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                dibujar(g2);
                g2.dispose();
            }
        });
        this.setVisible(true);  //Si no lo pongo acá no funcinoa

    }

    private void dibujar(Graphics2D g) {     //dibuja la escena
        for (Celula[] celula1 : celulas) {
            for (Celula celula : celula1) {
                g.setColor(celula.getEstado().equals(Estado.viva) ? Color.WHITE : Color.BLACK); //pinta las celulas
                g.fill(celula.getGrafico());                                                     // depentiendo de su estado
            }
        }
    }


}

















