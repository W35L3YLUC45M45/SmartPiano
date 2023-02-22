package Presentation.Views;

import Presentation.Controllers.CardController;
import Presentation.Controllers.PlaylistController;
import Business.ConfigDatabase.DatabaseManager;
import Business.Entities.Playlist;
import Business.Entities.Song;
import Business.PlayModel;
import SupportClasses.*;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * PlaylistSongView
 * Class in charge of everything related to the
 * playlist song view screen aesthetically.
 */
public class PlaylistSongView extends JPanel {
    private ImageIcon iiPlayButton;
    private ImageIcon iiPauseButton;
    private ImageIcon iiPressMeButton;
    private ImageIcon iiNextSong;
    private ImageIcon iiPrevSong;
    private ImageIcon iiTraining;
    private ImageIcon iiLoopMode;
    private ImageIcon iiRandMode;
    private ImageIcon iiBack;
    private ImageIcon iiPlaylistHeader;
    private ImageIcon iiPlaylistIcon;

    private JButton jbPlayButton;
    private JButton jbPressMeButton;
    private JButton jbNextSong;
    private JButton jbPrevSong;
    private JButton jbTraining;
    private JButton jbLoopMode;
    private JButton jbRandMode;
    private JButton jbBack;

    private JLabel jlPlaylistHeader;
    private JLabel jlPlaylistIcon;
    private JLabel jlPlaylist;
    private JLabel jlTotalSongs;
    private JLabel jlSongAuthorName;
    private JLabel jlSongTitle;

    private JPanel jpPlayButton;
    private JPanel jpPressMeButton;
    private JPanel jpNextSong;
    private JPanel jpPrevSong;
    private JPanel jpTraining;
    private JPanel jpLoopMode;
    private JPanel jpRandMode;
    private JPanel centerpanel;

    private JSlider jsVolumeSlider;

    private JPanel layoutSongs;
    private JPanel jpSongsDetails;
    private JScrollPane jpSongsPane;
    private ArrayList<Integer> songsList;
    private ArrayList<Song> songs;
    private ArrayList<SongPanel> songPanels;
    private Playlist playlist;

    private JButton hamburger;
    private ImageIcon hamburger_icon;
    private JPanel hamburgerpanel;
    private DeleteSongPanel deletesong;
    private MoveSong movesong;
    private MoveError moveerror;

    private DatabaseManager dm;
    private PlayModel pm;
    private PlaylistController plc;
    private CardController cc;
    private boolean play;
    private boolean loop;

    /**
     * Constructor in charge of initializing the
     * view's layout, along with initializing the
     * view's whole process of aesthetic body development
     * @param dm DatabaseManager that contains all the info. related to the project
     * @param pm PlayModel Entity in charge of the logic behind the piano's functionality
     */
    public PlaylistSongView(DatabaseManager dm, PlayModel pm) {
        setSize(1920, 1080);
        this.setLayout(new BorderLayout());

        this.dm = dm;
        this.pm = pm;

        deletesong = new DeleteSongPanel();
        movesong = new MoveSong();
        moveerror = new MoveError();

        loop = false;

        init();
    }

