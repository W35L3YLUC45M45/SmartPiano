package Presentation.Controllers;

import Presentation.Views.CardView;
import SupportClasses.ConstantList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class in charge of everything related to
 * the switching of screens when going from one place
 * to another when interacting with buttons
 */
public class CardController implements ActionListener {
    private CardView cv;

    /**
     * Controller in charge of instantiating a new Card controller.
     *
     * @param cv CardView used to organize the different views
     */
    public CardController(CardView cv){
        this.cv = cv;
    }

    /**
     * Method in charge of assigning a Constant to each of the views
     * @param e ActionEvent used for when interacting with a specific view,
     *          the event (screen switching) happens
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ConstantList.BTN_REGISTERLOGIN:
                cv.openRegisterMenu();
                break;
            case ConstantList.BTN_HOME:
                cv.openMainMenu();
                break;
            case ConstantList.BTN_PLAY:
                cv.openPlayMenu();
                break;
            case ConstantList.BTN_PLAYLIST:
                cv.openPlaylist();
                break;
            case ConstantList.BTN_TRAINING:
                cv.openTrainingMenu();
                break;
            case ConstantList.BTN_SETTINGS:
                cv.openSettings();
                break;
            case ConstantList.BTN_GRAPHS:
                cv.openGraphsMenu();
                break;
            case ConstantList.BTN_LOGOUT:
            case ConstantList.BTN_DELETEACC:
                cv.openWelcomeMenu();
                break;
            case ConstantList.BTN_OPENPLAYLIST:
                cv.openPlaylistSong();
                break;
            default:
                System.out.println("DEFAULT OPTION");
                break;
        }
    }

    /**
     * Method in charge of assigning a button of the main menu
     * to a specific string that recognizes where to go.
     *
     * @param command String in which depending of the mouse action,
     *                it leads to the activation of a specific Constant.
     */
    public void mouseActioned(String command){
        switch (command){
            case ConstantList.BTN_HOME:
                cv.openMainMenu();
                break;
            case ConstantList.BTN_PLAY:
                cv.openPlayMenu();
                break;
            case ConstantList.BTN_PLAYLIST:
                cv.openPlaylist();
                break;
            case ConstantList.BTN_TRAINING:
                cv.openTrainingMenu();
                break;
            case ConstantList.BTN_SETTINGS:
                cv.openSettings();
                break;
            case ConstantList.BTN_GRAPHS:
                cv.openGraphsMenu();
                break;
            default:
                System.out.println("DEFAULT OPTION");
                break;
        }
    }
}
