package ue_classes;

import java.util.ArrayList;
import java.util.List;

public class ObserverUe extends Ue {
    private int id;
    private String owner;
    private Boolean validated;
    private static int amount;
    private Boolean accept_status;
    private List<ObserverClass> classes;

    /**
     * Constructor of the class ObserverUe
     *
     * @param name String
     * @param code String
     * @param owner String
     */
    public ObserverUe(String name, String code, String owner){
        super(name, code);
        this.id = ++amount;
        this.owner = owner;
        this.validated = false;
        this.accept_status = false;
        this.classes = new ArrayList<ObserverClass>();
    }

    /**
     * When called, validates the UE If called again,
     * unvalidated the UE
     *
     */
    public void validate(){
        if (validated){
            validated = false;
        } else {
            validated = true;
        }
    }

    /**
     * Getter for id
     *
     * @return int
     */
    public int getId(){
        return id;
    }

    /**
     * Getter for owner
     *
     * @return String
     */
    public String getOwner(){
        return owner;
    }

    /**
     * Getter for accepted_status to know whether
     * a teacher accepted a student into an UE or not
     *
     * @return Boolean
     */
    public Boolean getStatus(){
        return accept_status;
    }

    /**
     * Getter for classes
     *
     * @return List<ObserverClass>
     */
    public List<ObserverClass> getClasses() {
        return classes;
    }

    /**
     * Calculates total validated credits from UE classes and
     * sends them back as an int
     *
     * @return int
     */
    public int calcValidCredits(){
        for (ObserverClass single_class: classes){
            if (!single_class.getValidate()){
                return 0;
            }
        }
        return this.getCredits();
    }

    /**
     * Function called whenever a change happens in corresponding
     * ObservableUe, should recalculate hours and credits and update
     * the info sheet -> calculated in Observable
     *
     * @param credits    int
     * @param hours      int
     * @param info_sheet String
     */
    public void update(int credits, int hours, String info_sheet){
        setCredits(credits);
        setHours(hours);
        setInfoSheet(info_sheet);
    }

    /** TESTING
     * validate getter necessary for testing
     *
     * @return Boolean
     */
    public Boolean getValidated(){
        return validated;
    }

    /** TESTING
     * Modifies params for testing
     *
     */
    public void testSetParamTwo(){
        accept_status = true;
        classes.add(new ObserverClass("SA4T", "1E0101", "13152"));
        classes.add(new ObserverClass("SA4L", "1E0102", "13152"));
    }
}
