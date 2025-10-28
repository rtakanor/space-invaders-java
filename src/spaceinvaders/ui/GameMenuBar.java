package spaceinvaders.ui;
import spaceinvaders.utilities.ImageSelection;

import javax.swing.*;

public class GameMenuBar extends JMenuBar {

    public GameMenuBar(ImageSelection imageSelection, SpaceInvadersUI game){

        ShooterImageMenu menuShooter= new ShooterImageMenu(imageSelection, game);

        JMenu invaderMenu = new JMenu("Invader Image");
        JMenu bulletMenu = new JMenu("Bullet Type");
        JMenu musicMenu = new JMenu("Music");

        add(menuShooter);
        add(invaderMenu);
        add(bulletMenu);
        add(musicMenu);
    }
    
}
