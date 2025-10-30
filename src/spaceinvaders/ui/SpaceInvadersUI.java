package spaceinvaders.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
// import spaceinvaders.listeners.ListenerActions;
import spaceinvaders.listeners.BulletsListener;
import spaceinvaders.painters.PaintingActions; 
import spaceinvaders.utilities.ImageSelection;
import spaceinvaders.listeners.KeyboardListener;
import spaceinvaders.entities.InvaderBox;   
import spaceinvaders.entities.Bullet;   

// import spaceinvaders.SpaceInvadersUI.Bullet;
// import spaceinvaders.SpaceInvadersUI.InvaderBox;

public class SpaceInvadersUI extends JPanel implements ActionListener, KeyListener {

    private final Timer timer; 
    public boolean moveLeft, moveRight;
    private final BulletsListener bulletsListener;

    private final KeyboardListener keyboardListener;

    public final ImageSelection imageSelection;
    private final PaintingActions paintingActions;
    public static int breakpointcounter = 0;

    // Constructor
    public SpaceInvadersUI() {
        //
        timer = new Timer(20, this); // not supposed to be final but ok
        invaderboxes = new ArrayList<>(); // not ui
        bullets = new ArrayList<>(); // not ui
        random = new Random(); // not ui
        moveLeft = false; // not ui
        moveRight = false; // not ui
        bulletsListener = new BulletsListener();
        imageSelection = new ImageSelection();
        paintingActions = new PaintingActions();
        keyboardListener = new KeyboardListener();

        // For debugging

        // Set images
        imageSelection.setGameImages();

        setFocusable(true);
        addKeyListener(this);
        timer.start();
    }

    @Override
    // Perhaps change this to specifically look for timer event or move all code to
    // ListenerActions and add overloading
    public void actionPerformed(ActionEvent e) {
        bulletsListener.updatePositions(this);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyboardListener.keyPressed(e, this);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyboardListener.keyReleased(e, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used. Not providing an implementation Violates Interface Segregation
        // Principle
        // Could be used for character keys.
    }

    @Override
    // Let's move these methods into a separate PaintUI class
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        // Draw shooter (rectangle)
        paintingActions.drawShooter(g, this);

        // Draw falling invaderboxes (as images)
        paintingActions.drawInvaders(g, invaderboxes, imageSelection.getInvaderImage(), this);

        // Draw bullets (bullets)
        paintingActions.drawBullets(g, bullets);
    }

    public int getShooterWidth() { // not ui
        return (shooter_width);
    }

    public int getShooterHeight() { // not ui
        return (shooter_height);
    }

    public int getShooter_X_Coordinate() { // not ui
        return (shooter_X_Coordinate);
    }

    public void setShooter_X_Coordinate(int shooter_X) { // not ui
        shooter_X_Coordinate = shooter_X;
    }

    public void updateShooterImage(Image newImage)
    {
        imageSelection.setShooterImageDirect(newImage);
        repaint();
    }
}

    // Inner class representing bullets (bullets)
    // Look for Java bullet class
