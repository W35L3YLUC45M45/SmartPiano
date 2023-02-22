package SupportClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Side menu.
 */
public class SideMenu {
    private int state;

    private JPanel sidemenu;
    private JPanel sidemenu_center;
    private JPanel home_logout;
    private JDialog menuDialog;

    private JButton closeSideMenu;
    private JLabel line;
    private JLabel line2;
    private JLabel line3;
    private JButton home;
    private JButton logout;
    private JButton play;
    private JButton training;
    private JButton settings;
    private JButton playlist;
    private JButton graph;
    private JButton short_logout;
    private JButton deleteAcc;
    private ImageIcon hamburger_icon_side;
    private ImageIcon line_icon_side;
    private ImageIcon home_icon_side;
    private ImageIcon logout_icon_side;
    private ImageIcon play_icon_side;
    private ImageIcon training_icon_side;
    private ImageIcon settings_icon_side;
    private ImageIcon playlist_icon_side;
    private ImageIcon graph_icon_side;
    private ImageIcon short_logout_icon_side;
    private ImageIcon delete_icon_side;

    /**
     * Instantiates a new Side menu.
     *
     * @param state the state
     */
    public SideMenu(int state) {
        sidemenu = new JPanel(new BorderLayout());
        sidemenu_center = new JPanel();
        sidemenu_center.setLayout(new BoxLayout(sidemenu_center, BoxLayout.Y_AXIS));
        home_logout = new JPanel();
        home_logout.setLayout(new FlowLayout());

        this.state = state;

        init();
    }

