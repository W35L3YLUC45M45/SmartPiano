package Presentation.Controllers;

import Business.Entities.Playlist;
import Business.Entities.Song;
import Business.PlayModel;
import Business.SongModel;
import Business.UserModel;
import Presentation.Views.CardView;
import Presentation.Views.PlaylistSongView;
import Presentation.Views.PlaylistView;
import SupportClasses.ConstantList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class in charge of everything related to
 * the controller of the Playlist linked to its own view.
 * The methods shown below
 * are in charge of the interactions with
 * most of the components present in its correspondent view
 */
public class PlaylistController implements ActionListener, ChangeListener {
    private PlaylistView plv;
    private PlaylistSongView plsv;
    private CardView cv;
    private UserModel um;

    private PlayModel pm;
    private SongModel sm;

    private String source;
    private int playlist;

    /**
     * Constructor that initializes all of the variables
     * previously declared.
     * @param plv PlaylistView in which allows the program
     *            to display the Playlist library screen
     * @param plsv PlaylistSongView in which allows the
     *             program to display the Song list
     *             subscreen from the Library screen
     * @param cv CardView in which allows us to list all of
     *           the screens pertaining to the project and
     *           switch between them whenever we feel like
     *           as the program's user
     */
    public PlaylistController(PlaylistView plv, PlaylistSongView plsv, CardView cv, PlayModel pm, UserModel um, SongModel sm){
        this.plv = plv;
        this.plsv = plsv;
        this.cv = cv;
        this.pm = pm;
        this.um = um;
        this.sm = sm;
    }

    /**
     * Method in charge of dealing with the button interactions
     * in which the user interacts with while using of the program
     * @param e ActionEvent default variable used to get the
     *          action/interaction coming from our keyboard
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ConstantList.BTN_HAMBURGUESA:
                plv.menuShow();
                break;
            case ConstantList.BTN_DELETEACC:
                um.deleteAccount(um.getUser().getUsername());
                plv.menuExit();
            case ConstantList.BTN_HOME:
            case ConstantList.BTN_SETTINGS:
            case ConstantList.BTN_LOGOUT:
            case ConstantList.BTN_PLAY:
            case ConstantList.BTN_TRAINING:
            case ConstantList.BTN_GRAPHS:
                plv.menuExit();
                plsv.setTrack("id");
                pm.setTrack("id");
                break;
            case ConstantList.BTN_CLOSEMENU:
                plv.menuExit();
                break;
            case ConstantList.BTN_PLAYLIST:
                plsv.setTrack("id");
                pm.setTrack("id");
                break;
            case ConstantList.BTN_OPENPLAYLIST:
                playlist = Integer.parseInt (((JButton)e.getSource()).getText());
                plsv.loadPlaylist(playlist);
                break;
            case ConstantList.BTN_DELETEFROM:
            case ConstantList.BTN_BACKTOLAYLIST:
            case ConstantList.BTN_CHANGEFOLDER:

            case ConstantList.BTN_PLAYTRACK:
                source = ((JButton)e.getSource()).getText();
                System.out.println(source);
                plsv.setTrack(source);
                pm.setTrack(source);
                sm.updateSong(Integer.parseInt(source), plsv.getDuration(Integer.parseInt(source))+1);
                break;
            case ConstantList.BTN_PAUSETRACK:
                source = ((JButton)e.getSource()).getText();
                if(source != "id"){
                    plsv.playPause();
                }
                break;
            case ConstantList.BTN_PRESSME:
                pm.setSequence("", true);
                plsv.initPause();
                break;
            case ConstantList.BTN_TRAININGTRACK:
            case ConstantList.BTN_RANDOMTRACK:
                randomTrack();
                break;
            case ConstantList.BTN_LOOPTRACK:
                plsv.loop();
                pm.loop();
                break;
            case ConstantList.BTN_PREVTRACK:
                source = ((JButton)e.getSource()).getText();
                changeTrack(source, false);
                break;
            case ConstantList.BTN_NEXTTRACK:
                source = ((JButton)e.getSource()).getText();
                changeTrack(source, true);
                break;
            case ConstantList.REFRESH:
                plv.refreshShow();
                plv.loadPlaylists();
                break;
            case ConstantList.CREATE_PLAYLIST:
                plv.createShow();
                break;
            case ConstantList.CREATE_PLAYLIST_YES:
                Playlist createPlaylist = new Playlist(0, plv.getNameText(), null, null, plv.getCopyright());
                sm.addPlaylist(createPlaylist);
            case ConstantList.CREATE_PLAYLIST_NO:
                plv.createExit();
                plv.loadPlaylists();
                break;
            case ConstantList.SAVE_CLOSE_POPUP:
                plv.refreshExit();
                break;
            case ConstantList.DELETE_SONG:
                source = ((JButton)e.getSource()).getText();
                System.out.println(source);
                plsv.deleteShow();
                break;
            case ConstantList.DELETE_SONG_YES:
                sm.deleteSong(Integer.parseInt (source));
                plsv.loadPlaylist(playlist);
            case ConstantList.DELETE_SONG_NO:
                plsv.deleteExit();
                source = "id";
                System.out.println(source);
                break;
            case ConstantList.DELETE_PLAYLIST:
                source = ((JButton)e.getSource()).getText();
                System.out.println(source);
                plv.deleteShow();
                break;
            case ConstantList.DELETE_PLAYLIST_YES:
                sm.deletePlaylist(Integer.parseInt (source));
                plv.loadPlaylists();
            case ConstantList.DELETE_PLAYLIST_NO:
                plv.deleteExit();
                source = "id";
                System.out.println(source);
                break;
            case ConstantList.MOVE_SONG:
                source = ((JButton)e.getSource()).getText();
                System.out.println(source);
                plsv.moveShow();
                break;
            case ConstantList.MOVE_SONG_YES:
                try {
                    sm.updatePlaylist(Integer.parseInt (source), plsv.getNameText());
                } catch (SQLException throwables) {
                    plsv.errorShow();
                }
                plsv.loadPlaylist(playlist);
            case ConstantList.MOVE_SONG_NO:
                plsv.moveExit();
                source = "id";
                System.out.println(source);
                break;
            case ConstantList.MOVE_SONG_OK:
                plsv.errorExit();
                break;
            default:
                System.out.println("DEFAULT");
                break;
        }
    }

    /**
     * Method in charge of allowing the user to play other tracks
     * and change between them whenever feels like
     * @param id String that represents the id of the song
     * @param next boolean that represents whether we can go or not
     *             to the next song to listen to
     */
    public void changeTrack(String id, boolean next){
        System.out.println("actual song in: " + plsv.getSongsList().indexOf(Integer.parseInt(id)));
        int index = plsv.getSongsList().indexOf(Integer.parseInt(id));
        int i = 0;
        if (next){
            i++;
        } else {
            i--;
        }

        try {
            plsv.setTrack(String.valueOf(plsv.getSongsList().get(index + i)));
            pm.setTrack(String.valueOf(plsv.getSongsList().get(index + i)));
        } catch (IndexOutOfBoundsException e){
            System.out.println("there is no track for: " + (index + i));
        }
    }

