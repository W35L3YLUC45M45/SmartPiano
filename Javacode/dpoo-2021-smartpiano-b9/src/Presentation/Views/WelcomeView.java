package Presentation.Views;
import SupportClasses.DrawableImage;

import java.awt.*;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Class in charge of everything related to the
 * welcome screen view when it comes
 * to the aesthetic of it.
 */
public class WelcomeView extends JPanel{

    private DrawableImage drawableImage;

    /**
     * Constructor of the welcome view in charge of initializing the main layout
     */
    public WelcomeView(){
        drawableImage = new DrawableImage("src/Icons/Welcome Screen/title_back.png");
        setLayout(new BorderLayout());
        add(drawableImage, BorderLayout.CENTER);
        setFocusable(true);
    }

    /**
     * Focus needed for the registered key listener to work
     */
    public void Focus(){
        requestFocus();
    }

    /**
     * Method to register the controller, in this case, a key listener which will listen for the 'space' key
     * @param listener The listener to be registered in this view
     */
    public void registerController(KeyListener listener){
        addKeyListener(listener);
    }
}