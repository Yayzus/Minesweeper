import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    private final MineField mineField;
    private final GameBar gameBar;
    private final MyFrame myFrame;

    public Game(int n, int m, int mineNumber, MyFrame myFrame) {
        this.myFrame = myFrame;
        mineField = new MineField(this, n, m, mineNumber);
        gameBar = new GameBar(mineField, this);
        add(gameBar, BorderLayout.NORTH);
        add(mineField, BorderLayout.CENTER);
        setPreferredSize(new Dimension(mineField.getPreferredSize().width, mineField.getPreferredSize().height + 40));
    }

    public Game(int n, int m, int mineNumber, int bombsFound, MyFrame myFrame) {
        mineField = new MineField(this, n, m, mineNumber, bombsFound);
        gameBar = new GameBar(mineField, this);
        add(gameBar, BorderLayout.NORTH);
        add(mineField, BorderLayout.CENTER);
        this.myFrame = myFrame;
        setPreferredSize(new Dimension(mineField.getPreferredSize().width, mineField.getPreferredSize().height + 40));
    }

    public MineField getMineField() {
        return mineField;
    }

    public void updateSmiley() {
        gameBar.updateSmiley();
    }

    public void updateBombCounter() {
        gameBar.updateBombCounter();
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }
}

