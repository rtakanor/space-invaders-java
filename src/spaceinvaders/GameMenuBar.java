package spaceinvaders;

import javax.swing.*;

public class GameMenuBar extends JMenuBar {

    public GameMenuBar(){

        ShooterImageMenu menuShooter= new ShooterImageMenu();

        JMenu invaderMenu = new JMenu("Invader Image");
        JMenu bulletMenu = new JMenu("Bullet Type");
        JMenu musicMenu = new JMenu("Music");

        add(menuShooter);
        add(invaderMenu);
        add(bulletMenu);
        add(musicMenu);
    }
    
}
