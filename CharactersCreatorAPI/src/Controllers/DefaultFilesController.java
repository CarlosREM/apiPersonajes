package Controllers;

import abstraction.AAppearance;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class used to manage files operations.
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
    public String saveImage(Path originalPath) throws IOException{
        createDataDirectory();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Date date = new Date(System.currentTimeMillis());        
        File newImg = new File(dataPath+"/"+formatter.format(date)+ "_" + System.currentTimeMillis() +".png");

        copy(originalPath,newImg);
        return newImg.toPath().toString();
    }
    
     /**
     * Copies the contents of a path to a file
     * @param originalPath The path of the image that you want to save
     * @param newImg The file that will be pasted
     * @throws IOException If occurs some exception in the I/O operations.
     */   
    private void copy(Path originalPath,File newImg) throws IOException{
        String var = originalPath.toString();
        ClassLoader classLoader = getClass().getClassLoader();
        char charAt = var.charAt(0);
        if (charAt=='\\'){
                Files.copy(classLoader.getResourceAsStream(var), newImg.toPath());      
        }
        else{
                Files.copy(originalPath, newImg.toPath());
        }
    }
    /**
     * Static method to delete an image from a absolute path.
     * @param fileName The name of the file to be deleted.
     * @throws IOException If the file doesn't exists.
     */
    private static void deleteImage(String fileName) throws IOException{
         if(checkFileInDirectory(fileName)){
            new File(dataPath,fileName).delete();
         }
    }
    
    /**
     * Static method to check if a file exists in a directory.
     * @param fileName The name of the fie.
     * @return True if file exists inside directory, false otherwise.
     */
    private static boolean checkFileInDirectory(String fileName){
        return new File(dataPath,fileName).exists();
    }
    
    /**
     * Static method to clear the appearances in absolute path directory.
     * @param appearances The TreeMap appearances to be cleared.
     * @throws IOException If file doesn't exist.
     */
    public static void clearAppearances(TreeMap<Integer,AAppearance> appearances) throws IOException{
        for(AAppearance appearance:appearances.values()){
            for(String look:appearance.getLooks()){
                File temp = new File(look);
                deleteImage(temp.getName());
            }
        }
    }
    
    public static String createCharacterJson(String directory) throws IOException{
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Date date = new Date(System.currentTimeMillis());        
        File newJson = new File(directory + "/" + formatter.format(date)+ "_" + System.currentTimeMillis() +".json");
        
        List<String> lines = Arrays.asList("{\"@class\" : \"Json.JSONCharacterHolder\", \"characters\" : []}");
        Path file = Paths.get(newJson.getPath());
        Files.write(file, lines, StandardCharsets.UTF_8);
        return newJson.getPath();
    }
    
    public static String createWeaponJson(String directory) throws IOException{
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Date date = new Date(System.currentTimeMillis());        
        File newJson = new File(directory + "/" + formatter.format(date)+ "_" + System.currentTimeMillis() +".json");
        
        List<String> lines = Arrays.asList("{\"@class\" : \"Json.JSONWeaponHolder\", \"weapons\" : []}");
        Path file = Paths.get(newJson.getPath());
        Files.write(file, lines, StandardCharsets.UTF_8);
        return newJson.getPath();
    }
}
