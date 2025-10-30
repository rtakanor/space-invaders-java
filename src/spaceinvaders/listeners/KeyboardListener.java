package spaceinvaders.listeners;
import spaceinvaders.ui.SpaceInvadersUI;
import java.awt.event.KeyEvent;
import spaceinvaders.entities.Bullet;
import spaceinvaders.states.GameState;

// new class to follow SRP principles for keyboard event handling
public class KeyboardListener {

    public void keyPressed(KeyEvent e, SpaceInvadersUI game, GameState gameState) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            game.moveLeft = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            game.moveRight = true;
        }
        if (key == KeyEvent.VK_SPACE) {
            int shooter_X_Coordinate = gameState.getShooter_X_Coordinate();
            int shooter_width = gameState.getShooterWidth();
            int shooter_height = gameState.getShooterHeight();
            gameState.bullets.add(
                    new Bullet(shooter_X_Coordinate + shooter_width / 2, game.getHeight() - shooter_height));
        }
    }

    public void keyReleased(KeyEvent e, SpaceInvadersUI game) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            game.moveLeft = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            game.moveRight = false;
        }
    }
    
}
