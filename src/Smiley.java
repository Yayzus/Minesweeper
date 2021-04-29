import javax.swing.*;

public class Smiley extends Thread {
    private final MineField mineField;
    private final JLabel smiley;
    private final Icons ikonok;

    public Smiley(JLabel smiley, MineField mineField) {
        this.mineField = mineField;
        this.smiley = smiley;
        ikonok = new Icons(mineField.getIconSize());
        smiley.setIcon(ikonok.getFaceDuringGame());
        smiley.setHorizontalAlignment(JLabel.CENTER);
    }

    public void update() {
        if (mineField.isBombExploded()) {
            smiley.setIcon(ikonok.getBombExploded());
        } else {
            smiley.setIcon(ikonok.getWinFace());
        }
    }
}

