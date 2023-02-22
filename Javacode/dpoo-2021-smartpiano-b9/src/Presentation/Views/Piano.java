package Presentation.Views;

import Presentation.Controllers.PianoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Class whose main purpose is declaring the piano itself
 * formed by keys
 */
public class Piano {

    private PianoController pianoController;

    private final Color BLACK_KEYS_COLOR = new Color(23, 24, 23);
    private final Color WHITE_KEYS_COLOR = new Color(255, 255, 255);

    private final int NUM_OCTAVES = 3;
    private final int NUM_KEYS = 7;

    private JPanel piano;
    private final JLayeredPane keyBoard;

    private ArrayList<Key> myKeys;

    private final String[] blackLabels = {"Do#", "Re#", "Fa#", "Sol#", "La#"};
    private final String[] whiteLabels = {"Do", "Re", "Mi", "Fa", "Sol", "La", "Si"};

    private final int global_margin = 0;

    //Initial positions
    private int x = global_margin;
    private int y = 0;

    private final int black_margin = 40;
    private int black_space = global_margin + black_margin;
    private final int short_dist = 53;
    private final int long_dist = 109;
    private final int black_gap = 377;

    //White Key Measures
    private final int white_width = 54;
    private final int white_height = 236;

    //Black Key Measures
    private final int black_width = 29;
    private final int black_height = 136;

    private final int distBetweenKey = 0;
    private final int dist_between_whites = white_width + distBetweenKey;


    /**
     * Constructor in charge of instantiating a new Piano.
     * @param pianoController PianoController controller of the
     *                        instantiated piano
     */
    public Piano(PianoController pianoController) {
        this.pianoController = pianoController;
        keyBoard = new JLayeredPane();
    }


