package DataModels.Notes;

import DataModels.Garage.Garage;
import DataModels.Users.Mechanic;

import java.time.LocalDate;
// Note class is designed to keep general information about work which was performed on car
// including mechanic and garage name
//
public class Note {
    private String subjectLine;
    private LocalDate date;
    private String description;
    private Mechanic mechanic;
    private Garage garage;
// all information must be filled out inorder to place a new note
    // thus only one constructor is made present
    public Note(String subjectLine, LocalDate date, String description, Mechanic mechanic, Garage garage) {
        this.subjectLine = subjectLine;
        this.date = date;
        this.description = description;
        this.mechanic = mechanic;
        this.garage = garage;
    }

    // for testing
    public Note(String subjectLine, LocalDate date, String description) {
        this.subjectLine = subjectLine;
        this.date = date;
        this.description = description;
        this.mechanic = null;
        this.garage = null;
    }

    public String getSubjectLine() {
        return subjectLine;
    }

    public void setSubjectLine(String subjectLine) {
        this.subjectLine = subjectLine;
    }

    public LocalDate getDate() {
        return date;
    }

    // for testing UI

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String saveNote() {
        return subjectLine + ";" + date.toString() + ";" + description;

    }

    public String toString() {
        return this.subjectLine;
    }
}
