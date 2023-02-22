package Presentation.Views;

import Business.ConfigDatabase.DatabaseManager;
import Business.Entities.Playlist;
import Business.UserModel;
import Presentation.Controllers.CardController;
import Presentation.Controllers.PlaylistController;
import SupportClasses.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.BorderFactory.createEmptyBorder;

/**
 * PlaylistView
 * Class in charge of everything related to the
 * playlist view screen aesthetically.
 */
public class PlaylistView extends JPanel {

    private ImageIcon iiRefresh;
    private ImageIcon iiCreate;
    private ImageIcon iiSongFilePlayIcon;
    private ImageIcon iiPlaylistHeader;
    private ImageIcon iiPrivatePlaylistIcon;
    private ImageIcon iiPublicPlaylistIcon;

    private JButton jbRefresh;
    private JButton jbCreate;

    private JLabel jlPlaylistHeader;
    private JLabel jlPublicPlaylistIcon;
    private JLabel jlPrivatePlaylistIcon;
    private JLabel jlPublicPlaylist;
    private JLabel jlPrivatePlaylist;
    private JLabel jlSongFile;

    private JPanel jpChangeFolder;
    private JPanel jpRefresh;
    private JPanel jpPlaylistHeader;
    private JPanel jpPrivatePlaylistIcon;
    private JPanel jpPublicPlaylistIcon;
    private JPanel jpPublicPlaylist;
    private JPanel jpPrivatePlaylist;
    private JPanel centerpanel;

    private JPanel layoutPlaylist;
    private JPanel headerPlaylist;
    private JPanel bodyPlaylist;
    private JPanel publicBodyPlaylist;
    private JPanel publicScrollPlaylist;
    private JPanel privateBodyPlaylist;
    private JPanel privateScrollPlaylist;

    private JScrollPane publicScrollPane;
    private JScrollPane privateScrollPane;

    private JButton hamburger;
    private ImageIcon hamburger_icon;
    private JPanel hamburgerpanel;
    private SideMenu sidemenu;
    private RefreshPanel refresh;
    private CreatePlaylist createPlaylist;
    private DeletePlaylistPanel deleteplaylist;

    private ArrayList<Playlist> publicPlaylists;
    private ArrayList<PlaylistPanel> publicPlaylistPanel;

    private ArrayList<Integer> privatePlaylistList;
    private ArrayList<Playlist> privatePlaylists;
    private ArrayList<PlaylistPanel> privatePlaylistPanel;

    private DatabaseManager dm;
    private UserModel um;
    private PlaylistController plc;
    private CardController cc;

    /////////////////////////////////////////////////

    /**
     * Constructor in charge of initializing the
     * view's layout, along with initializing the
     * view's whole process of aesthetic body development
     * @param dm DatabaseManager in charge of extracting
     *           the playlist's info from the database's info.
     * @param um UserModel model in charge of everything related
     *           to the user interacting with its account playlists
     */
    public PlaylistView(DatabaseManager dm, UserModel um) {
        //setSize(1920, 1080);
        this.dm = dm;
        this.um = um;
        this.setLayout(new BorderLayout());
        publicPlaylists = new ArrayList<>();
        sidemenu = new SideMenu(ConstantList.PLAYLIST);
        refresh = new RefreshPanel();
        createPlaylist = new CreatePlaylist();
        deleteplaylist = new DeletePlaylistPanel();
        init();
    }

