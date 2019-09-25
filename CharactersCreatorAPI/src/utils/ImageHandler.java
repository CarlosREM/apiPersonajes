/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Carlos Esquivel
 * @author Marco Gamboa
 */
public class ImageHandler {
   public ImageIcon createImageicon(String path, int width, int height){
        File f = new File(path);
        try {
            BufferedImage img;
            Image dimg;
            if(f.isFile()) {
                img = ImageIO.read(f);
                //return new ImageIcon(f.getAbsolutePath());
            }
            else {
                InputStream defaultFile = getClass().getResourceAsStream(path);
                img = ImageIO.read(defaultFile);
                //return new ImageIcon();
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
