package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class holds the code needed to for when the user would like to load the game from the information on the txt file with the co-ords
 */
public class GameLoader {

    private String fileName;
    private Game game;

    /**
     * Initialise a new gameloader
     * @param fileName the name of the save file
     */
    public GameLoader(String fileName, Game g) {
        this.fileName = fileName;
        game = g;

    }

    /**
     * Read the save state data from the save file and print it to
     * the terminal window.
     */
    public GameLevel loadGame() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);

            String line = reader.readLine();
            int levelNumber = Integer.parseInt(line);

            GameLevel level  = null;
            if (levelNumber == 1){
                level = new Level1();
                Sounds.getBackground1().loop();
            }
            else if (levelNumber == 2){
                level = new Level2();
                Sounds.getBackground2().loop();
            }
            else if (levelNumber == 3) {
                level = new Level3();
                Sounds.getBackground3().loop();
            }

            while ((line = reader.readLine()) != null){
                String[] tokens = line.split(",");
                String className = tokens[0];
                float xPlayer = Float.parseFloat(tokens[1]);
                float yPlayer = Float.parseFloat(tokens[2]);
                //int balls = Integer.parseInt(tokens[3]);
                Vec2 posPlayer = new Vec2(xPlayer,yPlayer);

                if (className.equals("MainChar")){
                    int count = Integer.parseInt(tokens[3]);
                    MainChar b = new MainChar(level);
                    b.setPosition(posPlayer);
                    b.setCount(count);
                    level.setPlayer(b);
                }
                if (className.equals("Door")){
                    Body b = new Door(level);
                    b.setPosition(posPlayer);
                    b.addCollisionListener(new DoorListener(game));
                }
                if (className.equals("LebronCoin")){
                    Body b = new LebronCoin(level);
                    b.setPosition(posPlayer);
                    b.addCollisionListener(new PickCoin(level.getPlayer()));
                }
                if (className.equals("Spike")){
                    Body b = new Spike(level);
                    b.setPosition(posPlayer);
                    b.addCollisionListener(new SpikeDamage(level.getPlayer()));
                }
                if (className.equals("Platform")){
                    float w = Float.parseFloat(tokens[3]);
                    float h = Float.parseFloat(tokens[4]);
                    Body b = new Platform(level ,w,h);
                    b.setPosition(posPlayer);
                }
                Shape groundShape = new BoxShape(12.5f, 1.5f);
                Body b = new StaticBody(level, groundShape);
                b.setPosition((new Vec2(0, -11.5f)));
            }
            return level;



        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}
