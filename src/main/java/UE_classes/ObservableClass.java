package UE_classes;

import People_side.Teacher;

import java.util.ArrayList;
import java.util.List;

public class ObservableClass extends Class {
    private List<ObserverClass> observers;

    /**
     * Constructor of the class ObservableClass
     *
     * @param name String
     * @param code String
     */
    public ObservableClass(String name, String code){
        super(name, code);
        this.observers = new ArrayList<ObserverClass>();
        this.nhours = 10;
    }

    /**
     * Adds a teacher to the teacher list
     *
     * @param teacher Teacher
     */
    public void addTeacher(Teacher teacher){
        teachers.put(teacher.getId(), teacher);
    }

    /**
     * Deletes a teacher from the teacher list
     *
     * @param id int
     */
    public void delTeacher(int id){
        teachers.remove(id);
    }

    /**
     * Used when a student duplicates the parent UE
     * and puts it in his program. Will update this class and add
     * the ObservableClass to the observer list
     *
     * !Allows the observer to trigger an update instead of having!
     * !to wait for the observable to trigger one                 !
     *
     * ->update specific Observable only
     *
     * @param single_class ObserverClass
     */
    public void duplicate(ObserverClass single_class){
        for (ObserverClass elem: observers) {
            if (single_class.getId() == elem.getId()) {
                elem.update(getNbrHours());
                return;
            }
        }

        observers.add(single_class);
        single_class.update(getNbrHours());
    }

    /**
     * Notifies all observers they should update
     *
     */
    public void notifyObservers(){
        for (ObserverClass observer: observers) {
            observer.update(nhours);
        }
    }

    /** TESTING
     * Getter necessary for testing
     *
     * @return List<ObserverClass>
     */
    public List<ObserverClass> getObservers(){
        return observers;
    }
}
