package Presentation.Controllers;

import Business.Entities.Song;
import Business.StatisticsModel;
import Business.UserModel;
import Presentation.Views.StatisticsView;
import SupportClasses.ConstantList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class in charge of the logic behind the logic of the
 * component's interactions with the Statistics View
 */
public class StatisticsController implements ActionListener {
    private StatisticsModel sm;
    private StatisticsView sv;
    private UserModel um;

    /**
     * Constructor that initializes all of the variables previously declared.
     * @param sm The Statistics Model, which connects the Statistics-related functions to the database manager.
     * @param sv The Statistics View, where it displays the Statistics window.
     * @param um The user model, used when interactions with the user are needed.
     */
    public StatisticsController(StatisticsModel sm, StatisticsView sv, UserModel um){
        this.sm = sm;
        this.sv = sv;
        this.um = um;
    }

    /**
     * Method used to get the songs from the database and order it by popularity.
     */
    public ArrayList<Song> getPopularSongs(){
        return sm.getPopularSongs();
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
            case ConstantList.BTN_CLOSEMENU:
            case ConstantList.BTN_HOME:
            case ConstantList.BTN_SETTINGS:
            case ConstantList.BTN_LOGOUT:
            case ConstantList.BTN_PLAY:
            case ConstantList.BTN_PLAYLIST:
            case ConstantList.BTN_TRAINING:
                sv.menuExit();
                break;
            case ConstantList.BTN_DELETEACC:
                um.deleteAccount(um.getUser().getUsername());
                sv.menuExit();
                break;
            default:
                System.out.println("DEFAULT OPTION");
                break;
        }
    }
}
