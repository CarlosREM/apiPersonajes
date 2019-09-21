package abstraction;

import java.util.TreeMap;

/**
 * Interface used to provide a better abstraction in appearances management.
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
public interface ILookable {
    
    /**
     * Gets the appearance of a specific level.
     * @param level The level of which you want to get the appearance.
     * @return An AAppearance of the specified weapon level
     * @see AAppearance
     */
    public AAppearance getAppearance(int level);
    
    /**
     * Gets the appearances.
     * @return A TreeMap containing the appearances with its level.
     */
    public TreeMap<Integer,AAppearance> getAppearances();
    
    /**
     * Sets the specific appearance in the specified level.
     * @param level The level to link the appearance.
     * @param appearance The new appearance.
     */
    public void setAppearance(int level, AAppearance appearance);
}
