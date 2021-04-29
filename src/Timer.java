import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Timer extends Thread {
    private final JLabel text;
    private final MineField mineField;
    private Font font;
    private int seconds;
    private int minutes;

    public Timer(JLabel text, MineField mineField) {
        seconds = 0;
        minutes = 0;
        this.text = text;
        this.mineField = mineField;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("res/digital-7.ttf"));
        } catch (FontFormatException | IOException ignored) {
        }
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(font);
        font = font.deriveFont(40f);
        text.setFont(font);
        text.setOpaque(true);
        text.setForeground(Color.RED);
        text.setBackground(Color.BLACK);
        text.setPreferredSize(new Dimension(40, 40));
    }

    @Override
    public void run() {
        do {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds++;
            if (seconds == 60) {
                minutes++;
                seconds = 0;
            }
            text.setText(minutes + ":" + seconds);
        } while (!mineField.isEndGame());
    }
}

