package sample;

import Data.CarData;
import Data.UserData;
import DataModels.Vehicle.Vehicle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ControllerUserDashboard {
    @FXML
    private BorderPane BorderPaneUserDashboard;
    @FXML
    private ListView<Vehicle> carsListView;
    @FXML
    private TextArea carDetails;
    @FXML
    private TextArea carLogs;
    @FXML
    private GridPane newUserWindow;
    @FXML
    private Button newCarButton;

    private ObservableList<Vehicle> vehicles;



    @FXML
    public void initialize() {
//        carsListView.setItems(CarData.getInstance().getCars(CarData.currentUser));
        reloadCars();

    }

    @FXML
    public void newCar() {

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(BorderPaneUserDashboard.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newCar.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
            dialog.setTitle("Add Car");
        } catch (IOException e) {
            System.out.println("Error loading new car fxml. Called from controllerNewCar method new car");
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.get() == ButtonType.OK) {
            ControllerNewCar newCar = fxmlLoader.getController();
            newCar.newCar();
        }
        reloadCars();
    }

    public void reloadCars() {
        vehicles = FXCollections.observableList(
                UserData.getInstance().getCustomer(CarData.currentUser).getCustomerCarsListView());
        carsListView.setItems(FXCollections.observableList(vehicles));
        carsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        carsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Vehicle>() {
            @Override
            public void changed(ObservableValue<? extends Vehicle> observableValue, Vehicle vehicle, Vehicle t1) {
                if (t1 != null) {
                    Vehicle temp = carsListView.getSelectionModel().getSelectedItem();
                    StringBuilder builder = new StringBuilder();
                    builder.append("Make: " + temp.getMake() + "\n");
                    builder.append("Model: " + temp.getModel() + "\n");
                    builder.append("VIN: " + temp.getVIN());
//                    builder.append("Year: " );
                    carDetails.setText(builder.toString());
                    carLogs.setText(temp.printMaintenanceRecords());
                }
            }
        });

        carsListView.getSelectionModel().selectFirst();
    }
}
