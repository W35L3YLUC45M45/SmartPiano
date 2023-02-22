package Persistance.dao;

import Business.Entities.Playlist;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The interface Playlist dao.
 */
public interface PlaylistDAO {
    /**
     * Add playlist.
     *
     * @param playlist the playlist
     */
    void addPlaylist(Playlist playlist);

    /**
     * Delete playlist.
     *
     * @param ID_Playlist the id playlist
     */
    void deletePlaylist(int ID_Playlist);

    /**
     * Gets playlist.
     *
     * @param ID_Playlist the id of the playlist
     * @return the playlist
     * @throws SQLException the sql exception
     */
    Playlist getPlaylist(int ID_Playlist) throws SQLException;

    /**
     * Gets playlist.
     *
     * @param name_playlist the name of the playlist
     * @return the playlist
     * @throws SQLException the sql exception
     */
    Playlist getPlaylistByName(String name_playlist) throws SQLException;

    /**
     * Gets public playlists.
     *
     * @return the public playlists
     * @throws SQLException the sql exception
     */
    ArrayList<Playlist> getPublicPlaylists() throws SQLException;
}