    /**
     * Method in charge of building the aesthetic of the piano
     * @return the piano built through various components
     */
    public JPanel buildPiano(){

        piano = new JPanel(new BorderLayout());

        //TODO Implement with Thread
        myKeys = new ArrayList<Key>();

        int keyTextId = 0;

        // Setting initial conditions from Keyboard
        keyBoard.setOpaque(true);
        keyBoard.setPreferredSize(new Dimension(white_width*NUM_KEYS*NUM_OCTAVES + x,white_height));
        keyBoard.setBackground(new Color(255, 255, 255));


        //All elements to have the upper black bar from the piano with the names needed for keys.
        JLayeredPane blackBar = new JLayeredPane();
        blackBar.setBackground(Color.WHITE);
        blackBar.setPreferredSize(new Dimension(white_width*NUM_KEYS*NUM_OCTAVES + x,20));

        JButton blackBarBackground = new JButton();
        blackBarBackground.setEnabled(false);

        blackBarBackground.setSize(new Dimension(white_width*NUM_KEYS*NUM_OCTAVES + x,20));
        blackBarBackground.setBackground(new Color(0, 0, 0));
        blackBarBackground.setBorderPainted(false);
        blackBar.add(blackBarBackground, Integer.valueOf(1));


        int blackBarTextHeight = 15;
        int blackBarTextMargin = black_margin + 10;

        for (int i = 0; i < NUM_OCTAVES; i++) {

            black_space = global_margin + blackBarTextMargin;

            blackBar.add(callBlackLabels(0,black_space+(black_gap*i),blackBarTextHeight), Integer.valueOf(2));
            black_space += short_dist;
            blackBar.add(callBlackLabels(1,black_space+(black_gap*i),blackBarTextHeight), Integer.valueOf(2));
            black_space += long_dist;
            blackBar.add(callBlackLabels(2,black_space+(black_gap*i),blackBarTextHeight), Integer.valueOf(2));
            black_space += short_dist;
            blackBar.add(callBlackLabels(3,black_space+(black_gap*i),blackBarTextHeight), Integer.valueOf(2));
            black_space += short_dist;
            blackBar.add(callBlackLabels(4,black_space+(black_gap*i),blackBarTextHeight), Integer.valueOf(2));

        }
        keyBoard.add(blackBar);


        int keyId = 48;
        int flip;
        int num;

        // Adding the white keys
        for(int i=0; i< NUM_OCTAVES; i++){
            flip = 0;
            for(int j=0; j<NUM_KEYS; j++){

                JButton jb = new JButton();
                jb.setBackground(WHITE_KEYS_COLOR);

                num = (keyId + 12*i + j*2 - flip);

                jb.setActionCommand(String.valueOf(num));
                jb.addActionListener(pianoController);
                jb.setFocusable(false);

                //TODO Manage the adding of Keys to record song in progress alongside Thread.
                Key newKey = new Key(num, i);
                myKeys.add(newKey);

                jb.setBounds(x, y, white_width, white_height);
                jb.setText(whiteLabels[keyTextId]);
                jb.setFont(new Font(jb.getName(),Font.BOLD,8));
                jb.setVerticalAlignment(SwingConstants.BOTTOM);
                jb.setHorizontalAlignment(SwingConstants.CENTER);


                // Placing keys on bottom (INTEGER 1)
                keyBoard.add(jb, Integer.valueOf(1));
                keyTextId++;

                keyBoard.add(Box.createRigidArea(new Dimension(distBetweenKey, 0)));
                x += dist_between_whites;

                if(j >= 2){
                    flip = 1;
                }
            }

            keyTextId = 0;

        }


        // Adding the black keys
        for(int i=0; i< NUM_OCTAVES; i++){

            // Making the five keys

            num = (keyId + 12*i) + 1;
            JButton jb0 = new JButton();
            jb0.setBackground(BLACK_KEYS_COLOR);
            jb0.setActionCommand(String.valueOf(num));
            jb0.addActionListener(pianoController);
            jb0.setFocusable(false);
            Key newKey = new Key(num, i);
            myKeys.add(newKey);

            num = (keyId + 12*i) + 3;
            JButton jb1 = new JButton();
            jb1.setBackground(BLACK_KEYS_COLOR);
            jb1.setActionCommand(String.valueOf(num));
            jb1.addActionListener(pianoController);
            jb1.setFocusable(false);
            Key newKey2 = new Key(num, i);
            myKeys.add(newKey2);

            num = (keyId + 12*i) + 6;
            JButton jb2 = new JButton();
            jb2.setBackground(BLACK_KEYS_COLOR);
            jb2.setActionCommand(String.valueOf(num));
            jb2.addActionListener(pianoController);
            jb2.setFocusable(false);
            Key newKey3 = new Key(num, i);
            myKeys.add(newKey3);

            num = (keyId + 12*i) + 8;
            JButton jb3 = new JButton();
            jb3.setBackground(BLACK_KEYS_COLOR);
            jb3.setActionCommand(String.valueOf(num));
            jb3.addActionListener(pianoController);
            jb3.setFocusable(false);
            Key newKey4 = new Key(num, i);
            myKeys.add(newKey4);

            num = (keyId + 12*i) + 10;
            JButton jb4 = new JButton();
            jb4.setBackground(BLACK_KEYS_COLOR);
            jb4.setActionCommand(String.valueOf(num));
            jb4.addActionListener(pianoController);
            jb4.setFocusable(false);
            Key newKey5 = new Key(num, i);
            myKeys.add(newKey5);


            //Initialize the starting point ok black keys
            black_space = global_margin + black_margin;


            // Placing my five keys on top (INTEGER 2)
            //Key 1
            jb0.setBounds(black_space+(black_gap*i),y,black_width,black_height);
            jb0.setBorderPainted(false);
            keyBoard.add(jb0, Integer.valueOf(2));

            black_space += short_dist;

            //Key 2
            jb1.setBounds(black_space+(black_gap*i),y,black_width,black_height);
            jb1.setBorderPainted(false);
            keyBoard.add(jb1, Integer.valueOf(2));

            black_space += long_dist;

            //Key 3
            jb2.setBounds(black_space+(black_gap*i),y,black_width,black_height);
            jb2.setBorderPainted(false);
            keyBoard.add(jb2, Integer.valueOf(2));

            black_space += short_dist;

            //Key 4
            jb3.setBounds(black_space+(black_gap*i),y,black_width,black_height);
            jb3.setBorderPainted(false);
            keyBoard.add(jb3, Integer.valueOf(2));

            black_space += short_dist;

            //Key 5
            jb4.setBounds(black_space+(black_gap*i),y,black_width,black_height);
            jb4.setBorderPainted(false);

            keyBoard.add(jb4, Integer.valueOf(2));
        }


        piano.add(blackBar, BorderLayout.NORTH);
        piano.add(keyBoard,BorderLayout.CENTER);


        // Returning the keyboard
        return piano;
    }

    /**
     * Method in charge of building the black piano keys over
     * the general piano layout
     * @param i int that indicates which key to assign the text
     * @param where int that indicates the tet alignment position
     * @param height int that indicates the height og the black piano keys
     * @return the text inside the black piano keys
     */
    private JButton callBlackLabels(int i, int where, int height) {

        int text_width = 60;
        int text_alignment = 27;
        JButton txt = new JButton();
        txt.setBounds(where-text_alignment,0,text_width,height);
        txt.setText(blackLabels[i]);

        txt.setOpaque(false);
        txt.setContentAreaFilled(false);
        txt.setBorderPainted(false);
        txt.setForeground(new Color(255, 255, 255));
        txt.setFont(new Font(txt.getName(),Font.BOLD,8));
        txt.setVerticalAlignment(SwingConstants.TOP);
        txt.setHorizontalAlignment(SwingConstants.CENTER);

        return txt;
    }

    /**
     * Method in charge of linking both the piano
     * and play controllers
     * @param playController  ActionListener in charge of the Play Controller button interaction
     * @param pianoController ActionListener in charge of the Piano Controller button interaction
     */
    public void registerController(ActionListener playController, ActionListener pianoController){
    }

}
