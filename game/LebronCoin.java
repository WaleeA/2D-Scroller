package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * This class holds the information of the coins in the game.
 * If the player collides with the coin then a point is added for the player and the coin is destroyed
 * The size and image of the coin is defined here
 */

public class LebronCoin extends DynamicBody {
    private static final Shape shape = new CircleShape(0.7f);
    private static final BodyImage image =
            new BodyImage("data/lebroncoin.png", 3.55f);

    /**
     *  Initialise a new coin.
     * @param world
     */

    public LebronCoin(World world) {
        super(world, shape);
        addImage(image);

    }
}
