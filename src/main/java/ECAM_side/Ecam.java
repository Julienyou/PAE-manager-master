package ECAM_side;

import People_side.Student;
import People_side.Teacher;
import UE_classes.ObservableClass;
import UE_classes.ObservableUE;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Ecam {
    private static Ecam instance = new Ecam();
    private Map<String, Orientation> orientations;
    private Map<Integer, Teacher> teachers;
    private Map<Integer, Student> students;

    private Ecam(){
        this.orientations = new HashMap<String, Orientation>();
        this.teachers = new HashMap<Integer, Teacher>();
        this.students = new HashMap<Integer, Student>();
    }

    /**
     * Get singleton instance
     *
     * @return ECAM_side.Ecam
     */
    public static Ecam getInstance(){
        return instance;
    }

    /**
     * Get specific orientation, orientations will be:
     *
     * -> Automatisation
     * -> Construction
     * -> Electronique
     * -> Geometre
     * -> Informatique
     * -> Electromecanique
     *
     * @param  code String
     * @return ECAM_side.Orientation
     */
    public Orientation getOrientation(String code){
        return orientations.get(code);
    }

    /**
     * Adds a teacher to teacher map
     * People_side.Teacher ID will be used for mapping
     *
     * @param  People_side.Teacher
     */
    public void addTeacher(){}

    /**
     * Gets a specific student though its id
     *
     * @param  matricule String
     * @return Student
     */
    public Student getStudent(String matricule){
        return students.get(Integer.parseInt(matricule));
    }

    /**
     * Adds a student to student list
     * People_side.Student ID will be used for mapping
     *
     * @param std People_side.Student
     */
    public void addStudent(Student std){
        students.put(std.getId(), std);
    }

    public void addOrientation(String code, Orientation orn){
        orientations.put(code, orn);
    }

    public void init(){
        ObservableClass class1 = new ObservableClass("DD4L", "1");
        ObservableClass class2 = new ObservableClass("DD4X", "2");
        ObservableClass class3 = new ObservableClass("DD4Y", "3");
        ObservableClass class4 = new ObservableClass("DD4Z", "4");

        ObservableUE ue1 = new ObservableUE("DD", "SA");
        ue1.setCredits(99);
        ue1.setHours(90);
        ObservableUE ue2 = new ObservableUE("DX", "SX");
        ue2.setCredits(2);
        ue2.setHours(9);

        ue1.addClass(class1);
        ue2.addClass(class2);
        ue2.addClass(class3);
        ue2.addClass(class4);

        HashMap<String, ObservableUE> ues = new HashMap<String, ObservableUE>();
        ues.put(ue1.getCode(), ue1);
        ues.put(ue2.getCode(), ue2);
        Bloc bloc1 = new Bloc(ues);
        Bloc bloc2 = new Bloc(ues);
        Bloc bloc3 = new Bloc(ues);
        Bloc bloc4 = new Bloc(ues);
        Bloc bloc5 = new Bloc(ues);
        Program bachelier = new Program(Arrays.asList(bloc1, bloc2, bloc3));
        Program master = new Program(Arrays.asList(bloc4, bloc5));
        Orientation min = new Orientation("MIN", bachelier, master);

        Ecam ecam = Ecam.getInstance();
        ecam.addOrientation(min.getName(), min);
    }
}
