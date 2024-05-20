package cecchetto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelControl extends JFrame {

    private Boolean modoEditar = false;

    public PanelControl(JuegoDeLaVida juegoDeLaVida) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton btnSiguiente = new JButton("Siguiente generacion");
        panel.add(btnSiguiente);

        JButton btnMatar = new JButton("Matar celulas");
        panel.add(btnMatar);

        JCheckBox checkEditar = new JCheckBox("Modo editar");
        panel.add(checkEditar);

        this.add(panel);
        this.pack();
        this.setLocation(
                juegoDeLaVida.getLocation().x + juegoDeLaVida.getWidth(),
                juegoDeLaVida.getLocation().y
        );

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juegoDeLaVida.siguienteGeneracion();
            }
        });

        checkEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modoEditar = checkEditar.isSelected();
            }
        });

        btnMatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juegoDeLaVida.matarCelulas();
            }
        });

    }

    public Boolean getModoEditar() {
        return modoEditar;
    }

}
