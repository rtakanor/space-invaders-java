package spaceinvaders.states;

import java.util.ArrayList;

import spaceinvaders.entities.Bullet;
import spaceinvaders.entities.InvaderBox;
import java.util.Random;

public class GameState {
    public ArrayList<InvaderBox> invaderboxes;
    public ArrayList<Bullet> bullets;
    public Random random;
    public boolean moveLeft;
    public boolean moveRight;
    private int shooter_width = 50;
    private int shooter_height = 60;
    private int shooter_X_Coordinate = 200;
    private int shooter_Y_Coordinate;

    public GameState() {

        invaderboxes = new ArrayList<>(); // not ui
        bullets = new ArrayList<>(); // not ui
        random = new Random(); // not ui
        moveLeft = false; // not ui
        moveRight = false; // not ui

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

    public int getShooter_Y_Coordinate() {
    return shooter_Y_Coordinate;
}
    



}
