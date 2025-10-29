package spaceinvaders.ui;


import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;


public class BulletTypeMenu extends JMenu {

    private SpaceInvadersUI game;

    public BulletTypeMenu(SpaceInvadersUI game)
    {
        super("Bullet Type");
        this.game = game;

        JMenuItem fire = new JMenuItem("Fire Bullet");
        JMenuItem ice = new JMenuItem("Ice Bullet");
        JMenuItem earth = new JMenuItem("Earth Bullet");
        JMenuItem custom = new JMenuItem("Custom Bullet");

        fire.addActionListener(e -> setBullet("/spaceinvaders/resources/Images/Bullets/fireball.png"));
        ice.addActionListener(e -> setBullet("/spaceinvaders/resources/Images/Bullets/iceball.png"));
        earth.addActionListener(e -> setBullet("/spaceinvaders/resources/Images/Bullets/dirtball.png"));
        custom.addActionListener(e -> chooseCustomBullet());

        add(fire);
        add(ice);
        add(earth);
        add(custom);

    }

    public void setBullet(String path)
    {
        try {
            if (path.startsWith("/")) path = path.substring(1);
            File file = new File("src/" + path);
            Image bulletImage = ImageIO.read(file);
            game.setBulletImage(bulletImage);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading bullet image: " + ex.getMessage());
        }


    }

    private void chooseCustomBullet() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                Image bulletImage = ImageIO.read(chooser.getSelectedFile());
                game.setBulletImage(bulletImage);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error loading custom bullet image: " + ex.getMessage());
            }
        }
    }
    
}
