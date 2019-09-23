package abstraction;

/**
 * Interface used to implements the prototyping of different objects
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 * @param <T> The type of object you want to prototype.
 */
public interface IPrototype<T extends IPrototype> extends Cloneable {
   
    /**
     * Method to realize a deep clone of the desired object.
     * @return The new cloned object.
     */
    public T deepClone();
}
