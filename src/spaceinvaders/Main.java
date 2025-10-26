package spaceinvaders;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Space Invaders with Images");
            ImageSelection imageSelection= new ImageSelection();
            SpaceInvadersUI game = new SpaceInvadersUI();
            GameMenuBar menuBar = new GameMenuBar(imageSelection);

            frame.setJMenuBar(menuBar);

            frame.add(game);
            frame.setSize(600, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
