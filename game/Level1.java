package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;



/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private static final int NUM_Coins = 1;
    public MainChar kobe;


    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);


        //for floor


        Platform ground = new Platform(this, 12.5f,1.5f);
        ground.setPosition(new Vec2(0, -11.5f));


        //for spikes placement

        Shape SpikeShape = new BoxShape(0.75f, 0.75f);
        Body Spike = new Spike(this, SpikeShape);
        Spike.addImage(new BodyImage("data/spike.png", 2.0f));
        Spike.setPosition(new Vec2(-4, -9));

        Shape SpikeShape2 = new BoxShape(0.75f, 0.75f);
        Body Spike2 = new Spike(this, SpikeShape2);
        Spike2.addImage(new BodyImage("data/spike.png", 2.0f));
        Spike2.setPosition(new Vec2(10, -9));

        Spike.addCollisionListener(new SpikeDamage(getPlayer()));
        Spike2.addCollisionListener(new SpikeDamage(getPlayer()));



        Body leftWall = new Platform(this, 0.5f, 6);
        leftWall.setPosition(new Vec2(-11.5f,-4.5f));
        Body rightWall = new Platform(this, 0.5f, 6);
        rightWall.setPosition(new Vec2(11.5f,-4.5f));

        // for platforms

        Body platform1 = new Platform(this, 4,0.5f);
        platform1.setPosition(new Vec2(-7, 4.5f));


        Body platform2 = new Platform(this, 4,0.5f);
        platform2.setPosition(new Vec2(5, 6.5f));

        Body platform3 = new Platform(this, 2.5f,0.5f);
        platform3.setPosition(new Vec2(3, -1.3f));


        //making coin
        for (int i = 0; i < 11; i++) {
            Body Bball = new LebronCoin(this);
            Bball.setPosition(new Vec2(i * 2 - 13, 20));
            Bball.addCollisionListener(new PickCoin(getPlayer()));
        }
        Sounds.getBackground1().loop();
    }



    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
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

        return 1;
    }


}

