package spaceinvaders.states;

import java.util.ArrayList;

import spaceinvaders.entities.Bullet;
import spaceinvaders.entities.InvaderBox;
import java.util.Random;

public class GameState {
    public ArrayList<InvaderBox> invaderboxes;
    public ArrayList<Bullet> bullets;
    public Random random;
    private int shooter_width = 50;
    private int shooter_height = 60;
    private int shooter_X_Coordinate = 200;
}
