package spaceinvaders.ui;
import javax.swing.*;
import spaceinvaders.utilities.ImageSelection;

public class InvaderImageMenu extends JMenu {

    private ImageSelection imageSelection;
    private SpaceInvadersUI game;

    public  InvaderImageMenu(ImageSelection imageSelection, SpaceInvadersUI game){
        super("Invader Image");
        this.imageSelection = imageSelection;
        this.game= game;

        JMenuItem option1= new JMenuItem("Easy");
        JMenuItem option2= new JMenuItem("Hard");
        JMenuItem option3= new JMenuItem("Extreme");
        JMenuItem option4= new JMenuItem("Custom");

        option1.addActionListener(e -> setInvader("/spaceinvaders/resources/Images/Invaders/zombie.png"));
        option2.addActionListener(e -> setInvader("/spaceinvaders/resources/Images/Invaders/zombie2.png"));
        option3.addActionListener(e -> setInvader("/spaceinvaders/resources/Images/Invaders/zombie3.png"));
        option4.addActionListener(e -> chooseCustomImage());

        add(option1);
        add(option2);
        add(option3);
        add(option4);
    }



    private void setInvader(String path) {
        imageSelection.setInvaderImage(path);
        game.updateInvaderImage(imageSelection.getInvaderImage());

    }

    private void chooseCustomImage() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String customPath = chooser.getSelectedFile().getAbsolutePath();
            imageSelection.setInvaderImage(customPath);
            game.updateInvaderImage(imageSelection.getInvaderImage());

        }
    }

}