package Presentation.Controllers;

import Presentation.Views.CardView;
import Presentation.Views.WelcomeView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Class in charge of the logic behind the Welcome View Screen
 */
public class WelcomeController extends KeyAdapter {

    private WelcomeView view;
    private CardView card;

    /**
     * Constructor of the controller
     * @param view The view this controller is registered to
     * @param card The view controller in which the welcome view is opened from
     */
    public WelcomeController(WelcomeView view, CardView card) {
        this.view = view;
        this.card = card;
    }

    /**
     * A listener for when a key is pressed. It's used to trigger the opening of the following view
     * @param e Key that's being pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            card.openRegisterMenu();
        }
    }
}

