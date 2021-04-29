import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Menu extends JPanel {

    public Menu(MyFrame myFrame) {
        JButton newGame = new JButton("New Game");
        JButton load = new JButton("Load Game");

        setLayout(new GridLayout(2, 1));
        add(newGame);
        add(load);

        newGame.addActionListener(e -> myFrame.showCard("newGame"));

        load.addActionListener(e -> {
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try (BufferedReader o = new BufferedReader(new FileReader(file))) {
                    int[] param = Arrays.stream(o.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    Game game = new Game(param[0], param[1], param[2], param[3], myFrame);
                    System.out.println(param[0] + " " + param[1] + " " + param[2] + " " + param[3]);
                    game.getMineField().setMines(
                            o.lines()
                                    .map(sor -> sor.split(" "))
                                    .map(sor -> new Mine(Boolean.parseBoolean(sor[0]), Boolean.parseBoolean(sor[1]), Boolean.parseBoolean(sor[2]), Boolean.parseBoolean(sor[3])))
                                    .collect(Collectors.toList())
                    );
                    myFrame.setGame(game);
                    myFrame.showCard("game");

                } catch (IOException er) {
                    er.printStackTrace();
                }
            }
        });
        setPreferredSize(new Dimension(200, 200));
    }
}

