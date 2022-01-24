package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.BorderLayout;

/**
 * This is the main class where the code for the main code for the game, controller and window is mainly stored.
 * Also stored in this class is the main functions that is used to create, load and manage the levels.
 *  Essentially this class is the mother class of the whole program.
 */

public class Game {

    private GameLevel world;
    private MyView view;
    private int level;
    private Controller controller;

    /**
     * This public function is used by pretty much all classes and it establishes the grounds of the game window and the basics of the start of the level
     */
    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);
        //Window size is established below
        view = new MyView(world, world.getPlayer(),  500, 550);


        //view.setGridResolution(1);

        //creates new window for game
        final JFrame frame = new JFrame("WaleeAhmedGame");

        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(),BorderLayout.SOUTH);

        //Controller c = new Controller(world.getPlayer());
        //frame.addKeyListener(c);


        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display game world within window
        frame.add(view);
        // user cannot resize window
        frame.setResizable(false);
        frame.pack();

        frame.setVisible(true);

        frame.requestFocus();
        view.addMouseListener(new GiveFocus(frame));

        controller = new Controller(world.getPlayer(), world, this);
        frame.addKeyListener(controller);

        // JFrame debugView = new DebugViewer(world, 500, 500);

       //starts game world
        world.start();
    }
    public MainChar getPlayer() { return world.getPlayer();
    }

    /**
     * function created to pause the game whenever called by the program
     */
    public void Pause(){
            world.stop();
    }
    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    /**This is used to load the level from the save state after the user saved the game and is trying to load the game by pressing R */
    public void goToLevel(GameLevel lev) {
        world.stop();
        if  (level == 1){
            Sounds.getBackground1().stop();
        }else if (level == 2){
            Sounds.getBackground2().stop();
        }else if (level == 3){
            Sounds.getBackground3().stop();
        }
        level = lev.getLevelNumber();
            // get a new world
        world = lev;
        view.AddLevel();
        controller.setBody(world.getPlayer());
        // show the new world in the view
        view.setWorld(world);


        world.start();

    }
    /** This function is used by the program for whenever the user restarted the game from the GUI */
    public void NewFreshWorld(){
        if (level == 1) {

            world = new Level1();}
        else if (level == 2){
            world = new Level2();
        }
        else if (level == 3){
            world = new Level3();
        }
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            // show the new world in the view
            view.setWorld(world);


            world.start();


    }

    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        if (level == 3) {

            //controller.setBody(world.getPlayer());
            System.exit(0);
        } else if (level == 1) {
            Sounds.getBackground1().stop();
            level++;

            // get a new world
            world = new Level2();
            view.AddLevel();
            NewFreshWorld();
        }
        else if (level == 2){
            Sounds.getBackground2().stop();
            level++;
            view.AddLevel();
            // get a new world
            world = new Level3();
            NewFreshWorld();
        }
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}
