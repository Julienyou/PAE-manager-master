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

    /**
     * Getter for static id, no two observervers
     * have the same id.
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for owner (matricule)
     *
     * @return String
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Validates the class when used, if class is already
     * validated then it will invalidate it
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
     * Used in UE_classes.ObservableClass to update all observer
     * classes, puts the hours up to date
     *
     * @param hours int
     */
    public void update(int hours){
        this.setNHours(hours);
    }

    /** TESTING
     * Necessary for unit tests
     *
     * @return Boolean
     */
    public Boolean getValidate(){ return validated; }
}
