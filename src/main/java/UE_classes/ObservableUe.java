package ue_classes;


import java.util.ArrayList;
import java.util.List;

public class ObservableUe extends Ue {
    private List<ObserverUe> observers;
    private List<ObservableClass> classes;

    public ObservableUe(String name, String code){
        super(name, code);
        this.observers = new ArrayList<ObserverUe>();
        this.classes = new ArrayList<ObservableClass>();
    }

    /**
     * Getter for observers
     *
     * @retun List<ObserverUe>
     */
    public List<ObserverUe> getObservers() {
        return observers;
    }

    /**
     * Getter for classes
     *
     * @return List<ObservableClass>
     */
    public List<ObservableClass> getClasses() {
        return classes;
    }

    /**
     * Calculates total hours from UE classes and
     * modifies nhours
     *
     */
    public void calcHours(){
        int sum_h = 0;
        for (ObservableClass single_class: classes){
            sum_h += single_class.getNbrHours();
        }
        setHours(sum_h);
    }

    /**
     * Used when a student duplicates this class
     * and puts it in his program. Will update his instance
     * and all his class children classes
     *
     * @param single_ue ObservableUe
     */
    public void duplicate(ObserverUe single_ue){
        for (ObserverUe ue: observers){
            if (single_ue.getId() == ue.getId()){
                single_ue.update(getCredits(), getHours(), getInfoSheet());
                return;
            }
        }

        observers.add(single_ue);
        single_ue.update(getCredits(), getHours(), getInfoSheet());
    }

    /**
     * Goes through all the observers and updates them
     *
     */
    public void notifyObservers(){
        for (ObserverUe ue: observers){
            ue.update(getCredits(), getHours(), getInfoSheet());
        }
    }

    public void addClass(ObservableClass single_class){
        classes.add(single_class);
    }

    /** TESTING
     * Modifies params for testing
     *
     */
    public void testSetParamTwo(){
        setHours(47);
        classes.add(new ObservableClass("SA4T", "1E0101"));
        classes.add(new ObservableClass("SA4L", "1E0102"));
    }
}
