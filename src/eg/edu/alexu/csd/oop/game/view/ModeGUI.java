package eg.edu.alexu.csd.oop.game.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ModeGUI extends JFrame {

    JFrame window = new JFrame("Circus of Plates");

    String path;
    BufferedImage image;

    JButton timedMode = new JButton("Timed Mode");
    JButton arcadeMode = new JButton("Arcade Mode");
    JButton back = new JButton("Back");


    public ModeGUI(String path , JFrame introGame) throws IOException {

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

                timedMode.setBounds(565, 200, 300, 75);
                arcadeMode.setBounds(565, 300, 300, 75);
                back.setBounds(565, 400, 300, 75);

                timedMode.setBackground(Color.cyan);
                arcadeMode.setBackground(Color.cyan);
                back.setBackground(Color.cyan);

                timedMode.setFont(new Font("Tahoma", Font.BOLD, 30));
                arcadeMode.setFont(new Font("Tahoma", Font.BOLD, 30));
                back.setFont(new Font("Tahoma", Font.BOLD, 30));

                window.add(timedMode);
                window.add(arcadeMode);
                window.add(back);

                timedMode.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        window.dispose();
                        try {
                            new DifficultyGUI("/circus_background.png" , window , "TimedMode");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

                arcadeMode.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        window.dispose();
                        try {
                            new DifficultyGUI("/circus_background.png" , window , "ArcadeMode");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

                back.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        window.dispose();
                        introGame.setVisible(true);
                    }
                });


            }
        });
    }
}

