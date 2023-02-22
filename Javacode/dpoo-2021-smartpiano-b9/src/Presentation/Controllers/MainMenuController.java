package Presentation.Controllers;

import Business.UserModel;
import Presentation.Views.MainMenuView;
import SupportClasses.ConstantList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class in charge of the logic behind the Main Menu
 * View screen, being that components that form the
 * whole layout
 */
public class MainMenuController extends MouseAdapter implements ActionListener {
    private MainMenuView mmv;
    private CardController cc;
    private UserModel um;

    /**
     * Controller in charge of instantiating a new Main menu controller.
     * @param mmv the MainMenuView that containg the aesthetic of the Main Menu View
     * @param cc  CardController class in charge of managing the view screens switching
     */
    public MainMenuController(MainMenuView mmv, CardController cc, UserModel um){
        this.mmv = mmv;
        this.cc = cc;
        this.um = um;
    }

    /**
     * Method in charge of assigning a Constant to each of the views that lead from the Main Menu screen.
     * @param e ActionEvent used for when interacting with a specific view,
     *          the event (screen switching) happens
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ConstantList.BTN_HAMBURGUESA:
                mmv.menuShow();
                break;
            case ConstantList.BTN_CLOSEMENU:
            case ConstantList.BTN_LOGOUT:
                mmv.menuExit();
                break;
            case ConstantList.BTN_DELETEACC:
                um.deleteAccount(um.getUser().getUsername());
                mmv.menuExit();
                break;
            default:
                System.out.println("DEFAULT OPTION");
                break;
        }
    }

    /**
     * Method in charge of the logic behind the interaction of the mouse on the screen.
     * @param e for the MouseEvent when using the mouse to interact with its
     *          position in the Main Menu screen
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        int x = e.getX();
        int y = e.getY();

        Dimension dim = mmv.getSize();

        float height[] = {dim.height*0.465f, dim.height*0.585f, dim.height*0.785f, dim.height*0.91f};
        float width[] = {(100 + (dim.width-100)*0.165f), (100 + (dim.width-100)*0.345f), (100 + (dim.width-100)*0.565f), (100 + (dim.width-100)*0.74f)};

        //System.out.println(x + ", " + y + " on dim: " + dim);

        if(y >= height[1] && y <= height[2] && x >= width[1] && x <= width[2])
            cc.mouseActioned(ConstantList.BTN_PLAY);

        if(y >= height[0] && y <= height[1] && x >= width[0] && x <= width[1])
            cc.mouseActioned(ConstantList.BTN_TRAINING);

        if(y >= height[0] && y <= height[1] && x >= width[2] && x <= width[3])
            cc.mouseActioned(ConstantList.BTN_PLAYLIST);

        if(y >= height[2] && y <= height[3] && x >= width[0] && x <= width[1])
            cc.mouseActioned(ConstantList.BTN_SETTINGS);

        if(y >= height[2] && y <= height[3] && x >= width[2] && x <= width[3])
            cc.mouseActioned(ConstantList.BTN_GRAPHS);
    }
}
