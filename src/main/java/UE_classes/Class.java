package UE_classes;

import People_side.Teacher;

import java.util.HashMap;
import java.util.Map;

public class Class {
    private String name;
    private String code;
    protected int nhours;
    protected Map<Integer, Teacher> teachers;

    /**
     * Constructor of the class Class
     *
     * @param name String
     * @param code String
     */
    public Class(String name, String code){
        this.name = name;
        this.code = code;
        this.teachers = new HashMap<Integer, Teacher>();
    }

    /**
     * Getter for name
     *
     * @return String
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter for code
     *
     * @return String
     */
    public String getCode(){
        return this.code;
    }

    /**
     * Getter for number of hours
     *
     * @return int
     */
    public int getNbrHours(){
        return this.nhours;
    }

    /**
     * Setter for number of hours
     *
     * @param hours int
     */
    public void setNbrHours(int hours){
        this.nhours = hours;
    }

    /**
     * Getter for teacher list
     *
     * @return HashMap<Integer, Teacher>
     */
    public Map<Integer, Teacher> getTeachers(){
        return this.teachers;
    }

    /** TESTING
     * Necessary for testing
     *
     * @return int
     */
    public int testSetParam(){
        this.nhours = 10;
        Teacher cbf = new Teacher("Sebastien", "Combefis");
        Teacher lrk = new Teacher("Quentin", "Lurkin");
        this.teachers.put(cbf.getId(), cbf);
        this.teachers.put(lrk.getId(), lrk);
        return cbf.getId();
    }
}
