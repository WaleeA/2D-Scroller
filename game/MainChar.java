package game;

import city.cs.engine.*;

/**
 * This class holds information about the main character and the coin and health information too
 */

public class MainChar extends Walker {
    private Game game;
    /**
     * Private functions are created below to store the character image and polygon shape
     */
    private static final Shape shape = new PolygonShape(
            0.038f, 0.466f, 0.358f, 0.477f, 0.178f, -0.47f, -0.347f, -0.371f);

    private static final BodyImage image =
            new BodyImage("data/kobechar.png", 2.25f);

    /**
     * Ball count is initially 0 and health is set to 3
     */
    private int BballCount;
    private int HealthCount = 3;

    /**
     * Main character is initialised alongside the ball and health count
     * @param world
     */
    public MainChar(World world) {
        super(world, shape);
        addImage(image);

    }

    public int getBallCount() { return BballCount; }
    public void incrementBallCount() {
        BballCount++;
        System.out.println("Lebron Thanks you! Lebron Count = " + BballCount);
    }

    public int getHealthCount() {return HealthCount; }
    public void ReduceHealthCount(){
        HealthCount--;
        System.out.println("Hit Spike! OUCH! Life Count =" + HealthCount);
        if (HealthCount == 0){
            System.exit(0);
            System.out.println("Game Over!");
        }
    }
    public void setCount(int c){
        BballCount = c;
    }
}
