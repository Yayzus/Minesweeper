import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyMouseListener implements MouseListener {

    private final int i;
    private final int j;
    private final MineField mineField;
    private final Icons ikonok;
    private final int[][] direction;

    public MyMouseListener(int i, int j, MineField mineField, Icons ikonok) {
        this.i = i;
        this.j = j;
        this.mineField = mineField;
        this.ikonok = ikonok;
        this.direction = new int[][]{{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}};
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (mineField.getMines()[i][j].isClickable()) {
                mineField.getMines()[i][j].uncover();
                mineField.getMines()[i][j].setClickable(false);

                if (mineField.getMines()[i][j].isEmpty()) {
                    for (int[] ints : direction) {
                        int newI = i + ints[0];
                        int newJ = j + ints[1];
                        if (newI >= 0 && newI < mineField.getN() && newJ >= 0 && newJ < mineField.getM())
                            if (!mineField.getMines()[newI][newJ].isChecked() && mineField.getMines()[newI][newJ].isClickable()) {
                                clickNeighbour(newI, newJ);
                            }
                    }
                }

                if (mineField.getMines()[i][j].isBomb()) {
                    new Sounds().explosion();
                    mineField.setEndGame(true);
                    mineField.setBombExploded(true);
                    reveal();
                    mineField.getMines()[i][j].setIcon(ikonok.getRedBomb());
                    mineField.getGame().updateSmiley();
                }
            }
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            if (mineField.getMines()[i][j].isChecked()) {
                mineField.setBombsFound(mineField.getBombsFound() - 1);
                mineField.getMines()[i][j].setIcon(ikonok.getUnopened());
                mineField.getMines()[i][j].setChecked(false);
                mineField.getMines()[i][j].setClickable(true);
                mineField.getGame().updateBombCounter();

            } else {
                if (mineField.getMines()[i][j].isClickable() && mineField.getBombsFound() < mineField.getBombNumber()) {
                    mineField.setBombsFound(mineField.getBombsFound() + 1);
                    mineField.getMines()[i][j].setIcon(ikonok.getFlag());
                    mineField.getMines()[i][j].setChecked(true);
                    mineField.getMines()[i][j].setClickable(false);
                    mineField.getGame().updateBombCounter();


                    if (mineField.getBombNumber() == mineField.getBombsFound()) {
                        if (endGame()) {
                            new Sounds().win();
                            mineField.setEndGame(true);
                            mineField.setBombExploded(false);
                            mineField.getGame().updateSmiley();
                            reveal();
                        }
                    }
                }
            }
        }
    }

    private void reveal() {
        for (int i = 0; i < mineField.getN(); i++)
            for (int j = 0; j < mineField.getM(); j++) {
                mineField.getMines()[i][j].uncover();
                if (mineField.getMines()[i][j].isChecked())
                    if (!mineField.getMines()[i][j].isBomb())
                        mineField.getMines()[i][j].setIcon(ikonok.getCheckFail());
                    else
                        mineField.getMines()[i][j].setIcon((ikonok.getFlag()));
                mineField.getMines()[i][j].setClickable(false);
            }
    }

    private void clickNeighbour(int a, int b) {
        mineField.getMines()[a][b].uncover();
        mineField.getMines()[a][b].setClickable(false);
        if (mineField.getMines()[a][b].isEmpty()) {
            for (int[] ints : direction) {
                int newI = a + ints[0];
                int newJ = b + ints[1];
                if (newI >= 0 && newI < mineField.getN() && newJ >= 0 && newJ < mineField.getM())
                    if (!mineField.getMines()[newI][newJ].isChecked() && mineField.getMines()[newI][newJ].isClickable()) {
                        clickNeighbour(newI, newJ);
                    }
            }
        }
    }

    private boolean endGame() {
        for (int i = 0; i < mineField.getN(); i++)
            for (int j = 0; j < mineField.getM(); j++) {
                if (mineField.getMines()[i][j].isChecked() && !mineField.getMines()[i][j].isBomb())
                    return false;
            }
        return true;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

