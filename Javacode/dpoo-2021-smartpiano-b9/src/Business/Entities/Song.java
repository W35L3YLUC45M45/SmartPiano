package Business.Entities;

/**
 * The type Song will be called everytime the user wants to access a song from the Database, or when downloading songs from the website.
 */
public class Song implements Comparable<Song> {
    private int ID_song;
    private String title;
    private String composer;
    private int duration;
    private String creation_date;
    private String copyright;
    private String genre;
    private String midi;
    private String release_date;

    /**
     * Instantiates a new Song to be filled by the information from the Database.
     *
     * @param ID_song       Int with the unique id from the song.
     * @param title         String with the title from the song.
     * @param composer      String with the composer from this song.
     * @param duration      Int with the duration (in seconds) from the song.
     * @param creation_date String with the creation date from the song.
     * @param copyright     String with the copyright from the song (Private/Public).
     * @param genre         String with the genre from the song.
     * @param release_date  String with the release date from the song.
     * @param midi          String with the midi file containing the song, ready to be played by Sequencer.
     */
    public Song(int ID_song, String title, String composer, int duration, String creation_date, String copyright, String genre, String release_date, String midi) {
        this.ID_song = ID_song;
        this.title = title;
        this.composer = composer;
        this.duration = duration;
        this.creation_date = creation_date;
        this.copyright = copyright;
        this.genre = genre;
        this.midi = midi;
        this.release_date = release_date;
    }

    /**
     * Instantiates a new Song to be filled by the information collected by the WebScrapper during te downloading of songs.
     *
     * @param title         String with the title from the song.
     * @param composer      String with the composer from this song.
     * @param duration      Int with the duration (in seconds) from the song.
     * @param creation_date String with the creation date from the song.
     * @param copyright     String with the copyright from the song (Private/Public).
     * @param genre         String with the genre from the song.
     * @param release_date  String with the release date from the song.
     * @param midi          String with the midi file containing the song, ready to be played by Sequencer.
     */
    public Song(String title, String composer, int duration, String creation_date, String copyright, String genre, String release_date, String midi) {
        this.title = title;
        this.composer = composer;
        this.duration = duration;
        this.creation_date = creation_date;
        this.copyright = copyright;
        this.genre = genre;
        this.midi = midi;
        this.release_date = release_date;
    }

    /**
     * Gets id from the song.
     *
     * @return int with the unique songID.
     */
    public int getID_song() {
        return ID_song;
    }

    /**
     * Sets id from the song.
     *
     * @param ID_song the unique id for the song.
     */
    public void setID_song(int ID_song) {
        this.ID_song = ID_song;
    }

    /**
     * Gets title from song.
     *
     * @return String with the title from the song.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title to song.
     *
     * @param title String for the song's title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets composer from song.
     *
     * @return String with the song's composer
     */
    public String getComposer() {
        return composer;
    }

    /**
     * Gets duration from song.
     *
     * @return Int with the duration (in seconds) of the song.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets duration to song.
     *
     * @param duration the duration from the song.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets creation date from song.
     *
     * @return String with the creation date from the song.
     */
    public String getCreation_date() {
        return creation_date;
    }

    /**
     * Sets creation date to song.
     *
     * @param creation_date the creation date to be set to the song.
     */
    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    /**
     * Gets copyright from the song.
     *
     * @return String with the copyright from song (Private/Public).
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * Sets copyright to song (Private/Public).
     *
     * @param copyright the copyright that we wish teh song to have (Private/Public).
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * Gets genre from song.
     *
     * @return String with the genre of the song.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets genre to the song.
     *
     * @param genre the genre to be set to song.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets midi file containing the song.
     *
     * @return String with the midi file ready to be downloaded or played.
     */
    public String getMidi() {
        return midi;
    }

    /**
     * Gets release date from song.
     *
     * @return String with the release date from the song.
     */
    public String getRelease_date() {
        return release_date;
    }

    @Override
    public int compareTo(Song o) {
        return o.duration-this.duration;
    }
}
