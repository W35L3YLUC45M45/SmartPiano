package Presentation.Views;

import Business.Entities.Song;
import Presentation.Controllers.StatisticsController;
import SupportClasses.ConstantList;
import SupportClasses.SideMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class in charge of everything related to the
 * statistics screen view when it comes
 * to the aesthetic of it.
 */
public class StatisticsView extends JPanel{

    private ImageIcon iiStatisticsHeader;
    private ImageIcon iiTopSongs;
    private ImageIcon iiSongsPlayed;
    private ImageIcon iiMinutesPlayed;
    private ImageIcon iiWhiteColumn;
    private ImageIcon iiWhiteRow;

    private JLabel jlStatisticsHeader;
    private JLabel jlTopSongs;
    private JLabel jlSongsPlayed;
    private JLabel jlMinutesPlayed;

    private JPanel biggerGeneralLayout;
    private JPanel generalLayout;
    private JPanel songsGraph;
    private JPanel minutesGraph;
    private JPanel topSongsLayout;
    private JPanel listOfSongs;
    private JPanel hamburgerpanel;

    private JButton hamburger;
    private ImageIcon hamburger_icon;
    private SideMenu sideMenu;

    private ArrayList<Song> songs;

    private StatisticsController sc;

    /**
     * Constructor/method in charge of building the aesthetic of the
     * statistics section
     */
    public StatisticsView(){

        hamburgerpanel = new JPanel();
        hamburgerpanel.setLayout(new BoxLayout(hamburgerpanel, BoxLayout.Y_AXIS));

        sideMenu = new SideMenu(ConstantList.GRAPHS);

        hamburger_icon = new ImageIcon("src/Icons/Main Menu Screen/grupo 12.jpg");

        hamburger = new JButton(hamburger_icon);
        hamburger.setSize(100, 100);
        hamburger.setOpaque(false);
        hamburger.setBorder(null);
        hamburger.setContentAreaFilled(false);
        hamburger.setBorderPainted(false);
        hamburger.setActionCommand(ConstantList.BTN_HAMBURGUESA);
        hamburgerpanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        hamburgerpanel.add(hamburger);
        hamburgerpanel.add(Box.createVerticalGlue());
        hamburgerpanel.setBackground(Color.WHITE);

        this.setLayout(new BorderLayout());

        iiStatisticsHeader = new ImageIcon("src/Icons/My Activity Screen/Grupo 259.png");
        iiWhiteColumn = new ImageIcon("src/Icons/My Activity Screen/white_column.png");
        iiWhiteRow = new ImageIcon("src/Icons/My Activity Screen/Rectángulo 255.png");
        iiTopSongs = new ImageIcon("src/Icons/My Activity Screen/Grupo 262.png");
        iiSongsPlayed = new ImageIcon("src/Icons/My Activity Screen/Imagen 2.png");
        iiMinutesPlayed = new ImageIcon("src/Icons/My Activity Screen/Imagen 3.png");

        jlStatisticsHeader = new JLabel(iiStatisticsHeader);
        jlTopSongs = new JLabel(iiTopSongs);
        jlSongsPlayed = new JLabel(iiSongsPlayed);
        jlMinutesPlayed = new JLabel(iiMinutesPlayed);

        generalLayout = new JPanel();
        generalLayout.setOpaque(true);
        generalLayout.setBackground(Color.WHITE);
        generalLayout.setForeground(Color.WHITE);
        generalLayout.setLayout(new BoxLayout(generalLayout, BoxLayout. X_AXIS));

        songsGraph = new JPanel();
        songsGraph.setOpaque(true);
        songsGraph.setBackground(Color.WHITE);
        songsGraph.setForeground(Color.WHITE);
        songsGraph.add(jlSongsPlayed);
        songsGraph.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        minutesGraph = new JPanel();
        minutesGraph.setOpaque(true);
        minutesGraph.setBackground(Color.WHITE);
        minutesGraph.setForeground(Color.WHITE);
        minutesGraph.add(jlMinutesPlayed);
        minutesGraph.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        topSongsLayout = new JPanel(new BorderLayout());
        topSongsLayout.setOpaque(true);
        topSongsLayout.setBackground((Color.WHITE));
        topSongsLayout.setAlignmentX(Component.LEFT_ALIGNMENT);
        topSongsLayout.add(jlTopSongs, BorderLayout.NORTH);

        listOfSongs = new JPanel();
        listOfSongs.setBackground(Color.WHITE);
        listOfSongs.setLayout(new BoxLayout(listOfSongs, BoxLayout.Y_AXIS));

        topSongsLayout.add(listOfSongs, BorderLayout.CENTER);

        generalLayout.add(songsGraph);
        generalLayout.add(songsGraph);
        generalLayout.add(minutesGraph);
        generalLayout.add(topSongsLayout);

        biggerGeneralLayout = new JPanel();
        biggerGeneralLayout.setOpaque(true);
        biggerGeneralLayout.setBackground(Color.WHITE);
        biggerGeneralLayout.setForeground(Color.WHITE);
        biggerGeneralLayout.setLayout(new BorderLayout());
        biggerGeneralLayout.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 100));

        biggerGeneralLayout.add(jlStatisticsHeader, BorderLayout.NORTH);
        biggerGeneralLayout.add(generalLayout, BorderLayout.CENTER);

        this.add(hamburgerpanel, BorderLayout.WEST);
        this.add(biggerGeneralLayout, BorderLayout.CENTER);
    }

    /**
     * Method in charge of setting the controller between
     * the Playlist's Controller and the Card's Controller
     * @param sc StaticticsController
     */
    public void setController(StatisticsController sc){
        this.sc = sc;
    }

    /**
     * Method used to get the songs from the database and order it by popularity, showing it in the view.
     */
    public void getPopularSongs(){
        listOfSongs.removeAll();
        songs = sc.getPopularSongs();
        for(int i = 0; i<5; i++){
            JLabel song = new JLabel((i+1) + ". " + songs.get(i).getTitle());
            song.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            song.setForeground(Color.GRAY);
            song.setOpaque(true);
            song.setBackground(Color.WHITE);
            song.setAlignmentX(Component.LEFT_ALIGNMENT);
            song.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
            listOfSongs.add(song);
        }
    }

    /**
     * Method in charge of showing the side menu pop up.
     */
    public void menuShow(){
        sideMenu.menuShow();
    }

    /**
     * Method in charge of exiting the side menu pop up through a button interaction.
     */
    public void menuExit(){
        sideMenu.menuExit();
    }

    /**
     * Method in charge of linking both the controller to the
     * side menu's controller
     * @param stc ActionListener
     * @param cc ActionListener
     */
    public void registerController(ActionListener stc, ActionListener cc) {
        hamburger.addActionListener(stc);
        sideMenu.registerController(stc, cc);
    }
}
