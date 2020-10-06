package DataModels.Appointment;

public class BookAppointment {
    public static boolean bookAppointment(Appointment appointment) {
        if (appointment == null) {
            return false;
        } else {
            return (appointment.getVehicle().addAppointment(appointment) &&
                    appointment.getGarage().addAppointment(appointment) &&
                    appointment.getMechanic().addAppointment(appointment));
        }
    }
}
