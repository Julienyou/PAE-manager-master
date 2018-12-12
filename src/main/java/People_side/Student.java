package People_side;

import java.util.ArrayList;
import java.util.List;

public class Student extends Human {
    private final int matricule;
    private List<StudentProgram> program;

    /**
     * Constructor of the class Student
     *
     * @param name String
     * @param lastname String
     * @param matricule int
     */
    public Student(String name, String lastname, int matricule) {
        super(name, lastname);
        this.matricule = matricule;
        this.program = new ArrayList<StudentProgram>();
    }

    /**
     * Getter for matricule
     *
     * @return int
     */
    public int getId(){
        return matricule;
    }

    /**
     * Gives back the status of a class after
     * receiving the class code as an input
     *
     * @param  code String
     * @return Boolean (class status)
     */
    public Boolean getStatus(String code){
        return false;
    }

    /**
     * Getter for last StudentProgram
     *
     * @return StudentProgram (last program)
     */
    public StudentProgram getProgram() {
        return program.get(program.size() - 1);
    }

    /**
     * Gets the total amount of credits for the
     * student's current program
     *
     * @return int
     */
    public int getCredits(){
        StudentProgram prog = getProgram();
        return prog.calcCredits();
    }

    /**
     * Gets the total amount of hours for the
     * student's current program
     *
     * @return int
     */
    public int getHours(){
        StudentProgram prog = getProgram();
        return prog.calcHours();
    }

    /**
     * Gets the total amount of validated credits
     * for the student's current program
     *
     * @return int
     */
    public int getValidCredits(){
        StudentProgram prog = getProgram();
        return prog.calcValidCredits();
    }

    /**
     * Add a new People_side.StudentProgram object to the
     * program list, representing a new year for
     * the student
     *
     * @param year   String
     * @param acyear String
     */
    public void newProgram(String year, String acyear){
        StudentProgram sprg = new StudentProgram(year, acyear, Integer.toString(matricule));
        program.add(sprg);
    }
}
