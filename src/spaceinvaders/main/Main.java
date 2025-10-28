package spaceinvaders.main;

import javax.swing.*;
import spaceinvaders.ui.GameMenuBar;
import spaceinvaders.ui.SpaceInvadersUI;
import spaceinvaders.utilities.ImageSelection;



public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Space Invaders with Images");
            ImageSelection imageSelection= new ImageSelection();
            SpaceInvadersUI game = new SpaceInvadersUI();
            GameMenuBar menuBar = new GameMenuBar(imageSelection,game);

            frame.setJMenuBar(menuBar);

            frame.add(game);
            frame.setSize(600, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
