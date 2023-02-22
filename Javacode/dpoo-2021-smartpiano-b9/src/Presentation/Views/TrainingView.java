package Presentation.Views;

import Presentation.Controllers.PianoController;
import SupportClasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Class in charge of everything related to the
 * training screen view when it comes
 * to the aesthetic of it.
 */
public class TrainingView extends JPanel{
    private JPanel mainpanel;
    private JPanel hamburgerpanel;
    private JPanel centerpanel;
    private JPanel inputpanel;
    private JPanel black;
    private JPanel white;
    private JPanel emptypanel;
    private JPanel emptypanel2;
    private JPanel emptypanel3;

    private JPanel pianopanel;
    private JPanel octaves;
    private JNotePanel thirdoctave;
    private JLabel fourthoctave;
    private JNotePanel fifthoctave;

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

    private JButton hamburger;
    private ImageIcon hamburger_icon;
    private DrawableImage title;

    private SideMenu sidemenu;
    private Piano piano;

    private PianoController pianoController;

    private KeyMap km;

    /**
     * Instantiates a new Training view.
     *
     * @param km KeyMap used to map the controls
     * @param pianoController PianoController used to instantiate the piano
     */
    public TrainingView(KeyMap km, PianoController pianoController){
        mainpanel = new JPanel(new BorderLayout());
        hamburgerpanel = new JPanel();
        hamburgerpanel.setLayout(new BoxLayout(hamburgerpanel, BoxLayout.Y_AXIS));
        centerpanel = new JPanel(new BorderLayout());

        pianopanel = new JPanel();
        pianopanel.setLayout(new BorderLayout());
        octaves = new JPanel();
        octaves.setLayout(new GridLayout(1, 3));

        thirdoctave = new JNotePanel(km, "3rd Octave activation", Color.WHITE, Color.BLACK, ConstantList.BTN_THIRD_LETTER);
        fourthoctave = new JLabel("4th Octave activation (default)", SwingConstants.CENTER);
        fifthoctave = new JNotePanel(km, "5th Octave activation", Color.WHITE, Color.BLACK, ConstantList.BTN_FIFTH_LETTER);

        inputpanel = new JPanel();
        inputpanel.setLayout(new BoxLayout(inputpanel, BoxLayout.Y_AXIS));
        white = new JPanel();
        white.setLayout(new GridLayout(1, 7));
        black = new JPanel();
        black.setLayout(new GridLayout(1, 8));

        cpanel = new JNotePanel (km, "Do/C", Color.WHITE, Color.BLACK, ConstantList.BTN_C_LETTER);
        dpanel = new JNotePanel (km, "Re/D", Color.WHITE, Color.BLACK, ConstantList.BTN_D_LETTER);
        epanel = new JNotePanel (km, "Mi/E", Color.WHITE, Color.BLACK, ConstantList.BTN_E_LETTER);
        fpanel = new JNotePanel (km, "Fa/F", Color.WHITE, Color.BLACK, ConstantList.BTN_F_LETTER);
        gpanel = new JNotePanel (km, "Sol/G", Color.WHITE, Color.BLACK, ConstantList.BTN_G_LETTER);
        apanel = new JNotePanel (km, "La/A", Color.WHITE, Color.BLACK, ConstantList.BTN_A_LETTER);
        bpanel = new JNotePanel (km, "Si/B", Color.WHITE, Color.BLACK, ConstantList.BTN_B_LETTER);

        cspanel = new JNotePanel (km, "<html>Do#/C#<br/>Reb/Db</html>", Color.DARK_GRAY, Color.WHITE, ConstantList.BTN_CS_LETTER);
        dspanel = new JNotePanel (km, "<html>Re#/D#<br/>Mib/Eb</html>", Color.DARK_GRAY, Color.WHITE, ConstantList.BTN_DS_LETTER);
        fspanel = new JNotePanel (km, "<html>Fa#/F#<br/>Solb/Gb</html>", Color.DARK_GRAY, Color.WHITE, ConstantList.BTN_FS_LETTER);
        gspanel = new JNotePanel (km, "<html>Sol#/G#<br/>Lab/Ab</html>", Color.DARK_GRAY, Color.WHITE, ConstantList.BTN_GS_LETTER);
        aspanel = new JNotePanel (km, "<html>La#/A#<br/>Sib/Bb</html>", Color.DARK_GRAY, Color.WHITE, ConstantList.BTN_AS_LETTER);

        sidemenu = new SideMenu(ConstantList.TRAINING);

        this.pianoController = pianoController;

        piano = new Piano(pianoController);

        this.km = km;

        init();
    }


