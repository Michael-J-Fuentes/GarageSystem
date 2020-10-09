package sample;

import Data.CarData;
import Data.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Optional;

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
    private GridPane mainWindow;

    @FXML
    public void newUser() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainWindow.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newUser.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
            dialog.setTitle("Create new User");
        } catch (IOException e) {
            System.out.println("Error loading new user FXML, called from controllerIndex newUser");
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ControllerNewUser controllerNewUser = fxmlLoader.getController();
            controllerNewUser.createUser();
        }
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
