package cecchetto;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Celula {

    private Estado estado = Estado.muerta;
    private Point posicion;
    private int tamanio;
    static private int WHIDTH = 10;
    private static int HEIGTH = 10;

    public Celula(Point posicion, int tamanio) {
        this.posicion = posicion;
        this.tamanio = tamanio;
    }

    public Rectangle2D getGrafico() {
        int x = posicion.x * WHIDTH;
        int y = posicion.y * WHIDTH;
        return new Rectangle2D.Double(x ,y, WHIDTH, HEIGTH);
    }

    public void cambiarEstado() {
        estado = (estado.equals(Estado.muerta) ? Estado.viva : Estado.muerta);
    }

    public Estado getEstado() {return estado;}


    public static Dimension getDimension () {return new Dimension(WHIDTH, HEIGTH);}
}
