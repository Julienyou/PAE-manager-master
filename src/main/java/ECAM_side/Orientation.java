package ecam_side;

public class Orientation {
    private String name;
    private Program bachelor;
    private Program master;


    public Orientation(String name, Program bachelor, Program master){
        this.bachelor = bachelor;
        this.master = master;
        this.name = name;
    }

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
