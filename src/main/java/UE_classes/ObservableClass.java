package UE_classes;

import ECAM_side.ECAM;
import People_side.Student;
import People_side.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObservableClass extends Class {
    private List<ObserverClass> observers;

    public ObservableClass(String name, String code){
        super(name, code);
        this.observers = new ArrayList<ObserverClass>();
        this.nhours = 10;
    }

    /*
     * Setter for hours
     *
     * inputs: int
     * outputs: void
     * */
    public void setNHours(int hours){
        nhours = hours;
    }

    /*
     * Adds a teacher to the teacher list
     *
     * inputs: Teacher
     * outputs: void
     * */
    public void addTeacher(Teacher teacher){
        teachers.put(teacher.getID(), teacher);
    }

    /*
     * Deletes a teacher from the teacher list
     *
     * inputs: int (mapped id)
     * outputs: void
     * */
    public void delTeacher(int id){
        teachers.remove(id);
    }

    /*
     * Used when a student duplicates the parent UE
     * and puts it in his program. Will update this class and add
     * the ObservableClass to the observer list
     *
     * !Allows the observer to trigger an update instead of having!
     * !to wait for the observable to trigger one                 !
     *
     * ->update specific Observable only
     *
     * inputs: ObserverClass
     * outputs: void
     * */
    public void duplicate(ObserverClass single_class){
        for (ObserverClass elem: observers) {
            if (single_class.getID() == elem.getID()) {
                elem.update(getNHours());
                return;
            }
        }

        observers.add(single_class);
        single_class.update(getNHours());
    }

    /*
     * Notifies all observers they should update
     *
     * inputs: void
     * outputs: void
     * */
    public void notifyObservers(){
        for (ObserverClass observer: observers) {
            observer.update(nhours);
        }
    }

    /* TESTING
     * Getter necessary for testing
     *
     * inputs: void
     * outputs: List<ObserverClass>
     * */
    public List<ObserverClass> getObservers(){ return observers; }
}
