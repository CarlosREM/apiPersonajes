/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Marco Gamboa
 */
public class ImageLoader {
   public ImageIcon createImageicon(String path){
        File f = new File(path);
        if(f.isFile()){
            return new ImageIcon(f.getAbsolutePath());
        }
        else{
            InputStream defaultFile = getClass().getResourceAsStream(path);
            try {
                return new ImageIcon(ImageIO.read(defaultFile));
            } catch (IOException ex) {
                Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        
    }
}
