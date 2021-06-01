package geekbrains.java_basics.catch_the_drop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame {

    private static GameWindow game_window;
    private static Image background;
    private static Image game_over;
    private static Image drop;

    public static void main(String[] args) {
        initBackground();
        initGameWindow();
    }

    private static void initBackground() {
        try {
            background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
            game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
            drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void initGameWindow() {
        game_window = new GameWindow();
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(200, 100);
        game_window.setSize(906, 478);
        game_window.setResizable(false);
        game_window.setVisible(true);

        GameField game_field = new GameField();
        game_window.add(game_field);
    }

    private static void onRepaint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, 100, 100, null);
        g.drawImage(game_over, 280, 120, null);
    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            onRepaint(g);
        }
    }
}
