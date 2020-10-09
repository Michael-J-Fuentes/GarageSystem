package sample;

import Data.CarData;
import Data.LogData;
import Data.UserData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        scene = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        primaryStage.setTitle("Garage System - Group 2");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    /** method called on start up to load files into working memory*/
    @Override
    public void init() throws Exception {
        try {
            UserData.getInstance().loadData();
            CarData.getInstance().loadCars();
            LogData.getInstance().load();
        } catch (Exception e) {
            System.out.println("Error loading data into array. Called from main");
            e.printStackTrace();
        }
    }
    /** Method automatically called at program termination to save files to disk */
    @Override
    public void stop() throws Exception {
        try {
            UserData.getInstance().saveData();
            CarData.getInstance().saveCars();
            LogData.getInstance().saveData();
        } catch (Exception e) {
            System.out.println("Error saving data to file, Called from main");
            e.printStackTrace();
        }
    }
}
