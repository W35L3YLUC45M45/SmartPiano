package Business;

/**
 * The type User exception will be the main exception containing the general message to be complemented
 * when being extended by the RegisterException or the LoginException.
 */
public class UserException extends Exception{

    /**
     * Instantiates a new User exception to be used by the derivative classes to be extended from UserException.
     *
     * @param message the message to be personalized by inherited classes.
     */
// Constructor with a message, to be used for general exceptions
        public UserException(String message) {
            super(message);
        }

}