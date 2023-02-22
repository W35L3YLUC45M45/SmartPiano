package Presentation.Controllers;

import Business.UserModel;
import Presentation.Views.CardView;
import Presentation.Views.RegisterLoginView;
import SupportClasses.ConstantList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * RegisterLoginController
 * Class in charge of everything related to the
 * user login/sign up process. The methods shown below
 * are in charge not only of the interactions with
 * most of the components present in the program,
 * but also in charge of making sure that it displays
 * the errors when necessary.
 */
public class RegisterLoginController implements ActionListener {
    private RegisterLoginView rlv;
    private CardView cv;
    private UserModel um;
    private String[] logininput;
    private String[] registerinput;
    private boolean[] allgood;

    /**
     * Constructor in charge of initializing the previously
     * declared variables
     *
     * @param rlv RegisterLoginView view in which allows the program to display the Sign Up/Login screen
     * @param cv  CardView List of views in which allows us to list all of the screens pertaining to the project           and switch between them whenever we feel like           as the program's user
     * @param um  UserModel model in charge of everything related to the user who's signing up/logging
     */
    public RegisterLoginController(RegisterLoginView rlv, CardView cv, UserModel um){
        this.rlv = rlv;
        this.cv = cv;
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
            case ConstantList.BTN_LOGIN:
                logininput = rlv.getLoginInfo();
                allgood = um.doLogin(logininput);
                if(allgood[0] && allgood[1]){
                    rlv.resetLoginInfo();
                    cv.openMainMenu();
                } else {
                    rlv.errorShow(0, allgood);
                }
                break;
            case ConstantList.BTN_REGISTER:
                registerinput = rlv.getRegisterInfo();
                allgood = um.doRegister(registerinput);
                if(allgood[0] && allgood[1] && allgood[2] && allgood[3] && allgood[4] && allgood[5] && allgood[6] && allgood[7] && allgood[8]){
                    rlv.resetRegisterInfo();
                    um.addUser(registerinput);
                    cv.openMainMenu();
                } else {
                    rlv.errorShow(1, allgood);
                }
                break;
            case ConstantList.BTN_CLOSEMENU:
                rlv.errorExit();
                break;
            default:
                System.out.println("DEFAULT OPTION");
                break;
        }

    }
}
