package sample;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
    public void makeProject(ActionEvent actionEvent) {
        System.out.println("Making project...");

        Project project = new Project();

        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Аудио файлы", "*.mp3", "*.wav"));

        fileChooser.setTitle("Выбор аудио файла");

        Stage stage = new Stage();
        fileChooser.showOpenDialog(stage);
    }
}
