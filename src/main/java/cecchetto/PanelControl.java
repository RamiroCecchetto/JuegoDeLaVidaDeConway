package cecchetto;

import javax.swing.*;
import java.awt.*;

public class PanelControl extends JFrame {

    public PanelControl(JuegoDeLaVida juegoDeLaVida) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton siguiente = new JButton("Siguiente generacion");
        panel.add(siguiente);

        JCheckBox modoEditar = new JCheckBox("Modo editar");
        panel.add(modoEditar);

        this.add(panel);
        this.pack();
        this.setLocation(
                juegoDeLaVida.getLocation().x + juegoDeLaVida.getWidth(),
                juegoDeLaVida.getLocation().y
        );

    }

}
