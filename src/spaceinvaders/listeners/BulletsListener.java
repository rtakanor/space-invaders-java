package spaceinvaders.listeners;
import spaceinvaders.ui.SpaceInvadersUI;
// import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.awt.*;
import spaceinvaders.entities.InvaderBox;

public class BulletsListener {

       public void updatePositions(SpaceInvadersUI game) {
        int shooter_X_Coordinate = game.getShooter_X_Coordinate();
        int shooter_Width = game.getShooterWidth();
        // Move shooter left or right
        if (game.moveLeft && shooter_X_Coordinate > 0) {
            game.setShooter_X_Coordinate(shooter_X_Coordinate - 5);
        }
        if (game.moveRight && shooter_X_Coordinate < game.getWidth() - shooter_Width) {
            game.setShooter_X_Coordinate(shooter_X_Coordinate + 5);
        }

        // Add new falling invaderboxs randomly
        if (game.random.nextInt(100) < 2) {
            int x = game.random.nextInt(game.getWidth());
            game.invaderboxes.add(game.new InvaderBox(x, 0, 40)); // Example size 40
        }

        // Move invaderboxes down
        Iterator<SpaceInvadersUI.InvaderBox> invaderboxIterator = game.invaderboxes.iterator();
        while (invaderboxIterator.hasNext()) {
            SpaceInvadersUI.InvaderBox invaderbox = invaderboxIterator.next();
            invaderbox.y += 2;
            if (invaderbox.y > game.getHeight()) {
                invaderboxIterator.remove(); // Remove invaderboxes that go off the screen
            }
        }

        // Move bullets up
        Iterator<SpaceInvadersUI.Bullet> bulletIterator = game.bullets.iterator();
        while (bulletIterator.hasNext()) {
            SpaceInvadersUI.Bullet bullet = bulletIterator.next();
            bullet.y -= 5;
            if (bullet.y < 0) {
                bulletIterator.remove(); // Remove bullets that go off the screen
            }
        }

        // Check for bullet-invaderbox collisions
        bulletIterator = game.bullets.iterator();
        while (bulletIterator.hasNext()) {
            SpaceInvadersUI.Bullet bullet = bulletIterator.next();
            invaderboxIterator = game.invaderboxes.iterator();
            while (invaderboxIterator.hasNext()) {
                SpaceInvadersUI.InvaderBox invaderbox = invaderboxIterator.next();
                if (new Rectangle(bullet.x - 5, bullet.y, 10, 10).intersects(
                        new Rectangle(invaderbox.x, invaderbox.y, invaderbox.size, invaderbox.size))) {
                    bulletIterator.remove();
                    invaderboxIterator.remove();
                    break;
                }
            }
        }
    }

}