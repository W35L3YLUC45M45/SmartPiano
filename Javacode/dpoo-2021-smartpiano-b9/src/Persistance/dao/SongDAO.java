package Persistance.dao;

import Business.Entities.Song;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The interface Song dao.
 */
public interface SongDAO {

    /**
     * Add song.
     *
     * @param song the song
     */
    void addSong(Song song);

    /**
     * Delete song.
     *
     * @param ID_Song the id song
     */
    void deleteSong(int ID_Song);

    /**
     * Gets song.
     *
     * @param ID_Song the id song
     * @return the song
     * @throws SQLException the sql exception
     */
    Song getSong(Integer ID_Song) throws SQLException;

    /**
     * Method to get a song from the database by its name.
     * @param name The name of the song.
     * @return The selected song.
     * @throws SQLException Throws an exception if there isn't a song.
     */
    Song getSongByName(String name) throws  SQLException;

    /**
     * Getter for the songs in the database.
     *
     * @return The songs.
     * @throws SQLException Throws if there were no songs
     */
    ArrayList<Song> getAllSongs() throws SQLException;

    /**
     * Metodo que hace el update de una cancion de la base de datos
     * @param ID_Song canción que queremos mover
     * @param duration le pasamos que playlist queremos actualizar
     */
    void updateSong(int ID_Song, int duration);
}
