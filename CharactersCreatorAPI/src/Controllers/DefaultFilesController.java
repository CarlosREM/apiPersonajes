package Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
public class DefaultFilesController {
    private static final String dataPath = System.getenv("APPDATA")+"/CharactersCreatorAPIData";
    
    /**
     * Creates a directory in AppData/Roaming for storage the API data
     */
    public static void createDataDirectory(){
        File file = new File(dataPath);
        if(!file.isDirectory()){
            file.mkdir();
            System.out.println(file.isDirectory());
        }
    }
    
    /**
     * Takes a image and storage it in API data directory and returns the path of new location
     * @param originalPath The path of the image that you want to save
     * @return A String of the new location of the image
     * @throws IOException If occurs some exception in the I/O operations.
     */
    public static String saveImage(Path originalPath) throws IOException{
        createDataDirectory();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Date date = new Date(System.currentTimeMillis());        
        File newImg = new File(dataPath+"/"+formatter.format(date)+ "_" + System.currentTimeMillis() +".png");
        
        Files.copy(originalPath, newImg.toPath());   
        return newImg.toPath().toString();
    }
}
