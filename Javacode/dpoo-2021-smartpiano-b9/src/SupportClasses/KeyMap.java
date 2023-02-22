package SupportClasses;

import java.util.HashMap;

/**
 * The type Key map.
 */
public class KeyMap {
    /**
     * The Keymap.
     */
    private HashMap<String, Integer> keymap;

    /**
     * Instantiates a new Key map.
     */
    public KeyMap(){
        keymap = new HashMap<>();

        keymap.put("C",65);
        keymap.put("D",83);
        keymap.put("E",68);
        keymap.put("F",70);
        keymap.put("G",71);
        keymap.put("A",72);
        keymap.put("B",74);
        keymap.put("C#",87);
        keymap.put("D#",69);
        keymap.put("F#",84);
        keymap.put("G#",89);
        keymap.put("A#",85);
        keymap.put("3",16);
        keymap.put("5",32);
    }

    /**
     * Set value.
     *
     * @param key   the key
     * @param value the value
     */
    public void setValue(String key, int value){
        if ((value >= 65 && value <= 90) || (value >= 48 && value <= 57)) {
            keymap.put(key, value);
        } else{
            switch (value){
                case 8: //Backspace
                case 9: //Tab
                case 10: //Enter
                case 16: //Shift
                case 17: //Control / Alt gr
                case 18: //Alt
                case 27: //Escape?
                case 32: //Space
                case 153: //bigger smaller
                    keymap.put(key, value);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Get value string.
     *
     * @param key the key
     * @return the string
     */
    public String getValue(String key){
        String lletra = new String();
        int value = keymap.get(key);

        if ((value >= 65 && value <= 90) || (value >= 48 && value <= 57)) {
            lletra = Character.toString(keymap.get(key));
        } else{
            switch (value){
                case 8: //Backspace
                    lletra = "⌫";
                    break;
                case 9: //Tab
                    lletra = "⇥";
                    break;
                case 10: //Enter
                    lletra = "↩";
                    break;
                case 16: //Shift
                    lletra = "⇧";
                    break;
                case 17: //Left control
                    lletra = "⌃";
                    break;
                case 18: //Alt / Alt gr
                    lletra = "⌘";
                    break;
                case 27: //Escape?
                    lletra = "␛";
                    break;
                case 32: //space
                    lletra = "␣";
                    break;
                case 153:
                    lletra = "\uD83D\uDE02";
                    break;
                default:
                    break;
            }
        }

        return lletra;
    }

    /**
     * Get key string.
     *
     * @param value the value
     * @return the string
     */
    public String getKey(int value){
        for (HashMap.Entry<String, Integer> entry : keymap.entrySet()){
            if (entry.getValue() == value){
                return entry.getKey();
            }
        }
        return null;
    }

    public HashMap getKeyMap(){
        return keymap;
    }
}
