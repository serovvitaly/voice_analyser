package sample;

import com.sun.media.sound.WaveFileReader;
import phonecs.WavFile;
import phonecs.WavFileException;

import java.io.*;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

class Project {

    private File audioFile;

    Project(File  audioFile) throws IOException, UnsupportedAudioFileException, WavFileException {
        InitLayout();
        this.audioFile = audioFile;
        WavFile  wavFile = WavFile.openWavFile(audioFile);
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
