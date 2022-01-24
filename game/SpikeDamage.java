package game;

import city.cs.engine.*;
/**
 * Listener for collision with a spike.  When the player collides with a spike,
 * the player loses a point from their health count. If the player's health reaches to 0 then the game is closed
 */
public class SpikeDamage implements CollisionListener{
    private final MainChar kobe;

    public SpikeDamage(MainChar kobe) {this.kobe = kobe;}

    @Override

    /**spike damage function below */
    public void collide(CollisionEvent e){
        if(e.getOtherBody() == kobe){
            //ball count function is used here from different java class
            kobe.ReduceHealthCount();

        }
    }
}
