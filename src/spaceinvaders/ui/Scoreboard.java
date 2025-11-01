package spaceinvaders.ui;
import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JPanel {
    private JLabel counterLabel;

    public Scoreboard() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.BLACK);
        counterLabel = new JLabel("Kills: 0");
        counterLabel.setForeground(Color.WHITE);
        counterLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(counterLabel);
    }

    public void updateCount(int kills) {
        counterLabel.setText("Kills: " + kills);
    }
}
