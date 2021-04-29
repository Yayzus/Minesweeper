import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sounds {
    public void win() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("res/win.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            new Thread(() -> {
                clip.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void explosion() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("res/explosion.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            new Thread(() -> {
                clip.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
}

