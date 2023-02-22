package Persistance.sql;

import Persistance.dao.SongDAO;
import Business.Entities.Song;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Sql song dao.
 */
public class SQLSongDAO implements SongDAO {
    private final SQLConnector sqlConnector;

    /**
     * Constructor del SQLSongDAO, le pasamos el conector para hacer la conexion a la base de datos
     *
     * @param sqlConnector le tenemos que pasar un sqlConnector para poder operar con la base de datos
     */
    public SQLSongDAO(SQLConnector sqlConnector) {
        this.sqlConnector = sqlConnector;
    }

    /**
     * Metodo que añade una Song a la base de datos
     * @param song le pasamos un Song para que lo podamos añadir
     */
    public void addSong(Song song) {
        //id_song,title,composer,duration,release_date,creation_date,copyright,genre,midi
        String query = "INSERT INTO Song(title, composer, duration, release_date, creation_date, copyright, genre, midi) VALUES ('" +
                song.getTitle() + "', '" +
                song.getComposer() + "', " +
                song.getDuration() + ", '" +
                song.getRelease_date() + "', '" +
                song.getCreation_date() + "', '" +
                song.getCopyright() + "', '" +
                song.getGenre() + "', '" +
                song.getMidi() +
                "');";

        sqlConnector.insertQuery(query);
    }

    /**
     * Metodo que elimina una cancion de la base de datos
     * @param ID_Song le pasamos que cancion queremos borrar
     */
    public void deleteSong(int ID_Song) {
        String query = "DELETE FROM Song WHERE ID_Song LIKE '" + ID_Song + "';";
        sqlConnector.deleteQuery(query);
    }

    /**
     * Metodo que coge una cancion de la base de datos
     * @param ID_Song le pasamos un int, el numero de id de la cancion
     * @return nos retorna una cancion, de la entidad Song
     * @throws SQLException
     */
    public Song getSong(Integer ID_Song) throws SQLException {
        String query = "SELECT * FROM Song WHERE song.id_song = " +
                ID_Song + " ;";
        ResultSet result = sqlConnector.selectQuery(query);
        result.next();
        int id_song = result.getInt("id_song");
        String title = result.getString("title");
        String composer = result.getString("composer");
        int duration = result.getInt("duration");
        String creation_date = result.getString("creation_date");
        String copyright = result.getString("copyright");
        String genre = result.getString("genre");
        String release_date = result.getString("release_date");
        String midi = result.getString("midi");

        return new Song(id_song, title, composer, duration, creation_date, copyright, genre, release_date, midi);
    }

    /**
     * Method to get a song from the database by its name.
     * @param name The name of the song.
     * @return The selected song.
     * @throws SQLException Throws an exception if there isn't a song.
     */
    public Song getSongByName(String name) throws SQLException {
        String query = "SELECT * FROM Song WHERE song.title LIKE '" +
                name + "' ;";
        ResultSet result = sqlConnector.selectQuery(query);
        result.next();
        int id_song = result.getInt("id_song");
        String title = result.getString("title");
        String composer = result.getString("composer");
        int duration = result.getInt("duration");
        String creation_date = result.getString("creation_date");
        String copyright = result.getString("copyright");
        String genre = result.getString("genre");
        String release_date = result.getString("release_date");
        String midi = result.getString("midi");

        return new Song(id_song, title, composer, duration, creation_date, copyright, genre, release_date, midi);
    }

    /**
     * Getter for the songs in the database.
     *
     * @return The songs.
     * @throws SQLException Throws if there were no songs
     */
    public ArrayList<Song> getAllSongs() throws SQLException {
        ArrayList<Song> songs = new ArrayList<>();
        String query = "SELECT * FROM Song;";
        ResultSet result = sqlConnector.selectQuery(query);

        while(result.next()) {
            int id_song = result.getInt("id_song");
            String title = result.getString("title");
            String composer = result.getString("composer");
            int duration = result.getInt("duration");
            String creation_date = result.getString("creation_date");
            String copyright = result.getString("copyright");
            String genre = result.getString("genre");
            String release_date = result.getString("release_date");
            String midi = result.getString("midi");
            songs.add(new Song(id_song, title, composer, duration, creation_date, copyright, genre, release_date, midi));
        }
        return songs;
    }

    /**
     * Metodo que hace el update de una cancion de la base de datos
     * @param ID_Song canción que queremos mover
     * @param duration le pasamos que playlist queremos actualizar
     */
    public void updateSong(int ID_Song, int duration) {
        String query = "UPDATE Song SET duration = " + duration + " WHERE ID_song = " + ID_Song + ";";
        sqlConnector.deleteQuery(query);
    }
}
