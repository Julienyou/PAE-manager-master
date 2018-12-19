package people_side;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teacher extends Human {
    private int id;
    private static int amount;
    private List<Date> schedule;
    private String background;

    /**
     * Constructor of the class Teacher
     *
     * @param name String
     * @param lastname String
     */
    public Teacher(String name, String lastname){
        super(name, lastname);
        this.id = ++amount;
        this.schedule = new ArrayList<Date>();
        this.background = "Maths";
    }

    /**
     * Getter for ID
     *
     * @return  int
     */
    public int getId(){
        return this.id;
    }

    /**
     * Getter for schedule
     * Should return List<Date>
     */
    public void getSchedule(){}

    /**
     * Setter for a UE_classes.UE's info sheet
     * Should take as param : UE_classes.ObservableUE String (path to info sheet)     *
     */
    public void setInfoSheet(){}

    /**
     * Setter for a UE_classes.UE's credits
     * Should take as param : UE_classes.ObservableUE int
     */
    public void setCredits(){}

    /**
     * Setter for UE_classes.UE's hours
     * Should take as param : UE_classes.ObservableUE int
     */
    public void setNbrHours(){}

    /**
     * Gets a student's history of student programs
     * Should take as param : matricule int (student matricule)
     * Should return List<People_side.StudentProgram>
     */
    public void getStudentPae(){}

    /**
     * Accept a student into an UE_classes.UE, therefore turning the
     * acepted_status of that students UE_classes.ObserverUE to true
     * Should take as param : matricule int (student matricule)
     */
    public void acceptStudent(){}
}
