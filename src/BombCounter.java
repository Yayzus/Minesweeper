import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BombCounter {
    private final MineField mineField;
    private final JLabel text;
    private Font font;

    public BombCounter(JLabel text, MineField mineField) {
        this.mineField = mineField;
        this.text = text;
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
        text.setText(String.valueOf(mineField.getBombNumber() - mineField.getBombsFound()));
    }


    public void update() {
        text.setText(String.valueOf(mineField.getBombNumber() - mineField.getBombsFound()));
    }
}

