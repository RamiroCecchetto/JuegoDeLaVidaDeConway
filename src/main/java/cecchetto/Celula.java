package cecchetto;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Celula {

    private Estado estado = Estado.muerta;
    private Point posicion;
    private int tamanio;
    private int WHIDTH = 50;
    private int HEIGTH = 50;

    public Celula(Point posicion, int tamanio) {
        this.posicion = posicion;
        this.tamanio = tamanio;
    }

    public Rectangle2D getGrafico() {
        int x = posicion.x * WHIDTH;
        int y = posicion.y * WHIDTH;
        return new Rectangle2D.Double(x ,y, WHIDTH, HEIGTH);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Point getPosicion() {
        return posicion;
    }
}
