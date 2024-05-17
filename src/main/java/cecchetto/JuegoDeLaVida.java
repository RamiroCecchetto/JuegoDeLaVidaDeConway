package cecchetto;

import javax.swing.*;
import java.awt.*;

public class JuegoDeLaVida extends JFrame {

    private PanelControl panelControl;
    Panel panel;
    Celula[][] celulas;
    private int tamanio = 12;
    static int size = 600;

    public JuegoDeLaVida() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setBackground(Color.DARK_GRAY);
        this.setSize(new Dimension(size, size));
        this.setLocationRelativeTo(null);
        panel = new Panel(this);
        this.add(panel);
        celulas = new Celula[tamanio][tamanio];

        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                celulas[i][j] = new Celula(new Point(i, j), tamanio);
            }
        }

        panelControl = new PanelControl(this);
    }

    public void dibujar(Graphics2D g) {
        for (Celula[] celula1 : celulas) {
            for (Celula celula : celula1) {
                g.setColor(celula.getEstado().equals(Estado.viva) ? Color.WHITE : Color.BLACK);
                g.fill(celula.getGrafico());
            }
        }



    }


    private static class Panel extends JPanel {
        private JuegoDeLaVida juegoDeLaVida;
        public Panel(JuegoDeLaVida juegoDeLaVida) {
            this.juegoDeLaVida = juegoDeLaVida;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            juegoDeLaVida.dibujar(g2);

            g2.dispose();
        }
    }

}

















