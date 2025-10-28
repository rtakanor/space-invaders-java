package spaceinvaders.utilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.*;
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
        shooterImage = loadImage("shooter", "/spaceinvaders/resources/Images/Shooters/guisante.png");
        invaderImage = loadImage("invader", "/spaceinvaders/resources/Images/Invaders/zombie.png");
    }

    public void setShooterImage(String path) {
    try {
        // Si el path empieza con "/", lo quitamos para construir correctamente la ruta
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        // Construye la ruta completa desde la carpeta del proyecto
        File file = new File("src/" + path);
        if (file.exists()) {
            shooterImage = ImageIO.read(file);
            return;
        }

        // Si no existe, lanza error claro
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
        
    
    private static Image loadImage(String imageType, String defaultResourcePath) {
        String imageUrl = JOptionPane.showInputDialog(null,
                "Enter URL for " + imageType + " image (or leave blank for default):");

        File localFile= new File(defaultResourcePath);
        if (localFile.exists())
        {
            try {
                return ImageIO.read(localFile);
            } catch (IOException  e) {
                GameExceptions.showErrorDialog("Error loading local image: " + e.getMessage());
            }
        }

        // Need to handle case where url is not an image, ie a png or jpeg.
        if (imageUrl != null && !imageUrl.isEmpty()) {
            try {
                URI uri = new URI(imageUrl);
                return ImageIO.read(uri.toURL());
            } catch (IllegalArgumentException e) {
                GameExceptions.showErrorDialog(
                        "Illegal Argument " + imageUrl + " : " + e.getMessage()
                                + "\nLoading default image instead");
            } catch (URISyntaxException e) {
                GameExceptions.showErrorDialog(
                        "URL Syntax error for " + imageUrl + " : " + e.getMessage()
                                + "\nLoading default image instead");
            } catch (MalformedURLException e) {
                GameExceptions.showErrorDialog(
                        "Malformed URL for " + imageUrl + " : " + e.getMessage()
                                + "\nLoading default image instead");
            } catch (IOException e) {
                GameExceptions.showErrorDialog(
                        "Failed to load " + imageUrl + " : " + e.getMessage()
                                + "\nLoading default image instead");
            }
        }

        // If no URL is provided or URL fails, load the default resource
        try {
            System.out.println("Attempting to load " + imageType + " image from: " + defaultResourcePath); //debugging
            return ImageIO.read(ImageSelection.class.getResource(defaultResourcePath));
        } catch (IOException e) {
            GameExceptions.showErrorDialog("Failed to load default " + imageType + " image: " + e.getMessage());
        }

        return null;
    }
}
