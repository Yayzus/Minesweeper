import javax.swing.*;
import java.awt.*;

public class NewGame extends JPanel {
    private int n;
    private int m;
    private int bombNumber;

    public NewGame(MyFrame myFrame) {
        JButton beginner = new JButton("Beginner: 9x9 with 10 bombs");
        JButton intermediate = new JButton("Intermediate: 16x16 with 40 bombs");
        JButton expert = new JButton("Expert: 16x30 with 99 bombs");
        JButton custom = new JButton("Custom");

        beginner.addActionListener(e -> {
            n = 9;
            m = 9;
            bombNumber = 10;

            myFrame.setGame(new Game(n, m, bombNumber, myFrame));
            myFrame.showCard("game");
        });

        intermediate.addActionListener(e -> {
            n = 16;
            m = 16;
            bombNumber = 40;

            myFrame.setGame(new Game(n, m, bombNumber, myFrame));
            myFrame.showCard("game");
        });

        expert.addActionListener(e -> {
            n = 16;
            m = 30;
            bombNumber = 99;

            myFrame.setGame(new Game(n, m, bombNumber, myFrame));
            myFrame.showCard("game");
        });
        custom.addActionListener(e -> myFrame.showCard("custom"));

        setLayout(new GridLayout(4, 1));

        add(beginner);
        add(intermediate);
        add(expert);
        add(custom);
    }
}

