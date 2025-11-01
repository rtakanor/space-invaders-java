package spaceinvaders.listeners;
import spaceinvaders.ui.SpaceInvadersUI;
import java.util.Iterator;
import java.awt.*;
import spaceinvaders.entities.InvaderBox;
import spaceinvaders.entities.Bullet;
import spaceinvaders.states.GameState;

public class BulletsListener {

       public void updatePositions(GameState gameState, SpaceInvadersUI game) {
        int shooter_X_Coordinate = gameState.getShooter_X_Coordinate();
        int shooter_Width = gameState.getShooterWidth();
        // Move shooter left or right
        if (gameState.moveLeft && shooter_X_Coordinate > 0) {
            gameState.setShooter_X_Coordinate(shooter_X_Coordinate - 5);
        }
        if (gameState.moveRight && shooter_X_Coordinate < game.getWidth() - shooter_Width) {
            gameState.setShooter_X_Coordinate(shooter_X_Coordinate + 5);
        }

        // Add new falling invaderboxs randomly
        if (gameState.random.nextInt(100) < 2) {
            int x = gameState.random.nextInt(game.getWidth());
            gameState.invaderboxes.add(new InvaderBox(x, 0, 40)); // Example size 40
        }

        // Move invaderboxes down
        Iterator<InvaderBox> invaderboxIterator = gameState.invaderboxes.iterator();
        while (invaderboxIterator.hasNext()) {
            InvaderBox invaderbox = invaderboxIterator.next();
            invaderbox.y += 2;
            if (invaderbox.y + invaderbox.size >= game.getHeight() - gameState.getShooterHeight()) {
                gameState.setGameOver(true);
                System.out.println("💀 YOU DIED — PRESS R TO TRY AGAIN MANCO");
                break;
            }
            if (invaderbox.y > game.getHeight()) {

                invaderboxIterator.remove(); // Remove invaderboxes that go off the screen
            }
        }

        // Move bullets up
        Iterator<Bullet> bulletIterator = gameState.bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            bullet.y -= 5;
            if (bullet.y < 0) {
                bulletIterator.remove(); // Remove bullets that go off the screen
            }
        }

        // Check for bullet-invaderbox collisions
        bulletIterator = gameState.bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            invaderboxIterator = gameState.invaderboxes.iterator();
            while (invaderboxIterator.hasNext()) {
                InvaderBox invaderbox = invaderboxIterator.next();
                if (new Rectangle(bullet.x - 5, bullet.y, 10, 10).intersects(
                        new Rectangle(invaderbox.x, invaderbox.y, invaderbox.size, invaderbox.size))) {
                    bulletIterator.remove();
                    invaderboxIterator.remove();

                    gameState.incrementInvadersKilled();

                    System.out.println("Invader was killed. Total: " + gameState.getInvadersKilled()); // just to check that is working


                    break;
                }
            }
        }
    }

}