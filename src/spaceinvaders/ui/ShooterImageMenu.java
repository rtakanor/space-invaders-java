package spaceinvaders.ui;
import javax.swing.*;
import spaceinvaders.utilities.ImageSelection;



public class ShooterImageMenu extends JMenu {

    private ImageSelection imageSelection;
    private SpaceInvadersUI game;

    public ShooterImageMenu(ImageSelection imageSelection, SpaceInvadersUI game){
        super("Shooter Image");
        this.imageSelection= imageSelection;
        this.game= game;


        JMenuItem option1= new JMenuItem("Green Plant");
        JMenuItem option2= new JMenuItem("Frozen Plant");
        JMenuItem option3= new JMenuItem("SunFlower");
        JMenuItem option4= new JMenuItem("Custom");

        option1.addActionListener(_ -> setShooter("/spaceinvaders/resources/Images/Shooters/guisante.png"));
        option2.addActionListener(_ -> setShooter("/spaceinvaders/resources/Images/Shooters/icedplant.png"));
        option3.addActionListener(_ -> setShooter("/spaceinvaders/resources/Images/Shooters/sunflower.png"));
        option4.addActionListener(_ -> chooseCustomImage());


        add(option1);
        add(option2);
        add(option3);
        add(option4);

    }

    

    private void setShooter(String path) {
        imageSelection.setShooterImage(path);
        game.updateShooterImage(imageSelection.getShooterImage());

    }


    private void chooseCustomImage() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String customPath = chooser.getSelectedFile().getAbsolutePath();
            imageSelection.setShooterImage(customPath);

            game.updateShooterImage(imageSelection.getShooterImage());
        }
    }
    
}
