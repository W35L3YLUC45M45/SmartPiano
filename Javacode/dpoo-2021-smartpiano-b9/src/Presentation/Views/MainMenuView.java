package Presentation.Views;

import SupportClasses.ConstantList;
import SupportClasses.DrawableImage;
import SupportClasses.SideMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * MainMenuView
 * Class in charge of everything related to the
 * main menu screen view when it comes
 * to the aesthetic of it.
 */
public class MainMenuView extends JPanel {

    private JPanel mainpanel;
    private JPanel hamburgerpanel;

    private JButton hamburger;
    private ImageIcon hamburger_icon;
    private SideMenu sideMenu;

    /**
     * Constructor in charge of instantiating a new menu view.
     */
    public MainMenuView(){
        mainpanel = new JPanel(new BorderLayout());
        hamburgerpanel = new JPanel();
        hamburgerpanel.setLayout(new BoxLayout(hamburgerpanel, BoxLayout.Y_AXIS));

        sideMenu = new SideMenu(ConstantList.HOME);

        init();
    }

    /**
     * Method in charge of building the whole view
     * from top to bottom with all of the components added into it
     */
    private void init(){
        setSize(1920, 1080);
        setLayout(new BorderLayout());

        hamburger_icon = new ImageIcon("src/Icons/Main Menu Screen/grupo 12.jpg");

        hamburger = new JButton(hamburger_icon);
        hamburger.setSize(100, 100);
        hamburger.setOpaque(false);
        hamburger.setBorder(null);
        hamburger.setContentAreaFilled(false);
        hamburger.setBorderPainted(false);
        hamburger.setActionCommand(ConstantList.BTN_HAMBURGUESA);
        hamburgerpanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        hamburgerpanel.add(hamburger);
        hamburgerpanel.add(Box.createVerticalGlue());
        hamburgerpanel.setBackground(Color.WHITE);

        mainpanel.add(hamburgerpanel, BorderLayout.WEST);
        mainpanel.add(new DrawableImage("src/Icons/Main Menu Screen/menu.png"), BorderLayout.CENTER);
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setBounds(0, 0, this.getWidth(), this.getHeight());

        this.add(mainpanel);
    }

    /**
     * Method in charge of showing the side menu pop up.
     */
    public void menuShow(){
        sideMenu.menuShow();
    }

    /**
     * Method in charge of exiting the side menu pop up through a button interaction.
     */
    public void menuExit(){
        sideMenu.menuExit();
    }

    /**
     * Method in charge of giving actions listeners to
     * both the side menu itself and the hamburger icon
     *
     * @param mmc ActionListener in charge of the Main Menu Controller button interaction
     * @param cc  ActionListener in charge of the Card Controller button interaction
     */
    public void registerController(ActionListener mmc, ActionListener cc) {
        hamburger.addActionListener(mmc);
        sideMenu.registerController(mmc, cc);
        addMouseListener((MouseListener) mmc);
    }
}
