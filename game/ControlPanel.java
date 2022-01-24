package game;

import city.cs.engine.World;
import org.jbox2d.pooling.IWorldPool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

/**
Here you'd find the code of the buttons and everything related to the control panel
 */

public class ControlPanel {
    /**
     * the Jbuttons and panels are established here and was previously modified with the form section of IntelliJ
     */
    private Game game;
    private JButton pauseButton;
    private JButton restartButton;
    private JButton exitButton;
    private JPanel mainPanel;
    private JButton nextLevelButton;

    public ControlPanel(Game game) {
        this.game = game;
        //Exit button code below
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // Pause button code below
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("PP");
                game.Pause();
            }

        });
        //Restart button code below
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.NewFreshWorld();

            }
        });
        //Next level button code below
        nextLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goNextLevel();
            }
        });
    }
    //The control panel is called when the game is ran
    public JPanel getMainPanel() {
        return mainPanel;
    }

}
