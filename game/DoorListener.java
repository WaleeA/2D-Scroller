package game;

import city.cs.engine.*;


/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {
    private Game game;
    
    public DoorListener(Game game) {
        this.game = game;
    }

    /**
     * this public function is used by the main character class and anything that would need to collide with the door.
     * It checks if the player is touching the door and has the right amount of coins to move onto the next level
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        MainChar player = game.getPlayer();
        // The door waits for the player to touch and checks if they have the correct amount of coins to move on
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
}
