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

        JMenuItem option1= new JMenuItem("Invader 1");
        JMenuItem option2= new JMenuItem("Invader 2");
        JMenuItem option3= new JMenuItem("Invader 3");
        JMenuItem option4= new JMenuItem("Custom");

        option1.addActionListener(e -> setInvader("/spaceinvaders/resources/Images/Invaders/gonzagordo.png"));
        option2.addActionListener(e -> setInvader("/spaceinvaders/resources/Images/Invaders/InvaderImageI.png"));
        option3.addActionListener(e -> setInvader("/spaceinvaders/resources/Images/Invaders/samuelcaraI.png"));
        option4.addActionListener(e -> chooseCustomImage());

        add(option1);
        add(option2);
        add(option3);
        add(option4);
    }



    private void setInvader(String path) {
        imageSelection.setInvaderImage(path);
        game.updateShooterImage(imageSelection.getInvaderImage());

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