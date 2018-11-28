package UE_classes;

import UE_classes.UE;

import java.util.ArrayList;
import java.util.List;

public class ObservableUE extends UE {
    private List<ObserverUE> observers;
    private List<ObservableClass> classes;

    public ObservableUE(String name, String code){
        super(name, code);
        this.observers = new ArrayList<ObserverUE>();
        this.classes = new ArrayList<ObservableClass>();
    }

    /*
     * Getter for observers
     *
     * input: void
     * output: List<ObserverUE>
     * */
    public List<ObserverUE> getObservers() {return observers;}

    /*
     * Getter for classes
     *
     * input: void
     * output: List<ObservableClass>
     * */
    public List<ObservableClass> getClasses() {return classes;}

    /*
     * Calculates total hours from UE classes and
     * modifies nhours
     *
     * inputs: void
     * outputs: void
     * */
    public void calcHours(){
        int sum_h = 0;
        for (ObservableClass single_class: classes){
            sum_h += single_class.getNHours();
        }
        setHours(sum_h);
    }

    /*
     * Used when a student duplicates this class
     * and puts it in his program. Will update his instance
     * and all his class children classes
     *
     * inputs: ObservableUE
     * outputs: void
     * */
    public void duplicate(ObserverUE single_ue){
        for (ObserverUE ue: observers){
            if (single_ue.getId() == ue.getId()){
                single_ue.update(getCredits(), getHours(), getInfoSheet());
                return;
            }
        }

        observers.add(single_ue);
        single_ue.update(getCredits(), getHours(), getInfoSheet());
    }

    /*
     * Goes through all the observers and updates them
     *
     * inputs: void
     * outputs: void
     * */
    public void notifyObservers(){
        for (ObserverUE ue: observers){
            ue.update(getCredits(), getHours(), getInfoSheet());
        }
    }

    public void addClass(ObservableClass single_class){
        classes.add(single_class);
    }

    /* TESTING
     * Modifies params for testing
     *
     * inputs: void
     * outputs: void
     * */
    public void testSetParam2(){
        setHours(47);
        classes.add(new ObservableClass("SA4T", "1E0101"));
        classes.add(new ObservableClass("SA4L", "1E0102"));
    }
}
