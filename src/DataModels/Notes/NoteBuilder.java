package DataModels.Notes;

import DataModels.Garage.Garage;
import DataModels.Users.Mechanic;

import java.time.LocalDate;
import java.util.Date;

public class NoteBuilder {
    public static Note buildNote(String subjectLine, LocalDate date, String description, Mechanic mechanic,
                                 Garage garage) {
        return new Note(subjectLine, date, description, mechanic, garage);
    }
    // build note with current system time
    public static Note buildNote(String subjectLine, String description, Mechanic mechanic, Garage garage) {
        return new Note(subjectLine, LocalDate.now(), description, mechanic, garage);
    }
}
