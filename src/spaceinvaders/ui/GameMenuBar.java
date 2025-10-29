package spaceinvaders.ui;
import javax.swing.*;
import spaceinvaders.utilities.ImageSelection;

public class GameMenuBar extends JMenuBar {

    public GameMenuBar(ImageSelection imageSelection, SpaceInvadersUI game){

        ShooterImageMenu menuShooter= new ShooterImageMenu(imageSelection, game);
        InvaderImageMenu menuInvader= new InvaderImageMenu(imageSelection, game);
        BulletTypeMenu menuBullet = new BulletTypeMenu(game);

        JMenu musicMenu = new JMenu("Music");

        add(menuShooter);
        add(menuInvader);
        add(menuBullet);
        add(musicMenu);
    }
    
}
