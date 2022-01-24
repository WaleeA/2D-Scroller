package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * This class holds the initial placement coding that used for all levels such as the walls and the floor
 */

public class GameWorld extends World {
    private MainChar kobe;

    /**
     * Code below is stored as a public function so it can easily be called later by the other classes
     * Code such as the intial floor and wall data can be found here
     * The character and coin is also established here
     */
    public GameWorld() {
        super();


        //for floor
        Shape groundShape = new BoxShape(12.5f, 1.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));


        //for spikes placement

        Shape SpikeShape = new BoxShape(0.75f,0.75f);
        Body Spike = new Spike(this, SpikeShape);
        Spike.addImage(new BodyImage("data/spike.png", 2.0f));
        Spike.setPosition(new Vec2(-4, -11));
        Spike.addCollisionListener(new SpikeDamage(kobe));

        

        // for platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        Shape smallBox = new BoxShape(2.5f,0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 7.5f));

        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(5, 11.5f));

        Body platform3 = new StaticBody(this,smallBox);
        platform3.setPosition(new Vec2(3,3.3f));
        

        //char placement
        kobe = new MainChar(this);
        kobe.setPosition(new Vec2(8, -10));
        
        
        //making coin
        for (int i = 0; i < 11; i++) {
            Body Bball = new LebronCoin(this);
            Bball.setPosition(new Vec2(i*2-13, 20));
            Bball.addCollisionListener(new PickCoin(kobe));
        }
    }
    /**kobe is made */
    public MainChar getPlayer() {
        return kobe;
    }
}
