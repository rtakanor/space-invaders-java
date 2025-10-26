package spaceinvaders;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ShooterImageMenu extends JMenu {

    public ShooterImageMenu(){
        super("Shooter Image");


        JMenuItem option1= new JMenuItem("Shooter 1");
        JMenuItem option2= new JMenuItem("Shooter 2");
        JMenuItem option3= new JMenuItem("Shooter 3");
        JMenuItem option4= new JMenuItem("Custom");


        add(option1);
        add(option2);
        add(option3);
        add(option4);

    }
    
}
