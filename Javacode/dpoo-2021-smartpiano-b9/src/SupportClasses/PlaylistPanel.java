package SupportClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class created specifically for generating playlist
 * panels with a variety of components inside of them
 *
 * @author Group B9
 * @version ?
 * @since 2021-03-01
 */
public class PlaylistPanel extends JPanel {

    private JPanel jpPlaylistPanel;

    private JLabel jlPlaylistName;
    private JPanel jpPlaylistName;

    private JLabel jlPlaylistNumOfSongs;
    private JPanel jpPlaylistNumOfSongs;

    private JLabel jlPlaylistDuration;
    private JPanel jpPlaylistDuration;

    private ImageIcon iiPlaylistIcon;
    private JButton jbPlaylistIcon;
    private JPanel jpPlaylistIcon;

    private ImageIcon iiTrashCan;
    private JButton jbTrashCan;
    private JPanel jpTrashCan;

    /**
     * Constructor in which the previously mentioned panels
     * contain JButtons, JLabels, etc...
     * @param playlistName String name of the playlist
     * @param playlistNumOfSongs Integer number of songs inside
     *                           the playlist previously commented
     * @param playlistDuration Integer total number of minutes
     *                         that compose a playlist based on the
     *                         timing of the song that it contains
     * @param id Integer playlist identification number
     */
    public PlaylistPanel (String playlistName, Integer playlistNumOfSongs, Integer playlistDuration, Integer id){
        jpPlaylistPanel = new JPanel();
        jpPlaylistPanel.setLayout(new GridLayout(1, 5));
        jpPlaylistPanel.setBackground(Color.WHITE);

        iiPlaylistIcon = new ImageIcon("src/Icons/Playlist Library Screen/Grupo 80.png");
        jbPlaylistIcon = new JButton(iiPlaylistIcon);
        jbPlaylistIcon.setText(id.toString());
        jbPlaylistIcon.setFont(new Font(jbPlaylistIcon.getName(), Font.PLAIN, 1));
        jbPlaylistIcon.setBorder(null);
        jbPlaylistIcon.setContentAreaFilled(false);
        jbPlaylistIcon.setBorderPainted(false);
        jbPlaylistIcon.setActionCommand(ConstantList.BTN_OPENPLAYLIST);
        jpPlaylistIcon = new JPanel();
        jpPlaylistIcon.setBackground(Color.WHITE);
        jpPlaylistIcon.setForeground(Color.WHITE);
        jpPlaylistIcon.add(jbPlaylistIcon);

        jpPlaylistName = new JPanel();
        jlPlaylistName = new JLabel(playlistName);
        jlPlaylistName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlPlaylistName.setForeground(Color.GRAY);
        jlPlaylistName.setOpaque(true);
        jlPlaylistName.setBackground(Color.WHITE);
        jlPlaylistName.setBorder(null);
        jpPlaylistName.setBackground(Color.WHITE);
        jpPlaylistName.add(jlPlaylistName);

        jpPlaylistNumOfSongs = new JPanel();
        jlPlaylistNumOfSongs = new JLabel(playlistNumOfSongs.toString());
        jlPlaylistNumOfSongs.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlPlaylistNumOfSongs.setForeground(Color.GRAY);
        jlPlaylistNumOfSongs.setOpaque(true);
        jlPlaylistNumOfSongs.setBackground(Color.WHITE);
        jlPlaylistNumOfSongs.setBorder(null);
        jpPlaylistNumOfSongs.setBackground(Color.WHITE);
        jpPlaylistNumOfSongs.add(jlPlaylistNumOfSongs);

        jpPlaylistDuration = new JPanel();
        jlPlaylistDuration = new JLabel(playlistDuration.toString());
        jlPlaylistDuration.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlPlaylistDuration.setForeground(Color.GRAY);
        jlPlaylistDuration.setOpaque(true);
        jlPlaylistDuration.setBackground(Color.WHITE);
        jlPlaylistDuration.setBorder(null);
        jpPlaylistDuration.setBackground(Color.WHITE);
        jpPlaylistDuration.add(jlPlaylistDuration);

        iiTrashCan = new ImageIcon("src/Icons/Playlist Library Screen/trash_can.jpg");
        jbTrashCan = new JButton(iiTrashCan);
        jbTrashCan.setBorder(null);
        jbTrashCan.setContentAreaFilled(false);
        jbTrashCan.setBorderPainted(false);
        jbTrashCan.setText(id.toString());
        jbTrashCan.setFont(new Font(jbTrashCan.getName(), Font.PLAIN, 1));
        jbTrashCan.setActionCommand(ConstantList.DELETE_PLAYLIST);
        jpTrashCan = new JPanel();
        jpTrashCan.setBackground(Color.WHITE);
        jpTrashCan.add(jbTrashCan);

        jpPlaylistPanel.add(jpPlaylistIcon);
        jpPlaylistPanel.add(jpPlaylistName);
        jpPlaylistPanel.add(jpPlaylistNumOfSongs);
        jpPlaylistPanel.add(jpPlaylistDuration);
        jpPlaylistPanel.add(jpTrashCan);
        jpPlaylistPanel.setMaximumSize(new Dimension(650, 500));
    }

    /**
     *
     * Getter that returns the custom panel previously mentioned
     * @return JPanel with all of the information previously passed
     */
    public JPanel getPanel(){
        return jpPlaylistPanel;
    }

    /**
     * Method in charge of linking both the controller and the
     * card controller
     * @param pc ActionListener in charge of making sure that
     *           the use of buttons and keyboard typing,
     *           is responsive
     * @param cc ActionListener in charge of making sure that
     *           the use of buttons and keyboard typing,
     *           is responsive
     */
    public void registerController(ActionListener pc, ActionListener cc) {
        jbPlaylistIcon.addActionListener(pc);
        jbPlaylistIcon.addActionListener(cc);
        jbTrashCan.addActionListener(pc);
    }
}
