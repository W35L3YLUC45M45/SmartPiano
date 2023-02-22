package Presentation.Controllers;

import Business.PlayModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class in charge of everything related to the piano and its basic logic behind it.
 */
public class PianoController implements ActionListener {

    private PlayModel playModel;

    /**
     * Constructor in charge of instantiating a new Piano controller.
     *
     * @param playModel PlayModel class that contains the logic behind
     *                  the functionality of the piano.
     */
    public PianoController(PlayModel playModel) {
        this.playModel = playModel;
    }

    /**
     * Method in charge of playing a specific note inputted by the user
     * @param e ActionEvent used for parsing the inputted note so it plays through
     *          the synthesizer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        playModel.playNote(Integer.parseInt(e.getActionCommand()), 100);
    }
}
