package Business.Entities;

/**
 * This User class represents an user from Smart Piano's Game
 * <p>
 * This class is uniquely identified by the user's name.
 */
public class User {
    // Attributes.
    private String username;
    private String email;
    private String password;

    /**
     * Instantiates a new User from our Game.
     *
     * @param username String with the username.
     * @param email    String with the email from the user.
     * @param password String with the password from the given User.
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Gets username from User.
     *
     * @return String with the user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets email from User.
     *
     * @return String with the user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets password from User.
     *
     * @return String with the user's password.
     */
    public String getPassword() {
        return password;
    }


}
