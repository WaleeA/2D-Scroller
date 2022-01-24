package game;

import city.cs.engine.*;

/**
 * Listener for collision with a coin.  When the player collides with a coin,
 * a point is added to the player's count and if enough is collected then the player can proceed to the door
 */
public class PickCoin implements CollisionListener {
    private final MainChar kobe;

    
    public PickCoin(MainChar kobe) {
        this.kobe = kobe;
    }

    @Override
    /**picking up coin function */
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == kobe) {
            kobe.incrementBallCount();
            //coin is gone when touched
            e.getReportingBody().destroy();
        }
    }
    
}
