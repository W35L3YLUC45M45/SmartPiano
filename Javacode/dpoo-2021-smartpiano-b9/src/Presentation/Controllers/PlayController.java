package Presentation.Controllers;

import Business.PlayModel;
import Presentation.Views.PlayView;
import SupportClasses.ConstantList;
import SupportClasses.KeyMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class in charge of the logic behind the Play
 * View screen, being that components that form the
 * whole layout
 */
public class PlayController extends KeyAdapter implements ActionListener {

    private PlayView playView;
    private PlayModel playModel;
    private KeyMap keyMap;

    private Set<Integer> keyPressed;

    /**
     * Constructor in charge of instantiating a new Play controller.
     *
     * @param pv PlayView class that contains the aesthetic of the Play screen
     * @param keyMap KeyMap used to map the controls
     * @param playModel PlayModel class tha contains the functionality logic
     *                  of the piano
     */
    public PlayController(PlayView pv, KeyMap keyMap, PlayModel playModel) {
        this.playView = pv;
        this.playModel = playModel;
        this.keyMap = keyMap;
        keyPressed = new TreeSet<>();
    }

    /**
     * Method in charge of assigning a Constant to each of the components from the Play screen.
     * @param e ActionEvent used for when interacting with a specific component
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ConstantList.BTN_HAMBURGUESA:
                playView.menuShow();
                break;

            case ConstantList.BTN_CLOSEMENU:
            case ConstantList.BTN_DELETEACC:
            case ConstantList.BTN_LOGOUT:
            case ConstantList.BTN_HOME:
            case ConstantList.BTN_SETTINGS:
            case ConstantList.BTN_PLAYLIST:
            case ConstantList.BTN_TRAINING:
            case ConstantList.BTN_GRAPHS:
                playView.menuExit();
                break;

            case ConstantList.START_RECORDING:
                playModel.startTimer();
                playView.flipRecImage(true);
                break;

            case ConstantList.STOP_RECORDING:
                playModel.stopTimer();
                playView.flipRecImage(false);
                break;

            case ConstantList.AUTO_TIMER:
                playView.showTimer(1);
                break;

            case ConstantList.SAVE_CLOSE_POPUP:
                playView.popUpDispose();
        }
    }

    /**
     * Method in charge of the logic behind when pressing a key from the piano
     * @param e KeyEvent that leads us to play that specific note.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (!keyPressed.contains(e.getKeyCode())) {
            keyPressed.add(e.getKeyCode());
            playModel.playSound(e.getKeyCode());
            playView.addKeyToProgress(e.getKeyCode());
        }
    }

    /**
     * Method in charge of the logic behind when releasing the finger from a piano key
     * @param e KeyEvent that leads us to stop the sound from the key playing a specific note.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed.remove(e.getKeyCode());
        playModel.stopSound(e.getKeyCode());
    }

}
