package DataModels.Vehicle;

import DataModels.Appointment.Appointment;
import DataModels.Notes.Note;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Vehicle {
    private String VIN;
    private String make;
    private String model;
    private final LinkedList<Note> maintenanceRecords;
    private final LinkedList<Appointment> appointments;

    public Vehicle(String VIN, String make, String model, LinkedList<Note> maintenanceRecords,
                   LinkedList<Appointment> appointmentTreeMap) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.maintenanceRecords = maintenanceRecords;
        this.appointments = appointmentTreeMap;
    }
// constructor for new car, with no record
    public Vehicle(String VIN, String make, String model) {
        this(VIN, make, model, new LinkedList<>(), new LinkedList<>());
    }
    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Note> getMaintenanceRecords() {
        return Collections.unmodifiableList(this.maintenanceRecords);
    }

    public boolean addNote(Note note) {
        return this.maintenanceRecords.add(note);
    }

    public boolean addAppointment(Appointment appointment) {
        if (appointment != null) {
            return this.appointments.add(appointment);
        }
        return false;
    }

    public boolean removeAppointment(Appointment appointment) {
        if (this.appointments.contains(appointment)) {
            return this.appointments.remove(appointment);
        }
        return false;
    }

//    public boolean modifyAppointment(Appointment oldAppointment, Appointment newAppointment) {
//        if (oldAppointment != null && newAppointment != null && this.appointments.contains(oldAppointment)) {
//
//        }
//    }


    public LinkedList<Appointment> getAppointments() {
        return this.appointments;
    }

    @Override
    public String toString() {
        return this.make + ", " + this.model;
    }
}
