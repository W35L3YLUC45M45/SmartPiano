package Business;

/**
 * The type Login exception.
 * Meant to catch any errors while Login to game.
 */
public class LoginException extends UserException {

    /**
     * The constant PASSWORD_ERROR will be shown by default when password is wrong.
     */
    public static final String PASSWORD_ERROR = "The given password is incorrect.\n";
    /**
     * The constant EMAIL_ERROR will be shown by default when email is wrong.
     */
    public static final String EMAIL_ERROR = "There is no user with this username.\n";

    private final boolean passwordOk;
    private final boolean emailOk;

    /**
     * Constructor with a message, to be used for general Login Exceptions.
     *
     * @param passwordValidation Boolean value from login Password Validation done in UserModel.
     * @param emailValidation    Boolean value from login Email Validation done in UserModel.
     */
    public LoginException(boolean passwordValidation, boolean emailValidation) {
        super("Login Error. \n");
        this.passwordOk = passwordValidation;
        this.emailOk = emailValidation;
    }

    // Override method that determines the message shown to the user
        @Override
        public String getMessage() {
            String message = super.getMessage();
            if(!passwordOk){
                message = message.concat(PASSWORD_ERROR);
            }
            if(!emailOk){
                message = message.concat(EMAIL_ERROR);
            }
            return message;
        }

}
