package ecam_side;

public class Orientation {
    private String name;
    private Program bachelor;
    private Program master;

    /**
     * Constructor of the class Orientation
     *
     * @param name String
     * @param bachelor Program
     * @param master Program
     */
    public Orientation(String name, Program bachelor, Program master){
        this.bachelor = bachelor;
        this.master = master;
        this.name = name;
    }

    /**
     * Get name of the orientation
     *
     * @return name String
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for bachelor
     *
     * @return ecam_side.Program
     */
    public Program getBachelor(){
        return bachelor;
    }

    /**
     * Getter for master
     *
     * @return ecam_side.Program
     */
    public Program getMaster(){
        return master;
    }
}
