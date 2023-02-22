package SupportClasses;

import Business.LoginException;
import Business.RegisterException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class in charge of everything related to the
 * user login/sign up error detection process.
 * The methods shown below are mainly related to
 * displaying errors, exiting, the display of specific
 * errors for them by creating new labels, etc...
 *
 * @author Group B9
 * @version ?
 * @since 2021 -03-01
 */
public class RegisterLoginError {

    private JDialog errorDialog;
    private JPanel errorpanel;

    private JLabel loginerror;
    private JLabel registererror;
    private JLabel line;
    private JButton okbutton;


    private ImageIcon loginerroricon;
    private ImageIcon registererroricon;
    private ImageIcon lineicon;
    private ImageIcon okicon;

    /**
     * Constructor in charge of generating the error panels
     * messaging with their respective images, labels, etc...
     */
    public RegisterLoginError(){
        loginerroricon = new ImageIcon("src/Icons/Login-Error Screen/Grupo 223.jpg");
        loginerror = new JLabel(loginerroricon);
        loginerror.setPreferredSize(new Dimension(300, 100));
        loginerror.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        loginerror.setAlignmentX(Component.CENTER_ALIGNMENT);

        registererroricon = new ImageIcon("src/Icons/Login-Error Screen/Grupo 224.jpg");
        registererror = new JLabel(registererroricon);
        registererror.setPreferredSize(new Dimension(300, 100));
        registererror.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        registererror.setAlignmentX(Component.CENTER_ALIGNMENT);

        lineicon = new ImageIcon("src/Icons/Login-Error Screen/Login Error Line.jpg");
        line = new JLabel(lineicon);
        line.setPreferredSize(new Dimension(300, 10));
        line.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        line.setAlignmentX(Component.CENTER_ALIGNMENT);

        okicon = new ImageIcon("src/Icons/Login-Error Screen/Unión 7.jpg");
        okbutton = new JButton(okicon);
        okbutton.setPreferredSize(new Dimension(500, 60));
        okbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okbutton.setOpaque(false);
        okbutton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        okbutton.setContentAreaFilled(false);
        okbutton.setBorderPainted(false);
        okbutton.setActionCommand(ConstantList.BTN_CLOSEMENU);
        okbutton.setFocusable(false);
    }

    /**
     * Method in charge of generating error message labels
     * depending on what type of error the user just ended up with
     *
     * @param inputtext String custom error message to display
     * @return JLabel label generated with the custom word in it
     */
    public JLabel createNewJLabel(String inputtext){
        JLabel label = new JLabel(inputtext);
        label.setPreferredSize(new Dimension(700, 50));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font(label.getName(), Font.PLAIN, 28));
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return label;
    }

    /**
     * Method in charge of managing the error display process
     *
     * @param state   int related to if the user is signing up
     *                or logging in his/her account
     * @param allgood boolean[] in charge of displaying a different
     *                error message depending on the type of
     *                registering/logging restrictions imposed
     *                by the program
     */
    public void errorShow(int state, boolean[] allgood){
        errorDialog = new JDialog();
        errorDialog.setUndecorated(true);
        errorpanel = new JPanel();
        errorpanel.setLayout(new BoxLayout(errorpanel, BoxLayout.Y_AXIS));
        errorpanel.setBackground(Color.WHITE);
        errorpanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        switch (state){
            case 0:
                errorpanel.add(loginerror);
                if (!allgood[0]) errorpanel.add(createNewJLabel(LoginException.EMAIL_ERROR));
                if (!allgood[1]) errorpanel.add(createNewJLabel(LoginException.PASSWORD_ERROR));
                break;
            case 1:
                errorpanel.add(registererror);
                if (!allgood[0]) errorpanel.add(createNewJLabel(RegisterException.USER_EXIST_ERROR));
                if (!allgood[1]) errorpanel.add(createNewJLabel(RegisterException.EMAIL_ERROR));
                if (!allgood[2]) errorpanel.add(createNewJLabel(RegisterException.EMAIL_EXIST_ERROR));
                if (!allgood[3]) errorpanel.add(createNewJLabel(RegisterException.DIGIT_ERROR));
                if (!allgood[4]) errorpanel.add(createNewJLabel(RegisterException.CAPS_ERROR));
                if (!allgood[5]) errorpanel.add(createNewJLabel(RegisterException.LOWER_ERROR));
                if (!allgood[6]) errorpanel.add(createNewJLabel(RegisterException.SYMBOL_ERROR));
                if (!allgood[7]) errorpanel.add(createNewJLabel(RegisterException.LENGTH_ERROR));
                if (!allgood[8]) errorpanel.add(createNewJLabel(RegisterException.REPEAT_ERROR));
                break;
        }
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
