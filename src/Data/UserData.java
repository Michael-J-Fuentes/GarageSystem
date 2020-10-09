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
        users.put("Customer", new HashMap<>());
        users.put("Mechanic", new HashMap<>());
    }

    public HashMap<String, HashMap<String, User>> getUsers() {
        return users;
    }

    public HashMap<String, User> getCustomers() {
        return users.get("Customer");
    }


    public Customer getCustomer(String userName) {
        return (Customer) users.get("Customer").get(userName);
    }

    public boolean isUser(String userName) {
       return (isUserCustomer(userName) || users.get("Mechanic").containsKey(userName));
    }

    public boolean isUser(String userName, String password) {
        if (isUser(userName)) {
            // check if user is in customer map
            if (isUserCustomer(userName)) {
                // check if password matches
                Customer temp = (Customer) users.get("Customer").get(userName);
                return (temp.getPassword().equals(password));
            } else {

            }
        }
        // username was not found
        return false;
    }

    public boolean isUserCustomer(String userName) {
        return users.get("Customer").containsKey(userName);
    }
    // save new customer to working memory
    public boolean addNewUser(User user, String type) {
        if (user == null) {
            return false;
        }
        switch (type.trim().toLowerCase()) {
            case "customer":
                Customer temp = (Customer) user;
                users.get(type).put(temp.getEmail(), temp);
                return users.get(type).containsKey(temp.getEmail());
            case "mechanic":
                Mechanic tempMech = (Mechanic) user;
                users.get(type).put(tempMech.getEmail(), tempMech);
                return users.get(type).containsKey(tempMech.getEmail());
            case "admin":
                // to be implemented
                return false;
        }
        return false;
    }

    public boolean addNewUser(String firstName, String lastName, String email, String phone, String password
                                , String type) {
        // checking if all inputs are valid
        if (isValid(firstName) && isValid(lastName) && isValid(email) && isValid(phone) && isValid(password)) {
            switch (type.trim().toLowerCase()) {
                case "customer":
                    Customer temp = new Customer(firstName, lastName, email, phone, password);
                    users.get(type).put(temp.getEmail(), temp);
                    return users.get(type).containsKey(temp.getEmail());
                case "mechanic":
                    Mechanic tempMech = new Mechanic(firstName, lastName, email, phone, password);
                    users.get(type).put(tempMech.getEmail(), tempMech);
                    return users.get(type).containsKey(tempMech.getEmail());
                case "admin":
                    // to be implemented
                    return false;
            }

        }
        return false;
    }

    private boolean isValid(String string) {
        return (string != null);
    }

    // load data from file
    // Done: 10/6/2020 Error reading data into file, creates null pointer exception
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
                    tempUser = new Mechanic(split[0], split[1], split[2], split[3],split[4]);
                }
                // check if user exit in current working memory
                if (!users.get(userType).containsKey(tempUser.getEmail())) {
                    users.get(userType).put(tempUser.getEmail(), tempUser);
                    System.out.println("User " + tempUser.getEmail() + " was added");
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
