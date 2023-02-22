package Presentation.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class whose main purpose is to store all of the project's
 * different screens to navigate from
 */
public class CardView extends JFrame {
    public static final String WELCOMEMENU = "WELCOMEMENU";
    public static final String MAINMENU = "MAINMENU";
    public static final String PLAYMENU = "PLAYMENU";
    public static final String SETTINGSMENU = "SETTINGSMENU";
    public static final String REGISTERLOGINMENU = "REGISTERLOGINMENU";
    public static final String TRAININGMENU = "TRAININGMENU";
    public static final String PLAYLISTMENU = "PLAYLIST";
    public static final String PLAYLISTSONGMENU = "PLAYLISTSONGMENU";
    public static final String GRAPHSMENU = "GRAPHSMENU";

    private JPanel cards;
    private CardLayout cl;

    private TrainingView tv;
    private WelcomeView wv;
    private PlaylistView plv;
    private PlaylistSongView plsv;
    private PlayView pv;
    private StatisticsView sv;

    /**
     * Constructor in charge of initializing the previously declared variables
     * @param mmv MainMenuView view related to the main menu screen
     * @param sv SettingsView view related to the settings screen
     * @param rlv RegisterLoginView view related to the register-login screen
     * @param tv TrainingView view related to the training mode screen
     * @param wv WelcomeView view related to the welcome screen
     * @param plv PlaylistView view related to the playlist management screen
     * @param plsv PlaylistSongView view related to the playlist song section screen
     * @param stv StatisticsView view related to the statistics screen
     */
    public CardView (MainMenuView mmv, SettingsView sv, RegisterLoginView rlv, TrainingView tv, WelcomeView wv, PlaylistView plv, PlaylistSongView plsv, PlayView pv, StatisticsView stv){
        cards = new JPanel(new CardLayout());
        cl = (CardLayout) cards.getLayout();

        cards.add(mmv, MAINMENU);
        cards.add(sv, SETTINGSMENU);
        cards.add(tv, TRAININGMENU);
        cards.add(rlv, REGISTERLOGINMENU);
        cards.add(tv, TRAININGMENU);
        cards.add(wv, WELCOMEMENU);
        cards.add(plv, PLAYLISTMENU);
        cards.add(plsv, PLAYLISTSONGMENU);
        cards.add(pv, PLAYMENU);
        cards.add(stv, GRAPHSMENU);

        this.tv = tv;
        this.wv = wv;
        this.plv = plv;
        this.plsv = plsv;
        this.pv = pv;
        this.sv = stv;

         init();
    }

    /**
     * Method in charge of initializing the aesthethic of the
     * Welcome Menu
     */
    private void init(){
        setTitle("SmartPiano");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cl.show(cards, WELCOMEMENU);
        getContentPane().add(cards);
    }

    /**
     * Method in charge of opening the Welcome Menu screen
     */
    public void openWelcomeMenu(){
        cl.show(cards, WELCOMEMENU);
        wv.Focus();
    }

    /**
     * Method in charge of opening the Register Menu
     */
    public void openRegisterMenu(){
        cl.show(cards, REGISTERLOGINMENU);
    }

    /**
     * Method in charge of opening the Main Menu
     */
    public void openMainMenu(){
        cl.show(cards, MAINMENU);
    }

    /**
     * Method in charge of opening the Play screen
     */
    public void openPlayMenu(){
        cl.show(cards, PLAYMENU);
        pv.setFocus();
    }

    /**
     * Method in charge of opening the Settings Menu
     */
    public void openSettings(){
        cl.show(cards, SETTINGSMENU);
    }

    /**
     * Method in charge of opening the Training Menu
     */
    public void openTrainingMenu() {
        cl.show(cards, TRAININGMENU);
        tv.changeLetter();
    }

    /**
     * Method in charge of opening the Playlist Menu
     */
    public void openPlaylist() {
        cl.show(cards, PLAYLISTMENU);
        plv.loadPlaylists();
    }

    /**
     * Method in charge of opening the Playlist Song Menu
     */
    public void openPlaylistSong() {
        cl.show(cards, PLAYLISTSONGMENU);
    }

    /**
     * Method in charge of opening the Graphs Menu
     */
    public void openGraphsMenu() {
        cl.show(cards, GRAPHSMENU);
        sv.getPopularSongs();
    }

    /**
     * RegisterController
     * @param cc CardController that controlls which sections to go depending
     *           on the option chosen
     */
    public void registerController(ActionListener cc) { }
}
