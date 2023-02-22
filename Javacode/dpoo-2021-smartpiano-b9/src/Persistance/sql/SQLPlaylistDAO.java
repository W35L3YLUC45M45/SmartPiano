package Persistance.sql;

import Persistance.dao.PlaylistDAO;
import Business.Entities.Playlist;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Sql playlist dao.
 */
public class SQLPlaylistDAO implements PlaylistDAO {
    private final SQLConnector sqlConnector;

    /**
     * Constructor del SQLPlaylistDAO, le pasamos el conector para hacer la conexion a la base de datos
     *
     * @param sqlConnector le tenemos que pasar un sqlConnector para poder operar con la base de datos
     */
    public SQLPlaylistDAO(SQLConnector sqlConnector) {
        this.sqlConnector = sqlConnector;
    }

    /**
     * Metodo que añade una playlist a la base de datos
     * @param playlist le pasamos un Playlist para que la podamos añadir
     */
    public void addPlaylist(Playlist playlist) {
        String query = "INSERT INTO Playlist(name, creation, last_update, " +
                "copyright) VALUES ('" +
                playlist.getName() + "', " +
                playlist.getCreation() + ", " +
                playlist.getLast_update() + ", '" +
                playlist.getCopyright() + "');";

        sqlConnector.insertQuery(query);
    }

    /**
     * Metodo que elimina una Playlist de la base de datos, tenemos que borrar antes sus tablas derivadas
     * @param ID_Playlist le pasamos que Playlist queremos borrar
     */
    public void deletePlaylist(int ID_Playlist) {
        String query = "DELETE FROM Playlist WHERE id =" + ID_Playlist + ";";
        sqlConnector.deleteQuery(query);
    }

    /**
     * Metodo que coge una Playlist segun su ID_Playlist de la base de datos
     * @param ID_Playlist
     * @return nos retorna una Playlist
     */
    public Playlist getPlaylist(int ID_Playlist) throws SQLException {
        String query = "SELECT * FROM Playlist WHERE playlist.id = " +
                ID_Playlist + " ;";
        ResultSet result = sqlConnector.selectQuery(query);
        result.next();
        int id = result.getInt("id");
        String name = result.getString("Name");
        Date creation = result.getDate("creation");
        Date last_update = result.getDate("last_update");
        String copyright = result.getString("copyright");

        return new Playlist(id, name, creation, last_update, copyright);
    }

    /**
     * Metodo que coge una Playlist segun su name_playlist de la base de datos
     * @param name_playlist
     * @return nos retorna una Playlist
     */
    public Playlist getPlaylistByName(String name_playlist) throws SQLException {
        String query = "SELECT * FROM Playlist WHERE playlist.name = '" +
                name_playlist + "' ;";
        ResultSet result = sqlConnector.selectQuery(query);
        result.next();
        int id = result.getInt("id");
        String name = result.getString("Name");
        Date creation = result.getDate("creation");
        Date last_update = result.getDate("last_update");
        String copyright = result.getString("copyright");

        return new Playlist(id, name, creation, last_update, copyright);
    }

    /**
     * Metodo que coge las Playlist publicas de la base de datos
     * @return nos retorna un ArrayList de Playlist
     */
    public ArrayList<Playlist> getPublicPlaylists() throws SQLException {
        ArrayList<Playlist> playlists = new ArrayList<>();
        //ordenats per id_song ASC
        String query = "SELECT * FROM Playlist WHERE playlist.copyright LIKE 'Public';" ;
        ResultSet result = sqlConnector.selectQuery(query);
        while(result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            Date creation = result.getDate("creation");
            Date last_update = result.getDate("last_update");
            String copyirght = result.getString("copyright");

            playlists.add(new Playlist(id, name, creation, last_update, copyirght));
        }
        return playlists;
    }
}
