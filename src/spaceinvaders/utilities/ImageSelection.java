package spaceinvaders.utilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import spaceinvaders.exceptions.GameExceptions;

public class ImageSelection {

    private Image shooterImage;
    private Image invaderImage;

    public Image getShooterImage() {
        return shooterImage;
    }

    public Image getInvaderImage() {
        return invaderImage;
    }


    public void setGameImages() {
        try {
            File shooterFile = new File("src/spaceinvaders/resources/Images/Shooters/guisante.png");
            File invaderFile = new File("src/spaceinvaders/resources/Images/Shooters/zombie.png");

            if(shooterFile.exists() && invaderFile.exists())
            {
                shooterImage = ImageIO.read(shooterFile);
                invaderImage = ImageIO.read(invaderFile);
            }
            else{
                shooterImage = ImageIO.read(ImageSelection.class.getResource("/spaceinvaders/resources/Images/Shooters/guisante.png"));
                invaderImage = ImageIO.read(ImageSelection.class.getResource("/spaceinvaders/resources/Images/Invaders/zombie.png"));
            }
        } catch (IOException e) {
            GameExceptions.showErrorDialog("Error loading default images: " + e.getMessage());
            
        } catch(Exception e) {
            GameExceptions.showErrorDialog("Unexpected error: " + e.getMessage());
        }
    }

    public void setShooterImage(String path) {
    try {
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        File file = new File("src/" + path);
        if (file.exists()) {
            shooterImage = ImageIO.read(file);
            return;
        }

        throw new IOException("File not found at " + file.getAbsolutePath());

    } catch (Exception e) {
        GameExceptions.showErrorDialog("Error loading shooter image: " + e.getMessage());
    }
}

    public void setShooterImageDirect(Image newImage) {
        this.shooterImage = newImage;
    }



    public void setInvaderImage(String path){
        try {
            if(path.startsWith("/"))
            {
                path= path.substring(1);
            }
        File file = new File("src/" + path);
        if (file.exists()) {
            invaderImage = ImageIO.read(file);
            return;
        }

        // Si no existe 
        throw new IOException("File not found at " + file.getAbsolutePath());
        } catch (Exception e) {
            GameExceptions.showErrorDialog("Error loading invader image: " + e.getMessage());
        }
    }

        public void setInvaderImageDirect(Image newImage){
                this.invaderImage = newImage;
        }
}
