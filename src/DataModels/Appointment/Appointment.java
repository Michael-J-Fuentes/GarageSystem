package DataModels.Appointment;

import DataModels.Garage.Garage;
import DataModels.Users.Mechanic;
import DataModels.Vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment {
    private Vehicle vehicle;
    private LocalDateTime date;
    private Mechanic mechanic;
    private Garage garage;

    public Appointment(Vehicle vehicle, LocalDateTime date, Mechanic mechanic, Garage garage) {
        this.vehicle = vehicle;
        this.date = date;
        this.mechanic = mechanic;
        this.garage = garage;
    }

    public Appointment(Vehicle vehicle, Mechanic mechanic, Garage garage) {
        this(vehicle, LocalDateTime.now(),mechanic, garage);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "vehicle=" + vehicle +
                ", date=" + date +
                ", mechanic=" + mechanic +
                ", garage=" + garage +
                '}';
    }
}
