package Data;

import DataModels.Vehicle.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.HashMap;

public class CarData {
    private static CarData instance = new CarData();
    private static String fileName = "src/Data/UserCars.txt";
    private static HashMap<String, ObservableList<Vehicle>> allCars;
    private ObservableList<Vehicle> cars;

    // temp solution for current user
    public static String currentUser;


    /** get location reference to principle list */
    public static CarData getInstance() {
        return instance;
    }
    /** prevents multiple instances of class from begin created */
    private CarData() {
        allCars = new HashMap<>();
        cars = FXCollections.observableArrayList();
    }
//    /**gets car list for javafx, every car included regards of owner*/
//    public ObservableList<Vehicle> getCars() {
//        return this.cars;
//    }
    /** get car list for specific Owner*/
    public ObservableList<Vehicle> getCars(String owner) {
        return allCars.get(owner);
    }
    /** add car main list*/
    public boolean addCar(String userName, Vehicle car) {
        return allCars.get(userName).add(car);
    }

    /** builds item list from file at start of program */
    public void loadCars() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.trim().split(";");
                // create temp car, could be used in both possible options
                Vehicle temp = new Vehicle(split[1], split[2], split[3]);
                // user already has a car
                if (allCars.containsKey(split[0])) {
                    // get user record
                    allCars.get(split[0]).add(temp);
                    // user does not currently have a car on record
                } else {
                    ObservableList<Vehicle> tempArray = FXCollections.observableArrayList();
                    tempArray.add(temp);
                    allCars.put(split[0], tempArray);
                }
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
            for (String key : allCars.keySet()) {
                ObservableList<Vehicle> temp = allCars.get(key);
                // iterate over each car the person owns,
                for (Vehicle tempCar : temp) {
                    writer.write(key + ";" + tempCar.getVIN() + ";" + tempCar.getMake() + ";" + tempCar.getModel());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving array to disk. Called from CarData-SaveCars");
            e.printStackTrace();
        }
    }






}
