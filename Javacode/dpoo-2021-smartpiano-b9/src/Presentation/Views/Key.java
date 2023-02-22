package Presentation.Views;

/**
 * Class whose main purpose is declaring the piano keys
 */
public class Key {

    private int id;
    private int octave;

    /**
     * Constructor in charge of initializing the
     * piano keys' variables
     * @param id int that gives an id to each key of the piano
     * @param octave int that acts as a trigger to activate the sound of the piano keys
     *               depending on the octave
     */
    public Key(int id, int octave){
        this.id = id;
        this.octave = octave;
    }
}
