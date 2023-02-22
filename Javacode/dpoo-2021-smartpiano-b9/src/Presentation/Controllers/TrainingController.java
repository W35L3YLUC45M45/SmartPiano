package Presentation.Controllers;

import Business.UserModel;
import Business.PlayModel;
import Presentation.Views.TrainingView;
import SupportClasses.ConstantList;
import SupportClasses.KeyMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Class in charge of the logic behind the Training
 * View screen, being that components that form the
 * whole layout
 */
public class TrainingController extends KeyAdapter implements ActionListener {
    private TrainingView tv;
    private CardController cc;
    private UserModel um;

    private Set<Integer> pressedKeys;

    private KeyMap km;
    private PlayModel pm;

    /**
     * Instantiates a new Training controller.
     *
     * @param tv the TrainingView class that contains the aesthetic of the Training screen
     * @param cc the CardController class in charge of managing the view screens switching
     * @param km the KeyMap used to map the controls
     * @param pm the PlayModel class tha contains the functionality logic of the piano
     */
    public TrainingController(TrainingView tv, CardController cc, KeyMap km, PlayModel pm, UserModel um){
        this.tv = tv;
        this.cc = cc;
        this.km = km;
        this.pm = pm;
        this.um = um;
        pressedKeys = new TreeSet<>();
    }

    /**
     * Method in charge of assigning a Constant to each of the components from the Training screen.
     * @param e ActionEvent used for when interacting with a specific component
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ConstantList.BTN_HAMBURGUESA:
                tv.menuShow();
                break;
            case ConstantList.BTN_CLOSEMENU:
            case ConstantList.BTN_HOME:
            case ConstantList.BTN_SETTINGS:
            case ConstantList.BTN_LOGOUT:
            case ConstantList.BTN_PLAY:
            case ConstantList.BTN_PLAYLIST:
            case ConstantList.BTN_GRAPHS:
                tv.menuExit();
                break;
            case ConstantList.BTN_DELETEACC:
                um.deleteAccount(um.getUser().getUsername());
                tv.menuExit();
                break;
            default:
                System.out.println("DEFAULT OPTION");
                break;
        }
    }

    /**
     * Method in charge of the logic behind when pressing a key from the piano
     * @param e KeyEvent that leads us to play that specific note.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (!pressedKeys.contains(e.getKeyCode())) {
            pressedKeys.add(e.getKeyCode());
            pm.playSound(e.getKeyCode());
        }
    }

    /**
     * Method in charge of the logic behind when releasing the finger from a piano key
     * @param e KeyEvent that leads us to stop the sound from the key playing a specific note.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
        pm.stopSound(e.getKeyCode());
    }
}
