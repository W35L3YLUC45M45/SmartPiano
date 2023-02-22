package Business;

import Business.ConfigDatabase.DatabaseManager;
import Business.Entities.Playlist;
import Business.Entities.Song;
import Business.Entities.UserPlaylist;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Song model will be used by the Playlist Controller, relating our Controller to the Database Manager.
 */
public class SongModel {

    private DatabaseManager dm;
    private UserModel um;

    /**
     * Instantiates a new Song model.
     *
     * @param dm the Database Manager.
     * @param um the User Model.
     */
    public SongModel (DatabaseManager dm, UserModel um){
        this.dm = dm;
        this.um = um;
    }

    /**
     * Method meant to Delete songs from the Database.
     *
     * @param id the id from the song we are willing to delete from Database.
     */
    public void deleteSong(int id){
        dm.getPlaylistSongDao().deleteSong(id);
        dm.getSongDao().deleteSong(id);
    }

    /**
     * Method meant to Delete playlists from the Database.
     *
     * @param id the id from the playlist we are willing to delete from Database.
     */
    public void deletePlaylist(int id) {
        dm.getPlaylistSongDao().deletePlaylist(id);
        dm.getUserPlaylistDAO().deleteUserPlaylistByPlaylist(id);
        dm.getPlaylistDao().deletePlaylist(id);
    }

    /**
     * Add playlist is a method that will simply add the given Playlist from our User into the Databases.
     *
     * @param playlist the Playlist created by our User through the Playlist Controller.
     */
    public void addPlaylist(Playlist playlist){
        dm.getPlaylistDao().addPlaylist(playlist);
        try {
            Playlist temp_playlist = dm.getPlaylistDao().getPlaylistByName(playlist.getName());
            dm.getUserPlaylistDAO().addPlaylist(new UserPlaylist(um.getUser().getUsername(), temp_playlist.getId()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Update playlist is a method that change a song from one playlist to another in the Database.
     *
     * @param ID_Song Song that we want to change.
     * @param name_playlist Name of the destination playlist.
     * @throws SQLException Throws when a playlist cannot be found in the database.
     */
    public void updatePlaylist (int ID_Song, String name_playlist) throws SQLException{
        Playlist temp_playlist = dm.getPlaylistDao().getPlaylistByName(name_playlist);
        dm.getPlaylistSongDao().updatePlaylist(ID_Song, temp_playlist.getId());
    }

    /**
     * Getter for the public playlists available in the database.
     *
     * @return The public playlists available.
     */
    public ArrayList<Playlist> getPublicPlaylists(){
        try {
            return dm.getPlaylistDao().getPublicPlaylists();
        } catch (SQLException throwables) {
            return null;
        }
    }

    /**
     * Getter for the private playlists available in the database.
     *
     * @return The private playlists available.
     */
    public ArrayList<Playlist> getPrivatePlaylists(){
        ArrayList<Integer> privatePlaylistList = new ArrayList<>();
        try {
            privatePlaylistList = dm.getUserPlaylistDAO().getUserPrivatePlaylist(um.getUser().getUsername());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ArrayList<Playlist> privatePlaylists = new ArrayList<>();
        for (int i = 0; i < privatePlaylistList.size(); i++) {
            try {
                privatePlaylists.add(dm.getPlaylistDao().getPlaylist(privatePlaylistList.get(i)));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return privatePlaylists;
    }

    /**
     * Getter for the number of songs in a playlist.
     *
     * @param id The id of the playlist.
     * @return The number of songs.
     */
    public int getPlaylistSize(int id){
        try {
            return dm.getPlaylistSongDao().getSongsByIDPlaylist(id).size();
        } catch (SQLException throwables) {
            return 0;
        }
    }

    /**
     * Getter for the information of a playlist.
     *
     * @param id The id of the playlist.
     * @return The playlist we searched.
     */
    public Playlist getPlaylist(int id){
        try {
            return dm.getPlaylistDao().getPlaylist(id);
        } catch (SQLException throwables) {
            return null;
        }
    }

    /**
     * Getter for the id of the songs in a playlist.
     *
     * @param id The id of the playlist.
     * @return The id of the songs.
     */
    public ArrayList<Integer> getSongsList(int id){
        ArrayList<Integer> songsList = new ArrayList<>();
        try {
            songsList = dm.getPlaylistSongDao().getSongsByIDPlaylist(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return songsList;
    }

    /**
     * Getter for the songs in the database.
     *
     * @return The songs.
     */
    public ArrayList<Song> getSongs(ArrayList<Integer> songsList){
        ArrayList<Song> songs = new ArrayList<>();
        for (int i = 0; i < songsList.size(); i++) {
            try {
                songs.add(dm.getSongDao().getSong(songsList.get(i)));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return songs;
    }

    /**
     * Getter for an specific song in the database.
     *
     * @param id The id of the song.
     * @return The song.
     */
    public Song getSong(int id) throws SQLException{
        return dm.getSongDao().getSong(id);
    }

    /**
     * Update song is used when we want to change the number of times a song has been listened.
     *
     * @param ID_Song The id of the song listened.
     * @param duration The number of times it has been listened.
     */
    public void updateSong(int ID_Song, int duration) {
        dm.getSongDao().updateSong(ID_Song, duration);
    }
}
