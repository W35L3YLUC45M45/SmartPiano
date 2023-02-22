package Presentation.Views;

import SupportClasses.ConstantList;
import SupportClasses.JPasswordFieldPanel;
import SupportClasses.JTextFieldPanel;
import SupportClasses.RegisterLoginError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * RegisterLoginView
 * Class in charge of everything related to the
 * user login/sign up screen view when it comes
 * to the aesthetic of it.
 */
public class RegisterLoginView extends JPanel {

    private JTextFieldPanel userRegisterBL;
    private JTextFieldPanel emailRegisterBL;
    private JPasswordFieldPanel passwordRegisterBL;
    private JPasswordFieldPanel confirmPasswordRegisterBL;
    private JTextFieldPanel userLoginBL;
    private JPasswordFieldPanel passwordLoginBL;

    private JButton arrowLoginButton;
    private JButton arrowRegisterButton;

    private RegisterLoginError error;

    /**
     * Constructor in charge of initializing the
     * view's layout and the error management process
     * of the RegisterLoginError class, along with
     * initializing the view's whole process of aesthetic
     * body development
     */
    public RegisterLoginView(){
        this.setLayout(new BorderLayout());

        error = new RegisterLoginError();

        init();
    }

    /**
     * Method in charge of building the whole view
     * from top to bottom with all of the components added into it
     */
    public void init() {

        ImageIcon smartpiano_logo = new ImageIcon("src/Icons/Register&Login/Logo2.png");
        JLabel jlNorth = new JLabel(smartpiano_logo);

        ImageIcon white_bar1 = new ImageIcon("src/Icons/Register&Login/Rectángulo 100.png");
        JLabel jbWest = new JLabel(white_bar1);

        ImageIcon white_bar2 = new ImageIcon("src/Icons/Register&Login/Rectángulo 100.png");
        JLabel jbEast = new JLabel(white_bar2);

        ImageIcon white_bar3 = new ImageIcon("src/Icons/Register&Login/Rectángulo 182.png");
        JLabel jlSouth = new JLabel(white_bar3);

        ImageIcon register = new ImageIcon("src/Icons/Register&Login/register.png");
        ImageIcon login = new ImageIcon("src/Icons/Register&Login/login.png");
        ImageIcon arrowRegister = new ImageIcon("src/Icons/Register&Login/arrow.png");
        ImageIcon arrowLogin = new ImageIcon("src/Icons/Register&Login/arrow.png");
        JLabel registerLabel = new JLabel(register);
        JLabel loginLabel = new JLabel(login);


        // BorderLayout para Label de Register
        JPanel registerLabelBL = new JPanel(new BorderLayout());
        registerLabelBL.setSize(new Dimension(300, 100));
        registerLabelBL.setMaximumSize(new Dimension(6000, 100));
        registerLabelBL.setForeground(Color.WHITE);
        registerLabelBL.setBackground(Color.WHITE);
        registerLabelBL.add(registerLabel, BorderLayout.NORTH);

        // BorderLayout para Label de Login
        JPanel loginLabelBL = new JPanel(new BorderLayout());
        loginLabelBL.setSize(new Dimension(300, 100));
        loginLabelBL.setMaximumSize(new Dimension(6000, 100));
        loginLabelBL.setForeground(Color.WHITE);
        loginLabelBL.setBackground(Color.WHITE);
        loginLabelBL.add(loginLabel, BorderLayout.NORTH);

        // BorderLayout para Label de Arrow Register
        JPanel arrowRegisterButtonBL = new JPanel(new BorderLayout());
        arrowRegisterButtonBL.setSize(new Dimension(300, 100));
        arrowRegisterButtonBL.setMaximumSize(new Dimension(6000, 100));
        arrowRegisterButtonBL.setForeground(Color.WHITE);
        arrowRegisterButtonBL.setBackground(Color.WHITE);
        arrowRegisterButton = new JButton(arrowRegister);
        arrowRegisterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        arrowRegisterButton.setOpaque(false);
        arrowRegisterButton.setContentAreaFilled(false);
        arrowRegisterButton.setBorderPainted(false);
        arrowRegisterButton.setActionCommand(ConstantList.BTN_REGISTER);
        arrowRegisterButtonBL.add(arrowRegisterButton, BorderLayout.CENTER);

        // BorderLayout para Label de Arrow Login
        JPanel arrowLoginButtonBL = new JPanel(new BorderLayout());
        arrowLoginButtonBL.setSize(new Dimension(300, 100));
        arrowLoginButtonBL.setMaximumSize(new Dimension(6000, 100));
        arrowLoginButtonBL.setForeground(Color.WHITE);
        arrowLoginButtonBL.setBackground(Color.WHITE);
        arrowLoginButton = new JButton(arrowLogin);
        arrowLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        arrowLoginButton.setOpaque(false);
        arrowLoginButton.setContentAreaFilled(false);
        arrowLoginButton.setBorderPainted(false);
        arrowLoginButton.setActionCommand(ConstantList.BTN_LOGIN);
        arrowLoginButtonBL.add(arrowLoginButton, BorderLayout.CENTER);


        // BorderLayout para Label de Login
        JPanel whiteSpaceBL = new JPanel(new BorderLayout());
        whiteSpaceBL.setSize(new Dimension(300, 100));
        whiteSpaceBL.setMaximumSize(new Dimension(6000, 100));
        whiteSpaceBL.setForeground(Color.WHITE);
        whiteSpaceBL.setBackground(Color.WHITE);

        ///////////////////////////////////////////////////////////////////////////////////////

        // BorderLayout para Blank Space
        JPanel blankSpaceBL = new JPanel(new BorderLayout());
        blankSpaceBL.setSize(new Dimension(300, 100));
        blankSpaceBL.setMaximumSize(new Dimension(6000, 100));
        blankSpaceBL.setForeground(Color.WHITE);
        blankSpaceBL.setBackground(Color.WHITE);

        // TextField de Blank Space
        JTextField blankSpaceTextField = new JTextField();
        blankSpaceTextField.setFont(new Font("Consolas", Font.PLAIN, 20));
        blankSpaceTextField.setMaximumSize(blankSpaceTextField.getPreferredSize());
        blankSpaceTextField.setEditable(false);
        blankSpaceTextField.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF")));
        blankSpaceTextField.setBackground(Color.WHITE);
        blankSpaceTextField.setForeground(Color.WHITE);

        // Label de Blank Space
        JLabel blankSpaceLabel = new JLabel(" ");
        blankSpaceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        blankSpaceLabel.setForeground(Color.GRAY);
        blankSpaceLabel.setOpaque(true);
        blankSpaceLabel.setBackground(Color.WHITE);
        blankSpaceLabel.setBorder(null);
        blankSpaceLabel.setLabelFor(blankSpaceTextField);

        // Adición de Label y Textfield de Blank Space a diferentes BorderLayout's
        blankSpaceBL.add(blankSpaceLabel, BorderLayout.NORTH);
        blankSpaceBL.add(blankSpaceTextField, BorderLayout.CENTER);

        // BorderLayout para Blank Space 2
        JPanel blankSpace2BL = new JPanel(new BorderLayout());
        blankSpace2BL.setSize(new Dimension(300, 100));
        blankSpace2BL.setMaximumSize(new Dimension(6000, 100));
        blankSpace2BL.setForeground(Color.WHITE);
        blankSpace2BL.setBackground(Color.WHITE);

        // TextField de Blank Space 2
        JTextField blankSpace2TextField = new JTextField();
        blankSpace2TextField.setFont(new Font("Consolas", Font.PLAIN, 20));
        blankSpace2TextField.setMaximumSize(blankSpace2TextField.getPreferredSize());
        blankSpace2TextField.setEditable(false);
        blankSpace2TextField.setBackground(Color.WHITE);
        blankSpace2TextField.setForeground(Color.WHITE);
        blankSpace2TextField.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF")));

        // Label de Blank Space 2
        JLabel blankSpace2Label = new JLabel(" ");
        blankSpace2Label.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        blankSpace2Label.setForeground(Color.GRAY);
        blankSpace2Label.setOpaque(true);
        blankSpace2Label.setBackground(Color.WHITE);
        blankSpace2Label.setBorder(null);
        blankSpace2Label.setLabelFor(blankSpace2TextField);

        // Adición de Label y Textfield de Blank Space 2 a diferentes BorderLayout's
        blankSpace2BL.add(blankSpace2Label, BorderLayout.NORTH);
        blankSpace2BL.add(blankSpace2TextField, BorderLayout.CENTER);

        ///////////////////////////////////////////////////////////////////////////////////////

        // Register Form

        // BorderLayout para Register User
        userRegisterBL = new JTextFieldPanel("Username");

        ///////////////////////////////////////////////////////////////////////////////////////

        // BorderLayout para Register Email
        emailRegisterBL = new JTextFieldPanel("Email");

        ///////////////////////////////////////////////////////////////////////////////////////

        // BorderLayout para Register Password
        passwordRegisterBL = new JPasswordFieldPanel("Password");

        ///////////////////////////////////////////////////////////////////////////////////////

        // BorderLayout para Register confirmPassword
        confirmPasswordRegisterBL = new JPasswordFieldPanel("Confirm password");

        ///////////////////////////////////////////////////////////////////////////////////////


        //Login Form

        // BorderLayout para Login User
        userLoginBL = new JTextFieldPanel("Username");

        ///////////////////////////////////////////////////////////////////////////////////////

        // BorderLayout para Login Password
        passwordLoginBL = new JPasswordFieldPanel("Password");

        ///////////////////////////////////////////////////////////////////////////////////////


        //Organización de ambos formularios

        JPanel form = new JPanel();
        form.setOpaque(true);
        form.setBackground(Color.WHITE);
        form.setLayout(new BoxLayout(form, BoxLayout.X_AXIS));

        JPanel infoRegister = new JPanel();
        infoRegister.setAlignmentY(TOP_ALIGNMENT);
        infoRegister.setOpaque(true);
        infoRegister.setBackground(Color.WHITE);
        infoRegister.setLayout(new BoxLayout(infoRegister, BoxLayout.Y_AXIS));

        JPanel infoLogin = new JPanel();
        infoLogin.setAlignmentY(TOP_ALIGNMENT);
        infoLogin.setOpaque(true);
        infoLogin.setBackground(Color.WHITE);
        infoLogin.setLayout(new BoxLayout(infoLogin, BoxLayout.Y_AXIS));

        form.add(infoRegister);
        form.add(Box.createRigidArea(new Dimension(50,0)));
        form.add(infoLogin);

        infoRegister.add(registerLabelBL);
        infoRegister.add(Box.createRigidArea(new Dimension(0,10)));
        infoRegister.add(userRegisterBL.getPanel());
        infoRegister.add(Box.createRigidArea(new Dimension(0,20)));
        infoRegister.add(emailRegisterBL.getPanel());
        infoRegister.add(Box.createRigidArea(new Dimension(0,20)));
        infoRegister.add(passwordRegisterBL.getPanel());
        infoRegister.add(Box.createRigidArea(new Dimension(0,20)));
        infoRegister.add(confirmPasswordRegisterBL.getPanel());
        infoRegister.add(Box.createRigidArea(new Dimension(0,20)));
        infoRegister.add(arrowRegisterButtonBL);

        infoLogin.add(loginLabelBL);
        infoLogin.add(Box.createRigidArea(new Dimension(0,10)));
        infoLogin.add(userLoginBL.getPanel());
        infoLogin.add(Box.createRigidArea(new Dimension(0,20)));
        infoLogin.add(passwordLoginBL.getPanel());
        infoLogin.add(Box.createRigidArea(new Dimension(0,20)));
        infoLogin.add(arrowLoginButtonBL);
        infoLogin.add(Box.createRigidArea(new Dimension(0,20)));
        infoLogin.add(blankSpaceBL);
        infoLogin.add(Box.createRigidArea(new Dimension(0,25)));
        infoLogin.add(blankSpace2BL);

        this.add(jlNorth, BorderLayout.NORTH);
        this.add(jbWest, BorderLayout.WEST);
        this.add(form, BorderLayout.CENTER);
        this.add(jbEast, BorderLayout.EAST);
        this.add(jlSouth, BorderLayout.SOUTH);
    }

