package utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Class used to manage an image resizing operations
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
public class ImageHandler {
    
    /**
     * Creates an image icon.
     * @param path The location of the image.
     * @param width The desired image icon's width.
     * @param height The desired image icon's height.
     * @return An ImageIcon of the image with the dimensions specified.
     */
   public ImageIcon createImageicon(String path, int width, int height){
        File f = new File(path);
        try {
            BufferedImage img;
            Image dimg;
            if(f.isFile()) {
                img = ImageIO.read(f);
            }
            else {
                InputStream defaultFile = getClass().getResourceAsStream(path);
                img = ImageIO.read(defaultFile);
                defaultFile.close();
            }
            dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(dimg);
        }
        catch (IOException ex) {
            Logger.getLogger(ImageHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
