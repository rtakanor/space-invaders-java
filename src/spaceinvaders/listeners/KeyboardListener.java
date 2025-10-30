package spaceinvaders.listeners;
import java.awt.event.KeyEvent;
import spaceinvaders.entities.Bullet;
import spaceinvaders.states.GameState;
import spaceinvaders.ui.SpaceInvadersUI;

// new class to follow SRP principles for keyboard event handling
public class KeyboardListener {

    public void keyPressed(KeyEvent e, GameState gameState, SpaceInvadersUI ui) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            gameState.moveLeft = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            gameState.moveRight = true;
        }
        if (key == KeyEvent.VK_SPACE) {
            int shooter_X_Coordinate = gameState.getShooter_X_Coordinate();
            int shooter_width = gameState.getShooterWidth();
            int shooter_height = gameState.getShooterHeight();
            int shooterY = ui.getHeight() - shooter_height;
            gameState.bullets.add(
                    new Bullet(shooter_X_Coordinate + shooter_width / 2, shooterY));
        }
    }

    public void keyReleased(KeyEvent e, GameState gameState) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            gameState.moveLeft = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            gameState.moveRight = false;
        }
    }
    
}
