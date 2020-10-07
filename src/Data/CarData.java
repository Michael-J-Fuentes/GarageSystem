package Data;

import DataModels.Users.Customer;
import DataModels.Users.User;
import DataModels.Vehicle.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class CarData {
    private static CarData instance = new CarData();
    private static String fileName = "src/Data/UserCars.txt";
//    private static HashMap<String, ObservableList<Vehicle>> allCars;

    // temp solution for current user
    public static String currentUser;


    /** get location reference to principle list */
    public static CarData getInstance() {
        return instance;
    }
    /** prevents multiple instances of class from begin created */
    private CarData() {

    }

    /** builds item list from file at start of program */
    public void loadCars() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.trim().split(";");
//                // create temp car, could be used in both possible options
                Vehicle temp = new Vehicle(split[1], split[2], split[3]);
                // create temp customer from user data, used for ease of access;
                Customer customer = UserData.getInstance().getCustomer(split[0]);
                // check if customer is not null,
                if (customer != null) {
                    customer.addVehicle(temp);
                }
                // if user is not in array, line is skipped
                line = bufferedReader.readLine();
            }
        } catch (IOException e ) {
            System.out.println("Error loading cars into array. Called from CarData-Load cars");
            e.printStackTrace();
        }
    }

    /** method to save items to file at end of program
     * Will write items grouped by owner*/
    public void saveCars() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (String userType : UserData.getInstance().getUsers().keySet()) {
                // iterate over each customer type
                for (String userName : UserData.getInstance().getUsers().get(userType).keySet() ) {
                    // iterate over customer cars
                    if (userType.toLowerCase().equals("customer")) {
                        Customer temp = (Customer) UserData.getInstance().getUsers().get(userType).get(userName);
                        for (String vin : temp.getCustomerCars().keySet()) {
                            String output = userName + ";" + vin + ";" + temp.getVehicle(vin).getMake() + ";";
                            output += temp.getVehicle(vin).getModel();
                            writer.write(output);
                            writer.newLine();
                        }
                    }
                }
            }
            // get customer cars, located in hash map
        } catch (IOException e) {
            System.out.println("Error saving array to disk. Called from CarData-SaveCars");
            e.printStackTrace();
        }
    }






}
