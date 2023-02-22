package Persistance.dao;

import Business.Entities.UserPlaylist;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The interface User playlist dao.
 */
public interface UserPlaylistDAO {
    /**
     * Add playlist.
     *
     * @param userPlaylist the user playlist
     */
    void addPlaylist(UserPlaylist userPlaylist);

    /**
     * Delete user playlist by playlist.
     *
     * @param ID_Playlist the id playlist
     */
    void deleteUserPlaylistByPlaylist(int ID_Playlist);

    /**
     * Delete user playlist by username.
     *
     * @param username the username
     */
    void deleteUserPlaylistByUsername(String username);

    /**
     * Gets user playlistby id playlist.
     *
     * @param ID_Playlist the id playlist
     * @return the user playlistby id playlist
     * @throws SQLException the sql exception
     */
    UserPlaylist getUserPlaylistbyIdPlaylist(int ID_Playlist) throws SQLException;

    /**
     * Gets user playlistby username.
     *
     * @param username the username
     * @return the user playlistby username
     * @throws SQLException the sql exception
     */
    UserPlaylist getUserPlaylistbyUsername(String username) throws SQLException;

    /**
     * Gets user private playlist.
     *
     * @param username the username
     * @return the user private playlist
     * @throws SQLException the sql exception
     */
    ArrayList<Integer> getUserPrivatePlaylist(String username) throws SQLException;
}
