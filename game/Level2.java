package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.Color;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_Coins = 1;



    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);


        //for floor
        Shape groundShape = new BoxShape(12.5f, 1.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));


        //for spikes placement

        Shape SpikeShape = new BoxShape(0.75f,0.75f);
        Body Spike = new Spike(this, SpikeShape);
        Spike.addImage(new BodyImage("data/spike.png", 2.0f));
        Spike.setPosition(new Vec2(-4, -9));
        Shape SpikeShape2 = new BoxShape(0.9f,0.75f);
        Body Spike2 = new Spike(this, SpikeShape2);
        Spike2.addImage(new BodyImage("data/spike.png", 2.0f));
        Spike2.setPosition(new Vec2(5f, 0));
        Shape SpikeShape3 = new BoxShape(0.75f,0.75f);
        Body Spike3 = new Spike(this, SpikeShape3);
        Spike3.addImage(new BodyImage("data/spike.png", 2.0f));
        Spike3.setPosition(new Vec2(10, -9));

        Spike.addCollisionListener(new SpikeDamage(getPlayer()));
        Spike2.addCollisionListener(new SpikeDamage(getPlayer()));
        Spike3.addCollisionListener(new SpikeDamage(getPlayer()));


        Body leftWall = new Platform(this, 0.5f, 6);
        leftWall.setPosition(new Vec2(-11.5f,-4.5f));
        Body rightWall = new Platform(this, 0.5f, 6);
        rightWall.setPosition(new Vec2(11.5f,-4.5f));

        // for platforms

        Body platform1 = new Platform(this, 4,0.5f);
        platform1.setPosition(new Vec2(-5, 4.5f));
        platform1.setFillColor(Color.ORANGE);




        Body platform3 = new Platform(this, 2.5f, 0.5f);
        platform3.setPosition(new Vec2(3, -1.3f));
        platform3.setFillColor(Color.ORANGE);





        //making coin
        for (int i = 0; i < 11; i++) {
            Body Bball = new LebronCoin(this);
            Bball.setPosition(new Vec2(i*2-13, 20));
            Bball.addCollisionListener(new PickCoin(getPlayer()));
        }
        Sounds.getBackground2().loop();
    }

    /**
     * User start position is defined and fixed here
     * @return
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    /**
     * the door position is defined and fixed
     * @return
     */
    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }
    /**
     * level will check if the user has the right amount of coins to progress
     * @return
     */
    @Override
    public boolean isCompleted() {
        return getPlayer().getBallCount() >= NUM_Coins;
    }

    @Override
    public int getLevelNumber() {
        return 2;
    }
}
