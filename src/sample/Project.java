package sample;

import com.sun.media.sound.WaveFileReader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Project implements Initializable {

    private File audioFile;

    public Label bitsPerSampleLabel;
    public Label numChannelsLabel;
    public Label sampleRateLabel;
    public Label audioFormatLabel;

    void initProject(File  audioFile) throws IOException, UnsupportedAudioFileException {
        InitLayout();
        this.audioFile = audioFile;
        WavFile  wavFile = WavFile.openWavFile(audioFile);

        audioFormatLabel.setText(String.valueOf(wavFile.AudioFormat));
        numChannelsLabel.setText(String.valueOf(wavFile.NumChannels));
        sampleRateLabel.setText(String.valueOf(wavFile.SampleRate));
        bitsPerSampleLabel.setText(String.valueOf(wavFile.BitsPerSample));

        System.out.println("AudioFormat: " + wavFile.AudioFormat);
        System.out.println("NumChannels: " + wavFile.NumChannels);
        System.out.println("SampleRate: " + wavFile.SampleRate);
        System.out.println("BitsPerSample: " + wavFile.BitsPerSample);

        //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

        //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
        //System.out.println(audioInputStream.getFormat().toString());
    }

    public File getAudioFile()
    {
        return this.audioFile;
    }

    private void InitLayout() {
        System.out.println("Init project layout...");
    }

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize");
    }
}
