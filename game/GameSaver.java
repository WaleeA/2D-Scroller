package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class holds the code that is needed for when the user wants to save the game. After they press the save button which is S, the code below is ran
 */
public class GameSaver {
    private String fileName;


    public GameSaver(String fileName) {
        this.fileName = fileName;
    }


    /**
     * function which holds the information about the current state of the game and writes it on the save file which is established before and overwrites any previous data
     * @param gameWorld
     * @throws IOException
     */
    public void saveGame(GameLevel gameWorld) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, false);

            writer.write(gameWorld.getLevelNumber() + "\n");

            writer.write(gameWorld.getPlayer().getClass().getSimpleName()+ "," +
                    gameWorld.getPlayer().getPosition().x + "," + gameWorld.getPlayer().getPosition().y + "," + gameWorld.getPlayer().getBallCount() + "\n");

            for (DynamicBody body : gameWorld.getDynamicBodies()){
                if (!(body instanceof MainChar))
                writer.write(body.getClass().getSimpleName()+ "," + body.getPosition().x + "," + body.getPosition().y + "\n");
            }
            for (StaticBody body : gameWorld.getStaticBodies()) {
                if (body instanceof Platform)
                    writer.write(body.getClass().getSimpleName() + "," +
                            body.getPosition().x + "," + body.getPosition().y + "," +
                            ((Platform) body).getWidth() + "," + ((Platform) body).getHeight() + "\n");
                else
                    writer.write(body.getClass().getSimpleName() + "," + body.getPosition().x + "," + body.getPosition().y + "\n");
            }} finally {
                if (writer != null) {
                    writer.close();
            }
        }
    }
}
