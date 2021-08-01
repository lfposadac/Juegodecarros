
/**
 * Metodo cn excepcion para ayudarme con la persistencia
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (01/08/2021)
 */
public class NonexistentEntityException extends Exception 
{
    public NonexistentEntityException (String message, Throwable cause) {
        super(message, cause);
    }
    
    public NonexistentEntityException(String message) {
        super(message);
    }
}
