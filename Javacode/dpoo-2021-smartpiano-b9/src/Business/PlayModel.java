package Business;

import Business.ConfigDatabase.DatabaseManager;
import SupportClasses.KeyMap;
import SupportClasses.PianoOctaves;

import javax.sound.midi.*;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * The type Play model will be used whenever we need to play any song along the game. It will also
 * pause or stop any song as well as handle the volume as our users desire.
 */
public class PlayModel {

    private Synthesizer synthesizer;
    private Instrument[] inst;
    private MidiChannel[] channels;
    private Sequencer sequencer;
    private Sequence sequence;
    private boolean play;
    private boolean loop;

    private Synthesizer synth = null;

    private KeyMap km;
    private PianoOctaves po;
    private DatabaseManager dm;
    private HashMap <String, Integer> octave;

    /**
     * Instantiates a new Play model to be used by our PianoController.
     *
     * @param km the KeyMap containing the specific sound from each Key.
     * @param po the Piano Octaves to interpret the sounds to be played.
     * @param dm the Database Manager to store settings and changes.
     */
    public PlayModel(KeyMap km, PianoOctaves po, DatabaseManager dm){
        this.km = km;
        this.po = po;
        this.dm = dm;
        octave = po.getFourth();
        loop = false;

        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            inst =  synthesizer.getDefaultSoundbank().getInstruments();
            channels = synthesizer.getChannels();
            synthesizer.loadInstrument(inst[0]);

            synth = MidiSystem.getSynthesizer();
            synth.open();
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            play = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The method Play sound will get the value from the key depending on the octave
     * we are at and play the given note by means of another method called PlayNote.
     *
     * @param value the value
     */
    public void playSound(int value){
        if(km.getKeyMap().containsValue(value)) {
            String key;

            key = km.getKey(value);

            if(key.equals("3")){
                octave = po.getThird();
            } else if (key.equals("5")){
                octave = po.getFifth();
            } else{
                playNote(octave.get(key), 100);
            }
        }
    }

    /**
     * Play note will be the method in charge of interpreting the specific note at a given velocity
     * to generate the sound of the note we desire..
     *
     * @param noteNumber the note number
     * @param velocity   the velocity
     */
    public void playNote(int noteNumber, int velocity){
        channels[0].noteOn(noteNumber, velocity);
    }

    /**
     * Set sequence will be in charge of, given an specific url, play through the Sequencer
     * the midi file set by SetTracker method.
     *
     * @param url  the url containing the song to be played.
     * @param file the file containing our famous song Megalovania.
     */
    public void setSequence(String url, boolean file){
        try {
            if (file){
                sequence = MidiSystem.getSequence(new File("Megalovania.mid"));
            }else{
                sequence = MidiSystem.getSequence(new URL(url));

            }
            sequencer.setSequence(sequence);
            sequencer.setTickPosition(0);
            sequencer.start();
            play = true;

            if (synth.getDefaultSoundbank() == null) {
                sequencer.getTransmitter().setReceiver( MidiSystem.getReceiver() );
            } else {
                sequencer.getTransmitter().setReceiver( synth.getReceiver() );
            }
        } catch (Exception e) {
            sequencer.stop();
        }
    }

    /**
     * The method playPause will simply stop or start the sequencer from the class PlayModel when needed.
     */
    public void playPause(){
        try {
            if (play) {
                sequencer.stop();
            } else {
                sequencer.start();
            }
            play = !play;
        } catch (IllegalStateException e){

        }
    }

    /**
     * The method stopSound will be executed each time we need t stop the sound of any Key from the
     * Training section of the game or the Play section..
     *
     * @param value the value from the KeyMap we are willing to stop.
     */
    public void stopSound(int value){
        if(km.getKeyMap().containsValue(value)) {
            String key = km.getKey(value);

            if(key.equals("3")){
                octave = po.getFourth();
            } else if (key.equals("5")){
                octave = po.getFourth();
            } else {
                channels[0].noteOff(octave.get(key), 100);
            }
        }
    }

    /**
     * This method SetTrack will obtain the url from the song asked by our users from the Databases.
     *
     * @param id the id from the song we wish to obtain from the Database.
     */
    public void setTrack(String id){
        String url;
        try {
            url = dm.getSongDao().getSong(Integer.parseInt(id)).getMidi();
        } catch (SQLException | NumberFormatException throwables) {
            url = id;
        }
        setSequence(url, false);
    }

    /**
     * The method Loop will simply be needed when asked by PlayList Controller in case
     * our user wants to loop a song, in which case we would loop the Sequencer from here.
     */
    public void loop(){
        if(!loop){
            loop = true;
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        } else {
            loop = false;
            sequencer.setLoopCount(0);
        }
    }

    /**
     * Change volume is a method which will be called by the Playlist Controller which will provide us
     * with a certain gain in order to affect the volumeChannels from the midi.
     *
     * @param gain the gain obtained by the Slider from the Playlist Controller.
     */
    public void changeVolume(float gain){

        MidiChannel[] volumeChannels = synth.getChannels();
        for (int i = 0; i < volumeChannels.length; i++) {
            volumeChannels[i].controlChange(7, (int) (gain * 127.0));
        }
    }

    public void startTimer(){
    }

    public void stopTimer() {
    }
}
