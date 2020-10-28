package sample;

import Data.CarData;
import Data.UserData;
import DataModels.Vehicle.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class ControllerNewCar {
    @FXML
    private Button newCarButton;
    @FXML
    private GridPane newUserWindow;
    @FXML
    private TextField vin;
    @FXML
    private TextField make;
    @FXML
    private TextField model;

    @FXML
    public void newCar() {
        UserData.getInstance().getCustomer(CarData.currentUser).addVehicle(new Vehicle(vin.getText(),
                make.getText(), model.getText()));
    }



}
