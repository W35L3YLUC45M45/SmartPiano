package Persistance.sql;

import Persistance.dao.UserDAO;
import Business.Entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Sql user dao.
 */
public class SQLUserDAO implements UserDAO {
    private final SQLConnector sqlConnector;

    /**
     * Constructor del SQLUserDAO, le pasamos el conector para hacer la conexion a la base de datos
     *
     * @param sqlConnector le pasamos un SQLConnector para poder operar con la base de datos
     */
    public SQLUserDAO(SQLConnector sqlConnector) {
        this.sqlConnector = sqlConnector;
    }

    /**
     * Metodo que añade un User a la base de datos
     * @param user le pasamos un User para que lo podamos añadir
     */
    public void addUser(User user) {
        String query = "INSERT INTO User(username, email, password) VALUES ('" +
                user.getUsername() + "', '" +
                user.getEmail() + "', '" +
                user.getPassword() +
                "');";

        sqlConnector.insertQuery(query);
    }

    /**
     * Metodo que elimina un User de la base de datos, tenemos que borrar antes sus tablas derivadas
     * @param username le pasamos que User queremos borrar
     */
    public void deleteUserbyusername(String username) {
        String query = "DELETE FROM userplaylist WHERE username LIKE '" + username + "';";
        sqlConnector.deleteQuery(query);

        query = "DELETE FROM User WHERE username LIKE '" + username + "';";
        sqlConnector.deleteQuery(query);
    }

    /**
     * Metodo que coge un User segun su username de la base de datos
     * @param username le pasamos una String, el username del User
     * @return nos retorna un User
     */
    public User getUserbyUsername(String username) {
        String query = "SELECT username, email, password FROM user WHERE username LIKE '" + username + "';";
        ResultSet result = sqlConnector.selectQuery(query);

        try {
            result.next();
            //System.out.println(result.getString(1));
            String usernameUser = result.getString("username");
            String emailUser = result.getString("email");
            String passwordUser = result.getString("password");
            return new User(usernameUser, emailUser, passwordUser);

        } catch (SQLException e){
        }
        return null;
    }

    /**
     * Metodo que coge un User segun su email de la base de datos
     * @param email le pasamos una String, el email del User
     * @return nos retorna un User
     */
    public User getUserbyEmail(String email) {
        String query = "SELECT username, email, password FROM user WHERE email LIKE '" + email + "';";
        ResultSet result = sqlConnector.selectQuery(query);

        try {
            result.next();
            //System.out.println(result.getString(1));
            String usernameUser = result.getString("username");
            String emailUser = result.getString("email");
            String passwordUser = result.getString("password");
            return new User(usernameUser, emailUser, passwordUser);

        } catch (SQLException e){
        }
        return null;
    }

    /**
     * Metodo que nos retorna todos los Users
     * @return nos retorna la Lista de todos los Users
     */
    public List<User> getUsers() {
        List<User> users = new LinkedList<>();
        String query = "SELECT * FROM user;";
        ResultSet result = sqlConnector.selectQuery(query);

        try {
            while (result.next()) {
                String usernameUser = result.getString("username");
                String emailUser = result.getString("email");
                String passwordUser = result.getString("password");

                users.add(new User(usernameUser, emailUser, passwordUser));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
