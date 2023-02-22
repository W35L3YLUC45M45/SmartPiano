package SupportClasses;

import javax.swing.*;
import java.awt.*;

/**
 * Class created specifically for generating playlist
 * title panels
 *
 * @author Group B9
 * @version ?
 * @since 2021-03-01
 */
public class PlaylistTitlePanel extends JPanel {

    private JPanel jpPlaylistPanel;

    private JLabel jlPlaylistName;
    private JPanel jpPlaylistName;

    private JLabel jlPlaylistNumOfSongs;
    private JPanel jpPlaylistNumOfSongs;

    private JLabel jlPlaylistDuration;
    private JPanel jpPlaylistDuration;

    private JLabel jlPlaylistIcon;
    private JPanel jpPlaylistIcon;

    private JLabel jlTrashCan;
    private JPanel jpTrashCan;

    /**
     * Constructor in which the previously mentioned title
     * panel contain all the JLabel titles that compose the
     * title header
     */
    public PlaylistTitlePanel (){
        jpPlaylistPanel = new JPanel();
        jpPlaylistPanel.setLayout(new GridLayout(1, 5));
        jpPlaylistPanel.setBackground(Color.WHITE);

        jpPlaylistIcon = new JPanel();
        jlPlaylistIcon = new JLabel("Go-to");
        jlPlaylistIcon.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jlPlaylistIcon.setForeground(Color.GRAY);
        jlPlaylistIcon.setOpaque(true);
        jlPlaylistIcon.setBackground(Color.WHITE);
        jlPlaylistIcon.setBorder(null);
        jpPlaylistIcon.setBackground(Color.WHITE);
        jpPlaylistIcon.add(jlPlaylistIcon);
        jpPlaylistIcon.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        jpPlaylistName = new JPanel();
        jlPlaylistName = new JLabel("Playlist name");
        jlPlaylistName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jlPlaylistName.setForeground(Color.GRAY);
        jlPlaylistName.setOpaque(true);
        jlPlaylistName.setBackground(Color.WHITE);
        jlPlaylistName.setBorder(null);
        jpPlaylistName.setBackground(Color.WHITE);
        jpPlaylistName.add(jlPlaylistName);
        jpPlaylistName.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        jpPlaylistNumOfSongs = new JPanel();
        jlPlaylistNumOfSongs = new JLabel("nº of songs");
        jlPlaylistNumOfSongs.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jlPlaylistNumOfSongs.setForeground(Color.GRAY);
        jlPlaylistNumOfSongs.setOpaque(true);
        jlPlaylistNumOfSongs.setBackground(Color.WHITE);
        jlPlaylistNumOfSongs.setBorder(null);
        jpPlaylistNumOfSongs.setBackground(Color.WHITE);
        jpPlaylistNumOfSongs.add(jlPlaylistNumOfSongs);
        jpPlaylistNumOfSongs.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        jpPlaylistDuration = new JPanel();
        jlPlaylistDuration = new JLabel("Total duration");
        jlPlaylistDuration.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jlPlaylistDuration.setForeground(Color.GRAY);
        jlPlaylistDuration.setOpaque(true);
        jlPlaylistDuration.setBackground(Color.WHITE);
        jlPlaylistDuration.setBorder(null);
        jpPlaylistDuration.setBackground(Color.WHITE);
        jpPlaylistDuration.add(jlPlaylistDuration);
        jpPlaylistDuration.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        jpTrashCan = new JPanel();
        jlTrashCan = new JLabel("Delete");
        jlTrashCan.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jlTrashCan.setForeground(Color.GRAY);
        jlTrashCan.setOpaque(true);
        jlTrashCan.setBackground(Color.WHITE);
        jlTrashCan.setBorder(null);
        jpTrashCan.setBackground(Color.WHITE);
        jpTrashCan.add(jlTrashCan);
        jpTrashCan.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        jpPlaylistPanel.add(jpPlaylistIcon);
        jpPlaylistPanel.add(jpPlaylistName);
        jpPlaylistPanel.add(jpPlaylistNumOfSongs);
        jpPlaylistPanel.add(jpPlaylistDuration);
        jpPlaylistPanel.add(jpTrashCan);
        jpPlaylistPanel.setMaximumSize(new Dimension(1000, 175));
    }

    /**
     * Getter that returns the title panel previously mentioned
     * @return JPanel with all of the information previously passed
     */
    public JPanel getPanel(){
        return jpPlaylistPanel;
    }
}
