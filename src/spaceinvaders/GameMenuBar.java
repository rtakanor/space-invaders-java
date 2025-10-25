package spaceinvaders;

import javax.swing.*;

public class GameMenuBar extends JMenuBar {

    public GameMenuBar(){
        JMenu shooterMenu = new JMenu("Shooter Image");
        JMenu invaderMenu = new JMenu("Invader Image");
        JMenu bulletMenu = new JMenu("Bullet Type");
        JMenu musicMenu = new JMenu("Music");

        add(shooterMenu);
        add(invaderMenu);
        add(bulletMenu);
        add(musicMenu);
    }
    
}
