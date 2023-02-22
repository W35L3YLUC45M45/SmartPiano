package Business;

import Business.ConfigDatabase.DatabaseManager;
import Business.Entities.Song;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Statistics model will be used by the Statistics Controller, relating our Controller to the Database Manager.
 */
public class StatisticsModel {
    DatabaseManager dm;

    /**
     * Instantiates a new Statistics model.
     *
     * @param dm the Database Manager.
     */
    public StatisticsModel (DatabaseManager dm){
        this.dm = dm;
    }

    /**
     * Method used to get the songs from the database and order it by popularity.
     */
    public ArrayList<Song> getPopularSongs(){
        ArrayList<Song> songs;
        try {
            songs = dm.getSongDao().getAllSongs();
        } catch (SQLException throwables) {
            songs = null;
        }
        Collections.sort(songs);
        return songs;
    }
}
