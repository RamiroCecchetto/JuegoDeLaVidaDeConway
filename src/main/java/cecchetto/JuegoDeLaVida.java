package cecchetto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JuegoDeLaVida extends JFrame {

    private PanelControl panelControl;
    Celula[][] celulas;
    private int tamanio = 75;
    static int size = 600;
    private ArrayList<Celula> celulasVivas;

    private Boolean modoEditar = true;

    public JuegoDeLaVida() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.DARK_GRAY);
        this.setSize(new Dimension(tamanio*Celula.getDimension().width, tamanio*Celula.getDimension().height));
        this.setLocationRelativeTo(null);       //cosas para que el Frame sea usable

        panelControl = new PanelControl(this);
        celulasVivas = new ArrayList<>();

        celulas = new Celula[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                celulas[i][j] = new Celula(new Point(i, j), tamanio);
            }
        }

        this.add(new JPanel() {         //clase anónima para dibujar la escena
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                dibujar(g2);
                repaint();
                g2.dispose();
            }
        });

        this.addMouseListener(new MouseAdapter() {      //se agrega el mouseListener al Frame
            @Override
            public void mousePressed(MouseEvent e) {
                accionClic(e);
            }
        });

        this.setVisible(true);  //Si no lo pongo acá no funcinoa

    }

    private void accionClic(MouseEvent e) {        //accion del mouse
        if (!panelControl.getModoEditar()) return;

        int x = e.getX()/Celula.getDimension().width;
        int y = (e.getY()-30)/Celula.getDimension().height;
        celulas[x][y].cambiarEstado();
    }

    private void dibujar(Graphics2D g) {     //dibuja la escena

        for (Celula[] celulaFila : celulas) {
            for (Celula celula : celulaFila) {
                if (celula.getEstado().equals(Estado.viva)) celulasVivas.add(celula);
                g.setColor((celula.getEstado().equals(Estado.viva) ? Color.WHITE : Color.BLACK));
                g.fill(celula.getGrafico());
            }
        }
    }


}

















