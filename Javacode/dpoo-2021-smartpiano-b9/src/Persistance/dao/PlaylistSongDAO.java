package Persistance.dao;

import Business.Entities.PlaylistSong;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The interface PlaylistSong dao.
 */
public interface PlaylistSongDAO {

    /**
     * Add playlist song to the database.
     *
     * @param playlistsong the playlistsong
     */
    void addPlaylistSong(PlaylistSong playlistsong);

    /**
     * Gets songs by id playlist.
     *
     * @param ID_Playlist the id playlist
     * @return the songs by id playlist
     * @throws SQLException the sql exception
     */
    ArrayList<Integer> getSongsByIDPlaylist(int ID_Playlist) throws SQLException;

    /**
     * Gets playlist by id song.
     *
     * @param ID_Song the id song
     * @return the playlist by id song
     * @throws SQLException the sql exception
     */
    PlaylistSong getPlaylistByIDSong(int ID_Song) throws SQLException;

    /**
     * Metodo que elimina una cancion de la base de datos
     * @param ID_Song le pasamos que cancion queremos borrar
     */
    void deleteSong(int ID_Song);

    /**
     * Metodo que elimina una playlist de la base de datos
     * @param ID_Playlist le pasamos que playlist queremos borrar
     */
    void deletePlaylist(int ID_Playlist);

    /**
     * Metodo que hace el update de una playlist de la base de datos
     * @param ID_Song canción que queremos mover
     * @param ID_Playlist le pasamos que playlist queremos actualizar
     */
    void updatePlaylist(int ID_Song, int ID_Playlist);
}
