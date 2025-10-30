package spaceinvaders.ui;
import javax.swing.*;
import spaceinvaders.utilities.ImageSelection;

public class GameMenuBar extends JMenuBar {

    public GameMenuBar(ImageSelection imageSelection, SpaceInvadersUI game){

        ShooterImageMenu menuShooter= new ShooterImageMenu(imageSelection, game);
        InvaderImageMenu menuInvader= new InvaderImageMenu(imageSelection, game);
        BulletTypeMenu menuBullet = new BulletTypeMenu(game);
        MusicMenu menuMusic = new MusicMenu();


        add(menuShooter);
        add(menuInvader);
        add(menuBullet);
        add(menuMusic);
    }
    
}
