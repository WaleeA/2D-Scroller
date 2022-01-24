package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * This class is developed to store the information needed to allow the game to have any music or sounds such as the background music of the levels
 *
 */

public class Sounds {

    private static SoundClip background1;

    /**
     * Information about the background music for the first level
     */
    static {
        try {
            background1 = new SoundClip("data/sounds/bg1.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex){
            ex.printStackTrace();
        }

    }

    public static SoundClip getBackground1(){
        return background1;
    }

    private static SoundClip background2;
    /**
     * Information about the background music for the second level
     */
    static {
        try {
            background2 = new SoundClip("data/sounds/bg2.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex){
            ex.printStackTrace();
        }
    }
    public static SoundClip getBackground2(){
        return background2;
    }

    private static SoundClip background3;
    /**
     * Information about the background music for the third level
     */
    static {
        try {
            background3 = new SoundClip("data/sounds/bg3.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex){
            ex.printStackTrace();
        }
    }
    public static SoundClip getBackground3(){
        return background3;
    }
}
