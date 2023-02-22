package Business.Entities;

/**
 * The type Playlist song reflects the relation between Playlists and their Songs.
 */
public class PlaylistSong {
    private int ID_playlist;
    private int ID_song;

    /**
     * Instantiates a new Playlist song.
     *
     * @param ID_playlist the id from the playlist selected by the user containing the selected song.
     * @param ID_song     the id from the song contained by the selected playlist.
     */
    public PlaylistSong(int ID_playlist, int ID_song) {
        this.ID_playlist = ID_playlist;
        this.ID_song = ID_song;
    }

    /**
     * Gets the id from the playlist containing the songs selected.
     *
     * @return an integer indicating the id playlist
     */
    public int getID_playlist() {
        return ID_playlist;
    }

    /**
     * Gets the id from the selected song.
     *
     * @return an integer indicating the id song
     */
    public int getID_song() {
        return ID_song;
    }
}
