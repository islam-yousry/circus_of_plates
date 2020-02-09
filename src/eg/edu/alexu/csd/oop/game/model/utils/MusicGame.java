package eg.edu.alexu.csd.oop.game.model.utils;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MusicGame {

    private String path;

    public MusicGame(String path) {
        this.path = path;
    }

    public void playMusic() {
        InputStream music;
        try {
            music = new FileInputStream(new File(path));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (Exception e) {

        }
    }
}
