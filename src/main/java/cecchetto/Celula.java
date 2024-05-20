package cecchetto;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Celula {

    private Estado estado = Estado.muerta;
    private Point posicion;
    private int tamanio;
    static private int WHIDTH = 10;
    private static int HEIGHT = 10;
    private final int MOVIMIENTOS[][] = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
    };

    public Celula(Point posicion, int tamanio) {
        this.posicion = posicion;
        this.tamanio = tamanio;
    }

    public void dibujar(Graphics2D g) {
        int x = posicion.x * WHIDTH;
        int y = posicion.y * HEIGHT;

        g.setColor(estado.equals(Estado.viva) ? Color.WHITE : Color.BLACK);
        g.fill(new Rectangle2D.Double(x, y, WHIDTH, HEIGHT));

//        return new Rectangle2D.Double(x ,y, WHIDTH, HEIGHT);
    }

    public void cambiarEstado() {
        estado = (estado.equals(Estado.muerta) ? Estado.viva : Estado.muerta);
    }

    public Estado getEstado() {return estado;}
    public void setEstado(Estado estado) {this.estado = estado;}
    public Point getPosicion() {return posicion;}

    public static Dimension getDimension () {return new Dimension(WHIDTH, HEIGHT);}

    public ArrayList<Point> getAdyacentes() {        //Devuelve las posiciones de las celulas adyacentes
        ArrayList<Point> arreglo = new ArrayList<>();

        for (int[] movimiento : MOVIMIENTOS) {
            int x = posicion.x + movimiento[0];
            int y = posicion.y + movimiento[1];

            if (x>=0 && x< tamanio && y>=0 && y<tamanio)
                arreglo.add(new Point(x, y));

        }

        return arreglo;
    }

}
