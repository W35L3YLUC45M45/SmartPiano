package Business.Entities;

/**
 * The type UserPlaylist reflects the relation between Users and their Playlists.
 */
public class UserPlaylist {
    private String username;
    private int ID_playlist;

    /**
     * Instantiates a new User-Playlist relation to connect both Entities.
     *
     * @param username    the unique username related to the Playlist.
     * @param ID_playlist the unique id from the Playlist related to the User.
     */
    public UserPlaylist(String username, int ID_playlist) {
        this.username = username;
        this.ID_playlist = ID_playlist;
    }

    /**
     * Gets the username from the User related to the Playlist.
     *
     * @return Int with the unique username from our User.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the playlistID from the Playlist related to the User.
     *
     * @return Int with the unique playlistID.
     */
    public int getID_playlist() {
        return ID_playlist;
    }
}
