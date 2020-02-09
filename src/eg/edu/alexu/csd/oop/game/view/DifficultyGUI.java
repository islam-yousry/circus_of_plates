package eg.edu.alexu.csd.oop.game.view;

import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.difficulties.EasyDifficulty;
import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.difficulties.HardDifficulty;
import eg.edu.alexu.csd.oop.game.model.worlds.levelStrategies.difficulties.MediumDifficulty;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DifficultyGUI {
    JFrame window = new JFrame("Circus of Plates");

    String path;
    BufferedImage image;

    JButton easy = new JButton("Easy");
    JButton normal = new JButton("Normal");
    JButton hard = new JButton("Hard");
    JButton back = new JButton("Back");


    public DifficultyGUI(String path , JFrame ModeGUI, String mode) throws IOException {

        image = ImageIO.read(getClass().getResourceAsStream(path));

        window.setVisible(true);
        window.setSize(1400, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);

                easy.setBounds(565, 200, 300, 75);
                normal.setBounds(565, 300, 300, 75);
                hard.setBounds(565, 400, 300, 75);
                back.setBounds(565, 500, 300, 75);

                easy.setBackground(Color.cyan);
                normal.setBackground(Color.cyan);
                hard.setBackground(Color.cyan);
                back.setBackground(Color.cyan);

                easy.setFont(new Font("Tahoma", Font.BOLD, 30));
                normal.setFont(new Font("Tahoma", Font.BOLD, 30));
                hard.setFont(new Font("Tahoma", Font.BOLD, 30));
                back.setFont(new Font("Tahoma", Font.BOLD, 30));

                window.add(easy);
                window.add(normal);
                window.add(hard);
                window.add(back);


                easy.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        window.dispose();
                        Main.starter(mode, new EasyDifficulty());
                    }
                });

                normal.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        window.dispose();
                        Main.starter(mode, new MediumDifficulty());
                    }
                });

                hard.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        window.dispose();
                        Main.starter(mode, new HardDifficulty());
                    }
                });


                back.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        window.dispose();
                        ModeGUI.setVisible(true);
                    }
                });






            }
        });
    }
}
