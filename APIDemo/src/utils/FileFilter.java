package utils;

/**
 *
 * @author Carlos Esquivel
 */
import java.io.File;

public class FileFilter extends javax.swing.filechooser.FileFilter {

    String description = "";
    String fileExt = "";

    public FileFilter(String extension) {
        fileExt = extension;
    }

    public FileFilter(String extension, String typeDescription) {
        fileExt = extension;
        this.description = typeDescription;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        return (f.getName().toLowerCase().endsWith(fileExt));
    }

    @Override
    public String getDescription() {
        return description;
    }
}