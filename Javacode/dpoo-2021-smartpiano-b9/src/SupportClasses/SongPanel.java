package SupportClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class created specifically for generating song
 * panels with a variety of components inside of them
 *
 * @author Group B9
 * @version ?
 * @since 2021-03-01
 */
public class SongPanel {
    private ImageIcon iiChangeFolder;
    private ImageIcon iiTrashCan;
    private ImageIcon iiSongFilePlayIcon;

    private JButton jbChangeFolder;
    private JButton jbTrashCan;
    private JButton jbSongFilePlayIcon;

    private JLabel jlSongFile;

    private JPanel jpChangeFolder;
    private JPanel jpTrashCan;

    private JPanel jbSongPanel;

    /**
     * Constructor in which the previously mentioned panels
     * contain JButtons, JLabels, etc...
     * @param songName String name of the song
     * @param authorName String author of the song
     * @param songDuration Integer number of minutes that
     *                     make up the duration of the song
     * @param registrationDate String date in which the song
     *                         was registered by the song's
     *                         author
     */
    public SongPanel (String songName, String authorName, Integer songDuration, String registrationDate, Integer id) {
        JPanel jpSongFileAndName = new JPanel();
        jpSongFileAndName.setLayout(new BoxLayout(jpSongFileAndName, BoxLayout.X_AXIS));
        jpSongFileAndName.setOpaque(true);
        jpSongFileAndName.setBackground(Color.WHITE);
        jpSongFileAndName.setForeground(Color.WHITE);

        iiSongFilePlayIcon = new ImageIcon("src/Icons/Playlist Library Screen/Grupo 254.png");
        jbSongFilePlayIcon = new JButton(iiSongFilePlayIcon);
        jbSongFilePlayIcon.setBackground(Color.WHITE);
        jbSongFilePlayIcon.setText(id.toString());
        jbSongFilePlayIcon.setFont(new Font(jbSongFilePlayIcon.getName(), Font.PLAIN, 1));
        jbSongFilePlayIcon.setActionCommand(ConstantList.BTN_PLAYTRACK);
        jbSongFilePlayIcon.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        jlSongFile = new JLabel(songName);
        jlSongFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlSongFile.setForeground(Color.GRAY);
        jlSongFile.setOpaque(true);
        jlSongFile.setBackground(Color.WHITE);

        jpSongFileAndName.add(jbSongFilePlayIcon);
        jpSongFileAndName.add(jlSongFile);

        JPanel jpAuthorInfo = new JPanel();
        JLabel jlAuthorInfo = new JLabel(authorName);
        jlAuthorInfo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlAuthorInfo.setForeground(Color.GRAY);
        jlAuthorInfo.setOpaque(true);
        jlAuthorInfo.setBackground(Color.WHITE);
        jlAuthorInfo.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jpAuthorInfo.add(jlAuthorInfo);
        jpAuthorInfo.setBackground(Color.WHITE);
        jpAuthorInfo.setForeground(Color.WHITE);

        JPanel jpDurationInfo = new JPanel();
        JLabel jlDurationInfo = new JLabel(songDuration.toString());
        jlDurationInfo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlDurationInfo.setForeground(Color.GRAY);
        jlDurationInfo.setOpaque(true);
        jlDurationInfo.setBackground(Color.WHITE);
        jlDurationInfo.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jpDurationInfo.add(jlDurationInfo);
        jpDurationInfo.setBackground(Color.WHITE);
        jpDurationInfo.setForeground(Color.WHITE);

        JPanel jpRegistrationDateInfo = new JPanel();
        JLabel jlRegistrationDateInfo = new JLabel(registrationDate);
        jlRegistrationDateInfo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlRegistrationDateInfo.setForeground(Color.GRAY);
        jlRegistrationDateInfo.setOpaque(true);
        jlRegistrationDateInfo.setBackground(Color.WHITE);
        jlRegistrationDateInfo.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jpRegistrationDateInfo.add(jlRegistrationDateInfo);
        jpRegistrationDateInfo.setBackground(Color.WHITE);
        jpRegistrationDateInfo.setForeground(Color.WHITE);

        JPanel jpSongOptionsGrid = new JPanel();
        jpSongOptionsGrid.setOpaque(true);
        jpSongOptionsGrid.setBackground(Color.WHITE);
        jpSongOptionsGrid.setForeground(Color.WHITE);
        jpSongOptionsGrid.setLayout(new GridLayout(1,2));

        jpChangeFolder = new JPanel();
        iiChangeFolder = new ImageIcon("src/Icons/Playlist Library Screen/Grupo 249.png");
        jbChangeFolder = new JButton(iiChangeFolder);
        jbChangeFolder.setBackground(Color.WHITE);
        jbChangeFolder.setBorder(null);
        jbChangeFolder.setText(id.toString());
        jbChangeFolder.setFont(new Font(jbSongFilePlayIcon.getName(), Font.PLAIN, 1));
        jbChangeFolder.setActionCommand(ConstantList.MOVE_SONG);
        jpChangeFolder.add(jbChangeFolder);

        jpTrashCan = new JPanel();
        iiTrashCan = new ImageIcon("src/Icons/Playlist Library Screen/Grupo 89.png");
        jbTrashCan = new JButton(iiTrashCan);
        jbTrashCan.setBackground(Color.WHITE);
        jbTrashCan.setBorder(null);
        jbTrashCan.setText(id.toString());
        jbTrashCan.setFont(new Font(jbSongFilePlayIcon.getName(), Font.PLAIN, 1));
        jbTrashCan.setActionCommand(ConstantList.DELETE_SONG);
        jpTrashCan.add(jbTrashCan);

        jpSongOptionsGrid.add(jbChangeFolder);
        jpSongOptionsGrid.add(jbTrashCan);

        jbSongPanel = new JPanel();
        jbSongPanel.setLayout(new GridLayout(1, 5));
        jbSongPanel.add(jpSongFileAndName);
        jbSongPanel.add(jpAuthorInfo);
        jbSongPanel.add(jpDurationInfo);
        jbSongPanel.add(jpRegistrationDateInfo);
        jbSongPanel.add(jpSongOptionsGrid);
        jbSongPanel.setMaximumSize(new Dimension(3000, 500));
    }

    /**
     * Getter that returns the custom panel previously mentioned
     * @return JPanel with all of the information previously passed
     */
    public JPanel getPanel(){
        return jbSongPanel;
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
        jbSongFilePlayIcon.addActionListener(pc);
        jbChangeFolder.addActionListener(pc);
        jbTrashCan.addActionListener(pc);
    }
}
