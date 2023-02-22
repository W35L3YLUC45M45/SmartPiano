package SupportClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clas in charge of loading the pop up option
 * to save a track recorded by the user.
 */
public class SaveArrangement extends JPanel {

    private String[] status = { "Public", "Private" };

    private JComboBox cbStatus;

    private ImageIcon iiSaveArrHeader;
    private ImageIcon iiCancel;
    private ImageIcon iiSave;

    private JLabel jlSaveArrHeader;
    private JLabel jlStatus;

    private JButton jbCancel;
    private JButton jbSave;

    private JPanel savearrpanel;
    private JPanel savearrcenter;
    private JPanel bottomsavearrcenter;
    private JPanel cancelorsave;
    private JPanel statusLayout;
    private JPanel jpCbStatus;

    private JDialog saveArrDialog;

    private JTextFieldPanel arrengementNameTextField;

    /**
     * Class created specifically for the 'Save Arrengement'
     * panel button in which its main goal is to open a pop up
     * offering us to save a track we just created and
     * recorded ourselves, the user.
     *
     * @author Group B9
     * @version ?
     * @since 2021-03-01
     */
    public SaveArrangement(){
        savearrpanel = new JPanel();
        savearrpanel.setOpaque(true);
        savearrpanel.setBackground(Color.WHITE);
        savearrpanel.setForeground(Color.WHITE);
        savearrpanel.setLayout(new BorderLayout());

        iiSaveArrHeader = new ImageIcon("src/Icons/Play Screen/Save arrengement/Grupo_259.png");
        iiCancel = new ImageIcon("src/Icons/Play Screen/Save arrengement/Grupo 161.jpg");
        iiSave = new ImageIcon("src/Icons/Play Screen/Save arrengement/Grupo 160.jpg");

        jlSaveArrHeader = new JLabel(iiSaveArrHeader);
        jbCancel = new JButton(iiCancel);
        jbCancel.setBackground(Color.WHITE);
        jbCancel.setBorder(null);
        jbSave = new JButton(iiSave);
        jbSave.setBackground(Color.WHITE);
        jbSave.setBorder(null);

        jbSave.setActionCommand(ConstantList.SAVE_CLOSE_POPUP);
        jbCancel.setActionCommand(ConstantList.SAVE_CLOSE_POPUP);

        savearrcenter = new JPanel();
        savearrcenter.setOpaque(true);
        savearrcenter.setBackground(Color.WHITE);
        savearrcenter.setForeground(Color.WHITE);
        savearrcenter.setLayout(new BoxLayout(savearrcenter, BoxLayout.Y_AXIS));
        savearrcenter.setBorder(BorderFactory.createEmptyBorder(0, 25, 25, 25));

        arrengementNameTextField = new JTextFieldPanel("Name:");

        bottomsavearrcenter = new JPanel();
        bottomsavearrcenter.setOpaque(true);
        bottomsavearrcenter.setBackground(Color.WHITE);
        bottomsavearrcenter.setForeground(Color.WHITE);
        bottomsavearrcenter.setLayout(new BoxLayout(bottomsavearrcenter, BoxLayout.X_AXIS));

        statusLayout = new JPanel();
        statusLayout.setOpaque(true);
        statusLayout.setBackground(Color.WHITE);
        statusLayout.setForeground(Color.WHITE);
        statusLayout.setLayout(new BoxLayout(statusLayout, BoxLayout.X_AXIS));

        jlStatus = new JLabel("Status:");
        jlStatus.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        jlStatus.setForeground(Color.GRAY);
        jlStatus.setOpaque(true);
        jlStatus.setBackground(Color.WHITE);

        jpCbStatus = new JPanel();
        cbStatus = new JComboBox(status);
        cbStatus.setSelectedIndex(1);
        cbStatus.setBackground(Color.WHITE);
        cbStatus.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 25));
        jpCbStatus.add(cbStatus);

        statusLayout.add(jlStatus);
        statusLayout.add(cbStatus);

        cancelorsave = new JPanel();
        cancelorsave.setOpaque(true);
        cancelorsave.setBackground(Color.WHITE);
        cancelorsave.setForeground(Color.WHITE);
        cancelorsave.setLayout(new GridLayout(1,2));

        cancelorsave.add(jbCancel);
        cancelorsave.add(jbSave);

        bottomsavearrcenter.add(statusLayout);
        bottomsavearrcenter.add(cancelorsave);

        savearrcenter.add(arrengementNameTextField.getPanel());
        arrengementNameTextField.getPanel().setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        savearrcenter.add(bottomsavearrcenter);

        savearrpanel.add(jlSaveArrHeader ,BorderLayout.NORTH);
        savearrpanel.add(savearrcenter, BorderLayout.CENTER);
        savearrpanel.setFocusable(true);
        savearrpanel.requestFocusInWindow();
        savearrpanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
    }

    /**
     * Method whose main purpose is to allow the
     * 'Save Arrangement' pop up
     * in a JDialog with the option to choose
     * to save in a 'Private' or 'Public' status,
     * and the name of the song
     */
    public void saveArrangementPopUpShow(){
        saveArrDialog = new JDialog();
        saveArrDialog.setUndecorated(true);
        saveArrDialog.add(savearrpanel);
        saveArrDialog.pack();
        saveArrDialog.setLocationRelativeTo(null);
        saveArrDialog.setVisible(true);
    }

    /**
     * Closes the pop up
     */
    public void closePopUp(){
        saveArrDialog.dispose();
    }

    /**
     * Method in charge adding a listener to the save and cancel
     * buttons
     * @param actionListener ActionListener to the 'Save'
     *                       and 'Cancel' buttons
     */
    public void registerController(ActionListener actionListener){
        jbSave.addActionListener(actionListener);
        jbCancel.addActionListener(actionListener);
    }
}
