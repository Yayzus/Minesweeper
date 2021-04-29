import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomGame extends JPanel {
    private int n;
    private int m;
    private int bombNumber;

    public CustomGame(MyFrame myFrame) {
        JTextArea nfield = new JTextArea();
        JTextArea mfield = new JTextArea();
        JLabel ntext = new JLabel("n: ");
        JLabel mtext = new JLabel("m: ");
        JLabel diftext = new JLabel("Difficulity");

        JButton start = new JButton("Start");
        setLayout(new GridLayout(4, 2));
        JComboBox<String> difficulity = new JComboBox<>();
        difficulity.addItem("Easy");
        difficulity.addItem("Medium");
        difficulity.addItem("Hard");


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n = Integer.parseInt(nfield.getText());
                m = Integer.parseInt(mfield.getText());

                System.out.println(difficulity.getName());

                switch (difficulity.getItemAt(difficulity.getSelectedIndex())) {
                    case "Easy" -> bombNumber = (n * m) / 11;
                    case "Medium" -> bombNumber = (n * m) / 7;
                    case "Hard" -> bombNumber = (n * m) / 5;
                }

                myFrame.setGame(new Game(n, m, bombNumber, myFrame));
                myFrame.showCard("game");
            }
        });
        add(ntext);
        add(nfield);
        add(mtext);
        add(mfield);
        add(diftext);
        add(difficulity);
        add(start);


        setPreferredSize(new Dimension(200, 200));
    }
}

