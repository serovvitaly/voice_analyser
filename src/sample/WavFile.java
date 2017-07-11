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

        StringBuilder valAsString = new StringBuilder();
        for (int ct = bytes.length - 1; ct >= 0; ct--) {
            valAsString.append(String.format("%02X", bytes[ct]));
        }
        return (int) Long.parseLong(valAsString.toString(), 16);
    }

    private void readHeader() {
        byte[] buffer = new byte[40];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(buffer, 0, 40);
            AudioFormat = getIntByBytes(Arrays.copyOfRange(buffer, 20, 22));
            NumChannels = getIntByBytes(Arrays.copyOfRange(buffer, 22, 24));
            SampleRate = getIntByBytes(Arrays.copyOfRange(buffer, 24, 28));
            BitsPerSample = getIntByBytes(Arrays.copyOfRange(buffer, 34, 36));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
