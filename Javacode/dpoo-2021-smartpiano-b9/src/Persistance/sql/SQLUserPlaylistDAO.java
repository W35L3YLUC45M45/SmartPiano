package Persistance.sql;

import Persistance.dao.UserPlaylistDAO;
import Business.Entities.UserPlaylist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Sql user playlist dao.
 */
public class SQLUserPlaylistDAO implements UserPlaylistDAO {
    private final SQLConnector sqlConnector;

    /**
     * Constructor del SQLUserPlaylistDAO, le pasamos el conector para hacer la conexion a la base de datos
     *
     * @param sqlConnector le tenemos que pasar un sqlConnector para poder operar con la base de datos
     */
    public SQLUserPlaylistDAO(SQLConnector sqlConnector) {
        this.sqlConnector = sqlConnector;
    }

    /**
     * Metodo que añade un UserPlaylist a la base de datos
     * @param userPlaylist le pasamos un UserPlaylist para que lo podamos añadir
     */
    public void addPlaylist(UserPlaylist userPlaylist) {
        String query = "INSERT INTO UserPlaylist(username, ID_Playlist) VALUES ('" +
                userPlaylist.getUsername() + "', '" +
                userPlaylist.getID_playlist() + "');";

        sqlConnector.insertQuery(query);
    }

    /**
     * Metodo que elimina un UserPlaylist de la base de datos segun su ID_Playlist
     * @param ID_Playlist le pasamos que UserPlaylist queremos borrar
     */
    public void deleteUserPlaylistByPlaylist(int ID_Playlist) {
        String query = "DELETE FROM UserPlaylist WHERE ID_Playlist =" + ID_Playlist + ";";
        sqlConnector.deleteQuery(query);
    }

    /**
     * Metodo que elimina un UserPlaylist de la base de datos segun su username
     * @param username le pasamos que UserPlaylist queremos borrar
     */
    public void deleteUserPlaylistByUsername(String username) {
        String query = "DELETE FROM UserPlaylist WHERE username =" + username + ";";
        sqlConnector.deleteQuery(query);
    }

    /**
     * Metodo que coge un UserPlaylist segun su ID_Playlist de la base de datos
     * @param ID_Playlist le pasamos un int, la ID_Playlist del UserPlaylist
     * @return nos retorna un UserPlaylist
     */
    public UserPlaylist getUserPlaylistbyIdPlaylist(int ID_Playlist) throws SQLException {
        String query = "SELECT username FROM UserPlaylist WHERE playlist.ID_Playlist =" +
                ID_Playlist + " ;";
        ResultSet result = sqlConnector.selectQuery(query);

        String username = result.getString("username");

        return new UserPlaylist(username, ID_Playlist);
    }

    /**
     * Metodo que coge un UserPlaylist segun su username de la base de datos
     * @param username le pasamos una String, el username del UserPlaylist
     * @return nos retorna un UserPlaylist
     */
    public UserPlaylist getUserPlaylistbyUsername(String username) throws SQLException {
        String query = "SELECT ID_Playlist FROM UserPlaylist WHERE playlist.username =" +
                username + " ;";
        ResultSet result = sqlConnector.selectQuery(query);

        int ID_Playlist = result.getInt("ID_Playlist");

        return new UserPlaylist(username, ID_Playlist);
    }

    /**
     * Metodo que retorna las playlists privadas de nuestro usuario segun su username de la base de datos
     * @param username le pasamos una String, el username del User
     * @return nos retorna un ArrayList<Integer> de las Playlist
     */
    public ArrayList<Integer> getUserPrivatePlaylist(String username) throws SQLException {
        ArrayList<Integer> playlists = new ArrayList<>();
        //ordenats per id_song ASC
        String query = "SELECT distinct ID_Playlist FROM UserPlaylist, Playlist WHERE UserPlaylist.username LIKE '" + username + "' AND " +
                "Playlist.id =  UserPlaylist.ID_Playlist AND Playlist.copyright LIKE 'Private';" ;
        ResultSet result = sqlConnector.selectQuery(query);
        while(result.next()) {
            int ID_Playlist = result.getInt("ID_Playlist");
            playlists.add(ID_Playlist);
        }
        return playlists;
    }
}
