package UE_classes;

import UE_classes.Class;

public class ObserverClass extends Class {
    private int id;
    private static int amount;
    private String owner;
    private Boolean validated;

    public ObserverClass(String name, String code, String owner){
        super(name, code);
        this.id = ++amount;
        this.owner = owner;
        this.validated = false;
    }

    /*
     * Getter for static id, no two observervers
     * have the same id.
     *
     * input: void
     * output: int
     * */
    public int getID() {
        return id;
    }

    /*
     * Getter for owner (matricule)
     *
     * input: void
     * output: String
     * */
    public String getOwner() {
        return owner;
    }

    /*
     * Validates the class when used, if class is already
     * validated then it will invalidate it
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
     * Used in UE_classes.ObservableClass to update all observer
     * classes, puts the hours up to date
     *
     * inputs: int (hours)
     * outputs: void
     * */
    public void update(int hours){
        this.setNHours(hours);
    }

    /* TESTING
     * Necessary for unit tests
     *
     * inputs: void
     * outputs: Boolean
     * */
    public Boolean getValidate(){ return validated; }
}
