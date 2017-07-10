package sample;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

class WavFile {

    private File file;

    int AudioFormat;
    int NumChannels;
    int SampleRate;
    int BitsPerSample;

    static WavFile openWavFile(File file) {
        WavFile wavFile = new WavFile();
        wavFile.file = file;
        wavFile.readHeader();
        return wavFile;
    }

    private int getIntByBytes(byte[] bytes) {

        for (byte bt: bytes) {
            System.out.print(bt);
        }
        System.out.println("");
        for (byte bt: bytes) {
            System.out.print(String.format("%02X", bt));
        }

        //System.out.println(bytes);
        System.out.println("");
        System.out.println("---------------------");
        return 1;
    }

    private void readHeader() {
        byte[] buffer = new byte[40];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int readBytes = fileInputStream.read(buffer, 0, 40);
            AudioFormat = getIntByBytes(Arrays.copyOfRange(buffer, 20, 22));
            NumChannels = getIntByBytes(Arrays.copyOfRange(buffer, 22, 24));
            SampleRate = getIntByBytes(Arrays.copyOfRange(buffer, 24, 28));
            BitsPerSample = getIntByBytes(Arrays.copyOfRange(buffer, 34, 36));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
