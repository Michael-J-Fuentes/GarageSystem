package Data;

import DataModels.Garage.Garage;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class GarageData {
    private static GarageData instance;
    private HashMap<String, Garage> garageHashMap;

    private GarageData() {
        instance = new GarageData();
        garageHashMap = new HashMap<>();
    }

    public static GarageData getInstance() {
        return instance;
    }

    public HashMap<String, Garage> getGarageHashMap() {
        return garageHashMap;
    }

    public boolean isGarage(String garageName) {
        return garageHashMap.containsKey(garageName);
    }

    public Garage getGarage(String garageName) {
        return garageHashMap.get(garageName);
    }

    public boolean addGarage(Garage garage) {
        garageHashMap.put(garage.getName(), garage);
        return garageHashMap.containsValue(garage);
    }

    public boolean removeGarage(Garage garage) {
        garageHashMap.remove(garage.getName(), garage);
        return !garageHashMap.containsValue(garage);
    }

    // save data at close
    public void saveData() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/Data/Garages.txt"))) {
            for (Garage garage : garageHashMap.values()) {
                if (garage != null) {
                    writer.write(garage.saveData());
                    writer.newLine();
                }
            }
        } catch (IOException e) {

        }
    }
    // load data at open
    public void loadData() {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/Data/Garages.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                garageHashMap.put(split[0],new Garage(split[0], split[1]));
                line = reader.readLine();
            }
        } catch (IOException e) {

        }
    }
}
