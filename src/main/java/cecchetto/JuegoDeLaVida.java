package cecchetto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class JuegoDeLaVida extends JFrame {

    private PanelControl panelControl;
    Celula[][] celulas;
    private int tamanio = 70;
    static int size = 600;
    private ArrayList<Celula> celulasVivas;
    private JPanel panel;

    private Boolean modoEditar = true;
    private final int MARCO = 50;

    public JuegoDeLaVida() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.DARK_GRAY);
        this.setSize(new Dimension(
                tamanio*(int)(Celula.getDimension().width * 1.1),
                tamanio*(int)(Celula.getDimension().height * 1.1)
        ));
        this.setLocationRelativeTo(null);       //cosas para que el Frame sea usable

        panelControl = new PanelControl(this);
        celulasVivas = new ArrayList<>();

        celulas = new Celula[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                celulas[i][j] = new Celula(new Point(i, j), tamanio);
            }
        }

        this.addMouseListener(new MouseAdapter() {      //se agrega el mouseListener al Frame
            @Override
            public void mousePressed(MouseEvent e) {
                accionClic(e);
            }
        });

        panel = new JPanel() {         //clase anónima para dibujar la escena
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                dibujar(g2);
                g2.dispose();
            }

        };

        this.add(panel);
        this.setVisible(true);  //Si no lo pongo acá no funcinoa

        Timer timer = new Timer(100, new ActionListener() {     //esto actualiza la escena cada cierto tiempo
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });
        timer.start();

    }

    public void siguienteGeneracion() {
        Celula[][] nuevaGeneracion = new Celula[tamanio][tamanio];

        for (int i=0 ; i<tamanio ; i++) {
            for (int j=0 ; j<tamanio ; j++) {
                nuevaGeneracion[i][j] = new Celula(new Point(i, j), tamanio);
                nuevaGeneracion[i][j].setEstado(celulas[i][j].getEstado());
            }
        }

        for (int i = 0; i < celulas.length; i++) {
            for (int j = 0; j < celulas[0].length; j++) {
                int count = 0;
                for (Point adyacente : celulas[i][j].getAdyacentes()) {
                    if (celulas[adyacente.x][adyacente.y].getEstado().equals(Estado.viva))
                        count++;
                }

                if (celulas[i][j].getEstado().equals(Estado.viva)) {
                    if (count < 2 || count > 3) {
                        nuevaGeneracion[i][j].setEstado(Estado.muerta);
                    }
                } else {
                    if (count == 3) {
                        nuevaGeneracion[i][j].setEstado(Estado.viva);
                    }
                }
            }
        }

        for (int i = 0; i < celulas.length; i++) {
            for (int j = 0; j < celulas[0].length; j++) {
                celulas[i][j].setEstado(nuevaGeneracion[i][j].getEstado());
            }
        }

    }

    private void accionClic(MouseEvent e) {        //accion del mouse
        if (!panelControl.getModoEditar()) return;
        if (e.getX()>700 || e.getY()>700) return;

        int x = e.getX()/Celula.getDimension().width;
        int y = (e.getY()-30)/Celula.getDimension().height;
        celulas[x][y].cambiarEstado();
    }

    private void dibujar(Graphics2D g) {     //dibuja la escena
        celulasVivas.clear();

        for (Celula[] filaCelula : celulas) {
            for (Celula celula : filaCelula) {
                celula.dibujar(g);
                if (celula.getEstado().equals(Estado.viva)) celulasVivas.add(celula);
            }
        }

        panel.repaint();
    }

    public void matarCelulas() {
        for (Celula celula : celulasVivas) {
            celula.setEstado(Estado.muerta);
        }
    }


}

















