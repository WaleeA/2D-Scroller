package game;

import java.awt.*;
import javax.swing.ImageIcon;
import city.cs.engine.*;

/**
 * extended view. Information about the health and coin text box is stored here
 * Also background image information is stored here
 */
public class MyView extends UserView {
    MainChar MChar;
    private int levelNum;
    private Image backGroundImage;
    public MyView(World world, MainChar MChar, int width, int height) {
        super(world, width, height);
        this.MChar = MChar;
        levelNum = 1;
        backGroundImage = new ImageIcon("data/GameBackground2.jpg").getImage();


    }
    public void AddLevel(){
        levelNum++;
    }
    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        if (levelNum == 1) {
            Image backGroundImage = new ImageIcon("data/GameLevel1BG.jpg").getImage();
            g.drawImage(backGroundImage,0,0,null);

        }
        else if (levelNum == 2){
            Image backGroundImage = new ImageIcon("data/GameLevel2BG.jpg").getImage();
            g.drawImage(backGroundImage,0,0,null);
        }
        else if (levelNum == 3){
            Image backGroundImage = new ImageIcon("data/BonusLevelBG.png").getImage();
            g.drawImage(backGroundImage,0,0,null);
        }
    }
    @Override
    protected void paintForeground(Graphics2D g) {


        g.setColor(Color.white);
        g.fillRect(30,30,70,50);
        g.drawRect(30,30,70,50);
        g.setColor(Color.BLACK);
        g.drawString("Score" + " " +MChar.getBallCount(), 45,50);
        g.drawString("Health" + " " + MChar.getHealthCount(),45,75);

        if (MChar.getHealthCount() == 0) {
            g.drawString("GAME OVER",0,0);
            }
        }


}


