package Business.ConfigDatabase.GestionJSON;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * The type Config. Is crucial for the execution of the game, with this class we will be reading
 * the config.json file set by our user to eventually connect to the databases and set the WebScrapping pace.
 */
public class Config {
    private int port;
    private String ip;
    private String name;
    private String user;
    private String password;
    private int time;

    /**
     * This is the only function from this class and will be in charge of using a Reader to read the
     * config.json file needed to configure the Database and parse the information needed from said file.
     *
     * @throws FileNotFoundException the file not found exception
     */
    public void configJson() throws FileNotFoundException {
        Reader reader = new FileReader("src/Business/ConfigDatabase/GestionJSON/config.json");
        JsonObject dataConfig = JsonParser.parseReader(reader).getAsJsonObject();

        port = dataConfig.get("port").getAsInt();
        ip = dataConfig.get("ip").getAsString();
        name = dataConfig.get("name").getAsString();
        user = dataConfig.get("user").getAsString();
        password = dataConfig.get("password").getAsString();
        time = dataConfig.get("time").getAsInt();
    }

    /**
     * Gets MySQL port, extracted from config.json file.
     *
     * @return an int with the MySQL port
     */
    public int getPort() {
        return port;
    }

    /**
     * Gets ip for connection, extracted from config.json file.
     *
     * @return a String with the ip needed for connecting with the Database.
     */
    public String getIp() {
        return ip;
    }

    /**
     * Gets name from the Databases, extracted from config.json file.
     *
     * @return a String with the name from the Database.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets user name to access the Database in further connection, extracted from config.json file.
     *
     * @return a String with the username needed for connecting with the Database.
     */
    public String getUser() {
        return user;
    }

    /**
     * Gets the time period (in seconds) which will establish the pace of the WebScrapping for the download of songs, extracted from config.json file.
     *
     * @return an int with the time (in seconds) needed to set the WebScrapping intervals.
     */
    public int getTime() {
        return time;
    }

    /**
     * Gets password to connect to the Database, extracted from config.json file.
     *
     * @return a String with the password needed for connecting with the Database.
     */
    public String getPassword() {
        return password;
    }


}
