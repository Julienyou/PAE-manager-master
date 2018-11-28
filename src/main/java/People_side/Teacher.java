package People_side;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teacher extends Human {
    private int ID;
    private static int amount;
    private List<Date> schedule;
    private String background;

    public Teacher(String name, String lastname){
        super(name, lastname);
        this.ID = ++amount;
        this.schedule = new ArrayList<Date>();
        this.background = "Maths";
    }

    /*
     * Getter for ID
     *
     * inputs: void
     * outputs: int
     * */
    public int getID(){
        return ID;
    }

    /*
     * Getter for schedule
     *
     * inputs: void
     * outputs: List<Date>
     * */
    public void getSchedule(){}

    /*
     * Setter for a UE_classes.UE's info sheet
     *
     * inputs: UE_classes.ObservableUE, string (path to info sheet)
     * outputs: void
     * */
    public void setInfoSheet(){}

    /*
     * Setter for a UE_classes.UE's credits
     *
     * inputs: UE_classes.ObservableUE, int
     * outputs: void
     * */
    public void setCredits(){}

    /*
     * Setter for UE_classes.UE's hours
     *
     * inputs: UE_classes.ObservableUE, int
     * outputs: void
     * */
    public void setNHours(){}

    /*
     * Gets a student's history of student programs
     *
     * inputs: int (student matricule)
     * outputs: List<People_side.StudentProgram>
     * */
    public void getStudentPAE(){}

    /*
     * Accept a student into an UE_classes.UE, therefore turning the
     * acepted_status of that students UE_classes.ObserverUE to true
     *
     * inputs: int (matricule)
     * outputs: void
     * */
    public void acceptStudent(){}
}
