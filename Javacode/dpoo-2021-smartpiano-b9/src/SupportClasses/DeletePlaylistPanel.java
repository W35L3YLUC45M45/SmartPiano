package SupportClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class created specifically for the refresh panel
 * button in which its main goal is refreshing the songs
 * from the public playlist when we are performing
 * web scrapping.
 *
 * @author Group B9
 * @version ?
 * @since 2021-03-01
 */
public class DeletePlaylistPanel extends JPanel {

    private JPanel deletePlaylistPopUpPanel;
    private JDialog deletePlaylistPopUpDialog;

    private ImageIcon iiPopUpSuccessful;
    private JLabel jlPopUpSuccessful;

    private JPanel buttonpanels;
    private JButton jbyes;
    private JButton jbno;

    /**
     * Constructor which creates the previously mentioned
     * refresh panel aesthetically
     */
    public DeletePlaylistPanel(){
        iiPopUpSuccessful = new ImageIcon("src/Icons/Playlist Library Screen/Grupo 266.jpg");
        jlPopUpSuccessful = new JLabel(iiPopUpSuccessful);
        jlPopUpSuccessful.setAlignmentX(CENTER_ALIGNMENT);
        jlPopUpSuccessful.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));

        jbyes = new JButton(new ImageIcon("src/Icons/Playlist Library Screen/Grupo 262.png"));
        jbyes.setBorder(null);
        jbyes.setContentAreaFilled(false);
        jbyes.setBorderPainted(false);
        jbyes.setFocusable(false);
        jbyes.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 25));
        jbyes.setAlignmentX(CENTER_ALIGNMENT);
        jbyes.setActionCommand(ConstantList.DELETE_PLAYLIST_YES);

        jbno = new JButton(new ImageIcon("src/Icons/Playlist Library Screen/Grupo 263.png"));
        jbno.setBorder(null);
        jbno.setContentAreaFilled(false);
        jbno.setBorderPainted(false);
        jbno.setFocusable(false);
        jbno.setBorder(BorderFactory.createEmptyBorder(10, 25, 20, 0));
        jbno.setAlignmentX(CENTER_ALIGNMENT);
        jbno.setActionCommand(ConstantList.DELETE_PLAYLIST_NO);

        buttonpanels = new JPanel();
        buttonpanels.setLayout(new BoxLayout(buttonpanels, BoxLayout.X_AXIS));
        buttonpanels.setBackground(Color.WHITE);
        buttonpanels.add(jbyes);
        buttonpanels.add(jbno);

        deletePlaylistPopUpPanel = new JPanel();
        deletePlaylistPopUpPanel.setLayout(new BoxLayout(deletePlaylistPopUpPanel, BoxLayout.Y_AXIS));
        deletePlaylistPopUpPanel.setBackground(Color.WHITE);
        deletePlaylistPopUpPanel.add(jlPopUpSuccessful);
        deletePlaylistPopUpPanel.add(buttonpanels);
        deletePlaylistPopUpPanel.setFocusable(true);
        deletePlaylistPopUpPanel.requestFocusInWindow();
        deletePlaylistPopUpPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
    }

    /**
     * Method whose main purpose is to allow the
     * 'Refresh successfully' message to pop up
     * in a JDialog
     */
    public void sucessfulRefreshedPopUpShow(){
        deletePlaylistPopUpDialog = new JDialog();
        deletePlaylistPopUpDialog.setUndecorated(true);
        deletePlaylistPopUpDialog.add(deletePlaylistPopUpPanel);
        deletePlaylistPopUpDialog.pack();
        deletePlaylistPopUpDialog.setLocationRelativeTo(null);
        deletePlaylistPopUpDialog.setVisible(true);
    }

    /**
     * Method in charge of closing the refresh panel pop up
     * whenever the user feels like to close
     */
    public void closePopUp(){
        deletePlaylistPopUpDialog.dispose();
    }

    /**
     * Method in charge adding a listener to the close button
     * @param actionListener ActionListener to the 'Close' button
     */
    public void registerController(ActionListener actionListener){
        jbyes.addActionListener(actionListener);
        jbno.addActionListener(actionListener);
    }
}
