package Business.Entities;

import java.util.Date;

/**
 * The type Playlist serves as a bridge between the game and the Database when allowing our users to create
 * or edit their playlists. Contains all elements from Database and relevant for the game UI.
 */
public class Playlist {
    private int id;
    private String name;
    private Date creation;
    private Date last_update;
    private String copyright;

    /**
     * Instantiates a new Playlist.
     *
     * @param id          the id from the playlist to make it unique and manageable.
     * @param name        the name from the playlist.
     * @param creation    the creation date from the playlist.
     * @param last_update the date from the last update made to the playlist.
     * @param copyright   the copyright from the playlist (private/public).
     */
    public Playlist(int id, String name, Date creation, Date last_update, String copyright) {
        this.id = id;
        this.name = name;
        this.creation = creation;
        this.last_update = last_update;
        this.copyright = copyright;
    }

    /**
     * Gets id from the playlist.
     *
     * @return an integer indicating the id from the playlist.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name from the playlist.
     *
     * @return a String indicating the name from the playlist.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets creation date from the playlist.
     *
     * @return a Date indicating the creation date from the playlist.
     */
    public Date getCreation() {
        return creation;
    }

    /**
     * Gets last update made to the current playlist.
     *
     * @return a Date indicating the the last update from the playlist.
     */
    public Date getLast_update() {
        return last_update;
    }

    /**
     * Gets copyright from the playlist. It might be private or public.
     *
     * @return a Sting indicating if the playlist is Public or Private.
     */
    public String getCopyright() {
        return copyright;
    }
}