    /**
     * Method in charge the inicialization of the
     * whole side menu aesthetic
     */
    private void init() {
        hamburger_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/grupo 12.jpg");
        line_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/línea 22.jpg");
        home_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/grupo 55.jpg");
        logout_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/grupo 18.jpg");
        play_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/grupo 114.jpg");
        training_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/grupo 115.jpg");
        settings_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/grupo 118.jpg");
        playlist_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/grupo 189.jpg");
        graph_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/grupo 110.jpg");
        short_logout_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/grupo 20.jpg");
        delete_icon_side = new ImageIcon("src/Icons/Side Sub-Menu/grupo 19.jpg");

        closeSideMenu = new JButton(hamburger_icon_side);
        closeSideMenu.setPreferredSize(new Dimension(100, 100));
        closeSideMenu.setOpaque(false);
        closeSideMenu.setBorder(null);
        closeSideMenu.setContentAreaFilled(false);
        closeSideMenu.setBorderPainted(false);
        closeSideMenu.setActionCommand(ConstantList.BTN_CLOSEMENU);
        closeSideMenu.setFocusable(false);

        line = new JLabel(line_icon_side);
        line.setPreferredSize(new Dimension(300, 10));
        line.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        line.setAlignmentX(Component.CENTER_ALIGNMENT);

        home = new JButton(home_icon_side);
        home.setPreferredSize(new Dimension(250, 100));
        home.setAlignmentX(Component.CENTER_ALIGNMENT);
        home.setOpaque(false);
        home.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        home.setContentAreaFilled(false);
        home.setBorderPainted(false);
        home.setActionCommand(ConstantList.BTN_HOME);
        home.setFocusable(false);

        logout = new JButton(logout_icon_side);
        logout.setPreferredSize(new Dimension(250, 100));
        logout.setAlignmentX(Component.CENTER_ALIGNMENT);
        logout.setOpaque(false);
        logout.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        logout.setContentAreaFilled(false);
        logout.setBorderPainted(false);
        logout.setActionCommand(ConstantList.BTN_LOGOUT);
        logout.setFocusable(false);

        home_logout.setBackground(Color.WHITE);
        home_logout.add(home);
        home_logout.add(logout);

        line2 = new JLabel(line_icon_side);
        line2.setPreferredSize(new Dimension(300, 10));
        line2.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        line2.setAlignmentX(Component.CENTER_ALIGNMENT);

        play = new JButton(play_icon_side);
        play.setPreferredSize(new Dimension(500, 100));
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        play.setOpaque(false);
        play.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.setActionCommand(ConstantList.BTN_PLAY);
        play.setFocusable(false);

        training = new JButton(training_icon_side);
        training.setPreferredSize(new Dimension(500, 100));
        training.setAlignmentX(Component.CENTER_ALIGNMENT);
        training.setOpaque(false);
        training.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        training.setContentAreaFilled(false);
        training.setBorderPainted(false);
        training.setActionCommand(ConstantList.BTN_TRAINING);
        training.setFocusable(false);

        settings = new JButton(settings_icon_side);
        settings.setPreferredSize(new Dimension(500, 100));
        settings.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.setOpaque(false);
        settings.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        settings.setContentAreaFilled(false);
        settings.setBorderPainted(false);
        settings.setActionCommand(ConstantList.BTN_SETTINGS);
        settings.setFocusable(false);

        playlist = new JButton(playlist_icon_side);
        playlist.setPreferredSize(new Dimension(500, 100));
        playlist.setAlignmentX(Component.CENTER_ALIGNMENT);
        playlist.setOpaque(false);
        playlist.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        playlist.setContentAreaFilled(false);
        playlist.setBorderPainted(false);
        playlist.setActionCommand(ConstantList.BTN_PLAYLIST);
        playlist.setFocusable(false);

        graph = new JButton(graph_icon_side);
        graph.setPreferredSize(new Dimension(500, 100));
        graph.setAlignmentX(Component.CENTER_ALIGNMENT);
        graph.setOpaque(false);
        graph.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        graph.setContentAreaFilled(false);
        graph.setBorderPainted(false);
        graph.setActionCommand(ConstantList.BTN_GRAPHS);
        graph.setFocusable(false);

        line3 = new JLabel(line_icon_side);
        line3.setPreferredSize(new Dimension(300, 10));
        line3.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        line3.setAlignmentX(Component.CENTER_ALIGNMENT);

        short_logout = new JButton(short_logout_icon_side);
        short_logout.setPreferredSize(new Dimension(500, 100));
        short_logout.setAlignmentX(Component.CENTER_ALIGNMENT);
        short_logout.setOpaque(false);
        short_logout.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        short_logout.setContentAreaFilled(false);
        short_logout.setBorderPainted(false);
        short_logout.setActionCommand(ConstantList.BTN_LOGOUT);
        short_logout.setFocusable(false);

        deleteAcc = new JButton(delete_icon_side);
        deleteAcc.setPreferredSize(new Dimension(400, 100));
        deleteAcc.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteAcc.setOpaque(false);
        deleteAcc.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        deleteAcc.setContentAreaFilled(false);
        deleteAcc.setBorderPainted(false);
        deleteAcc.setFocusable(false);
        deleteAcc.setActionCommand(ConstantList.BTN_DELETEACC);

        sidemenu_center.setBackground(Color.WHITE);
        sidemenu_center.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25));
        sidemenu_center.add(line);
        switch (state){
            case ConstantList.HOME:
                sidemenu_center.add(short_logout);
                break;

            case ConstantList.TRAINING:
                sidemenu_center.add(home_logout);
                sidemenu_center.add(line2);
                sidemenu_center.add(play);
                sidemenu_center.add(settings);
                sidemenu_center.add(playlist);
                sidemenu_center.add(graph);
                sidemenu_center.add(line3);
                break;

            case ConstantList.SETTINGS:
                sidemenu_center.add(home_logout);
                sidemenu_center.add(line2);
                sidemenu_center.add(play);
                sidemenu_center.add(training);
                sidemenu_center.add(playlist);
                sidemenu_center.add(graph);
                sidemenu_center.add(line3);
                break;

            case ConstantList.PLAY:
                sidemenu_center.add(home_logout);
                sidemenu_center.add(line2);
                sidemenu_center.add(training);
                sidemenu_center.add(playlist);
                sidemenu_center.add(graph);
                sidemenu_center.add(settings);
                sidemenu_center.add(line3);
                break;

            case ConstantList.PLAYLIST:
                sidemenu_center.add(home_logout);
                sidemenu_center.add(line2);
                sidemenu_center.add(play);
                sidemenu_center.add(training);
                sidemenu_center.add(graph);
                sidemenu_center.add(settings);
                sidemenu_center.add(line3);
                break;
            case ConstantList.GRAPHS:
                sidemenu_center.add(home_logout);
                sidemenu_center.add(line2);
                sidemenu_center.add(play);
                sidemenu_center.add(training);
                sidemenu_center.add(playlist);
                sidemenu_center.add(settings);
                sidemenu_center.add(line3);
                break;
            default:
                break;
        }
        sidemenu_center.add(deleteAcc);

        sidemenu.setBackground(Color.WHITE);
        sidemenu.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        sidemenu.add(closeSideMenu, BorderLayout.NORTH);
        sidemenu.add(sidemenu_center, BorderLayout.CENTER);
    }

    /**
     * Menu show.
     */
    public void menuShow(){
        menuDialog = new JDialog();
        menuDialog.setUndecorated(true);
        menuDialog.add(sidemenu);
        menuDialog.setModal(true);
        menuDialog.pack();
        menuDialog.setLocationRelativeTo(null);
        menuDialog.setVisible(true);
    }

    /**
     * Menu exit.
     */
    public void menuExit(){
        menuDialog.dispose();
    }

    /**
     * Register controller.
     *
     * @param vc the vc
     * @param cc the cc
     */
    public void registerController(ActionListener vc, ActionListener cc) {
        closeSideMenu.addActionListener(vc);
        home.addActionListener(vc);
        home.addActionListener(cc);
        logout.addActionListener(vc);
        logout.addActionListener(cc);
        play.addActionListener(vc);
        play.addActionListener(cc);
        training.addActionListener(vc);
        training.addActionListener(cc);
        settings.addActionListener(vc);
        settings.addActionListener(cc);
        playlist.addActionListener(vc);
        playlist.addActionListener(cc);
        graph.addActionListener(vc);
        graph.addActionListener(cc);
        short_logout.addActionListener(vc);
        short_logout.addActionListener(cc);

        deleteAcc.addActionListener(vc);
        deleteAcc.addActionListener(cc);


    }
}
