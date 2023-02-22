package Business;

import Business.ConfigDatabase.DatabaseManager;
import Business.Entities.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The Type User Model will create the bridge between our Users and the Database, managing things like the
 * logic behind the Register and Login Validations, by means of the following Regex expressions:
 * <P>
 * (?=.*\d) Has a Digit.
 * (?=.*[a-z]) Has LowerCase.
 * (?=.*[A-Z]) Has Upper Case.
 * (?=.*[@#$%]) Has these symbols: @, #, $, %.
 * {8,20}$ Larger or equal than 8, smaller or equal than 20.
 * Full regex expression = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
 * </P>
 */
public class UserModel {

    private static final String DIGITS_VALIDATION = "(?=.*\\d).{1,20}";
    private static final String UPPER_CASE_VALIDATION = "(?=.*[A-Z]).{1,20}";
    private static final String LOWER_CASE_VALIDATION = "(?=.*[a-z]).{1,20}";
    private static final String SYMBOL_VALIDATION = "(?=.*[@#$%!?&€¡¿]).{1,20}";
    private static final String LENGTH_VALIDATION = ".{8,20}";
    private static final String EMAIL_VALIDATION = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";


    private DatabaseManager dm;
    private User user;

    /**
     * Instantiates a new User model.
     *
     * @param dm the DatabaseManager
     */
    public UserModel(DatabaseManager dm){
        this.dm = dm;
        user = null;
    }


    /**
     * Function meant to manage the Login of any User. It will ask for Email and password and validate both.
     *
     * @param logininput the logininput
     * @return the boolean [ ]
     */
    public boolean[] doLogin(String[] logininput) {
        boolean[] allGood = new boolean[2];
        //Using the userId, call the database to get Password + Email to be compared with

        validateLogin(logininput[1],logininput[0], allGood);
        return allGood;
    }

    /**
     * Method meant to validate the Login introduced by the User.
     *
     * @param inputPassword Password introduced by User during Login.
     * @param inputUser Email introduced by User during Login.
     * @param allGood Boolean containing the array of validations to be compared.
     */
    private void validateLogin(String inputPassword, String inputUser, boolean[] allGood) {
        user = dm.getUserDao().getUserbyUsername(inputUser);
        if (user == null){
            user = dm.getUserDao().getUserbyEmail(inputUser);
        }
        if (user == null){
            allGood[0] = false;
            allGood[1] = true;
        } else {
            allGood[0] = true;
            allGood[1] = matchCheck(inputPassword, user.getPassword());
            if (!allGood[1]){
                user = null;
            }
        }
    }

    /**
     * Match check will do a comparison between the input from the User and that from the Database.
     *
     * @param input String to be compared
     * @param database Value from Database to be compared to.
     * @return Boolean expression; true if they match, false if not.
     */
    private boolean matchCheck(String input, String database){
        return (input.compareTo(database) == 0);
    }

    /**
     * Function meant to manage the Register of a new User. It will ask for Email and password and validate both.
     *
     * @param registerinput the registerinput
     * @return the boolean [ ]
     */
    public boolean[] doRegister(String[] registerinput) {
        boolean[] allGood = new boolean[9];
        /*
        * Error 0 = user already exists
        * Error 1 = email not with the correct construction
        * Error 2 = email already exists
        * Error 3 = password does not contain any digit
        * Error 4 = password does not contain any upper case
        * Error 5 = password does not contain any lower case
        * Error 6 = password does not contain any symbol
        * Error 7 = password does not have the length required
        * Error 8 = password and repeatpassword do not match
        */
        allGood[0] = isValidUser(registerinput[0]);
        isValidEmail(registerinput[1], allGood);
        isValidPassword(registerinput[2], allGood);
        allGood[8] = matchCheck(registerinput[2], registerinput[3]);

        return allGood;
    }

    /**
     * Prints errors in red and does a flush.
     * @param errorMessage Is the message we intend to print as an error through System.err.println()
     */
    private static void printErrors(String errorMessage) {
        System.err.println(errorMessage);
        System.err.flush();
    }

    /**
     *
     * @param password The password introduced by user during Register
     * @param regex Regex expression to be analyzed against password.
     * @return Boolean expression; true if the password fulfills the regex expression, false if not.
     */
    private static boolean regexCheck(String password,String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /**
     * Function meant to execute all regexChecks to validate a Password from an User wishing to Register.
     *
     * @param password The password introduced by user during Register
     * @param allGood  the allGood boolean checking no errors found.
     */
    public void isValidPassword(String password, boolean[] allGood){

        boolean DigitOk = regexCheck(password, DIGITS_VALIDATION);
        boolean CapsOk = regexCheck(password, UPPER_CASE_VALIDATION);
        boolean LowerOk = regexCheck(password, LOWER_CASE_VALIDATION);
        boolean SymbolOk = regexCheck(password, SYMBOL_VALIDATION);
        boolean LengthOk = regexCheck(password, LENGTH_VALIDATION);

        allGood[3] = DigitOk;
        allGood[4] = CapsOk;
        allGood[5] = LowerOk;
        allGood[6] = SymbolOk;
        allGood[7] = LengthOk;

//        System.out.println("Digit: " + DigitOk);
//        System.out.println("Caps: " + CapsOk);
//        System.out.println("Lower: " + LowerOk);
//        System.out.println("Symbol: " + SymbolOk);
//        System.out.println("Length: " + LengthOk);

    }

    /**
     * Is valid email.
     *
     * @param email   Email being inputted by the User.
     * @param allGood the allGood boolean checking no errors found.
     */
    public void isValidEmail(String email, boolean[] allGood){
        boolean EmailOk = regexCheck(email, EMAIL_VALIDATION);
        boolean EmailRepeated;
        EmailRepeated = dm.getUserDao().getUserbyEmail(email) == null;
        allGood[1] = EmailOk;
        allGood[2] = EmailRepeated;
    }

    /**
     * Is valid user boolean will check for a match between user given and Database.
     *
     * @param user the user requested
     * @return the boolean indicating there have been no errors during validation.
     */
    public boolean isValidUser(String user){
        boolean userOK;
        userOK = dm.getUserDao().getUserbyUsername(user) == null;
        System.out.println(userOK + " -> " + dm.getUserDao().getUserbyUsername(user));
        return  userOK;
    }

    /**
     * Gets user class from teh Model.
     *
     * @return the user from the UserModel
     */
    public User getUser(){
        return user;
    }

    /**
     * Deletes account from databases given a User name.
     *
     * @param username the username of the User we wish to delete.
     */
    public void deleteAccount(String username){
        dm.getUserDao().deleteUserbyusername(username);
        logoutAccount();
    }

    /**
     * Logouts the user from account, setting it to null.
     */
    public void logoutAccount(){
        user = null;
    }

    /**
     * Adds a user to the Databases.
     *
     * @param registerInput the array from the three values needed to Add a User; username, email and password.
     */
    public void addUser(String[] registerInput){
        dm.getUserDao().addUser(new User(registerInput[0], registerInput[1], registerInput[2]));
    }
}
