package Persistance.sql;

import Persistance.dao.PlaylistSongDAO;
import Business.Entities.PlaylistSong;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Sql playlist song dao.
 */
public class SQLPlaylistSongDAO implements PlaylistSongDAO {
    private final SQLConnector sqlConnector;

    /**
     * Constructor del SQLPlaylistSongDAO
     *
     * @param sqlConnector le tenemos que pasar un sqlConnector para poder operar con la base de datos
     */
    public SQLPlaylistSongDAO(SQLConnector sqlConnector) {
        this.sqlConnector = sqlConnector;
    }

    /**
     * Metodo que añade una PlaylistSong a la base de datos
     * @param playlistsong
     */
    public void addPlaylistSong(PlaylistSong playlistsong) {
        String query = "INSERT INTO PlaylistSong(ID_Playlist, ID_Song) VALUES ('" +
                playlistsong.getID_playlist() + "', '" +
                playlistsong.getID_song() + "');";

        sqlConnector.insertQuery(query);
    }

    /**
     * Método para coger canciones de una playlist de la base de datos
     * @param ID_Playlist
     * @return devuelve una lista de int, las ID_Song
     * @throws SQLException
     */
    //METODE PER A AGAFAR LES CANÇONS DUNA PLAYLIST
    public ArrayList<Integer> getSongsByIDPlaylist(int ID_Playlist) throws SQLException {
        ArrayList<Integer> songs = new ArrayList<>();
        //ordenats per id_song ASC
        String query = "SELECT DISTINCT ID_Playlist, ID_Song FROM PlaylistSong WHERE playlistsong.ID_Playlist = '" +
                ID_Playlist + "' ORDER BY playlistsong.id_song ASC;";
        ResultSet result = sqlConnector.selectQuery(query);
        while(result.next()) {
            songs.add(result.getInt("ID_Song"));
        }
        return songs;
    }

    /**
     * Método para coger las playlist donde está una cancion de la base de datos
     * @param ID_Song
     * @return
     * @throws SQLException
     */
    public PlaylistSong getPlaylistByIDSong(int ID_Song) throws SQLException {
        String query = "SELECT DISTINCT ID_Playlist, ID_Song FROM PlaylistSong WHERE playlistsong.ID_Song = '" +
                ID_Song + "' ;";
        ResultSet result = sqlConnector.selectQuery(query);
        result.next();
        int ID_Playlist = result.getInt("ID_Playlist");

        return new PlaylistSong(ID_Playlist, ID_Song);
    }

    /**
     * Metodo que elimina una cancion de la base de datos según su id
     * @param ID_Song le pasamos que cancion queremos borrar
     */
    public void deleteSong(int ID_Song) {
        String query = "DELETE FROM PlaylistSong WHERE ID_Song LIKE '" + ID_Song + "';";
        sqlConnector.deleteQuery(query);
    }

    /**
     * Metodo que elimina una playlist de la base de datos según su id
     * @param ID_Playlist le pasamos que playlist queremos borrar
     */
    public void deletePlaylist(int ID_Playlist) {
        String query = "DELETE FROM PlaylistSong WHERE ID_Playlist LIKE '" + ID_Playlist + "';";
        sqlConnector.deleteQuery(query);
    }

    /**
     * Metodo que hace el update de una playlist de la base de datos
     * @param ID_Song canción que queremos mover
     * @param ID_Playlist le pasamos que playlist queremos actualizar
     */
    public void updatePlaylist(int ID_Song, int ID_Playlist) {
        String query = "UPDATE PlaylistSong SET ID_playlist = " + ID_Playlist + " WHERE ID_song = " + ID_Song + ";";
        sqlConnector.deleteQuery(query);
    }
}
