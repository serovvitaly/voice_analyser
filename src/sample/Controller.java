package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {

    public VBox mainLayout;
    public ListView<String> projectListView;

    /**
     * Действие "Создание проекта"
     * @param actionEvent
     * @throws IOException
     * @throws UnsupportedAudioFileException
     */
    public void makeProject(ActionEvent actionEvent) throws IOException, UnsupportedAudioFileException {
        System.out.println("Making project...");

        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Аудио файлы", "*.mp3", "*.wav"));

        fileChooser.setTitle("Выбор аудио файла");

        Stage stage = new Stage();
        List<File> audioFiles = fileChooser.showOpenMultipleDialog(stage);

        try {

            Project project = new Project();

            ObservableList<String> items = projectListView.getItems();
            for (File audioFile: audioFiles) {
                String audioFileName = audioFile.getName();
                if (items.contains(audioFileName)) {
                    continue;
                }
                items.add(audioFileName);
            }
            projectListView.setItems(items);

            projectListView.setCellFactory(lv -> {
                ListCell<String> listCell = new ListCell<>();
                listCell.setContextMenu(null);
                return listCell;
            });

            //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            //System.out.println(audioInputStream.getFormat().toString());
        /*} catch (UnsupportedAudioFileException e) {
            Alert alertDialog = new Alert(Alert.AlertType.ERROR);
            alertDialog.setTitle("Ошибка открытия файла");
            alertDialog.setHeaderText("Невозможно открыть файл");
            alertDialog.setContentText("Файл неверного формата или поврежден.");
            alertDialog.showAndWait();*/
        } catch (NullPointerException e) {
            //
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
