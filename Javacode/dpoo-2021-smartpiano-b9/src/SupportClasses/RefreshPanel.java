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
public class RefreshPanel extends JPanel {

    private JPanel webScrappingPopUpPanel;
    private JDialog webScrappingPopUpDialog;

    private ImageIcon iiPopUpSuccessful;
    private JLabel jlPopUpSuccessful;
    private JButton jbClose;

    /**
     * Constructor which creates the previously mentioned
     * refresh panel aesthetically
     */
    public RefreshPanel (){
        iiPopUpSuccessful = new ImageIcon("src/Icons/Playlist Library Screen/Download songs/Grupo 261.png");
        jlPopUpSuccessful = new JLabel(iiPopUpSuccessful);
        jlPopUpSuccessful.setAlignmentX(CENTER_ALIGNMENT);

        jbClose = new JButton(new ImageIcon("src/Icons/Register-Error Screen/Unión 6.jpg"));
        jbClose.setBorder(null);
        jbClose.setContentAreaFilled(false);
        jbClose.setBorderPainted(false);
        jbClose.setFocusable(false);
        jbClose.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        jbClose.setAlignmentX(CENTER_ALIGNMENT);
        jbClose.setActionCommand(ConstantList.SAVE_CLOSE_POPUP);

        webScrappingPopUpPanel = new JPanel();
        webScrappingPopUpPanel.setLayout(new BoxLayout(webScrappingPopUpPanel, BoxLayout.Y_AXIS));
        webScrappingPopUpPanel.setBackground(Color.WHITE);
        webScrappingPopUpPanel.add(jlPopUpSuccessful);
        webScrappingPopUpPanel.add(jbClose);
        webScrappingPopUpPanel.setFocusable(true);
        webScrappingPopUpPanel.requestFocusInWindow();
        webScrappingPopUpPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
    }

    /**
     * Method whose main purpose is to allow the
     * 'Refresh successfully' message to pop up
     * in a JDialog
     */
    public void sucessfulRefreshedPopUpShow(){
        webScrappingPopUpDialog = new JDialog();
        webScrappingPopUpDialog.setUndecorated(true);
        webScrappingPopUpDialog.add(webScrappingPopUpPanel);
        webScrappingPopUpDialog.pack();
        webScrappingPopUpDialog.setLocationRelativeTo(null);
        webScrappingPopUpDialog.setVisible(true);
    }

    /**
     * Method in charge of closing the refresh panel pop up
     * whenever the user feels like to close
     */
    public void closePopUp(){
        webScrappingPopUpDialog.dispose();
    }

    /**
     * Method in charge adding a listener to the close button
     * @param actionListener ActionListener to the 'Close' button
     */
    public void registerController(ActionListener actionListener){
        jbClose.addActionListener(actionListener);
    }
}