    /**
     * Method that allows us to forward next to any other song
     * from the playlist randomly, taking into the account the
     * possibility that there may not be a track detected by the index
     */
    public void randomTrack(){
        Random rand = new Random();
        int index = rand.nextInt(plsv.getSongsList().size());
        try {
            plsv.setTrack(String.valueOf(plsv.getSongsList().get(index)));
            pm.setTrack(String.valueOf(plsv.getSongsList().get(index)));
        } catch (IndexOutOfBoundsException e){
            System.out.println("there is no track for: " + (index));
        }
    }

    /**
     * Method in charge of adjusting the volume slider from
     * the playlist song menu
     * @param e for the ChangeEvent
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            float volume = source.getValue()/100.0f;
            pm.changeVolume(volume);
        }
    }

    /**
     * Method in charge of acting as getter of the public playlists
     * containing its own music tracks
     * @return ArrayList of playlists
     */
    public ArrayList<Playlist> getPublicPlaylists(){
        return sm.getPublicPlaylists();
    }

    /**
     * Method in charge of acting as getter of the private playlists
     * containing its own music tracks
     * @return ArrayList of playlists
     */
    public ArrayList<Playlist> getPrivatePlaylists(){
        return sm.getPrivatePlaylists();
    }

    /**
     * Method in charge of getting the number of songs that a playlist contains
     * @param id int playlist of our interest
     * @return the specific playlist's number of tracks
     */
    public int getPlaylistSize(int id){
        return sm.getPlaylistSize(id);
    }

    /**
     * Method in charge of getting the playlist of our interest
     * @param id int id of the playlist of our interest
     * @return Playlist of our interest
     */
    public Playlist getPlaylist(int id){
        return sm.getPlaylist(id);
    }

    /**
     * Method in charge of getting the ids of the list of music tracks inside a playlist
     * @param id int id of the playlist to extract the music tracks from
     * @return ArrayList of ids of the songs
     */
    public ArrayList<Integer> getSongsList(int id){
        return sm.getSongsList(id);
    }

    /**
     * Method in charge of getting all the songs of a playlist
     * @param id ArrayList of the playlist that contains all of the songs
     * @return All the songs
     */
    public ArrayList<Song> getSongs(ArrayList<Integer> id){
        return sm.getSongs(id);
    }

    /**
     * Method in charge of getting a specific song from a playlist
     * @param id int id of the specific song
     * @return Song of our interest
     * @throws SQLException
     */
    public Song getSong(int id) throws SQLException{
        return sm.getSong(id);
    }
}
