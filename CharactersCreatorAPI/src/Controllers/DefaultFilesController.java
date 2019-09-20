/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco Gamboa
 */
public class DefaultFilesController {
    private static final String dataPath = System.getenv("APPDATA")+"/CharactersCreatorAPIData";
    public static void createDataDirectory(){
        File file = new File(dataPath);
        if(!file.isDirectory()){
            file.mkdir();
            System.out.println(file.isDirectory());
        }
    }
    public static String saveImage(Path originalPath) throws IOException{
        createDataDirectory();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Date date = new Date(System.currentTimeMillis());        
        File newImg = new File(dataPath+"/"+formatter.format(date)+ "_" + System.currentTimeMillis() +".png");
        
        Files.copy(originalPath, newImg.toPath());   
        return newImg.toPath().toString();
    }
}
