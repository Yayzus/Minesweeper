
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MineField extends JPanel {
    private final Icons ikonok;
    private final Game game;
    private final int n;
    private final int m;
    private final int iconSize;
    private final int bombNumber;
    private Mine[][] mines;
    private int bombsFound;
    private boolean endGame;
    private boolean bombExploded;

    public MineField(Game game, int n, int m, int mineNumber) {
        this.game = game;
        this.n = n;
        this.m = m;
        if (n < 13 && m < 25)
            this.iconSize = 40;
        else if (n < 20 && m < 35)
            this.iconSize = 30;
        else
            this.iconSize = 20;
        ikonok = new Icons(iconSize);
        this.bombNumber = mineNumber;

        setLayout(new GridLayout(n, m));
        init();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                add(mines[i][j]);
        setPreferredSize(new Dimension(m * iconSize, n * iconSize));
    }

    public MineField(Game game, int n, int m, int bombNumber, int bombsFound) {
        this.game = game;
        this.n = n;
        this.m = m;
        this.bombsFound = bombsFound;
        this.bombNumber = bombNumber;
        if (n < 13 && m < 25)
            this.iconSize = 40;
        else if (n < 20 && m < 35)
            this.iconSize = 30;
        else
            this.iconSize = 20;
        ikonok = new Icons(iconSize);
        setPreferredSize(new Dimension(m * iconSize, n * iconSize));
    }

    private void init() {
        bombsFound = 0;
        Random rand = new Random();
        int[][] direction = {{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}};

        mines = new Mine[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                mines[i][j] = new Mine(ikonok.getUnopened());

        for (int k = 0; k < bombNumber; k++) {
            int i = rand.nextInt(n);
            int j = rand.nextInt(m);
            while (mines[i][j].isBomb()) {
                i = rand.nextInt(n);
                j = rand.nextInt(m);
            }
            mines[i][j].setIkon(ikonok.getBomb());
            mines[i][j].setBomb(true);
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (!mines[i][j].isBomb()) {
                    int bombCounter = 0;
                    for (int[] ints : direction) {
                        int newI = i + ints[0];
                        int newJ = j + ints[1];
                        if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && mines[newI][newJ].isBomb())
                            bombCounter++;
                    }

                    switch (bombCounter) {
                        case 0 -> {
                            mines[i][j].setIkon(ikonok.getEmpty());
                            mines[i][j].setEmpty(true);
                        }
                        case 1 -> mines[i][j].setIkon(ikonok.getOne());
                        case 2 -> mines[i][j].setIkon(ikonok.getTwo());
                        case 3 -> mines[i][j].setIkon(ikonok.getThree());
                        case 4 -> mines[i][j].setIkon(ikonok.getFour());
                        case 5 -> mines[i][j].setIkon(ikonok.getFive());
                        case 6 -> mines[i][j].setIkon(ikonok.getSix());
                        case 7 -> mines[i][j].setIkon(ikonok.getSeven());
                        case 8 -> mines[i][j].setIkon(ikonok.getEight());
                    }
                }
            }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                mines[i][j].addMouseListener(new MyMouseListener(i, j, this, ikonok));
            }
    }

    public void setMines(List<Mine> minefield) {
        mines = new Mine[n][m];
        Iterator<Mine> mineit = minefield.iterator();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                mines[i][j] = mineit.next();
            }
        setIcons();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                mines[i][j].addMouseListener(new MyMouseListener(i, j, this, ikonok));
            }
        setLayout(new GridLayout(n, m));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                add(mines[i][j]);
    }

    private void setIcons() {
        int[][] direction = {{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}};
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (!mines[i][j].isBomb()) {
                    int bombCounter = 0;
                    for (int[] ints : direction) {
                        int newI = i + ints[0];
                        int newJ = j + ints[1];
                        if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && mines[newI][newJ].isBomb())
                            bombCounter++;
                    }

                    switch (bombCounter) {
                        case 0 -> mines[i][j].setIkon(ikonok.getEmpty());
                        case 1 -> mines[i][j].setIkon(ikonok.getOne());
                        case 2 -> mines[i][j].setIkon(ikonok.getTwo());
                        case 3 -> mines[i][j].setIkon(ikonok.getThree());
                        case 4 -> mines[i][j].setIkon(ikonok.getFour());
                        case 5 -> mines[i][j].setIkon(ikonok.getFive());
                        case 6 -> mines[i][j].setIkon(ikonok.getSix());
                        case 7 -> mines[i][j].setIkon(ikonok.getSeven());
                        case 8 -> mines[i][j].setIkon(ikonok.getEight());
                    }
                } else {
                    mines[i][j].setIkon(ikonok.getBomb());
                }
                if (mines[i][j].isChecked())
                    mines[i][j].setIcon(ikonok.getFlag());
                else if (mines[i][j].isClickable())
                    mines[i][j].setIcon(ikonok.getUnopened());
                else
                    mines[i][j].uncover();
            }

    }

    public boolean isBombExploded() {
        return bombExploded;
    }

    public void setBombExploded(boolean bombExploded) {
        this.bombExploded = bombExploded;
    }

    public Mine[][] getMines() {
        return mines;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getIconSize() {
        return iconSize;
    }

    public int getBombNumber() {
        return bombNumber;
    }

    public int getBombsFound() {
        return bombsFound;
    }

    public void setBombsFound(int bombsFound) {
        this.bombsFound = bombsFound;
    }

    public Game getGame() {
        return game;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }
}
