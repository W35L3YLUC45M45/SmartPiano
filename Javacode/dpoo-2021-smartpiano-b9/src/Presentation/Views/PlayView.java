package Presentation.Views;

import Presentation.Controllers.PianoController;
import SupportClasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * PlayView
 * Class in charge of everything related to the
 * play view screen aesthetically.
 */
public class PlayView extends JPanel{

    private final JPanel fullGamePanel;

    private SaveArrangement saveArrangement;

    private JPanel rightOptions;
    private JTextPane recTimer_TextPane;
    private Timer recordingTimer;

    private PianoController pianoController;

    private final int screen_x = 1412;
    private final int screen_y = 795;

    private JButton rec_button_btn;
    private JButton stop_rec_button_btn;

    private DrawableImage new_arrangement;
    private DrawableImage save_arrangement;
    private DrawableImage open_midi_file;
    private DrawableImage play_title;

    private JButton hamburger;
    private ImageIcon hamburger_icon;

    private JPanel title;
    private JPanel options;
    private Piano myPiano;

    private JPanel jP_center;
    private JPanel centerPanel;
    private JPanel hamburgerPanel;

    private SideMenu sideMenu;

    private int time = 0;

    private ArrayList<Integer> playedSequence;


    /**
     * Controller in charge of instantiating a new Play view.
     *
     * @param pianoController PianoController instance
     */
    public PlayView(PianoController pianoController) {

        this.pianoController = pianoController;
        saveArrangement = new SaveArrangement();

        fullGamePanel = new JPanel(new BorderLayout());

        sideMenu = new SideMenu(ConstantList.PLAY);

        buildGame();

        setBackground(Color.WHITE);
    }

