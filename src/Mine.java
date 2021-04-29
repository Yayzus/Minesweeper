import javax.swing.*;

public class Mine extends JButton {
    private ImageIcon ikon;
    private boolean bomb;
    private boolean checked;
    private boolean empty;
    private boolean clickable;

    public Mine(ImageIcon icon) {
        this.setIcon(icon);
        bomb = false;
        checked = false;
        clickable = true;
    }

    public Mine(boolean bomb, boolean checked, boolean empty, boolean clickable) {
        this.bomb = bomb;
        this.checked = checked;
        this.empty = empty;
        this.clickable = clickable;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }


    public void setIkon(ImageIcon ikon) {
        this.ikon = ikon;
    }

    public void uncover() {
        this.setIcon(ikon);
    }
}
