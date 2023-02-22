package Business;

import SupportClasses.ConstantList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Web scrapper update controller will be used to control the time between every update from the WebScrapper as
 * this should be done continuously while the game is running.
 */
public class WebScrapperUpdateController implements ActionListener{

    private final WebScrapper webScrapper;

    /**
     * Instantiates a new Web scrapper update controller.
     *
     * @param webScrapper the WebScrapper to be controlled and triggered every given time period.
     */
    public WebScrapperUpdateController(WebScrapper webScrapper){
        this.webScrapper = webScrapper;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ConstantList.SCRAPPING_TIMER.equals(e.getActionCommand())) {
            webScrapper.increaseStartAt();
            webScrapper.startWebScrapping();
        }
    }

    /**
     * Trigger meant to start the WebScrapping for the first time from the Main.
     */
    public void trigger() {
        webScrapper.startWebScrapping();
    }
}