    /**
     * Method in charge of building the game in terms of aesthetic
     */
    private void buildGame() {

        loadIcons();
        configureTitle();
        configureOptions();
        configureHamburger();

        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 100));
        centerPanel.setBackground(Color.WHITE);

        configureNorth();
        configureCenter();

        centerPanel.add(jP_center,BorderLayout.CENTER);

        fullGamePanel.add(centerPanel,BorderLayout.CENTER);

        configureSideMenu();
        fullGamePanel.add(hamburgerPanel,BorderLayout.WEST);

        //Adding all built View to the Frame
        this.setLayout(new BorderLayout());
        this.add(fullGamePanel, BorderLayout.CENTER);

    }

    /**
     * Method in charge of configuring the side menu aesthetic
     */
    private void configureSideMenu() {

        hamburgerPanel = new JPanel();
        hamburgerPanel.setLayout(new BoxLayout(hamburgerPanel, BoxLayout.Y_AXIS));
        hamburgerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        hamburgerPanel.add(hamburger);
        hamburgerPanel.add(Box.createVerticalGlue());
        hamburgerPanel.setBackground(Color.WHITE);

    }

    /**
     * Method in charge of configuring the North side of the general center panel
     */
    private void configureNorth() {
        centerPanel.add(title,BorderLayout.NORTH);
    }


    /**
     * Method in charge of configuring the Center side of the general center panel
     */
    private void configureCenter() {

        int panel_height = 240;
        jP_center = new JPanel();
        jP_center.setBackground(Color.WHITE);

        jP_center.add(options,BorderLayout.NORTH);

        JPanel fallingKeys = new JPanel();
        fallingKeys.setBackground(new Color(20, 146, 151));
        fallingKeys.setPreferredSize(new Dimension(1137,panel_height));
        jP_center.add(fallingKeys,BorderLayout.CENTER);

        myPiano = new Piano(pianoController);
        jP_center.add(myPiano.buildPiano(),BorderLayout.SOUTH);
        jP_center.setFocusable(true);

    }

    /**
     * Method in charge of configuring the title of the game
     */
    private void configureTitle(){
        // Main Title of game
        title = new JPanel();
        title.setOpaque(true);
        title.setBackground(Color.WHITE);
        title.setLayout(new BorderLayout());
        title.add(play_title, BorderLayout.NORTH);
    }

    /**
     * Method in charge of configuring the available piano options
     */
    private void configureOptions() {

        // Options from game
        options = new JPanel();
        options.setLayout(new BoxLayout(options, BoxLayout.X_AXIS));
        options.setBackground(Color.WHITE);

        JPanel leftSide = new JPanel(new BorderLayout());
        leftSide.setBackground(Color.WHITE);

        JPanel leftOptions = new JPanel();
        leftOptions.setLayout(new BoxLayout(leftOptions, BoxLayout.X_AXIS));
        leftOptions.setBackground(Color.WHITE);

        rightOptions = new JPanel();
        rightOptions.setLayout(new BoxLayout(rightOptions, BoxLayout.X_AXIS));
        rightOptions.setBackground(Color.WHITE);

        leftOptions.add(new_arrangement);
        leftOptions.add(open_midi_file);
        leftOptions.add(save_arrangement);

        leftOptions.setAlignmentY(SwingConstants.BOTTOM);
        leftSide.setAlignmentY(SwingConstants.BOTTOM);


        String[] songName = {"Riptide", "Vance Joy"};
        JTextPane songTitle = new JTextPane();
        songTitle.setEditable(false);
        songTitle.setText("Now playing " + songName[0] + " from: " + songName[1] );
        //songTitle.setAlignmentY(SwingConstants.BOTTOM);
        rightOptions.add(songTitle);

        recTimer_TextPane = new JTextPane();
        recTimer_TextPane.setText("00:00:00");
        recTimer_TextPane.setPreferredSize(new Dimension(60,20));
        recTimer_TextPane.setEditable(false);
        recTimer_TextPane.setBackground(new Color(0, 0, 0));
        recTimer_TextPane.setForeground(new Color(252, 251, 251));
        rightOptions.add(recTimer_TextPane);

        rightOptions.add(rec_button_btn);

        leftSide.add(leftOptions, BorderLayout.WEST);
        JPanel middle = new JPanel();
        middle.setBackground(Color.WHITE);
        leftSide.add(middle, BorderLayout.CENTER);
        leftSide.add(rightOptions, BorderLayout.EAST);


        options.setPreferredSize(new Dimension(1137,29));

        options.add(leftSide);
        options.setAlignmentY(SwingConstants.BOTTOM);

    }

    /**
     * Method in charge of configuring the hamburger icon on the side menu
     */
    private void configureHamburger() {

        //Side Menu
        hamburger = new JButton(hamburger_icon);
        hamburger.setSize(100, 100);
        hamburger.setOpaque(false);
        hamburger.setBorder(null);
        hamburger.setContentAreaFilled(false);
        hamburger.setBorderPainted(false);
        hamburger.setActionCommand(ConstantList.BTN_HAMBURGUESA);
        hamburger.setFocusable(false);

    }

    /**
     * Method in charge of loading the icons of the piano
     */
    private void loadIcons() {

        Dimension option_button_dim = new Dimension(132,29);
        Dimension rec_dimension = new Dimension(29,29);
        Dimension title_dimension = new Dimension(1134,184);

        new_arrangement = new DrawableImage("src/Icons/Piano UI/Other elements/Grupo 240.png");
        new_arrangement.setPreferredSize(option_button_dim);

        save_arrangement = new DrawableImage("src/Icons/Piano UI/Other elements/Grupo 241.png");
        save_arrangement.setPreferredSize(option_button_dim);

        open_midi_file = new DrawableImage("src/Icons/Piano UI/Other elements/Grupo 242.png");
        open_midi_file.setPreferredSize(option_button_dim);

        ImageIcon rec_button = scaleImage("src/Icons/Piano UI/Other elements/rec_Button.png", rec_dimension);
        rec_button_btn = new JButton(rec_button);
        rec_button_btn.setPreferredSize(rec_dimension);
        rec_button_btn.setFocusable(false);
        rec_button_btn.setActionCommand(ConstantList.START_RECORDING);


        ImageIcon stop_rec_button = scaleImage("src/Icons/Piano UI/Other elements/Stop_rec_Button.png", rec_dimension);

        stop_rec_button_btn = new JButton(stop_rec_button);
        stop_rec_button_btn.setPreferredSize(rec_dimension);
        stop_rec_button_btn.setFocusable(false);
        stop_rec_button_btn.setActionCommand(ConstantList.STOP_RECORDING);


        play_title = new DrawableImage("src/Icons/Piano UI/Other elements/Grupo 245.png");
        play_title.setPreferredSize(title_dimension);

        hamburger_icon = new ImageIcon("src/Icons/Main Menu Screen/grupo 12.jpg");

    }

    /**
     * Method in charge of scaling th instances of the images
     * @param source String image source
     * @param dimension Dimension desired of the image
     * @return ImageIcon rescaled
     */
    private ImageIcon scaleImage(String source, Dimension dimension) {
        // Get image
        ImageIcon resource = new ImageIcon(source);
        // Scale image
        Image image = resource.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);    // Scaled image
    }

    /**
     * Method in charge of setting the focus.
     */
    public void setFocus(){
        jP_center.requestFocus();
    }

    /**
     * Method in charge of showing the side menu pop up.
     */
    public void menuShow(){
        sideMenu.menuShow();
    }

    /**
     * Method in charge of closing the side menu pop up.
     */
    public void menuExit(){
        sideMenu.menuExit();
    }

    /**
     * Method in charge of showing the timer aesthetically in real time on the piano
     * @param time
     */
    public void showTimer(int time) {

        this.time += time;

        int hours = this.time / 3600;
        int minutes = (this.time % 3600) / 60;
        int seconds = this.time % 60;

        String s_hours =  (hours < 10 ? "0" : "") + hours;
        String s_minutes = (minutes < 10 ? "0" : "") + minutes;
        String s_seconds = (seconds < 10 ? "0" : "") + seconds;

        String text_Time = s_hours + ":" + s_minutes + ":" + s_seconds;

        recTimer_TextPane.setText(text_Time);

    }

    /**
     * Method in charge of switching the rec button to pause whenever
     * we click on that option
     * @param on boolean of the image being flipped or not
     */
    public void flipRecImage(boolean on) {

        if(on){
            rightOptions.remove(rec_button_btn);

            recTimer_TextPane.setBackground(new Color(255, 255, 255));
            recTimer_TextPane.setBorder(BorderFactory.createLineBorder(new Color(253, 1, 1),2));
            recTimer_TextPane.setForeground(new Color(1, 1, 1));

            recordingTimer.start();

            rightOptions.add(stop_rec_button_btn);

            revalidate();
        }

        if(!on){
            //rightOptions.remove(recTimer);
            rightOptions.remove(stop_rec_button_btn);
            rightOptions.remove(recTimer_TextPane);

            popUpSaving();

            recTimer_TextPane.setText("00:00:00");
            recTimer_TextPane.setBackground(new Color(0, 0, 0));
            recTimer_TextPane.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 2)));
            recTimer_TextPane.setForeground(new Color(255, 255, 255));

            this.time = 0;

            recordingTimer.stop();

            rightOptions.add(recTimer_TextPane);
            rightOptions.add(rec_button_btn);

            revalidate();
        }
    }

    /**
     * Method in charge of adding a key to progress for recordings.
     *
     * @param keyCode the key code
     */
    public void addKeyToProgress(int keyCode) {
    }


    /**
     * Method in charge of showing the pop up
     */
    public void popUpSaving() {
        saveArrangement.saveArrangementPopUpShow();
    }

    /**
     * Method in charge of closing the pop up
     */
    public void popUpDispose() {
        saveArrangement.closePopUp();
    }

    /**
     * Register controller of creating the interaction of
     * the controllers and action listeners.
     * @param actionListener in charge of the button interaction
     * @param pianoController in charge of the Piano Controller components interactions
     */
    public void registerController(ActionListener actionListener, PianoController pianoController, ActionListener cc){
        hamburger.addActionListener(actionListener);
        sideMenu.registerController(actionListener,cc);
        myPiano.registerController(actionListener, pianoController);
        jP_center.addKeyListener((KeyListener) actionListener);

        rec_button_btn.addActionListener(actionListener);
        stop_rec_button_btn.addActionListener(actionListener);

        recordingTimer = new Timer(1000, actionListener);
        recordingTimer.setActionCommand(ConstantList.AUTO_TIMER);

        saveArrangement.registerController(actionListener);
    }
}
