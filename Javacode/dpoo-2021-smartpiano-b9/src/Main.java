import Business.*;
import Business.ConfigDatabase.DatabaseManager;
import Business.ConfigDatabase.GestionJSON.Config;
import Persistance.dao.*;
import Persistance.sql.*;
import Presentation.Controllers.*;
import Presentation.Views.*;
import SupportClasses.KeyMap;
import SupportClasses.PianoOctaves;

import javax.swing.*;
import java.io.FileNotFoundException;

/**
 * Main of the program
 */
public class Main {
    public static void main(String[] args){
        Config config = new Config();
        try {
            config.configJson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SQLConnector sqlConnector = new SQLConnector(config.getUser(), config.getPassword(), config.getIp(), config.getPort(), config.getName());
        UserDAO userDAO = new SQLUserDAO(sqlConnector);
        SongDAO songDAO = new SQLSongDAO(sqlConnector);
        PlaylistDAO playlistDAO = new SQLPlaylistDAO(sqlConnector);
        PlaylistSongDAO playlistSongDAO = new SQLPlaylistSongDAO(sqlConnector);
        UserPlaylistDAO userPlaylistDAO = new SQLUserPlaylistDAO(sqlConnector);

        SwingUtilities.invokeLater(() ->{
            KeyMap km = new KeyMap();
            PianoOctaves po = new PianoOctaves();

            DatabaseManager dm = new DatabaseManager(userDAO, songDAO, playlistDAO, playlistSongDAO, userPlaylistDAO);
            PlayModel pm = new PlayModel(km, po, dm);
            UserModel um = new UserModel(dm);
            SongModel sm = new SongModel(dm, um);
            StatisticsModel stm = new StatisticsModel(dm);
            PianoController pianoController = new PianoController(pm);

            WebScrapper webScrapper = new WebScrapper(dm, config);
            WebScrapperUpdateController webScrapperUpdateController = new WebScrapperUpdateController(webScrapper);
            webScrapperUpdateController.trigger();

            WelcomeView wv = new WelcomeView();
            MainMenuView mmv = new MainMenuView();
            SettingsView sv = new SettingsView(km);
            RegisterLoginView rlv =  new RegisterLoginView();
            TrainingView tv = new TrainingView(km, pianoController);
            PlayView playView = new PlayView(pianoController);
            PlaylistView plv = new PlaylistView(dm, um);
            PlaylistSongView plsv = new PlaylistSongView(dm, pm);
            StatisticsView stv = new StatisticsView();
            CardView cv = new CardView(mmv, sv, rlv, tv, wv, plv, plsv, playView, stv);

            CardController cc = new CardController(cv);
            WelcomeController wc = new WelcomeController(wv, cv);
            MainMenuController mmc = new MainMenuController(mmv, cc, um);
            SettingsController sc = new SettingsController(sv, cc, km, um);
            RegisterLoginController rlc = new RegisterLoginController(rlv, cv, um);
            TrainingController tc = new TrainingController(tv, cc, km, pm, um);
            PlayController playController = new PlayController(playView, km, pm);
            PlaylistController plc = new PlaylistController(plv, plsv, cv, pm, um, sm);
            StatisticsController stc = new StatisticsController(stm, stv, um);

            cv.registerController(cc);
            wv.registerController(wc);
            mmv.registerController(mmc, cc);
            sv.registerController(sc, cc);
            rlv.registerController(rlc);
            tv.registerController(tc, cc);
            plv.setController(plc, cc);
            plv.registerController(plc, cc);
            plsv.registerController(plc, cc);
            plsv.setController(plc, cc);
            stv.registerController(stc, cc);
            stv.setController(stc);
            playView.registerController(playController, pianoController, cc);
            webScrapper.registerController(webScrapperUpdateController);
            cv.setVisible(true);
        });
    }
}
