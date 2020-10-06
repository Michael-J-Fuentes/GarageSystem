package sample;

import DataModels.Users.Customer;
import DataModels.Vehicle.Vehicle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;


import java.io.*;
import java.util.*;

public class Controller {











//    @FXML
//    public Button loginButton;
//    @FXML
//    public Hyperlink newUserClick;
//
////    new user account section
//    @FXML
//    public TextField firstName;
//    @FXML
//    public TextField lastName;
//    @FXML
//    public TextField email;
//    @FXML
//    public TextField phone;
//    @FXML
//    public PasswordField password;
//    @FXML
//    public ChoiceBox<String> userType;
//    @FXML
//    public Button createUserButton;
//
//    // user login things
//    @FXML
//    public TextField loginEmail;
//    @FXML
//    public PasswordField loginPassword;
//
//    public Customer currentCustomer;
//
//    // user dashboard things
//    @FXML
//    public ListView<Vehicle> carListView;
//    @FXML
//    public TextArea userDashBoardTextArea;
//
//
//
//    public HashMap<String, HashMap<String, Vehicle>> customerCars;
//    public HashMap<String, Customer> customers;
//    public List<Vehicle> vehicleList;
//    public void initialize() throws Exception{
//        this.customers = new HashMap<>();
//        try(BufferedReader bf = new BufferedReader(new FileReader("src/Data/Users.txt"))) {
//            String line = bf.readLine();
//            while (line != null) {
//                String[] splitLine = line.split(";");
//                this.customers.put(splitLine[2],
//                        new Customer(splitLine[0], splitLine[1], splitLine[2], splitLine[3], splitLine[4]));
//                line = bf.readLine();
//            }
//        } catch (IOException e) {
//            System.out.println("Error loading file data");
//            e.printStackTrace();
//        }
//        this.loadCustomerCars();
//    }
////    @FXML
////    public void onAction(ActionEvent event) throws Exception{
////        if (event.getSource().equals(home)) {
////            System.out.println("In item One");
////            Parent root = FXMLLoader.load(getClass().getResource("SecenTwo.fxml"));
////            Main.window.setScene(new Scene(root, 300, 275));
////        } else {
////            System.out.println("In item two");
////            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
////            Main.window.setScene(new Scene(root, 300, 275));
////        }
////    }
//
//    @FXML
//    public void onAction(ActionEvent event) throws Exception {
//        if (event.getSource().equals(this.loginButton)) {
//            this.logInUser();
//        } else if (event.getSource().equals(this.newUserClick)) {
//            this.newUserLogin();
//        }
//    }
//
//
//    private void logInUser() throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("SecenTwo.fxml"));
//        Main.window.setScene(new Scene(root, 300, 275));
//    }
//
//    private void newUserLogin() throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("newUser.fxml"));
//        Main.window.setScene(new Scene(root, 400, 375));
//    }
//
//    private void userDashboard() throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("UserDashboard.fxml"));
//        Main.window.setScene(new Scene(root, 1000, 1000));
//    }
//
//    @FXML
//    public void createNewUser() throws Exception{
//        signUpUser();
//        // go to user dash board
//        this.userDashboard();
//    }
//
//    // writes data to file
//    private void signUpUser() {
//        try(BufferedWriter bf = new BufferedWriter(new FileWriter("src/Data/Users.txt", true))) {
//            String line = String.format("%s;%s;%s;%s;%s;%s%n",this.firstName.getText(), this.lastName.getText(),
//                    this.email.getText(), this.phone.getText(),
//                    this.password.getText(), this.userType.getValue());
//            bf.write(line);
////             temp solution to not have to read file all over again for new user during session
////            this.customers.put(this.email.getText(), new Customer(this.firstName.getText(), this.lastName.getText(),
////                    this.email.getText(), this.phone.getText(),
////                    this.password.getText()));
//        } catch (Exception e) {
//            System.out.println("Error writing to file for new user");
//            e.printStackTrace();
//        }
//    }
//
//    // check if user is part of the system
//    private boolean isUser() {
//        if (this.customers.containsKey(this.loginEmail.getText())) {
//            Customer temp = this.customers.get(this.loginEmail.getText());
////            System.out.println(temp.getEmail() + " " + temp.getPassword());
//            return true;
//        }
//        return false;
//    }
//
//
//    @FXML
//    public void toUserDashBoard() throws Exception{
//        if (this.isUser()) {
//            this.currentCustomer = this.customers.get(this.loginEmail.getText());
//            this.loadCustomerCars();
//            this.printCustomerCars();
//            this.userDashboard();
//            this.setUpCarListView();
//
//        } else {
////            TODO something to warn users
//            System.out.println("Incorrect email or password");
//            this.loginPassword.clear();
//        }
//    }
//
//    @FXML
//    public void setUpCarListView() {
//        this.carListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Vehicle>() {
//            @Override
//            public void changed(ObservableValue<? extends Vehicle> observableValue, Vehicle vehicle, Vehicle t1) {
//                if (t1 != null) {
//                    Vehicle v = carListView.getSelectionModel().getSelectedItem();
//                    StringBuilder builder = new StringBuilder("Customer name: " + currentCustomer.getFirstName() + " "
//                        + currentCustomer.getLastName() + '\n');
//                    builder.append("Vin: " + v.getVIN() + '\n');
//                    builder.append("Make: " + v.getMake() + "\n");
//                    builder.append("Model: " + v.getModel());
//                    userDashBoardTextArea.setText(builder.toString());
//                }
//            }
//        });
//        this.carListView.getItems().setAll(this.vehicleList);
//        this.carListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//    }
//
//
//    public void loadCustomerCars() throws Exception {
//        this.customerCars = new HashMap<>();
//        try(BufferedReader bf = new BufferedReader(new FileReader("src/Data/UserCars.txt"))) {
//            String line = bf.readLine();
//            while (line != null) {
//                String[] split = line.split(";" );
//                Vehicle vehicle = new Vehicle(split[1], split[2], split[3]);
//                //System.out.println(vehicle);
//                HashMap<String, Vehicle> temp;
//                if (this.customerCars.containsKey(split[0])) {
//                        this.customerCars.get(split[0]).put(vehicle.getVIN(),vehicle );
//                } else {
//                    temp = new HashMap<>();
//                    temp.put(split[1], vehicle);
//                    this.customerCars.put(split[0], temp);
//                }
//                line = bf.readLine();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        this.getCurrentCustomerCars();
//    }
//
//    public void getCurrentCustomerCars() {
//        this.vehicleList = new LinkedList<>();
//        for (String key : this.customerCars.get(this.currentCustomer.getEmail()).keySet()) {
//            this.vehicleList.add(this.customerCars.get(this.currentCustomer.getEmail()).get(key));
//        }
//    }
//
//    public void viewAllCars() {
//        for (String key : this.customerCars.keySet()) {
//            HashMap<String,Vehicle> temp = this.customerCars.get(key);
//            for (String vin : temp.keySet()) {
//                System.out.println(vin);
//                System.out.println(temp.get(vin).getModel());
//            }
//        }
//    }
//
//    // for testing
//    public void printCustomerCars() {
//        for (Vehicle car : this.vehicleList) {
//            System.out.println(car);
//        }
//    }
}
