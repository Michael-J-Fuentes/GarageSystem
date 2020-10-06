package sample;

import Data.CarData;
import Data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class ControllerIndex {
    @FXML
    private TextField loginEmail;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private Hyperlink newUserClick;
    @FXML
    private Button loginButton;
    @FXML
    private Label invalidUser;

    @FXML
    public void newUser() {

    }

    @FXML
    public void userLoginIn() {
        // check if user is in records
        boolean bool = UserData.getInstance().isUser(loginEmail.getText(), loginPassword.getText());
        if (!bool) {
            loginPassword.clear();
            invalidUser.setText("Incorrect login Information");
        } else {
            CarData.currentUser = loginEmail.getText();
            // load new scene
            try {
                Parent userDashboard = FXMLLoader.load(getClass().getResource("UserDashboard.fxml"));
                Main.scene.setScene(new Scene(userDashboard, 1000, 750));
            } catch (Exception e ) {
                System.out.println("Something happened in ControllerIndex userLogIn");
                e.printStackTrace();
            }
    }
//        String msg = bool ? "Yes it's correct" : "Invalid";
//        System.out.println(msg);
    }
}
