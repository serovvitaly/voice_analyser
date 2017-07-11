package sample;

import com.sun.media.sound.WaveFileReader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Project implements Initializable {

    private File audioFile;

    Project(File  audioFile) throws IOException, UnsupportedAudioFileException {
        InitLayout();
        this.audioFile = audioFile;
        WavFile  wavFile = WavFile.openWavFile(audioFile);

        System.out.println("AudioFormat: " + wavFile.AudioFormat);
        System.out.println("NumChannels: " + wavFile.NumChannels);
        System.out.println("SampleRate: " + wavFile.SampleRate);
        System.out.println("BitsPerSample: " + wavFile.BitsPerSample);

        //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
    }

    public File getAudioFile()
    {
        return this.audioFile;
    }

    private void InitLayout() {
        System.out.println("Init project layout...");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
