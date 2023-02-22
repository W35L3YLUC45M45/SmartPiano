package Business;

import Business.ConfigDatabase.DatabaseManager;
import Business.ConfigDatabase.GestionJSON.Config;
import Business.Entities.PlaylistSong;
import Business.Entities.Song;
import SupportClasses.ConstantList;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The type Web scrapper will be extremely useful to help our User Download automatically by groups of 10,
 * all songs from the Official Website that our game uses. This way he will be able to fill up the Databases with
 * songs that might be used along the game.
 */
public class WebScrapper {

    private int startAt = 10;
    private String title;
    private String composer;
    private int duration;
    private String creation_date;
    private String genre;
    private String release_date;
    private String midi;
    private final Config config;

    private final DatabaseManager databaseManager;


    /**
     * Instantiates a new WebScrapper.
     *
     * @param databaseManager the Database Manager that will link the downloaded songs to those on the Database.
     * @param config          the config Class will be the link to our config.json file containing the reloading time
     *                        that our WebScrapper should follow when downloading the songs from the Internet.
     */
    public WebScrapper (DatabaseManager databaseManager, Config config){
        this.databaseManager = databaseManager;
        this.config = config;
        startWebScrapping();
    }

    /**
     * This method will Start the WebScrapping by getting a Connection Status Code from the url used to obtain all songs
     * needed in the game.
     * Once this connection is done correctly it will parse the Website and extract the songs in groups of 10 to later on
     * add them to the Databases.
     */
    public void startWebScrapping(){
        String urlStartAt = "https://www.mutopiaproject.org/cgibin/make-table.cgi?startat=";
        urlStartAt = urlStartAt.concat(String.valueOf(startAt)).concat("&Instrument=Piano");

        // Compruebo si me da un 200 al hacer la petición
        if (getStatusConnectionCode(urlStartAt) == 200) {

            // Obtengo el HTML de la web en un objeto Document
            Document document = getHtmlDocument(urlStartAt);
            Elements groupOf10Elements = document.select("table.table-bordered.result-table");

            for (int i = 0; i < groupOf10Elements.size(); i++) {

                Elements allElementsFromOneTable = groupOf10Elements.get(i).select("tr td");

                for (int j = 0; j < allElementsFromOneTable.size(); j++) {

                //All important fields from tables in website.
                    //0 title
                    //1 composer
                    //2 ______
                    //3 ______
                    //4 ______
                    //5 creation_date
                    //6 genre
                    //7 ______
                    //8 ______
                    //9 ______
                    //10 ______
                    //11 release_date
                    //12 ______
                    //13 midi
                    //14 ______
                    //15 ______
                    //16 ______
                    //17 ______
                    //18 ______
                    //19 ______

                    switch (j % 20) {
                        case 0 -> {
                            title = allElementsFromOneTable.get(j).toString();
                            title = cleanString(title);
                        }
                        case 1 -> {
                            composer = allElementsFromOneTable.get(j).toString();
                            composer = cleanString(composer);
                        }
                        case 5 -> {
                            creation_date = allElementsFromOneTable.get(j).toString();
                            creation_date = cleanString(creation_date);
                        }
                        case 6 -> {
                            genre = allElementsFromOneTable.get(j).toString();
                            genre = cleanString(genre);
                        }
                        case 11 -> {
                            release_date = allElementsFromOneTable.get(j).toString();
                            release_date = cleanString(release_date);
                        }
                        case 13 -> {
                            midi = allElementsFromOneTable.get(j).toString();
                            midi = cleanMidi(midi);
                        }
                    }

                }
                Song newSong = new Song(title,composer,0,creation_date,"Web",genre,release_date, midi);
                Song previousSong;
                try {
                    previousSong = databaseManager.getSongDao().getSongByName(newSong.getTitle());
                    System.out.println("Already got song: " + newSong.getTitle());
                } catch (SQLException throwables) {
                    System.out.println("Adding song: " + newSong.getTitle());
                    databaseManager.getSongDao().addSong(newSong);
                    try {
                        previousSong = databaseManager.getSongDao().getSongByName(newSong.getTitle());
                        databaseManager.getPlaylistSongDao().addPlaylistSong(new PlaylistSong(1, previousSong.getID_song()));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        }else
            System.out.println("El Status Code no es OK es: "+getStatusConnectionCode(urlStartAt));

    }

    private String cleanMidi(String link) {
        return link.replace("<td><a href=\"", "").replace("\">.mid file</a></td>", "");
    }

    private String cleanString(String input) {
        String output;
        output = input.replace("<td>", "").replace("</td>", "");
        if(output.compareTo("&nbsp;") != 0 && output.compareTo("?") != 0){
            return output;
        }else {
            return "";
        }

    }

    /**
     * This method Gets the status connection code used on the method startWebScrapping().
     * If this status is not equal to 200, the connection will not be possible.
     *
     * @param url the url from the Website containing all songs for the game.
     * @return the status connection code meant to be used by the WebScrapper as a validation code.
     */
    public static int getStatusConnectionCode(String url) {

        HttpConnection.Response response = null;
        try {
            response = (HttpConnection.Response) Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        assert response != null;
        return response.statusCode();
    }

    /**
     * Gets html document.
     *
     * @param url the url
     * @return the html document
     */
    public static Document getHtmlDocument(String url) {

        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }
        return doc;

    }

    /**
     * This method will increase the StartAt variable in charge of indicating the WebScrapper from what page from the
     * website he is supposed to read the songs to be added. There is a safety lock at 780 as this is the page's limit.
     */
    public void increaseStartAt(){
        int startAtLimit = 780;
        if(startAt >= startAtLimit){
            startAt = 10;
        }else{
            startAt += 10;
        }
    }

    /**
     * The RegisterController method will register the given ActionListener as well as trigger the Timer from our
     * WebScrapper according to the value chosen by our User trough the Config.json file.
     *
     * @param actionListener the Action Listener from the webScrapperUpdateController.
     */
    public void registerController(ActionListener actionListener){

        int delay = config.getTime()*60000;
        Timer scrappingTimer = new Timer(delay, actionListener);
        scrappingTimer.start();
        scrappingTimer.setActionCommand(ConstantList.SCRAPPING_TIMER);
    }


}
