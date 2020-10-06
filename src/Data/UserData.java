package Data;

import DataModels.Users.Customer;
import DataModels.Users.Mechanic;
import DataModels.Users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class UserData {
    private static UserData instance = new UserData();
    private static String fileName = "src/Data/Users.txt";
    private static HashMap<String,HashMap<String, User>> users;

    public static UserData getInstance() {
        return instance;
    }

    private UserData() {
        users = new HashMap<>();
    }

    // load data from file
    public void loadData() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null ){
                String[] split = line.trim().split(";");
                String userType = split[5];
                User tempUser;
                if (userType.toLowerCase().equals("customer")) {
                    tempUser = new Customer(split[0], split[1], split[2], split[3],split[4]);
                } else { //(userType.toLowerCase().equals("mechanic"))
                    // something for mech
                    tempUser = new Mechanic(split[0], split[1], split[2], split[3],split[4]);
                }
                // check if user exit
                if (!users.get(userType).containsKey(tempUser.getEmail())) {
                    // user is not in current array
                    users.get(userType).put(tempUser.getEmail(), tempUser);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading in user file data. Called from UserData- load data");
            e.printStackTrace();
        }
    }

    public void saveData() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (String userType : users.keySet()) {
                for (String userName : users.get(userType).keySet()) {
                    User temp = users.get(userType).get(userName);
                    bufferedWriter.write(temp.getFirstName() + ";" + temp.getLastName() + ";" + temp.getEmail() +
                            ";" + temp.getPhone() + ";" + temp.getPassword() + ";" + userType);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file. Called from UserData saveData");
            e.printStackTrace();
        }
    }
}
