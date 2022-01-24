package game;

import city.cs.engine.*;
import com.sun.tools.javac.Main;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * the code for the basics of a level of the game.
 */
public abstract class GameLevel extends World {
    public MainChar kobe;
    
    public MainChar getPlayer() {
        return kobe;
    }
    public void setPlayer(MainChar p) {kobe = p; }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {

        kobe = new MainChar(this);
        kobe.setPosition(startPosition());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));

    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
    /** Gets the level number to be used by other classes */
    public abstract int getLevelNumber();

}
