package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {

    @FXML
    private TextField inputField;

    @FXML
    private ListView<String> listView;

    @FXML
    private ListView<String> usersListView;


    private final ObservableList<String> wordList = FXCollections.observableArrayList("Приветствую в своём первом чате!");

    private final ObservableList<String> usersList = FXCollections.observableArrayList("SentsovSA");

    @FXML
    void initialize() {
        listView.setItems(wordList);
         usersListView.setItems(usersList);
    }


    @FXML
    void sendMessage() {
        String message = inputField.getText().trim();
        if (message.length() != 0) {
            addMessageToList(message);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Ошибка ввода сообщения");
            alert.setContentText("Введено пустое сообщение");
            alert.show();
        };
        inputField.clear();
    }

    private void addMessageToList(String message) {
        listView.getItems().add(message);
    }


    @FXML
    void showAbout() {
        System.out.println("about");
    }

    @FXML
    void addClient() {

    }
}
