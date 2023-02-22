package Business.ConfigDatabase;

import Persistance.dao.*;

/**
 * The type Database manager. This class contains the different entities created to manage the database.
 * In order to use all the methods of the different entities, we relate DatabaseManager with their interfaces
 */
public class DatabaseManager {
    private final UserDAO userDao;
    private final PlaylistDAO playlistDao;
    private final SongDAO songDao;
    private final PlaylistSongDAO playlistSongDao;
    private final UserPlaylistDAO userPlaylistDAO;

    /**
     * Instantiates a new Database manager. Its parameters as we can see are the different interfaces.
     *
     * @param userDAO         the user dao
     * @param songDAO         the song dao
     * @param playlistDAO     the playlist dao
     * @param playlistSongDAO the playlist song dao
     */
    // Constructor initializing a specific implementation of the DAOs. In this
    //  occasion, the SQL implementations will be used.
    public DatabaseManager(UserDAO userDAO, SongDAO songDAO, PlaylistDAO playlistDAO, PlaylistSongDAO playlistSongDAO, UserPlaylistDAO userPlaylistDAO) {
        userDao = userDAO;
        songDao = songDAO;
        playlistDao = playlistDAO;
        playlistSongDao = playlistSongDAO;
        this.userPlaylistDAO = userPlaylistDAO;
    }

    /**
     * Gets PlaylistSongDAO interface in order to use their methods.
     *
     * @return the PlaylistSongDAO
     */
    public PlaylistSongDAO getPlaylistSongDao() {
        return playlistSongDao;
    }

    /**
     * Gets UserDAO interface in order to use their methods.
     *
     * @return the UserDAO
     */
    public UserDAO getUserDao() {
        return userDao;
    }

    /**
     * Gets PlaylistDAO interface in order to use their methods.
     *
     * @return the PlaylistDAO
     */
    public PlaylistDAO getPlaylistDao() {
        return playlistDao;
    }

    /**
     * Gets SongDAO interface in order to use their methods.
     *
     * @return the SongDAO
     */
    public SongDAO getSongDao() {
        return songDao;
    }

    /**
     * Gets UserPlaylistDAO interface in order to use their methods.
     *
     * @return the UserPlaylistDAO
     */
    public UserPlaylistDAO getUserPlaylistDAO(){
        return userPlaylistDAO;
    }
}
