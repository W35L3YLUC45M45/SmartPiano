package SupportClasses;

import java.util.HashMap;

/**
 * The type Piano octaves.
 */
public class PianoOctaves {
    /**
     * The Third.
     */
    private HashMap<String, Integer> third;
    /**
     * The Fourth.
     */
    private HashMap<String, Integer> fourth;
    /**
     * The Fifth.
     */
    private HashMap<String, Integer> fifth;

    /**
     * Instantiates a new Piano octaves.
     */
    public PianoOctaves(){
        third = new HashMap<>();
        fourth = new HashMap<>();
        fifth = new HashMap<>();

        third.put("C",48);
        third.put("D",50);
        third.put("E",52);
        third.put("F",53);
        third.put("G",55);
        third.put("A",57);
        third.put("B",59);
        third.put("C#",49);
        third.put("D#",51);
        third.put("F#",54);
        third.put("G#",56);
        third.put("A#",58);

        fourth.put("C",60);
        fourth.put("D",62);
        fourth.put("E",64);
        fourth.put("F",65);
        fourth.put("G",67);
        fourth.put("A",69);
        fourth.put("B",71);
        fourth.put("C#",61);
        fourth.put("D#",63);
        fourth.put("F#",66);
        fourth.put("G#",68);
        fourth.put("A#",70);

        fifth.put("C",72);
        fifth.put("D",74);
        fifth.put("E",76);
        fifth.put("F",77);
        fifth.put("G",79);
        fifth.put("A",81);
        fifth.put("B",83);
        fifth.put("C#",73);
        fifth.put("D#",75);
        fifth.put("F#",78);
        fifth.put("G#",80);
        fifth.put("A#",82);
    }

    public HashMap getThird(){
        return third;
    }

    public HashMap getFourth(){
        return fourth;
    }

    public HashMap getFifth(){
        return fifth;
    }
}
