package people_side;

public class Human {
    private String name;
    private String lastname;

    public Human(String name, String lastname){
        this.name = name;
        this.lastname = lastname;
    }

    /**
     * Getter for name + lastname
     *
     * @return String (full name)
     */
    public String getName(){
        return name + " " + lastname;
    }
}
