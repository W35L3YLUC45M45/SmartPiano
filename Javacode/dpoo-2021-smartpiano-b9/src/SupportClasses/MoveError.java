package SupportClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class in charge of everything related to the
 * moving tracks error detection process.
 * The methods shown below are mainly related to
 * displaying errors, exiting, the display of specific
 * errors for them by creating new labels, etc...
 */
public class MoveError {

    private JDialog errorDialog;
    private JPanel errorpanel;

    private JLabel error;
    private JLabel label;
    private JLabel line;
    private JButton okbutton;


    private ImageIcon erroricon;
    private ImageIcon lineicon;
    private ImageIcon okicon;

    /**
     * Constructor in charge of generating the error panels
     * messaging with their respective images, labels, etc...
     */
    public MoveError(){
        erroricon = new ImageIcon("src/Icons/Playlist Library Screen/Grupo 276.png");
        error = new JLabel(erroricon);
        error.setPreferredSize(new Dimension(500, 100));
        error.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        error.setAlignmentX(Component.CENTER_ALIGNMENT);

        label = new JLabel("<html>There are no playlists with the name<br/>previously specified.<br/>Please introduce a valid playlist name.</html>", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(500, 150));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font(label.getName(), Font.PLAIN, 28));
        label.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        lineicon = new ImageIcon("src/Icons/Login-Error Screen/Login Error Line.jpg");
        line = new JLabel(lineicon);
        line.setPreferredSize(new Dimension(500, 10));
        line.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        line.setAlignmentX(Component.CENTER_ALIGNMENT);

        okicon = new ImageIcon("src/Icons/Login-Error Screen/Unión 7.jpg");
        okbutton = new JButton(okicon);
        okbutton.setPreferredSize(new Dimension(500, 60));
        okbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okbutton.setOpaque(false);
        okbutton.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        okbutton.setContentAreaFilled(false);
        okbutton.setBorderPainted(false);
        okbutton.setActionCommand(ConstantList.MOVE_SONG_OK);
        okbutton.setFocusable(false);
    }

    /**
     * Method in charge of managing the error display process
     */
    public void errorShow(){
        errorDialog = new JDialog();
        errorDialog.setUndecorated(true);
        errorpanel = new JPanel();
        errorpanel.setLayout(new BoxLayout(errorpanel, BoxLayout.Y_AXIS));
        errorpanel.setBackground(Color.WHITE);
        errorpanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        errorpanel.add(error);
        errorpanel.add(label);
        errorpanel.add(line);
        errorpanel.add(okbutton);
        errorDialog.add(errorpanel);
        errorDialog.setModal(true);
        errorDialog.pack();
        errorDialog.setLocationRelativeTo(null);
        errorDialog.setVisible(true);
    }

    /**
     * Method in charge of exiting the error message display tab
     */
    public void errorExit(){
        errorDialog.dispose();
    }

    /**
     * Method in charge of linking both the controller and the
     * error process when dealing with user resctrictions
     *
     * @param rlc ActionListener in charge of making sure that
     *            the process of error displaying through the use
     *            of buttons and keyboard typing, is responsive
     */
    public void registerController(ActionListener rlc) {
        okbutton.addActionListener(rlc);
    }
}
