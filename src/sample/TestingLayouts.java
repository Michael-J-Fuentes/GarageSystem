package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestingLayouts extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("newUser.fxml"));
        stage.setTitle("Testing Layouts");
        stage.setScene(new Scene(root, 500,400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
