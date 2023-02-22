package Presentation.Controllers;

import Business.UserModel;
import Presentation.Views.SettingsView;
import SupportClasses.ConstantList;
import SupportClasses.KeyMap;

import java.awt.event.*;

/**
 * Class in charge of the logic behind the Settings screen, being that
 * components that from the whole layout
 */
public class SettingsController extends KeyAdapter implements ActionListener {

    private SettingsView sv;
    private CardController cc;
    private KeyMap km;
    private String keypressed;
    private UserModel um;

    /**
     * Constructor in charge of instantiating a new Settings controller.
     *
     * @param sv the SettingsView view in which allows the program to display the settings screen
     * @param cc the CardController in charge of switching between screens
     * @param km the KeyMap used to map the controls
     */
    public SettingsController(SettingsView sv, CardController cc, KeyMap km, UserModel um){
        this.sv = sv;
        this.cc = cc;
        this.km = km;
        this.um = um;
    }

    /**
     * Method in charge of dealing with the button interactions
     * in which the user interacts with while using of the program
     * @param e ActionEvent default variable used to get the
     *          action/interaction coming from our keyboard
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ConstantList.BTN_HAMBURGUESA:
                sv.menuShow();
                break;
            case ConstantList.BTN_DELETEACC:
                um.deleteAccount(um.getUser().getUsername());
                sv.menuExit();
                break;
            case ConstantList.BTN_CLOSEMENU:
            case ConstantList.BTN_HOME:
            case ConstantList.BTN_TRAINING:
            case ConstantList.BTN_LOGOUT:
                sv.menuExit();
                break;
            case ConstantList.BTN_C_LETTER:
            case ConstantList.BTN_D_LETTER:
            case ConstantList.BTN_E_LETTER:
            case ConstantList.BTN_F_LETTER:
            case ConstantList.BTN_G_LETTER:
            case ConstantList.BTN_A_LETTER:
            case ConstantList.BTN_B_LETTER:
            case ConstantList.BTN_CS_LETTER:
            case ConstantList.BTN_DS_LETTER:
            case ConstantList.BTN_FS_LETTER:
            case ConstantList.BTN_GS_LETTER:
            case ConstantList.BTN_AS_LETTER:
            case ConstantList.BTN_THIRD_LETTER:
            case ConstantList.BTN_FIFTH_LETTER:
                System.out.println(e.getActionCommand());
                keypressed = e.getActionCommand();
                sv.letterMenuShow();
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
        System.out.println(e.getKeyCode());
        km.setValue(keypressed, e.getKeyCode());
        sv.letterMenuExit();
    }
}
