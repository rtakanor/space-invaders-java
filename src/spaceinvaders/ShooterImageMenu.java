package spaceinvaders;

import javax.swing.*;



public class ShooterImageMenu extends JMenu {

    private ImageSelection imageSelection;

    public ShooterImageMenu(ImageSelection imageSelection){
        super("Shooter Image");
        this.imageSelection= imageSelection;


        JMenuItem option1= new JMenuItem("Shooter 1");
        JMenuItem option2= new JMenuItem("Shooter 2");
        JMenuItem option3= new JMenuItem("Shooter 3");
        JMenuItem option4= new JMenuItem("Custom");

        option1.addActionListener(e -> setShooter("/spaceinvaders/resources/Images/Shooters/ShooterImageS.png"));
        option2.addActionListener(e -> setShooter("/spaceinvaders/resources/Images/Shooters/ana_samS.png"));
        option3.addActionListener(e -> setShooter("/spaceinvaders/resources/Images/Shooters/virS.png"));
        option4.addActionListener(e -> chooseCustomImage());

        add(option1);
        add(option2);
        add(option3);
        add(option4);

    }

    private void setShooter(String path) {
        imageSelection.setShooterImage(path);
    }


    private void chooseCustomImage() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String customPath = chooser.getSelectedFile().getAbsolutePath();
            imageSelection.setShooterImage(customPath);
        }
    }
    
}
