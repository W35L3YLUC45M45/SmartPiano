package Business;

/**
 * The type Register exception.
 * Meant to catch any errors during a new User's Register to the game.
 */
public class RegisterException extends UserException {

    /**
     * The message DIGIT_ERROR explaining that digits must be from 0 to 9.
     */
    public static final String DIGIT_ERROR = "The password must contain a digit (0-9).\n";
    /**
     * The message CAPS_ERROR explaining that the password must have an upper case letter.
     */
    public static final String CAPS_ERROR = "The password must contain a upperCase letter.\n";
    /**
     * The message LOWER_ERROR explaining that the password must have an lower case letter.
     */
    public static final String LOWER_ERROR = "The password must contain a lowerCase letter.\n";
    /**
     * The message SYMBOL_ERROR explaining that the password must have a symbol such as: @, #, $ or %.
     */
    public static final String SYMBOL_ERROR = "The password must contain a symbol (@#$%).\n";
    /**
     * The message LENGTH_ERROR thrown when the password is shorter that 8 letters/symbols.
     */
    public static final String LENGTH_ERROR = "The password's length is lower than 8.\n";
    /**
     * The message EMAIL_ERROR explaining that the email's format is incorrect.
     */
    public static final String EMAIL_ERROR = "The email is not in the correct format (text@text.text).\n";
    /**
     * The message REPEAT_ERROR thrown when the password validation gives a mismatch.
     */
    public static final String REPEAT_ERROR = "The password and it's repetition do not match.\n";
    /**
     * The message USER_EXIST_ERROR shown when the given user is already registered in the Databases.
     */
    public static final String USER_EXIST_ERROR = "This user already exists.\n";
    /**
     * The error EMAIL_EXIST_ERROR shown when the given email is already registered in the Databases.
     */
    public static final String EMAIL_EXIST_ERROR = "This email already exists.\n";

    private final boolean DigitOk;
    private final boolean CapsOk;
    private final boolean LowerOk;
    private final boolean SymbolOk;
    private final boolean LengthOk;
    private final boolean EmailOk;

    /**
     * Constructor with a message, to be used for general Password Exceptions
     *
     * @param DigitOk  Boolean value from password Validation done in UserModel, indicates all digits are correct.
     * @param CapsOk   Boolean value from password Validation done in UserModel, indicates there is at least one upperCase letter.
     * @param LowerOk  Boolean value from password Validation done in UserModel, indicates there is at least one lowerCase letter.
     * @param SymbolOk Boolean value from password Validation done in UserModel, indicates there is at least one symbol.
     * @param LengthOk Boolean value from password Validation done in UserModel, indicates that the password length is over 8 letters/symbols.
     */
    public RegisterException(boolean DigitOk, boolean CapsOk, boolean LowerOk, boolean SymbolOk, boolean LengthOk) {

        super("This password is not valid. \n");

        this.DigitOk = DigitOk;
        this.CapsOk = CapsOk;
        this.LowerOk = LowerOk;
        this.SymbolOk = SymbolOk;
        this.LengthOk = LengthOk;

        this.EmailOk = false;
    }

    /**
     * Constructor with a message, to be used for general Email Exceptions.
     *
     * @param EmailOk Boolean value from email Validation done in UserModel.
     */
    public RegisterException(boolean EmailOk) {

        super("Format error. \n");

        this.EmailOk = EmailOk;

        DigitOk = true;
        LengthOk = true;
        SymbolOk = true;
        LowerOk = true;
        CapsOk = true;

    }

    // Override method that determines the message shown to the user
    @Override
    public String getMessage() {
        String message = super.getMessage();

        if(!DigitOk){
            message = message.concat(DIGIT_ERROR);
        }
        if(!CapsOk){
            message = message.concat(CAPS_ERROR);
        }
        if(!LowerOk){
            message = message.concat(LOWER_ERROR);
        }
        if(!SymbolOk){
            message = message.concat(SYMBOL_ERROR);
        }
        if(!LengthOk){
            message = message.concat(LENGTH_ERROR);
        }

        if(!EmailOk){
            message = message.concat(EMAIL_ERROR);
        }

        return message;
    }

}
