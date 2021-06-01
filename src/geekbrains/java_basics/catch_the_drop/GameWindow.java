package geekbrains.java_basics.catch_the_drop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

public class GameWindow extends JFrame {

    private static GameWindow game_window;
    private static GameField game_field;

    private static long last_frame_time;

    private static Image background;
    private static Image game_over;
    private static Image drop;

    private static float drop_left = 200;
    private static float drop_top = -100;
    private static float drop_v = 20;

    private static int score = 0;

    public static void main(String[] args) {
        last_frame_time = System.nanoTime();

        addImages();
        initGameWindow();
        initGameField();

        addMouseListener();
    }

    private static void addMouseListener() {
        game_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                boolean is_drop = dropIsInsideWindow(mouseEvent);

                if (is_drop) {
                    drop_top = -100;
                    drop_left = (int) (Math.random() * (game_field.getWidth() - drop.getWidth(null)));

                    drop_v = drop_v + 20;

                    toggleUpScore();
                }
            }
        });
    }

    private static void toggleUpScore() {
        score ++;

        game_window.setTitle("Score: " + score);
    }

    private static void accelerate() {
        drop_v = drop_v + 20;
    }

    private static boolean dropIsInsideWindow(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        float drop_right = drop_left + drop.getWidth(null);
        float drop_bottom = drop_top + drop.getHeight(null);

        boolean xIsValid = x >= drop_left && x <= drop_right;
        boolean yIsValid = y >= drop_top && y <= drop_bottom;

        return xIsValid && yIsValid;
    }

    private static void addImages() {
        try {
            background = ImageIO.read(Objects.requireNonNull(GameWindow.class.getResourceAsStream("background.png")));
            game_over = ImageIO.read(Objects.requireNonNull(GameWindow.class.getResourceAsStream("game_over.png")));
            drop = ImageIO.read(Objects.requireNonNull(GameWindow.class.getResourceAsStream("drop.png")));
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
    }

    private static void initGameField() {
        game_field = new GameField();
        game_window.add(game_field);
    }

    private static void onRepaint(Graphics g) {
        setDrop();

        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, (int) drop_left, (int) drop_top, null);

        gameOver(g);
    }

    private static void gameOver(Graphics g) {
        if (drop_top > game_window.getHeight()) g.drawImage(game_over, 280, 120, null);
    }

    private static void setDrop() {
        long current_time = System.nanoTime();
        float delta_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;

        drop_top = drop_top + drop_v * delta_time;

//        randomDropBehaviour(delta_time);
    }

    private static void randomDropBehaviour(float delta_time) {
        int flip = (int) (Math.random() * 2);
        if (flip == 1) drop_left = drop_left + drop_v * delta_time;
    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            onRepaint(g);
            repaint();
        }
    }
}
