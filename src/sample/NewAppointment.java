package sample;

import Data.CarData;
import DataModels.Appointment.Appointment;
import DataModels.Vehicle.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewAppointment {
    @FXML
    private TextField garageNameTextField;
    @FXML
    private TextField vinNumber;
    @FXML
    private DatePicker datePicker;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM d YYYY");;

//    for testing
    @FXML
    private Button submitButton;

    @FXML
    public void processData() {
        System.out.println(garageNameTextField.getText());
        System.out.println(vinNumber.getText());
        System.out.println(datePicker.getValue().format(formatter));
    }

    // save data to current array
    // appointment data is kept under car information
    // temp method
    public boolean saveData() {
        // get car object from customer hashmap
        Vehicle temp = Data.UserData.getInstance().getCustomer(CarData.currentUser).getVehicle(vinNumber.getText());

        // get garage object

        // save data to linkedList
        return false;
    }

}
