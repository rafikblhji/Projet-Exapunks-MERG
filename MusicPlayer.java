/**
 * Le menu du jeu 
 * @since 25/02/2024
 * @version 17/03/2024
 * @author ORCUN Gabriel
 * 
 */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class MusicPlayer {

    private Clip clip;

    public MusicPlayer(String filePath) {
        File audioFile = new File(filePath);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Ajoute un écouteur pour détecter quand la musique se termine
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        // Si la musique est terminée, rembobine et rejoue
                        clip.setFramePosition(0);
                        clip.start();
                    }
                }
            });

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.start();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0); // Rembobine la musique au début
        }
    }

    public void close() {
        if (clip != null) {
            clip.close();
        }
    }
}
