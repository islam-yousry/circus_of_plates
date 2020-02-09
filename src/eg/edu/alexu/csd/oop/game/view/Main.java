package eg.edu.alexu.csd.oop.game.view;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.difficulties.Difficulty;
import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.difficulties.EasyDifficulty;
import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.difficulties.HardDifficulty;
import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.difficulties.MediumDifficulty;
import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.modes.ArcadeMode;
import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.modes.Mode;
import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.modes.TimedMode;
import eg.edu.alexu.csd.oop.game.model.worlds.levels.Level;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Main {

    private static JMenuBar menuBar = new JMenuBar();
    private static GameEngine.GameController gameController;

    public static void starter(String mode, Difficulty difficulty){
        Level level;
        if(mode.equals("ArcadeMode")){
            level = new Level(new ArcadeMode(difficulty));
        }
        else {
            level = new Level(new TimedMode(difficulty));
        }
        gameController = GameEngine.start("Test Run", level);
    }



    public static void main(String[] args) {

        try {
            IntroGUI newGame = new IntroGUI("/circus_background.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        JMenu menu1 = new JMenu("File");

        JMenu menu2 = new JMenu("Options");

        JMenu menu3 = new JMenu("MainMenu");

        JMenuItem newMenuItem = new JMenu("New Game");
        JMenuItem ArcadeModeItem = new JMenu("Arcade Mode");
        JMenuItem TimeModeItem = new JMenu("Time Mode");
        JMenuItem easyArcadeModeItem = new JMenuItem("Easy");
        JMenuItem normalArcadeModeItem = new JMenuItem("Normal");
        JMenuItem hardArcadeModeItem = new JMenuItem("Hard");
        JMenuItem easyTimeModeItem = new JMenuItem("Easy");
        JMenuItem normalTimeModeItem = new JMenuItem("Normal");
        JMenuItem hardTimeModeItem = new JMenuItem("Hard");

        ArcadeModeItem.add(easyArcadeModeItem);
        ArcadeModeItem.add(normalArcadeModeItem);
        ArcadeModeItem.add(hardArcadeModeItem);
        TimeModeItem.add(easyTimeModeItem);
        TimeModeItem.add(normalTimeModeItem);
        TimeModeItem.add(hardTimeModeItem);

        newMenuItem.add(ArcadeModeItem);
        newMenuItem.add(TimeModeItem);

        easyArcadeModeItem.addActionListener(arg0 -> {
            // TODO Auto-generated method stub
            starter("ArcadeMode", new EasyDifficulty());
        });

        normalArcadeModeItem.addActionListener(e -> {
            // TODO Auto-generated method stub
            starter("ArcadeMode", new MediumDifficulty());
        });

        hardArcadeModeItem.addActionListener(e -> {
            // TODO Auto-generated method stub
            starter("ArcadeMode", new HardDifficulty());
        });

        easyTimeModeItem.addActionListener(e -> {
            // TODO Auto-generated method stub
            starter("TimeMode", new EasyDifficulty());
        });

        normalTimeModeItem.addActionListener(e -> {
            // TODO Auto-generated method stub
            starter("TimeMode", new MediumDifficulty());
        });

        hardTimeModeItem.addActionListener(e -> {
            // TODO Auto-generated method stub
            starter("TimeMode", new HardDifficulty());
        });

        newMenuItem.addActionListener(e -> {
            // TODO Auto-generated method stub
            //gameController.changeWorld();
        });

        JMenuItem saveMenuItem = new JMenu("Save");
        saveMenuItem.addActionListener(arg0 -> {
            // TODO Auto-generated method stub


        });

        JMenuItem loadMenuItem = new JMenu("Load");
        loadMenuItem.addActionListener(e -> {
            // TODO Auto-generated method stub

        });

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> {
            // TODO Auto-generated method stub
            System.exit(0);
        });


        menu1.add(newMenuItem);
        menu1.addSeparator();
        menu1.add(saveMenuItem);
        menu1.add(loadMenuItem);
        menu1.addSeparator();
        menu1.add(exitMenuItem);

        JMenuItem replayMenuItem = new JMenuItem("Replay");
        replayMenuItem.addActionListener(e -> {
            // TODO Auto-generated method stub
            //gameController.pause();
            //level.flag = false;
        });

        JMenuItem resumeItem = new JMenuItem("Resume");
        JMenuItem pauseItem = new JMenuItem("Pause");

        resumeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2.remove(resumeItem);
                menu2.remove(replayMenuItem);
                menu2.add(pauseItem);
                menu2.add(replayMenuItem);
                gameController.resume();
            }

        });

        pauseItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu2.remove(pauseItem);
                menu2.remove(replayMenuItem);
                menu2.add(resumeItem);
                menu2.add(replayMenuItem);
                gameController.pause();
            }
        });

        menu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    new IntroGUI("/circus_background.png");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        menu2.add(pauseItem);
        menu2.add(replayMenuItem);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

    }
}