    /**
     * Method in charge of building the aesthetic of the
     * training section
     */
    private void init(){
        setSize(1920, 1080);
        setLayout(new BorderLayout());

        hamburger_icon = new ImageIcon("src/Icons/Main Menu Screen/grupo 12.jpg");
        title = new DrawableImage("src/Icons/Training Screen/title.jpg");

        hamburger = new JButton(hamburger_icon);
        hamburger.setSize(100, 100);
        hamburger.setOpaque(false);
        hamburger.setBorder(null);
        hamburger.setContentAreaFilled(false);
        hamburger.setBorderPainted(false);
        hamburger.setActionCommand(ConstantList.BTN_HAMBURGUESA);
        hamburger.setFocusable(false);
        hamburgerpanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        hamburgerpanel.add(hamburger);
        hamburgerpanel.add(Box.createVerticalGlue());
        hamburgerpanel.setBackground(Color.WHITE);

        title.setPreferredSize(new Dimension(100, 250));

        emptypanel = new JPanel();
        emptypanel.setBackground(Color.WHITE);
        emptypanel2 = new JPanel();
        emptypanel2.setBackground(Color.WHITE);
        emptypanel3 = new JPanel();
        emptypanel3.setBackground(Color.WHITE);

        black.add(emptypanel);
        black.add(cspanel.getPanel());
        black.add(dspanel.getPanel());
        black.add(emptypanel2);
        black.add(fspanel.getPanel());
        black.add(gspanel.getPanel());
        black.add(aspanel.getPanel());
        black.add(emptypanel3);

        white.add(cpanel.getPanel());
        white.add(dpanel.getPanel());
        white.add(epanel.getPanel());
        white.add(fpanel.getPanel());
        white.add(gpanel.getPanel());
        white.add(apanel.getPanel());
        white.add(bpanel.getPanel());

        inputpanel.add(black);
        inputpanel.add(white);
        inputpanel.setPreferredSize(new Dimension(100, 100));

        fourthoctave.setFont(new Font(fourthoctave.getName(), Font.PLAIN, 20));
        fourthoctave.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));
        thirdoctave.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));
        fifthoctave.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));

        octaves.add(thirdoctave.getPanel());
        octaves.add(fourthoctave);
        octaves.add(fifthoctave.getPanel());
        octaves.setBackground(Color.WHITE);
        octaves.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));


        JPanel temp_piano = piano.buildPiano();
        temp_piano.setBorder(BorderFactory.createEmptyBorder(25, 100, 25, 0));
        temp_piano.setBackground(Color.WHITE);
        pianopanel.setBackground(Color.WHITE);
        pianopanel.add(octaves, BorderLayout.NORTH);
        pianopanel.add(temp_piano, BorderLayout.CENTER);

        centerpanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 100));
        centerpanel.setBackground(Color.WHITE);
        centerpanel.add(title, BorderLayout.NORTH);
        centerpanel.add(pianopanel, BorderLayout.CENTER);
        centerpanel.add(inputpanel, BorderLayout.SOUTH);

        mainpanel.add(hamburgerpanel, BorderLayout.WEST);
        mainpanel.add(centerpanel, BorderLayout.CENTER);
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        mainpanel.setFocusable(true);

        this.add(mainpanel);

    }

    /**
     * Method in charge of showing the side menu when clicked the hamburger icon
     */
    public void menuShow(){
        sidemenu.menuShow();
    }

    /**
     * Method in charge of exiting the side menu
     */
    public void menuExit(){
        sidemenu.menuExit();
    }

    /**
     * Method in charge of setting the text when mapping the controls for the piano keys
     */
    public void changeLetter(){
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
        mainpanel.requestFocus();
    }

    /**
     * Register controller of creating the interaction of
     * the controllers and action listeners.
     * @param tc ActionListener of the training controller
     * @param cc ActionListener of the card controller
     */
    public void registerController(ActionListener tc, ActionListener cc) {
        hamburger.addActionListener(tc);
        sidemenu.registerController(tc, cc);

        mainpanel.addKeyListener((KeyListener) tc);
    }
}
