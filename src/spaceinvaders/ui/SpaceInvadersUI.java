package spaceinvaders.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import spaceinvaders.listeners.BulletsListener;
import spaceinvaders.painters.PaintingActions; 
import spaceinvaders.utilities.ImageSelection;
import spaceinvaders.listeners.KeyboardListener;
import spaceinvaders.states.GameState;

public class SpaceInvadersUI extends JPanel implements ActionListener, KeyListener {

    private final Timer timer; 
    private final BulletsListener bulletsListener;
    private final GameState gameState;
    private final KeyboardListener keyboardListener;

    public final ImageSelection imageSelection;
    private final PaintingActions paintingActions;
    public static int breakpointcounter = 0;

    // Constructor
    public SpaceInvadersUI() {
        //
        timer = new Timer(20, this); // not supposed to be final but ok

        bulletsListener = new BulletsListener();
        imageSelection = new ImageSelection();
        paintingActions = new PaintingActions();
        keyboardListener = new KeyboardListener();
        gameState = new GameState();

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
        bulletsListener.updatePositions(gameState, this);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyboardListener.keyPressed(e, gameState, this);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyboardListener.keyReleased(e, gameState);
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
        paintingActions.drawShooter(g, this, gameState);

        // Draw falling invaderboxes (as images)
        paintingActions.drawInvaders(g, gameState.invaderboxes, imageSelection.getInvaderImage(), this);

        // Draw bullets (bullets)
        paintingActions.drawBullets(g, gameState.bullets);
    }

    public void updateShooterImage(Image newImage)
    {
        imageSelection.setShooterImageDirect(newImage);
        repaint();
    }
}

    // Inner class representing bullets (bullets)
    // Look for Java bullet class
