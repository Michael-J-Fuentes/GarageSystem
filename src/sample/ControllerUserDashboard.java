package sample;

import Data.CarData;
import DataModels.Vehicle.Vehicle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

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
    public void initialize() {
        carsListView.setItems(CarData.getInstance().getCars(CarData.currentUser));
        carsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        carsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Vehicle>() {
            @Override
            public void changed(ObservableValue<? extends Vehicle> observableValue, Vehicle vehicle, Vehicle t1) {
                if (t1 != null) {
                    Vehicle temp = carsListView.getSelectionModel().getSelectedItem();
                    StringBuilder builder = new StringBuilder();
                    builder.append("Make: " + temp.getMake() + "\n");
                    builder.append("Model: " + temp.getModel() + "\n");
                    builder.append("VIN: " + temp.getVIN() + "\n");
                    builder.append("Year: " );
                    carDetails.setText(builder.toString());
                    carLogs.setText("Place holder for logs");
                }
            }
        });

        carsListView.getSelectionModel().selectFirst();
    }
}
