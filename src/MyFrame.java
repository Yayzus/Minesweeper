import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private final JPanel cardPanel;
    private final CardLayout layout;
    private Game game;

    public MyFrame() {
        layout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(layout);

        NewGame newGame = new NewGame(this);
        Menu menu = new Menu(this);

        add(cardPanel);
        cardPanel.add(menu, "menu");
        cardPanel.add(newGame, "newGame");
        layout.show(cardPanel, "menu");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setBounds(300, 150, 200, 200);
    }

    public void showCard(String key) {
        if (key.equals("game")) {
            cardPanel.add(game, "game");
            setPreferredSize(new Dimension(game.getPreferredSize().width + 20, game.getPreferredSize().height + 50));
        }
        if (key.equals("custom")) {
            CustomGame custom = new CustomGame(this);
            cardPanel.add(custom, "custom");
        }
        layout.show(cardPanel, key);
        pack();
    }

    public void setGame(Game game) {
        this.game = game;
    }

}

