package sample;

import Data.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerNewUser {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private PasswordField password;
    @FXML
    private ChoiceBox<String> userType;


    // save customer data to working data set
    @FXML
    public void createUser() {
        System.out.println(UserData.getInstance().addNewUser(firstName.getText(), lastName.getText(),
                email.getText(), phone.getText(), password.getText(), userType.getValue().toString()));
        // take them to dashboard

    }
}