    /**
     * Method in charge of building the whole view
     * from top to bottom with all of the components added into it
     */
    public void init(){
        // JPANEL // JPANEL // JPANEL //
        centerpanel = new JPanel(new BorderLayout());
        centerpanel.setBackground(Color.WHITE);

        jpChangeFolder = new JPanel();
        jpChangeFolder.setBackground(Color.WHITE);

        jpRefresh = new JPanel();
        jpRefresh.setBackground(Color.WHITE);
        jpRefresh.setBorder(new LineBorder(Color.BLACK, 1));


        jpPlaylistHeader = new JPanel();
        jpPlaylistHeader.setBackground(Color.WHITE);



        jpPublicPlaylist = new JPanel();
        jpPublicPlaylist.setBackground(Color.WHITE);

        jpPrivatePlaylist = new JPanel();
        jpPrivatePlaylist.setBackground(Color.WHITE);

        jpPublicPlaylistIcon = new JPanel();
        jpPublicPlaylistIcon.setBackground(Color.WHITE);

        jpPrivatePlaylistIcon = new JPanel();
        jpPrivatePlaylistIcon.setBackground(Color.WHITE);

        hamburgerpanel = new JPanel();
        hamburgerpanel.setLayout(new BoxLayout(hamburgerpanel, BoxLayout.Y_AXIS));

        // IMAGEICON // IMAGEICON // IMAGEICON //

        iiRefresh = new ImageIcon("src/Icons/Playlist Library Screen/refresh.png");
        iiCreate = new ImageIcon("src/Icons/Playlist Library Screen/create.jpg");
        iiSongFilePlayIcon = new ImageIcon("src/Icons/Playlist Library Screen/songfile_icon.jpg");
        iiPlaylistHeader = new ImageIcon("src/Icons/Playlist Library Screen/Grupo 250.png");
        iiPrivatePlaylistIcon = new ImageIcon("src/Icons/Playlist Library Screen/private_library.png");
        iiPublicPlaylistIcon = new ImageIcon("src/Icons/Playlist Library Screen/public_library.png");
        hamburger_icon = new ImageIcon("src/Icons/Main Menu Screen/grupo 12.jpg");

        // JLABEL // JLABEL // JLABEL //

        jlSongFile = new JLabel(iiSongFilePlayIcon);
        jlPlaylistHeader = new JLabel(iiPlaylistHeader);
        jlPrivatePlaylistIcon = new JLabel(iiPrivatePlaylistIcon);
        jlPublicPlaylistIcon = new JLabel(iiPublicPlaylistIcon);

        jlPublicPlaylist = new JLabel("Public PlayLists  -  " + "10" + " playlist(s)");
        jlPublicPlaylist.setFont(new Font("Segoe UI", Font.BOLD, 32));
        jlPublicPlaylist.setForeground(Color.GRAY);
        jlPublicPlaylist.setOpaque(true);
        jlPublicPlaylist.setBackground(Color.WHITE);

        jlPrivatePlaylist = new JLabel("Private PlayLists  -  " + "2" + " playlist(s)");
        jlPrivatePlaylist.setFont(new Font("Segoe UI", Font.BOLD, 32));
        jlPrivatePlaylist.setForeground(Color.GRAY);
        jlPrivatePlaylist.setOpaque(true);
        jlPrivatePlaylist.setBackground(Color.WHITE);


        // JBUTTON // JBUTTON // JBUTTON //

        jbRefresh = new JButton();
        jbRefresh.setIcon(iiRefresh);
        jbRefresh.setActionCommand(ConstantList.REFRESH);
        jbRefresh.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        jbRefresh.setContentAreaFilled(false);
        jbRefresh.setBorderPainted(false);

        jbCreate = new JButton();
        jbCreate.setIcon(iiCreate);
        jbCreate.setActionCommand(ConstantList.CREATE_PLAYLIST);
        jbCreate.setBorder(null);
        jbCreate.setContentAreaFilled(false);
        jbCreate.setBorderPainted(false);

        // JPANEL LAYOUT // JPANEL LAYOUT // JPANEL LAYOUT //

        layoutPlaylist = new JPanel();
        layoutPlaylist.setOpaque(true);
        layoutPlaylist.setBackground(Color.WHITE);
        layoutPlaylist.setForeground(Color.WHITE);
        layoutPlaylist.setLayout(new BoxLayout(layoutPlaylist, BoxLayout. Y_AXIS));
        layoutPlaylist.setBorder(new LineBorder(Color.BLACK));

        headerPlaylist = new JPanel();
        headerPlaylist.setOpaque(true);
        headerPlaylist.setBackground(Color.WHITE);
        headerPlaylist.setForeground(Color.WHITE);
        headerPlaylist.setLayout(new BoxLayout(headerPlaylist, BoxLayout.X_AXIS));
        headerPlaylist.setBorder(new LineBorder(Color.BLACK, 1));

        bodyPlaylist = new JPanel();
        bodyPlaylist.setOpaque(true);
        bodyPlaylist.setBackground(Color.WHITE);
        bodyPlaylist.setForeground(Color.WHITE);
        bodyPlaylist.setLayout(new GridLayout(1,2));
        bodyPlaylist.setBorder(new LineBorder(Color.BLACK));

        publicBodyPlaylist = new JPanel();
        publicBodyPlaylist.setLayout(new BoxLayout(publicBodyPlaylist, BoxLayout.Y_AXIS));
        publicBodyPlaylist.setBackground(Color.WHITE);

        publicScrollPlaylist = new JPanel();
        publicScrollPlaylist.setLayout(new BoxLayout(publicScrollPlaylist, BoxLayout.Y_AXIS));
        publicScrollPlaylist.setBackground(Color.WHITE);

        privateBodyPlaylist = new JPanel();
        privateBodyPlaylist.setLayout(new BoxLayout(privateBodyPlaylist, BoxLayout.Y_AXIS));
        privateBodyPlaylist.setBackground(Color.WHITE);

        privateScrollPlaylist = new JPanel();
        privateScrollPlaylist.setLayout(new BoxLayout(privateScrollPlaylist, BoxLayout.Y_AXIS));
        privateScrollPlaylist.setBackground(Color.WHITE);

        PlaylistTitlePanel publicTitlePanel = new PlaylistTitlePanel();
        publicBodyPlaylist.add(publicTitlePanel.getPanel());
        publicBodyPlaylist.add(publicScrollPlaylist);
        publicScrollPane = new JScrollPane(publicScrollPlaylist);
        publicScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));
        publicScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        publicBodyPlaylist.add(publicScrollPane);
        bodyPlaylist.add(publicBodyPlaylist);

        PlaylistTitlePanel privateTitlePanel = new PlaylistTitlePanel();
        privateBodyPlaylist.add(privateTitlePanel.getPanel());
        privateBodyPlaylist.add(privateScrollPlaylist);
        privateScrollPane = new JScrollPane(privateScrollPlaylist);
        privateScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));
        privateScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        privateBodyPlaylist.add(privateScrollPane);
        bodyPlaylist.add(privateBodyPlaylist);

        jpPublicPlaylist.add(jlPublicPlaylistIcon);
        jpPublicPlaylist.add(jlPublicPlaylist);
        jpPublicPlaylist.setBorder(createEmptyBorder(0, 20, 0, 20));
        jpPublicPlaylist.setMaximumSize(new Dimension(210, 1000));
        jpRefresh.add(jbRefresh);
        jpRefresh.add(jbCreate);
        jpPrivatePlaylist.add(jlPrivatePlaylistIcon);
        jpPrivatePlaylist.add(jlPrivatePlaylist);
        jpPrivatePlaylist.setBorder(createEmptyBorder(0, 20, 0, 20));
        jpPrivatePlaylist.setMaximumSize(new Dimension(225, 1000));

        headerPlaylist.add(jpPublicPlaylist);
        headerPlaylist.add(jpRefresh);
        headerPlaylist.add(jpPrivatePlaylist);

        layoutPlaylist.add(headerPlaylist);
        layoutPlaylist.add(bodyPlaylist);

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
        centerpanel.add(layoutPlaylist, BorderLayout.CENTER);
        centerpanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 100));

        this.add(centerpanel, BorderLayout.CENTER);
        this.add(hamburgerpanel, BorderLayout.WEST);
    }


    /**
     * Method in charge of loading the playlists using
     * the info. extracted from the database
     */
    public void loadPlaylists(){
        publicScrollPlaylist.removeAll();
        privateScrollPlaylist.removeAll();

        publicPlaylists = plc.getPublicPlaylists();
        publicPlaylistPanel = new ArrayList<>();
        for (Playlist p:publicPlaylists) {
            publicPlaylistPanel.add(new PlaylistPanel(p.getName(), plc.getPlaylistSize(p.getId()), 10, p.getId()));
        }

        for (PlaylistPanel ppl:publicPlaylistPanel) {
            ppl.registerController(plc, cc);
            publicScrollPlaylist.add(ppl.getPanel());
        }
        publicScrollPlaylist.add(Box.createVerticalGlue());
        jlPublicPlaylist.setText("Public PlayLists  -  " + publicPlaylists.size() + " playlist(s)");
        publicScrollPane.getVerticalScrollBar().setValue(publicScrollPane.getVerticalScrollBar().getMinimum());
        jlPublicPlaylist.revalidate();
        publicScrollPlaylist.revalidate();


        privatePlaylists = plc.getPrivatePlaylists();
        privatePlaylistPanel = new ArrayList<>();
        for (Playlist p:privatePlaylists) {
            privatePlaylistPanel.add(new PlaylistPanel(p.getName(), plc.getPlaylistSize(p.getId()), 10, p.getId()));
        }

        for (PlaylistPanel ppl:privatePlaylistPanel) {
            ppl.registerController(plc, cc);
            privateScrollPlaylist.add(ppl.getPanel());
        }
        privateScrollPlaylist.add(Box.createVerticalGlue());
        jlPrivatePlaylist.setText("Private PlayLists  -  " + privatePlaylists.size() + " playlist(s)");
        privateScrollPane.getVerticalScrollBar().setValue(privateScrollPane.getVerticalScrollBar().getMinimum());
        jlPrivatePlaylist.revalidate();
        privateScrollPlaylist.revalidate();
    }

    /**
     * Method in charge of getting the name of the playlist created
     * @return name of the playlist created
     */
    public String getNameText(){
        return createPlaylist.getNameText();
    }

    /**
     * Method in charge of getting the status (public or private) of the playlist
     * @return status of the playlist
     */
    public String getCopyright(){
        return createPlaylist.getCopyright();
    }

    /**
     * Method in charge of allowing to display the
     * side menu when clicking its button
     */
    public void menuShow(){
        sidemenu.menuShow();
    }

    /**
     * Method in charge o allowing to exit the
     * side menu when clicking the close button
     */
    public void menuExit(){
        sidemenu.menuExit();
    }

    /**
     * Method in charge of allowing to display the
     * refresh menu when clicking its button
     */
    public void refreshShow(){
        refresh.sucessfulRefreshedPopUpShow();
    }

    /**
     * Method in charge o allowing to exit the
     * refresh menu when clicking the close button
     */
    public void refreshExit(){
        refresh.closePopUp();
    }

    /**
     * Method in charge of allowing to display the
     * create menu when clicking its button
     */
    public void createShow(){
        createPlaylist.createPlaylistPopUpShow();
    }

    /**
     * Method in charge o allowing to exit the
     * create menu when clicking the close button
     */
    public void createExit(){
        createPlaylist.closePopUp();
    }

    /**
     * Method in charge of setting the controller between
     * the Playlist's Controller and the Card's Controller
     * @param plc PlaylistController
     * @param cc CardController
     */
    public void setController(PlaylistController plc, CardController cc){
        this.plc = plc;
        this.cc = cc;
    }

    /**
     * Method in charge of allowing to display the
     * delete menu when clicking its button
     */
    public void deleteShow(){
        deleteplaylist.sucessfulRefreshedPopUpShow();
    }

    /**
     * Method in charge of allowing to exit the
     * delete menu when clicking the close button
     */
    public void deleteExit(){
        deleteplaylist.closePopUp();
    }

    /**
     * Method in charge of linking both the controller to the
     * side menu's controller
     * @param pc ActionListener
     * @param cc ActionListener
     */
    public void registerController(ActionListener pc, ActionListener cc) {
        hamburger.addActionListener(pc);
        jbRefresh.addActionListener(pc);
        jbCreate.addActionListener(pc);
        sidemenu.registerController(pc, cc);
        refresh.registerController(pc);
        deleteplaylist.registerController(pc);
        createPlaylist.registerController(pc);
    }
}
