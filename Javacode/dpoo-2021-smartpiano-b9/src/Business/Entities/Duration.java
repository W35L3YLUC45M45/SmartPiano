package Business.Entities;

import java.util.Date;

/**
 * The type Duration.
 * Will be used to determine the popularity of songs and be displayed in the Graphs section of the game.
 */
public class Duration {
    private Date startTime;
    private int numSongs;

    /**
     * Instantiates a new Duration with a startTime and counter of number of times played.
     *
     * @param startTime the start time will indicate when was the first time the song was played.
     * @param numSongs  the num songs will be a counter of all the times the song has been played by the user.
     */
    public Duration(Date startTime, int numSongs) {
        this.startTime = startTime;
        this.numSongs = numSongs;
    }

    /**
     * Gets start time to calculate for how long has it been known by user.
     *
     * @return a Date indicating the start time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Gets num songs which reflects number of times the song has been played.
     *
     * @return an int indicating the number of times the song has been played.
     */
    public int getNumSongs() {
        return numSongs;
    }
}
