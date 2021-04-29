import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameBar extends JPanel {
    private final Smiley smiley;
    private final BombCounter bombCount;

    public GameBar(MineField mineField, Game game) {
        setLayout(new GridLayout(1, 5));
        JButton m1 = new JButton("Save");
        JLabel m2 = new JLabel();
        JLabel m3 = new JLabel();
        JLabel m4 = new JLabel();
        JButton m5 = new JButton("Menu");

        add(m1);
        add(m2);
        add(m3);
        add(m4);
        add(m5);

        bombCount = new BombCounter(m2, mineField);

        smiley = new Smiley(m3, mineField);

        Timer t = new Timer(m4, mineField);
        t.start();

        m1.addActionListener(e -> {
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(null); //parent component to JFileChooser
            if (returnVal == JFileChooser.APPROVE_OPTION) { //OK button pressed by user
                File file = fc.getSelectedFile(); //get File selected by user
                try (BufferedWriter o = new BufferedWriter(new FileWriter(file))) {
                    o.write(mineField.getN() + " " + mineField.getM() + " " + mineField.getBombNumber() + " " + mineField.getBombsFound() + "\n");
                    for (int i = 0; i < mineField.getN(); i++)
                        for (int j = 0; j < mineField.getM(); j++) {
                            o.write(mineField.getMines()[i][j].isBomb() + " " + mineField.getMines()[i][j].isChecked() + " " + mineField.getMines()[i][j].isEmpty() + " " + mineField.getMines()[i][j].isClickable() + "\n");
                        }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        m5.addActionListener(e -> game.getMyFrame().showCard("menu"));

        setOpaque(true);
        setPreferredSize(new Dimension(mineField.getPreferredSize().width, 40));
    }

    public void updateSmiley() {
        smiley.update();
    }

    public void updateBombCounter() {
        bombCount.update();
    }
}
