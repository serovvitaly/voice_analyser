package sample;

import com.sun.media.sound.WaveFileReader;

import java.io.*;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

class Project {

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
}
