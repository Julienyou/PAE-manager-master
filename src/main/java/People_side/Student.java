package People_side;

import java.util.ArrayList;
import java.util.List;

public class Student extends Human {
    private final int matricule;
    private List<StudentProgram> program;

    public Student(String name, String lastname, int matricule) {
        super(name, lastname);
        this.matricule = matricule;
        this.program = new ArrayList<StudentProgram>();
    }

    /*
     * Getter for matricule
     *
     * inputs: void
     * outputs: int
     * */
    public int getID(){return matricule;}

    /*
     * Gives back the status of a class after
     * receiving the class code as an input
     *
     * inputs: string (class code)
     * outputs: Boolean (class status)
     * */
    public Boolean getStatus(String code){return false;}

    /*
     * Getter for last StudentProgram
     *
     * inputs: void
     * outputs: StudentProgram (last program)
     * */
    public StudentProgram getProgram() {return program.get(program.size() - 1);}

    /*
     * Gets the total amount of credits for the
     * student's current program
     *
     * inputs: void
     * outputs: int
     * */
    public int getCredits(){
        StudentProgram prog = getProgram();
        return prog.calcCredits();
    }

    /*
     * Gets the total amount of hours for the
     * student's current program
     *
     * inputs: void
     * outputs: int
     * */
    public int getHours(){
        StudentProgram prog = getProgram();
        return prog.calcHours();
    }

    /*
     * Gets the total amount of validated credits
     * for the student's current program
     *
     * inputs: void
     * outputs: void
     * */
    public int getValidCredits(){
        StudentProgram prog = getProgram();
        return prog.calcValidCredits();
    }

    /*
     * Add a new People_side.StudentProgram object to the
     * program list, representing a new year for
     * the student
     *
     * inputs: People_side.StudentProgram
     * outputs: void
     * */
    public void newProgram(String year, String acyear){
        StudentProgram sprg = new StudentProgram(year, acyear, Integer.toString(matricule));
        program.add(sprg);
    }
}
