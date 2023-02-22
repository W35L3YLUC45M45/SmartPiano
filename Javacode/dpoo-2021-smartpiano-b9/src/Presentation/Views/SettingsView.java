package Presentation.Views;

import SupportClasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Class in charge of everything related to the
 * settings screen view when it comes
 * to the aesthetic of it.
 */
public class SettingsView extends JPanel {

    private JPanel mainpanel;
    private JPanel hamburgerpanel;
    private JPanel centerpanel;
    private JPanel inputpanel;

    private JNotePanel cpanel;
    private JNotePanel dpanel;
    private JNotePanel epanel;
    private JNotePanel fpanel;
    private JNotePanel gpanel;
    private JNotePanel apanel;
    private JNotePanel bpanel;

    private JNotePanel cspanel;
    private JNotePanel dspanel;
    private JNotePanel fspanel;
    private JNotePanel gspanel;
    private JNotePanel aspanel;

    private JNotePanel thirdpanel;
    private JNotePanel fifthpanel;

    private JPanel octavepanel;

    private JButton hamburger;
    private ImageIcon hamburger_icon;
    private DrawableImage title;
    private DrawableImage controller;

    private JLabel white;
    private JLabel black;
    private JLabel octave;

    private SideMenu sidemenu;

    private JPanel letterpanel;
    private JDialog letterdialog;

    private KeyMap km;

    /**
     * Controller in charge of instantiating a new Settings view.
     * @param km the key map used for the assignment of controller buttons according to the keyboard.
     */
    public SettingsView(KeyMap km){

        mainpanel = new JPanel(new BorderLayout());
        hamburgerpanel = new JPanel();
        hamburgerpanel.setLayout(new BoxLayout(hamburgerpanel, BoxLayout.Y_AXIS));
        centerpanel = new JPanel(new BorderLayout());
        inputpanel = new JPanel();
        inputpanel.setLayout(new GridLayout(8, 2));

        cpanel = new JNotePanel (km, "Do/C", Color.WHITE, Color.BLACK, ConstantList.BTN_C_LETTER);
        dpanel = new JNotePanel (km, "Re/D", Color.WHITE, Color.BLACK, ConstantList.BTN_D_LETTER);
        epanel = new JNotePanel (km, "Mi/E", Color.WHITE, Color.BLACK, ConstantList.BTN_E_LETTER);
        fpanel = new JNotePanel (km, "Fa/F", Color.WHITE, Color.BLACK, ConstantList.BTN_F_LETTER);
        gpanel = new JNotePanel (km, "Sol/G", Color.WHITE, Color.BLACK, ConstantList.BTN_G_LETTER);
        apanel = new JNotePanel (km, "La/A", Color.WHITE, Color.BLACK, ConstantList.BTN_A_LETTER);
        bpanel = new JNotePanel (km, "Si/B", Color.WHITE, Color.BLACK, ConstantList.BTN_B_LETTER);

        cspanel = new JNotePanel (km, "Do#/C# - Reb/Db", Color.WHITE, Color.BLACK, ConstantList.BTN_CS_LETTER);
        dspanel = new JNotePanel (km, "Re#/D# - Mib/Eb", Color.WHITE, Color.BLACK, ConstantList.BTN_DS_LETTER);
        fspanel = new JNotePanel (km, "Fa#/F# - Solb/Gb", Color.WHITE, Color.BLACK, ConstantList.BTN_FS_LETTER);
        gspanel = new JNotePanel (km, "Sol#/G# - Lab/Ab", Color.WHITE, Color.BLACK, ConstantList.BTN_GS_LETTER);
        aspanel = new JNotePanel (km, "La#/A# - Sib/Bb", Color.WHITE, Color.BLACK, ConstantList.BTN_AS_LETTER);

        thirdpanel = new JNotePanel (km, "3rd", Color.WHITE, Color.BLACK, ConstantList.BTN_THIRD_LETTER);
        fifthpanel = new JNotePanel (km, " -  5th", Color.WHITE, Color.BLACK, ConstantList.BTN_FIFTH_LETTER);


        octavepanel = new JPanel();
        octavepanel.setLayout(new FlowLayout());

        sidemenu = new SideMenu(ConstantList.SETTINGS);

        letterpanel = new JPanel(new BorderLayout());

        this.km = km;

        init();
    }

