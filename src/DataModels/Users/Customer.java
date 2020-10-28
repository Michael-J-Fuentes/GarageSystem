package DataModels.Users;

import DataModels.Appointment.Appointment;
import DataModels.Vehicle.Vehicle;

import java.util.*;

public class Customer extends User implements ViewAppointments{
    private HashMap<String, Vehicle> customerCars;
    // create a customer with existing records
    public Customer(String firstName, String lastName, String email, String phone, String password,
                    HashMap<String, Vehicle> customerCars) {
        super(firstName, lastName, email, phone, password);
        this.customerCars = customerCars;
    }
    // create a new customer with no records
    public Customer(String firstName, String lastName, String email, String phone, String password) {
        super(firstName, lastName, email, phone, password);
        this.customerCars = new HashMap<>();

    }

    public HashMap<String, Vehicle> getCustomerCars() {
        return customerCars;
    }

    // used for GUI
    public List<Vehicle> getCustomerCarsListView() {
        return new ArrayList<>(customerCars.values());
    }

    public void setCustomerCars(HashMap<String, Vehicle> customerCars) {
        this.customerCars = customerCars;
    }


    public boolean addVehicle(Vehicle vehicle) {
        // check if customer already added the car to their list
        if (vehicle == null || this.customerCars.containsKey(vehicle.getVIN())) {
            // short cut decision returning a failed state
            return false;
        } else {
            this.customerCars.put(vehicle.getVIN(), vehicle);
            return true;
        }
    }

    public LinkedList<Appointment> getAppointments() {
        LinkedList<Appointment> appointments = new LinkedList<>();
        for (Map.Entry<String, Vehicle> entry : this.customerCars.entrySet()) {
            appointments.addAll(entry.getValue().getAppointments());
        }
        return appointments;
    }

    public Vehicle getVehicle(String id) {
        if (this.customerCars.containsKey(id)) {
            return this.customerCars.get(id);
        }
        return null;
    }

    @Override
    public void viewAppointments() {
        for (Appointment appointment : this.getAppointments()) {
            System.out.printf("%s %s%n", appointment.getVehicle().getMake(), appointment.getVehicle().getModel());
            System.out.printf("Time: %s%n%n", appointment.getDate().toString());
        }
    }

}
