
package pet;

/**
 * Throws an exception if the type of pet is unknown.
 * 
 * @author Alex Vasil
 */
public class UnknownPetTypeException extends Exception{
    
    public UnknownPetTypeException() {
        super("Encountered an unknown pet type");
    }
    
    public UnknownPetTypeException(String user_message) {
        super(user_message);
    }
}
