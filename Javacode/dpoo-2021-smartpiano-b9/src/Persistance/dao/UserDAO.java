package Persistance.dao;

import Business.Entities.User;

import java.util.List;

/**
 * The interface User dao.
 */
public interface UserDAO {

    /**
     * Add user.
     *
     * @param user the user
     */
    void addUser(User user);

    /**
     * Delete userbyusername.
     *
     * @param username the username
     */
    void deleteUserbyusername(String username);

    /**
     * Gets userby username.
     *
     * @param username the username
     * @return the userby username
     */
    User getUserbyUsername(String username);

    /**
     * Gets userby email.
     *
     * @param email the email
     * @return the userby email
     */
    User getUserbyEmail(String email);

    /**
     * Gets users.
     *
     * @return the users
     */
    List<User> getUsers();
}
