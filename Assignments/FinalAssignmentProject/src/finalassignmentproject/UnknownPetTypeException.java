
package finalassignmentproject;

/**
 * Throws an exception if the type of pet is unknown.
 * 
 * @author Alex Vasil
 */
public class UnknownPetTypeException extends Exception {
    
    /**
     * Exception for unknown pet type.
     */
    public UnknownPetTypeException() {
        super("Encountered an unknown pet type");
    }
    
    /**
     * Exception for unknown pet type with a user message.
     * 
     * @param user_message the user inputed message.
     */
    public UnknownPetTypeException(String user_message) {
        super(user_message);
    }
}
