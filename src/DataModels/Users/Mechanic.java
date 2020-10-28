package DataModels.Users;

import DataModels.Appointment.Appointment;
import DataModels.Vehicle.Note;
import DataModels.Vehicle.Vehicle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Mechanic extends User{
    private LinkedList<Appointment> upcomingCustomers;
    private int id;

    public Mechanic(String firstName, String lastName, String email, String phone,
                    String password, int id, LinkedList<Appointment> upcomingCustomers) {
        super(firstName, lastName, email, phone, password);
        this.id = id;
        this.upcomingCustomers = upcomingCustomers;
    }
    public Mechanic(String firstName, String lastName, String email, String phone,
                    String password) {
        super(firstName, lastName, email, phone, password);
        this.upcomingCustomers = new LinkedList<>();
    }

    public List<Appointment> getUpcomingCustomers() {
        return Collections.unmodifiableList(this.upcomingCustomers);
    }

    public void setUpcomingCustomers(LinkedList<Appointment> upcomingCustomers) {
        this.upcomingCustomers = upcomingCustomers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void viewAppointments() {
        for (Appointment appointment : this.upcomingCustomers) {
//            TODO add something to view user request(subject Line)
            System.out.printf("%s %s%n", appointment.getVehicle().getMake(), appointment.getVehicle().getModel());
            System.out.printf("Time: %s%n%n", appointment.getDate().toString());

        }
    }

    public boolean addNotes(Vehicle vehicle, Note note) {
        // check if information passed is valid
        if (vehicle == null || note == null) {
            return false;
        } else {
            return vehicle.addNote(note);
        }
    }

    // gets a linked list of all the things which have been done to car
    // list can not be modified by mechanic
    public List<Note> getVehicleHistory(Vehicle current) {
        if (current != null && current.getMaintenanceRecords() != null) {
            return Collections.unmodifiableList(current.getMaintenanceRecords());
        } else {
            return Collections.unmodifiableList(new LinkedList<>());
        }
    }

    // print vehicle history
    public void printVehicleHistory(Vehicle current) {
        LinkedList<Note> history = (LinkedList<Note>) this.getVehicleHistory(current);

        for (Note historyItem : history) {
            System.out.println(historyItem);
            System.out.println();
        }
    }

    public boolean addAppointment(Appointment appointment) {
        if (appointment != null) {
            return this.upcomingCustomers.add(appointment);
        } else {
            return false;
        }
    }



}
