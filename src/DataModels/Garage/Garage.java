package DataModels.Garage;

import DataModels.Appointment.Appointment;
import DataModels.Users.Mechanic;
import DataModels.Users.ViewAppointments;

import java.util.HashMap;
import java.util.LinkedList;

public class Garage implements ViewAppointments {
    private String name;
    private HashMap<Integer, Mechanic> mechanics;
    //private HashMap<Integer, Admin> admins;
    private String address;
    // replace with a binary tree map, with a custom comparable value based on time
    private LinkedList<Appointment> appointments;

    public Garage(String name, HashMap<Integer, Mechanic> mechanics,  String address, LinkedList<Appointment> appointments) {
        this.name = name;
        this.mechanics = mechanics;
        this.address = address;
        this.appointments = appointments;
    }

    // default constructor for a new shop that does not contain mechs
    public Garage(String name, String address) {
        this(name, new HashMap<>(), address, new LinkedList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(HashMap<Integer, Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean addMechanic(Mechanic newMechanic) {
        if (mechanics != null && !(this.mechanics.containsKey(newMechanic.getId()))) {
            this.mechanics.put(newMechanic.getId(), newMechanic);
            return true;
        }
        return false;
    }

    public LinkedList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(LinkedList<Appointment> appointments) {
        this.appointments = appointments;
    }


    public boolean addAppointment(Appointment appointment) {
        if (appointment == null) {
            return false;
        } else {
            return this.appointments.add(appointment);
        }
    }

    @Override
    public void viewAppointments() {
        for (Appointment appointment : this.appointments) {
            System.out.printf("%s %s%n", appointment.getVehicle().getMake(), appointment.getVehicle().getModel());
            System.out.printf("Time: %s%n%n", appointment.getDate().toString());
        }
    }

    // get appointments for a specific mechanic
    public LinkedList<Appointment> mechanicAppointments(int mechanicID) {
        LinkedList<Appointment> mechanicAppointments = new LinkedList<>();
        for (Appointment item : this.appointments) {
            if (item.getMechanic().getId() == mechanicID) {
                mechanicAppointments.add(item);
            }
        }
        return mechanicAppointments;
    }

    // used to save data to file
    public String saveData() {
        return this.name + ";" + this.address;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
