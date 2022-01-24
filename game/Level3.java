package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

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
        Spike.setPosition(new Vec2(-6, -9));
        Spike.addCollisionListener(new SpikeDamage(getPlayer()));

        Shape Spike2Shape = new BoxShape(0.75f,0.75f);
        Body Spike2 = new Spike(this, Spike2Shape);
        Spike.addImage(new BodyImage("data/spike.png", 2.0f));
        Spike.setPosition(new Vec2(6, -9));
        Spike2.addCollisionListener(new SpikeDamage(getPlayer()));


        Body leftWall = new Platform(this, 0.5f, 6);
        leftWall.setPosition(new Vec2(-11.5f,-4.5f));
        Body rightWall = new Platform(this, 0.5f, 6);
        rightWall.setPosition(new Vec2(11.5f,-4.5f));

        // for platforms

        Body platform1 = new Platform(this, 9, 0.5f);
        platform1.setPosition(new Vec2(0, 9.5f));
        platform1.setFillColor(Color.BLACK);






        //making coin
        for (int i = 0; i < 21; i++) {
            Body Bball = new LebronCoin(this);
            Bball.setPosition(new Vec2(i*2-13, 8));
            Bball.addCollisionListener(new PickCoin(getPlayer()));
        }
        Sounds.getBackground3().loop();
    }
    //kobe is made

    /**
     * user start position is defined and fixed here
     * @return
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

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
        return 3;
    }
}
