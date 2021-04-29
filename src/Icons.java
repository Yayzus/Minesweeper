import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Icons {
    private final ImageIcon bomb;
    private final ImageIcon flag;
    private final ImageIcon unopened;
    private final ImageIcon empty;
    private final ImageIcon one;
    private final ImageIcon two;
    private final ImageIcon three;
    private final ImageIcon four;
    private final ImageIcon five;
    private final ImageIcon six;
    private final ImageIcon seven;
    private final ImageIcon eight;
    private final ImageIcon redBomb;
    private final ImageIcon checkFail;
    private final ImageIcon faceDuringGame;
    private final ImageIcon winFace;
    private final ImageIcon bombExploded;

    int iconSize;

    public Icons(int iconSize) {
        this.iconSize = iconSize;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("res/bomb.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert img != null;
        bomb = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/flag.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        flag = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        one = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        two = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        three = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        four = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        five = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/6.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        six = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/7.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        seven = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/8.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        eight = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/unopened.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        unopened = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/empty.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        empty = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/red_bomb.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        redBomb = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/checkFail.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        checkFail = new ImageIcon(img.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/faceDuringGame.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        faceDuringGame = new ImageIcon(img.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/winFace.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        winFace = new ImageIcon(img.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        try {
            img = ImageIO.read(new File("res/bombExploded.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bombExploded = new ImageIcon(img.getScaledInstance(40, 40, Image.SCALE_SMOOTH));

    }

    public ImageIcon getBomb() {
        return bomb;
    }

    public ImageIcon getFlag() {
        return flag;
    }

    public ImageIcon getUnopened() {
        return unopened;
    }

    public ImageIcon getEmpty() {
        return empty;
    }

    public ImageIcon getOne() {
        return one;
    }

    public ImageIcon getTwo() {
        return two;
    }

    public ImageIcon getThree() {
        return three;
    }

    public ImageIcon getFour() {
        return four;
    }

    public ImageIcon getFive() {
        return five;
    }

    public ImageIcon getSix() {
        return six;
    }

    public ImageIcon getSeven() {
        return seven;
    }

    public ImageIcon getEight() {
        return eight;
    }

    public ImageIcon getRedBomb() {
        return redBomb;
    }

    public ImageIcon getCheckFail() {
        return checkFail;
    }

    public ImageIcon getFaceDuringGame() {
        return faceDuringGame;
    }

    public ImageIcon getWinFace() {
        return winFace;
    }

    public ImageIcon getBombExploded() {
        return bombExploded;
    }
}

