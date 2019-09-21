package abstraction;

/**
 * Interface used to implements the builder methods.
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 * @param <T> The object type will be created.
 */
public interface IBuild<T> {
    /**
     * Method to make the build of the object
     * @return An object of the specific implementation of the interface
     */
    public T build();
}
