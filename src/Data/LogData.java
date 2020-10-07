package Data;

import DataModels.Notes.Note;
import DataModels.Users.Customer;
import DataModels.Users.User;
import DataModels.Vehicle.Vehicle;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

public class LogData {
    private static LogData instance = new LogData();
    private static String file = "src/Data/CarLogs.txt";

    private LogData() {

    }

    public static LogData getInstance() {
        return instance;
    }

    // load notes directly to user classes
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.trim().split(";");
                String userName = split[0];
                if (UserData.getInstance().isUserCustomer(userName)) {
                    // add note to their file
                    User abstractUser = UserData.getInstance().getCustomers().get(userName);
                    Customer tempCustomer = (Customer) abstractUser;
                    // DONE: 10/6/2020 below is returning null, check if cars were not added for customer
                    System.out.println(tempCustomer);
                    if (tempCustomer.getVehicle(split[1]) != null ){
                        Vehicle tempVeh = tempCustomer.getVehicle(split[1]);
                        tempVeh.addNote(new Note(split[2], LocalDate.parse(split[3]), split[4]));
//                        tempVeh.addNote(new Note("Test", LocalDate.parse("2007-12-03"),
//                                "Testing notes one"));
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error in LogData load");
            e.printStackTrace();
        }
    }

    // save notes

    public void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){

            for (String userName : UserData.getInstance().getCustomers().keySet()) {
                // loop over cars
                Customer temp = (Customer) UserData.getInstance().getCustomers().get(userName);
                for(String vin : temp.getCustomerCars().keySet()) {
                    // loop over cars notes
                    Iterator<Note> iterator = temp.getVehicle(vin).getMaintenanceRecords().iterator();
                    while (iterator.hasNext()) {
                        writer.write(userName + ";" + vin + ";" +iterator.next().saveNote());
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e ) {
            System.out.println("Error saving log data to file, called from LogData saveData");
            e.printStackTrace();
        }
    }
}
