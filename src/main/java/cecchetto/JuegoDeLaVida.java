package cecchetto;

import javax.swing.*;
import java.awt.*;

public class JuegoDeLaVida extends JFrame {

    private PanelControl panelControl;

    public JuegoDeLaVida() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setBackground(Color.DARK_GRAY);

        this.setSize(new Dimension(600, 600));
        this.setLocationRelativeTo(null);

        panelControl = new PanelControl(this);
    }

}
