package game;
import city.cs.engine.*;

/**
 * Information about the spike's characteristics is stored in this class.
 * This is used within all levels
 */

public class Spike extends StaticBody{
    public Spike(World world, Shape spikeShape) {
        super(world, new BoxShape(0.95f, 1.4f));
        addImage(new BodyImage("data/Spike.png", 2f));
    }


    public Spike(GameLevel level) {
        super(level);
    }
}
