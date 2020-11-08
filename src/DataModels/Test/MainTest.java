package DataModels.Test;

import DataModels.Appointment.Appointment;
import DataModels.Appointment.BookAppointment;
import DataModels.Garage.Address;
import DataModels.Garage.Garage;
import DataModels.Users.Customer;
import DataModels.Users.Mechanic;
import DataModels.Vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        ArrayList<Garage> shops = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Mechanic> mechanics = new ArrayList<>();

        // create a customer
        Customer bobCantFixMyCar = new Customer("bob", "Can'tFixMyCar", "bob@noSkills.com",
                "1800-756-1597", "1234");
        customers.add(bobCantFixMyCar);
        // create a car
        Vehicle carOne = new Vehicle("VINONE-HELLO", "Toyota", "4runner");
        // add car to customer list
        System.out.println(bobCantFixMyCar.addVehicle(carOne));
        //create shop address
        Address address = new Address("123", "Main Street", "Fort Worth",
                "Texas", 76140);
        // create a garage
        Garage shopOne = new Garage("Shop One", "address" );
        shops.add(shopOne);
        // create a mechanic
        Mechanic mrDIY = new Mechanic("John", "fix", "john@shop.com", "98765",
                "diy");
        mechanics.add(mrDIY);
        // add mechanic to garage
        System.out.println(shopOne.addMechanic(mrDIY));
        // create appointment
        Appointment appointmentZero = new Appointment(carOne, mrDIY, shopOne);
        // add appointment to shop
        BookAppointment.bookAppointment(appointmentZero);
        // view shop appointments
        System.out.println("____________ shop view ______________");
        shopOne.viewAppointments();
        System.out.println("_____________ customer view can't fix it_______________");
        // veiw customer appointments
        bobCantFixMyCar.viewAppointments();

        // creating a second car to add to garage appointments
        Vehicle carTwo = new Vehicle("runTwo", "Ford", "Mustang");
        BookAppointment.bookAppointment(new Appointment(carTwo, LocalDateTime.now(), mrDIY, shopOne));
        System.out.println("____________ shop view ______________");
        shopOne.viewAppointments();
        System.out.println("_____________ customer view can't fix it _______________");
        // veiw customer appointments
        bobCantFixMyCar.viewAppointments();

        // view mechanic appointments

        System.out.println("___________________ mr diy appointments ___________________");
        mrDIY.viewAppointments();



        Customer c2 = new Customer("customerTwo", "Two", "two@gmail.com", "3564",
                "pass");
        c2.addVehicle(new Vehicle("VinTwo", "Tesla", "Model 3"));
        Garage shopTwo = new Garage("Bob garage", "Address");
        Mechanic mechanicTwo = new Mechanic("Mike", "Fuentes", "mike@shopTwo.com", "64341",
                "mikepass");
        // booking a appointment
        System.out.println(BookAppointment.bookAppointment(new Appointment(c2.getVehicle("VinTwo"),LocalDateTime.now(),
                mechanicTwo, shopTwo)));
        System.out.println("____________________ appointments for customer two_________________");
        c2.viewAppointments();

        // view appointments for shop one
        System.out.println("__________________ shop two appointments _____________________");
        shopTwo.viewAppointments();
        // view appointment for shop two
        System.out.println("________________________ mechanic two appointments______________________");
        mechanicTwo.viewAppointments();
    }


}
