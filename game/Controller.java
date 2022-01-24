package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
/**
This class is used by the program for any controls of the game. This also stores the code for the characters movement and Save/load game
 */
/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    /**
     * Below the character speed is set and the game and game level class is called in
     */
    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 5;
    
    public Walker body;
    private GameLevel currentLevel;
    private Game game;

    /**
     * public function is created so the controller can be used by other classes in collaboration with the walker, gamelevel and game class
     * @param body
     * @param level
     * @param game
     */
    public Controller(Walker body, GameLevel level, Game game) {
        this.body = body;
        currentLevel = level;
        this.game = game;
    }

    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) { // SPACE = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            body.startWalking(- WALKING_SPEED); // LEFT ARROW = walk left
        } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // RIGHT ARROW = walk right
        }
        else if (code == KeyEvent.VK_S){ // S = Save State
            GameSaver sw = new GameSaver("data/saveFile.txt");
            try{
                sw.saveGame(currentLevel);
        }
            catch (IOException ex) {
                ex.printStackTrace();
            }
    }
        else if (code == KeyEvent.VK_R){ // R = Load State
            GameLoader sr = new GameLoader("data/saveFile.txt", game);
            try{
                GameLevel loadedGame = sr.loadGame();
                game.goToLevel(loadedGame);
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }


    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            body.stopWalking();
        }
    }

    public void setBody(Walker body) {
        this.body = body;
    }
    public void setWorld(GameLevel level){
        this.currentLevel = level;
    }
}
