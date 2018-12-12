package UE_classes;

public class Ue {
    private String name;
    private String code;
    private int nhours;
    private int credits;
    private String info_sheet;

    /**
     * Constructor of the class Ue
     *
     * @param name String
     * @param code String
     */
    public Ue(String name, String code){
        this.name = name;
        this.code = code;
    }

    /**
     * Getter for class code
     *
     * @return String
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for class code
     *
     * @return String
     */
    public String getCode(){
        return code;
    }

    /**
     * Getter for class hours
     *
     * @return int
     */
    public int getHours(){
        return nhours;
    }

    /**
     * Setter for hours, int will probably be calculated
     * using the sum of UE_classes.ObservableClass's hours
     *
     * @param hours int
     */
    public void setHours(int hours){
        nhours = hours;
    }

    /**
     * Getter for class credits
     *
     * @return int
     */
    public int getCredits(){
        return credits;
    }

    /**
     * Setter for credits, int will probably be calculated
     * using the sum of UE_classes.ObservableClass's credits
     *
     * @param creds int
     */
    public void setCredits(int creds){
        credits = creds;
    }

    /**
     * Setter for infosheet, protected because Observer's
     * access to this should be limited
     *
     * @param path string
     *             path to infosheet
     */
    protected void setInfoSheet(String path){
        info_sheet = path;
    }

    /**
     * Getter for class infosheet
     * Should take as param : String (path to infosheet)
     *
     * @return info_sheet String
     */
    public String getInfoSheet(){
        return info_sheet;
    }

    /** TESTING
     * Used in unit tests to modify private params
     *
     */
    public void testSetParam(){
        nhours = 30;
        credits = 30;
        info_sheet = "base";
    }
}