    /**
     * Method in charge of building the whole view
     * from top to bottom with all of the components added into it
     */
    private void init(){
        setSize(1920, 1080);
        setLayout(new BorderLayout());

        hamburger_icon = new ImageIcon("src/Icons/Main Menu Screen/grupo 12.jpg");
        title = new DrawableImage("src/Icons/Controller Settings Screen/title.jpg");
        controller = new DrawableImage("src/Icons/Controller Settings Screen/controller.jpg");

        hamburger = new JButton(hamburger_icon);
        hamburger.setSize(100, 100);
        hamburger.setOpaque(false);
        hamburger.setBorder(null);
        hamburger.setContentAreaFilled(false);
        hamburger.setBorderPainted(false);
        hamburger.setActionCommand(ConstantList.BTN_HAMBURGUESA);
        hamburgerpanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        hamburgerpanel.add(hamburger);
        hamburgerpanel.add(Box.createVerticalGlue());
        hamburgerpanel.setBackground(Color.WHITE);

        title.setPreferredSize(new Dimension(100, 275));

        centerpanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 100));
        centerpanel.setBackground(Color.WHITE);

        white = new JLabel("White Keys", SwingConstants.CENTER);
        white.setFont(new Font(white.getName(), Font.PLAIN, 24));
        black = new JLabel("Black Keys", SwingConstants.CENTER);
        black.setFont(new Font(black.getName(), Font.PLAIN, 24));
        octave = new JLabel("Octave Activation Keys", SwingConstants.CENTER);
        octave.setFont(new Font(octave.getName(), Font.PLAIN, 24));


        octavepanel.add(thirdpanel.getPanel());
        octavepanel.add(fifthpanel.getPanel());
        octavepanel.setBackground(Color.WHITE);


        inputpanel.setBackground(Color.WHITE);
        inputpanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        inputpanel.add(white);
        inputpanel.add(black);
        inputpanel.add(cpanel.getPanel());
        inputpanel.add(cspanel.getPanel());
        inputpanel.add(dpanel.getPanel());
        inputpanel.add(dspanel.getPanel());
        inputpanel.add(epanel.getPanel());
        inputpanel.add(fspanel.getPanel());
        inputpanel.add(fpanel.getPanel());
        inputpanel.add(gspanel.getPanel());
        inputpanel.add(gpanel.getPanel());
        inputpanel.add(aspanel.getPanel());
        inputpanel.add(apanel.getPanel());
        inputpanel.add(octave);
        inputpanel.add(bpanel.getPanel());
        inputpanel.add(octavepanel);

        centerpanel.add(title, BorderLayout.NORTH);
        centerpanel.add(controller, BorderLayout.CENTER);
        centerpanel.add(inputpanel, BorderLayout.EAST);

        mainpanel.add(hamburgerpanel, BorderLayout.WEST);
        mainpanel.add(centerpanel, BorderLayout.CENTER);
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setBounds(0, 0, this.getWidth(), this.getHeight());



        letterpanel.add(new JLabel(new ImageIcon("src/Icons/Controller Settings Screen/grupo 220.jpg")));
        letterpanel.setFocusable(true);
        letterpanel.requestFocusInWindow();

        this.add(mainpanel);
    }

    /**
     * Method in charge of showing the side menu.
     */
    public void menuShow(){
        sidemenu.menuShow();
    }

    /**
     * Method in charge of closing the side menu.
     */
    public void menuExit(){
        sidemenu.menuExit();
    }

    /**
     * Method in charge of showing the letter menu.
     */
    public void letterMenuShow(){
        letterdialog = new JDialog();
        letterdialog.setUndecorated(true);
        letterdialog.add(letterpanel);
        letterdialog.setModal(true);
        letterdialog.pack();
        letterdialog.setLocationRelativeTo(null);
        letterdialog.setVisible(true);
    }

    /**
     * Method in charge of exiting the letter menu.
     */
    public void letterMenuExit(){
        letterdialog.dispose();
        cpanel.setText();
        dpanel.setText();
        epanel.setText();
        fpanel.setText();
        gpanel.setText();
        apanel.setText();
        bpanel.setText();
        cspanel.setText();
        dspanel.setText();
        fspanel.setText();
        gspanel.setText();
        aspanel.setText();
        thirdpanel.setText();
        fifthpanel.setText();
    }

    /**
     * Register controller of creating the interaction of
     * the controllers and action listeners.
     * @param sc ActionListener of the settings controller
     * @param cc ActionListener of the card controller
     */
    public void registerController(ActionListener sc, ActionListener cc) {
        hamburger.addActionListener(sc);
        sidemenu.registerController(sc, cc);

        letterpanel.addKeyListener((KeyListener) sc);

        cpanel.registerController(sc);
        dpanel.registerController(sc);
        epanel.registerController(sc);
        fpanel.registerController(sc);
        gpanel.registerController(sc);
        apanel.registerController(sc);
        bpanel.registerController(sc);
        cspanel.registerController(sc);
        dspanel.registerController(sc);
        fspanel.registerController(sc);
        gspanel.registerController(sc);
        aspanel.registerController(sc);
        thirdpanel.registerController(sc);
        fifthpanel.registerController(sc);
    }
}
