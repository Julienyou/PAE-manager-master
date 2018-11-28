package UE_classes;

import UE_classes.UE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObserverUE extends UE {
    private int id;
    private String owner;
    private Boolean validated;
    private static int amount;
    private Boolean accept_status;
    private List<ObserverClass> classes;

    public ObserverUE(String name, String code, String owner){
        super(name, code);
        this.id = ++amount;
        this.owner = owner;
        this.validated = false;
        this.accept_status = false;
        this.classes = new ArrayList<ObserverClass>();
    }

    /*
     * When called, validates the UE If called again,
     * unvalidated the UE
     *
     * inputs: void
     * outputs: void
     * */
    public void validate(){
        if (validated){
            validated = false;
        } else {
            validated = true;
        }
    }

    /*
     * Getter for id
     *
     * inputs: void
     * outputs: int
     * */
    public int getId(){return id;}

    /*
     * Getter for owner
     *
     * inputs: void
     * outputs: String
     * */
    public String getOwner(){return owner;}

    /*
     * Getter for accepted_status to know whether
     * a teacher accepted a student into an UE or not
     *
     * inputs: void
     * outputs: Boolean
     * */
    public Boolean getStatus(){return accept_status;}

    /*
     * Getter for classes
     *
     * input: void
     * output: List<ObserverClass>
     * */
    public List<ObserverClass> getClasses() {return classes;}

    /*
     * Calculates total validated credits from UE classes and
     * sends them back as an int
     *
     * inputs: void
     * outputs: int
     * */
    public int calcValidCredits(){
        for (ObserverClass single_class: classes){
            if (!single_class.getValidate()){
                return 0;
            }
        }
        return this.getCredits();
    }

    /*
     * Function called whenever a change happens in corresponding
     * ObservableUE, should recalculate hours and credits and update
     * the info sheet -> calculated in Observable
     *
     * inputs: int, int, String (credits, hours, info_sheet)
     * outputs: void
     * */
    public void update(int credits, int hours, String info_sheet){
        setCredits(credits);
        setHours(hours);
        setInfoSheet(info_sheet);
    }

    /* TESTING
     * validate getter necessary for testing
     *
     * inputs: void
     * outputs: Boolean
     * */
    public Boolean getValidated(){return validated;}

    /* TESTING
     * Modifies params for testing
     *
     * inputs: void
     * outputs: void
     * */
    public void testSetParam2(){
        accept_status = true;
        classes.add(new ObserverClass("SA4T", "1E0101", "13152"));
        classes.add(new ObserverClass("SA4L", "1E0102", "13152"));
    }
}