    /**
     * Method in charge of building the whole view
     * from top to bottom with all of the components added into it
     */
    public void init(){
        centerpanel = new JPanel(new BorderLayout());
        centerpanel.setBackground(Color.WHITE);

        hamburgerpanel = new JPanel();
        hamburgerpanel.setLayout(new BoxLayout(hamburgerpanel, BoxLayout.Y_AXIS));

        // PLAYLIST'S LIST OF SONGS GENERAL LAYOUT /////////////////////////////////////////////////////////////////////
        layoutSongs = new JPanel();
        layoutSongs.setOpaque(true);
        layoutSongs.setBackground(Color.WHITE);
        layoutSongs.setForeground(Color.WHITE);
        layoutSongs.setLayout(new BoxLayout(layoutSongs, BoxLayout. Y_AXIS));
        layoutSongs.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        hamburger_icon = new ImageIcon("src/Icons/Main Menu Screen/grupo 12.jpg");
        iiPlaylistHeader = new ImageIcon("src/Icons/Playlist Library Screen/Grupo 250.png");

        jlPlaylistHeader = new JLabel(iiPlaylistHeader);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // GENERAL LAYOUT'S BORDERLAYOUT.CENTER ////////////////////////////////////////////////////////////////////////

        // CURRENT PLAYLIST PANEL (1/4) //
        JPanel jpCurrentPlaylist = new JPanel();
        jpCurrentPlaylist.setLayout(new BorderLayout());
        jpCurrentPlaylist.setOpaque(true);
        jpCurrentPlaylist.setBackground(Color.WHITE);
        jpCurrentPlaylist.setForeground(Color.WHITE);

        JPanel jpCurrentPlaylistName = new JPanel();
        jpCurrentPlaylistName.setLayout(new BoxLayout(jpCurrentPlaylistName, BoxLayout.X_AXIS));
        jpCurrentPlaylistName.setOpaque(true);
        jpCurrentPlaylistName.setBackground(Color.WHITE);
        jpCurrentPlaylistName.setForeground(Color.WHITE);

        iiBack = new ImageIcon("src/Icons/Playlist Library Screen/back_arrow.png");
        jbBack = new JButton(iiBack);
        jbBack.setBackground(Color.WHITE);
        jbBack.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 50));
        jbBack.setActionCommand(ConstantList.BTN_PLAYLIST);

        // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // /

        jlTotalSongs = new JLabel("29 song(s)");
        jlTotalSongs.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        jlTotalSongs.setForeground(Color.GRAY);
        jlTotalSongs.setBackground(Color.WHITE);
        jlTotalSongs.setOpaque(true);
        jlTotalSongs.setBackground(Color.WHITE);

        // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // /

        iiPlaylistIcon = new ImageIcon("src/Icons/Playlist Library Screen/grupo 80.png");

        jlPlaylistIcon = new JLabel(iiPlaylistIcon);
        jlPlaylistIcon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));

        jlPlaylist = new JLabel("Public PlayLists  - " + "Boku No Pico OST");
        jlPlaylist.setFont(new Font("Segoe UI", Font.BOLD, 35));
        jlPlaylist.setForeground(Color.GRAY);
        jlPlaylist.setOpaque(true);
        jlPlaylist.setBackground(Color.WHITE);

        // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // /

        JLabel jlTotalDurationSongs = new JLabel("2 hour(s), 54 minute(s)");
        jlTotalDurationSongs.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        jlTotalDurationSongs.setForeground(Color.GRAY);
        jlTotalDurationSongs.setOpaque(true);
        jlTotalDurationSongs.setBackground(Color.WHITE);
        jlTotalDurationSongs.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));

        // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // /

        jpCurrentPlaylistName.add(Box.createHorizontalGlue());
        jpCurrentPlaylistName.add(jlPlaylistIcon);
        jpCurrentPlaylistName.add(jlPlaylist);
        jpCurrentPlaylistName.add(Box.createHorizontalGlue());

        JPanel backTime = new JPanel();
        backTime.setLayout(new BoxLayout(backTime, BoxLayout.X_AXIS));
        backTime.setBackground(Color.WHITE);

        backTime.add(jbBack);
        backTime.add(jlTotalSongs);
        jpCurrentPlaylist.add(backTime, BorderLayout.WEST);
        jpCurrentPlaylist.add(jpCurrentPlaylistName, BorderLayout.CENTER);
        jpCurrentPlaylist.add(jlTotalDurationSongs, BorderLayout.EAST);

        // SONG INFO PANEL (2/4) ***************************************************************************************
        JPanel jpSongInfo = new JPanel();
        jpSongInfo.setOpaque(true);
        jpSongInfo.setBackground(Color.WHITE);
        jpSongInfo.setLayout(new GridLayout(1,5));
        jpSongInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // /

        JPanel jpSongName = new JPanel();
        JLabel jlSongName = new JLabel("Song name");
        jlSongName.setFont(new Font("Segoe UI", Font.BOLD, 25));
        jlSongName.setForeground(Color.GRAY);
        jlSongName.setOpaque(true);
        jlSongName.setBackground(Color.WHITE);
        jpSongName.add(jlSongName);
        jpSongName.setBackground(Color.WHITE);
        jpSongName.setForeground(Color.WHITE);
        jpSongName.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel jpAuthorName = new JPanel();
        JLabel jlAuthorName = new JLabel("Author");
        jlAuthorName.setFont(new Font("Segoe UI", Font.BOLD, 25));
        jlAuthorName.setForeground(Color.GRAY);
        jlAuthorName.setOpaque(true);
        jlAuthorName.setBackground(Color.WHITE);
        jpAuthorName.add(jlAuthorName);
        jpAuthorName.setBackground(Color.WHITE);
        jpAuthorName.setForeground(Color.WHITE);
        jpAuthorName.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel jpSongDuration = new JPanel();
        JLabel jlSongDuration = new JLabel("Duration");
        jlSongDuration.setFont(new Font("Segoe UI", Font.BOLD, 25));
        jlSongDuration.setForeground(Color.GRAY);
        jlSongDuration.setOpaque(true);
        jlSongDuration.setBackground(Color.WHITE);
        jpSongDuration.add(jlSongDuration);
        jpSongDuration.setBackground(Color.WHITE);
        jpSongDuration.setForeground(Color.WHITE);
        jpSongDuration.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel jpRegistrationDate = new JPanel();
        JLabel jlRegistrationDate = new JLabel("Registration date");
        jlRegistrationDate.setFont(new Font("Segoe UI", Font.BOLD, 25));
        jlRegistrationDate.setForeground(Color.GRAY);
        jlRegistrationDate.setOpaque(true);
        jlRegistrationDate.setBackground(Color.WHITE);
        jpRegistrationDate.add(jlRegistrationDate);
        jpRegistrationDate.setBackground(Color.WHITE);
        jpRegistrationDate.setForeground(Color.WHITE);
        jpRegistrationDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel jpOptions = new JPanel();
        JLabel jlOptions = new JLabel("Options");
        jlOptions.setFont(new Font("Segoe UI", Font.BOLD, 25));
        jlOptions.setForeground(Color.GRAY);
        jlOptions.setOpaque(true);
        jlOptions.setBackground(Color.WHITE);
        jpOptions.add(jlOptions);
        jpOptions.setBackground(Color.WHITE);
        jpOptions.setForeground(Color.WHITE);
        jpOptions.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // /

        jpSongInfo.add(jpSongName);
        jpSongInfo.add(jpAuthorName);
        jpSongInfo.add(jpSongDuration);
        jpSongInfo.add(jpRegistrationDate);
        jpSongInfo.add(jpOptions);

        // SONGS' PANEL (3/4) ******************************************************************************************

        jpSongsDetails = new JPanel();
        jpSongsDetails.setOpaque(true);
        jpSongsDetails.setBackground(Color.WHITE);
        jpSongsDetails.setLayout(new BoxLayout(jpSongsDetails, BoxLayout.Y_AXIS));

        JPanel jpSongsList = new JPanel();
        jpSongsList.setLayout(new BoxLayout(jpSongsList, BoxLayout.X_AXIS));
        jpSongsList.setOpaque(true);
        jpSongsList.setBackground(Color.WHITE);
        jpSongsList.setForeground(Color.WHITE);

        jpSongsList.add(jpSongsDetails);
        jpSongsPane = new JScrollPane(jpSongsDetails);
        jpSongsPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));
        jpSongsPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        jpSongsList.add(jpSongsPane);
        jpSongsDetails.setPreferredSize(new Dimension(50, 1000));

        // SONG PLAYER (4/4) *******************************************************************************************
        JPanel jpSongPlayer = new JPanel();
        jpSongPlayer.setOpaque(true);
        jpSongPlayer.setBackground(Color.WHITE);
        jpSongPlayer.setForeground(Color.WHITE);
        jpSongPlayer.setLayout(new BoxLayout(jpSongPlayer, BoxLayout.X_AXIS));
        jpSongPlayer.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel jpSongSelected = new JPanel();
        jpSongSelected.setOpaque(true);
        jpSongSelected.setBackground(Color.WHITE);
        jpSongSelected.setForeground(Color.WHITE);
        jpSongSelected.setLayout(new BoxLayout(jpSongSelected, BoxLayout.X_AXIS));

        JPanel jpSongSelectedInfo = new JPanel();
        jpSongSelectedInfo.setOpaque(true);
        jpSongSelectedInfo.setBackground(Color.WHITE);
        jpSongSelectedInfo.setForeground(Color.WHITE);
        jpSongSelectedInfo.setLayout(new BoxLayout(jpSongSelectedInfo, BoxLayout.Y_AXIS));

        ImageIcon iiSongFileIcon = new ImageIcon("src/Icons/Playlist Library Screen/Grupo 127.png");
        JLabel jlSongFileIcon = new JLabel(iiSongFileIcon);

        JPanel jpSongTitle = new JPanel();
        jlSongTitle = new JLabel(" ");
        jlSongTitle.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlSongTitle.setForeground(Color.GRAY);
        jlSongTitle.setOpaque(true);
        jlSongTitle.setBackground(Color.WHITE);
        jpSongTitle.add(jlSongTitle);
        jpSongTitle.setBackground(Color.WHITE);
        jpSongTitle.setForeground(Color.WHITE);

        JPanel jpSongAuthorName = new JPanel();
        jlSongAuthorName = new JLabel(" ");
        jlSongAuthorName.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jlSongAuthorName.setForeground(Color.GRAY);
        jlSongAuthorName.setOpaque(true);
        jlSongAuthorName.setBackground(Color.WHITE);
        jpSongAuthorName.add(jlSongAuthorName);
        jpSongAuthorName.setBackground(Color.WHITE);
        jpSongAuthorName.setForeground(Color.WHITE);

        JPanel jpSongSelectedDurationTimer = new JPanel();
        JLabel jlSongSelectedDurationTimer = new JLabel("00:00");
        jlSongSelectedDurationTimer.setFont(new Font("Segoe UI", Font.BOLD, 30));
        jlSongSelectedDurationTimer.setForeground(Color.GRAY);
        jlSongSelectedDurationTimer.setOpaque(true);
        jlSongSelectedDurationTimer.setBackground(Color.WHITE);
        jpSongSelectedDurationTimer.add(jlSongSelectedDurationTimer);
        jlSongSelectedDurationTimer.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 50));
        jpSongSelectedDurationTimer.setBackground(Color.WHITE);
        jpSongSelectedDurationTimer.setForeground(Color.WHITE);
        jlSongSelectedDurationTimer.setAlignmentX(LEFT_ALIGNMENT);

        jpSongSelectedInfo.add(jpSongTitle);
        jpSongSelectedInfo.add(jpSongAuthorName);
        jpSongSelected.add(jlSongFileIcon);
        jlSongFileIcon.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        jpSongSelected.add(jpSongSelectedInfo);
        jpSongSelected.add(jpSongSelectedDurationTimer);

        // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // /

        JPanel jpMediaPlayerOptions = new JPanel();
        jpMediaPlayerOptions.setOpaque(true);
        jpMediaPlayerOptions.setBackground(Color.WHITE);
        jpMediaPlayerOptions.setForeground(Color.WHITE);
        jpMediaPlayerOptions.setLayout(new BoxLayout(jpMediaPlayerOptions, BoxLayout.X_AXIS));

        JPanel jpMediaPlayerOptionsTopGrid = new JPanel();
        jpMediaPlayerOptionsTopGrid.setOpaque(true);
        jpMediaPlayerOptionsTopGrid.setBackground(Color.WHITE);
        jpMediaPlayerOptionsTopGrid.setForeground(Color.WHITE);
        jpMediaPlayerOptionsTopGrid.setLayout(new GridLayout(1,7));

        jpTraining = new JPanel();
        iiTraining = new ImageIcon("src/Icons/Playlist Library Screen/training.png");
        jbTraining = new JButton(iiTraining);
        jbTraining.setBackground(Color.WHITE);
        jbTraining.setBorder(null);
        jpTraining.setBackground(Color.WHITE);
        jpTraining.add(jbTraining);

        jpRandMode = new JPanel();
        iiRandMode = new ImageIcon("src/Icons/Playlist Library Screen/random_play.jpg");
        jbRandMode = new JButton(iiRandMode);
        jbRandMode.setBackground(Color.WHITE);
        jbRandMode.setBorder(null);
        jbRandMode.setActionCommand(ConstantList.BTN_RANDOMTRACK);
        jpRandMode.setBackground(Color.WHITE);
        jpRandMode.add(jbRandMode);

        jpPrevSong = new JPanel();
        iiPrevSong = new ImageIcon("src/Icons/Playlist Library Screen/prev.png");
        jbPrevSong = new JButton(iiPrevSong);
        jbPrevSong.setBackground(Color.WHITE);
        jbPrevSong.setBorder(null);
        jbPrevSong.setText("id");
        jbPrevSong.setFont(new Font(jbPrevSong.getName(), Font.PLAIN, 1));
        jbPrevSong.setActionCommand(ConstantList.BTN_PREVTRACK);
        jpPrevSong.setBackground(Color.WHITE);
        jpPrevSong.add(jbPrevSong);

        jpPlayButton = new JPanel();
        iiPlayButton = new ImageIcon("src/Icons/Playlist Library Screen/play.png");
        iiPauseButton = new ImageIcon("src/Icons/Playlist Library Screen/pause.png");
        jbPlayButton = new JButton(iiPlayButton);
        jbPlayButton.setBackground(Color.WHITE);
        jbPlayButton.setBorder(null);
        jbPlayButton.setText("id");
        jbPlayButton.setFont(new Font(jbPlayButton.getName(), Font.PLAIN, 1));
        jbPlayButton.setActionCommand(ConstantList.BTN_PAUSETRACK);
        jpPlayButton.setBackground(Color.WHITE);
        jpPlayButton.add(jbPlayButton);

        jpNextSong = new JPanel();
        iiNextSong = new ImageIcon("src/Icons/Playlist Library Screen/next.png");
        jbNextSong = new JButton(iiNextSong);
        jbNextSong.setBackground(Color.WHITE);
        jbNextSong.setBorder(null);
        jbNextSong.setText("id");
        jbNextSong.setFont(new Font(jbNextSong.getName(), Font.PLAIN, 1));
        jbNextSong.setActionCommand(ConstantList.BTN_NEXTTRACK);
        jpNextSong.setBackground(Color.WHITE);
        jpNextSong.add(jbNextSong);

        jpLoopMode = new JPanel();
        iiLoopMode = new ImageIcon("src/Icons/Playlist Library Screen/loop.jpg");
        jbLoopMode = new JButton(iiLoopMode);
        jbLoopMode.setBackground(Color.WHITE);
        jbLoopMode.setBorder(null);
        jbLoopMode.setText("id");
        jbLoopMode.setFont(new Font(jbLoopMode.getName(), Font.PLAIN, 1));
        jbLoopMode.setActionCommand(ConstantList.BTN_LOOPTRACK);
        jpLoopMode.setBackground(Color.WHITE);
        jpLoopMode.add(jbLoopMode);

        jpPressMeButton = new JPanel();
        iiPressMeButton = new ImageIcon("src/Icons/Playlist Library Screen/press_me.png");
        jbPressMeButton = new JButton(iiPressMeButton);
        jbPressMeButton.setBackground(Color.WHITE);
        jbPressMeButton.setBorder(null);
        jbPressMeButton.setActionCommand(ConstantList.BTN_PRESSME);
        jpPressMeButton.setBackground(Color.WHITE);
        jpPressMeButton.add(jbPressMeButton);

        jpMediaPlayerOptionsTopGrid.add(jpTraining);
        jpTraining.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jpMediaPlayerOptionsTopGrid.add(jpRandMode);
        jpRandMode.setBorder(BorderFactory.createEmptyBorder(17, 0, 0, 0));
        jpMediaPlayerOptionsTopGrid.add(jpPrevSong);
        jpPrevSong.setBorder(BorderFactory.createEmptyBorder(22, 0, 0, 0));
        jpMediaPlayerOptionsTopGrid.add(jpPlayButton);
        jpPlayButton.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        jpMediaPlayerOptionsTopGrid.add(jpNextSong);
        jpNextSong.setBorder(BorderFactory.createEmptyBorder(23, 0, 0, 0));
        jpMediaPlayerOptionsTopGrid.add(jpLoopMode);
        jpLoopMode.setBorder(BorderFactory.createEmptyBorder(13, 0, 0, 0));
        jpMediaPlayerOptionsTopGrid.add(jpPressMeButton);
        jpPressMeButton.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 30));

        jpMediaPlayerOptions.add(jpMediaPlayerOptionsTopGrid);

        // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // /

        //JPanel jpVolumeSlider = new JPanel();
        jsVolumeSlider = new JSlider(JSlider.HORIZONTAL);
        jsVolumeSlider.setBackground(Color.WHITE);
        jsVolumeSlider.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        //framesPerSecond.addChangeListener(this);

        //Turn on labels at major tick marks.
        jsVolumeSlider.setMajorTickSpacing(20);
        jsVolumeSlider.setMinorTickSpacing(0);
        jsVolumeSlider.setPaintTicks(true);
        jsVolumeSlider.setPaintLabels(true);
        jsVolumeSlider.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // /

        jpSongPlayer.add(jpSongSelected);
        jpSongPlayer.add(jpMediaPlayerOptions);
        jpSongPlayer.add(jsVolumeSlider);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // ADDS ////////////////////////////////////////////////////////////////////////////////////////////////////////
        layoutSongs.add(jpCurrentPlaylist);
        jpCurrentPlaylist.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        layoutSongs.add(jpSongInfo);
        layoutSongs.add(jpSongsList);
        layoutSongs.add(jpSongPlayer);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        hamburger = new JButton(hamburger_icon);
        hamburger.setSize(100, 100);
        hamburger.setOpaque(false);
        hamburger.setBorder(null);
        hamburger.setContentAreaFilled(false);
        hamburger.setBorderPainted(false);
        hamburger.setActionCommand(ConstantList.BTN_HAMBURGUESA);
        hamburger.setFocusable(false);
        hamburgerpanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        hamburgerpanel.add(hamburger);
        hamburgerpanel.add(Box.createVerticalGlue());
        hamburgerpanel.setBackground(Color.WHITE);

        centerpanel.add(jlPlaylistHeader, BorderLayout.NORTH);
        centerpanel.add(layoutSongs, BorderLayout.CENTER);
        centerpanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 100));

        this.add(centerpanel, BorderLayout.CENTER);
        this.add(hamburgerpanel, BorderLayout.WEST);
    }

    /**
     * Method in charge of loading the songs using
     * the info. extracted from the playlist
     * previously obtained from the database
     * @param index Integer index used to obtain the
     *              exact song from the desired playlist
     */
    public void loadPlaylist(int index){
        jpSongsDetails.removeAll();

        playlist = plc.getPlaylist(index);

        songsList = plc.getSongsList(index);

        songs = plc.getSongs(songsList);

        songPanels = new ArrayList<>();
        for (Song s:songs) {
            songPanels.add(new SongPanel(s.getTitle(), s.getComposer(), 10, s.getRelease_date(), s.getID_song()));
        }

        for (SongPanel spl:songPanels) {
            spl.registerController(plc, cc);
            jpSongsDetails.add(spl.getPanel());
        }
        jpSongsDetails.add(Box.createVerticalGlue());

        jlTotalSongs.setText(songsList.size() + " song(s)");
        jlPlaylist.setText(playlist.getCopyright().substring(0, 1).toUpperCase() + playlist.getCopyright().substring(1) + " playlists - " + playlist.getName());

        jpSongsPane.getVerticalScrollBar().setValue(jpSongsPane.getVerticalScrollBar().getMinimum());
        jpSongsDetails.revalidate();
    }

    /**
     * Method in charge of selecting the track and setting it in selection
     * mode when playing it
     * @param id String of the id of the song
     */
    public void setTrack(String id){
        jbPrevSong.setText(id);
        jbPlayButton.setText(id);
        jbNextSong.setText(id);
        jbLoopMode.setText(id);
        initPause();
        try {
            jlSongTitle.setText(plc.getSong(Integer.parseInt(id)).getTitle());
            jlSongAuthorName.setText(plc.getSong(Integer.parseInt(id)).getComposer());
        } catch (SQLException | NumberFormatException throwables) {
            playPause();
            jlSongTitle.setText("");
            jlSongAuthorName.setText("");
        }
    }

    /**
     * Method in charge of initializing the Pausing process
     */
    public void initPause(){
        play = true;
        jbPlayButton.setIcon(iiPauseButton);
    }

    /**
     * Method in charge of playing or pausing the song selected
     */
    public void playPause(){
        if(!play){
            play = true;
            jbPlayButton.setIcon(iiPauseButton);
        } else {
            play = false;
            jbPlayButton.setIcon(iiPlayButton);
        }
        pm.playPause();
    }

    /**
     * Method in charge of looping the song selected
     */
    public void loop(){
        if(!loop){
            loop = true;
            jbLoopMode.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        } else {
            loop = false;
            jbLoopMode.setBorder(null);
        }
    }

    /**
     * Getter in charge of getting the songs list
     * @return ArrayList of Integer of number of songs
     */
    public ArrayList<Integer> getSongsList(){
        return songsList;
    }

    public int getDuration(int id){
        try {
            return plc.getSong(id).getDuration();
        } catch (SQLException throwables) {
            return 0;
        }
    }

    /**
     * Setter of Controllers
     * @param plc PlaylistController of the playlist management
     * @param cc CardController of the card controller
     */
    public void setController(PlaylistController plc, CardController cc){
        this.plc = plc;
        this.cc = cc;
    }

    /**
     * Method in charge of getting the name of the song being moved
     * @return String of the song being moved
     */
    public String getNameText(){
        return movesong.getNameText();
    }

    /**
     * Method in charge of allowing to display the
     * delete menu when clicking its button
     */
    public void deleteShow(){
        deletesong.sucessfulRefreshedPopUpShow();
    }

    /**
     * Method in charge of allowing to exit the
     * delete menu when clicking the close button
     */
    public void deleteExit(){
        deletesong.closePopUp();
    }

    /**
     * Method in charge of allowing to display the
     * move menu when clicking its button
     */
    public void moveShow(){
        movesong.changeSongPopUpShow();
    }

    /**
     * Method in charge of allowing to exit the
     * move menu when clicking the close button
     */
    public void moveExit(){
        movesong.closePopUp();
    }

    /**
     * Method in charge of allowing to display the
     * move menu when clicking its button
     */
    public void errorShow(){
        moveerror.errorShow();
    }

    /**
     * Method in charge of allowing to exit the
     * move menu when clicking the close button
     */
    public void errorExit(){
        moveerror.errorExit();
    }

    /**
     * Method in charge of linking both the controller to the
     * side menu's controller
     * @param pc ActionListener in charge of the Play Controller button interaction
     * @param cc ActionListener in charge of the Card Controller button interaction
     */
    public void registerController(ActionListener pc, ActionListener cc) {
        hamburger.addActionListener(pc);
        jbBack.addActionListener(pc);
        jbBack.addActionListener(cc);
        jbPlayButton.addActionListener(pc);
        jbPressMeButton.addActionListener(pc);
        jbPrevSong.addActionListener(pc);
        jbNextSong.addActionListener(pc);
        jbRandMode.addActionListener(pc);
        jbLoopMode.addActionListener(pc);
        jsVolumeSlider.addChangeListener((ChangeListener) pc);
        deletesong.registerController(pc);
        movesong.registerController(pc);
        moveerror.registerController(pc);
    }
}
