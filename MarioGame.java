import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MarioGame extends JPanel implements ActionListener, KeyListener {

    private int playerX = 50;
    private int playerY = 300;
    private int playerWidth = 40;
    private int playerHeight = 60;

    private int velocityX = 0;
    private int velocityY = 0;

    private final int GRAVITY = 1;
    private final int FLOOR = 300;

    private boolean jumping = false;

    private Timer timer;

    public MarioGame() {
        timer = new Timer(15, this); // 15 ms delay (~60 FPS)
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear background
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw ground
        g.setColor(Color.GREEN);
        g.fillRect(0, FLOOR + playerHeight, getWidth(), getHeight() - FLOOR - playerHeight);

        // Draw player (Mario)
        g.setColor(Color.RED);
        g.fillRect(playerX, playerY, playerWidth, playerHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Apply gravity
        if (playerY < FLOOR) {
            velocityY += GRAVITY;
            jumping = true;
        } else {
            velocityY = 0;
            jumping = false;
            playerY = FLOOR;
        }

        playerX += velocityX;
        playerY += velocityY;

        // Prevent going out of bounds
        if (playerX < 0) playerX = 0;
        if (playerX > getWidth() - playerWidth) playerX = getWidth() - playerWidth;

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            velocityX = -5;
        }
        if (key == KeyEvent.VK_RIGHT) {
            velocityX = 5;
        }
        if (key == KeyEvent.VK_SPACE && !jumping) {
            velocityY = -15;
            jumping = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            velocityX = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mario Game");
        MarioGame gamePanel = new MarioGame();
        frame.add(gamePanel);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