    /**
     * Getter in charge of gathering the Login info typed
     * by the user so it can be displayed eventually or
     * revised to see if it has any errors
     * @return String[] that ends up later in a
     *         function meant to manage the Login of any User.
     *         It will ask for Email and password and validate both.
     */
    public String[] getLoginInfo(){
        String[] logininput = new String[2];
        logininput[0] = userLoginBL.getText();
        logininput[1] = passwordLoginBL.getText();
        return logininput;
    }

    /**
     * Getter in charge of gathering the Login info typed
     * by the user so it can be displayed eventually or
     * revised to see if it has any errors
     * @return String[] that ends up later in a
     *         function meant to manage the Register of any User.
     *         It will ask for many details and validate them.
     */
    public String[] getRegisterInfo(){
        String[] registerinput = new String[4];
        registerinput[0] = userRegisterBL.getText();
        registerinput[1] = emailRegisterBL.getText();
        registerinput[2] = passwordRegisterBL.getText();
        registerinput[3] = confirmPasswordRegisterBL.getText();
        return registerinput;
    }

    /**
     * Method in charge of resettig all the Login info
     */
    public void resetLoginInfo(){
        userLoginBL.resetText();
        passwordLoginBL.resetText();
    }

    /**
     * Method in charge of resettig all the Register info
     */
    public void resetRegisterInfo(){
        userRegisterBL.resetText();
        emailRegisterBL.resetText();
        passwordRegisterBL.resetText();
        confirmPasswordRegisterBL.resetText();
    }

    /**
     * Method in charge of managing the error display process
     * @param state int related to if the user is signing up
     *              or logging in his/her account
     * @param allgood boolean[] in charge of displaying a different
     *                error message depending on the type of
     *                registering/logging restrictions imposed
     *                by the program
     */
    public void errorShow(int state, boolean[] allgood){
        error.errorShow(state, allgood);
    }

    /**
     * Method in charge of exiting the error message display tab
     */
    public void errorExit(){
        error.errorExit();
    }

    /**
     * Method in charge of linking both the controller and the
     * error process when dealing with user resctrictions
     * @param rlc ActionListener in charge of making sure that
     *            the process of error displaying through the use
     *            of buttons and keyboard typing, is responsive
     */
    public void registerController(ActionListener rlc) {
        arrowLoginButton.addActionListener(rlc);
        arrowRegisterButton.addActionListener(rlc);
        error.registerController(rlc);
    }
}