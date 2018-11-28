package UE_classes;

public class UE {
    private String name;
    private String code;
    private int nhours;
    private int credits;
    private String info_sheet;

    public UE(String name, String code){
        this.name = name;
        this.code = code;
    }

    /*
     * Getter for class code
     *
     * inputs: void
     * outputs: String
     * */
    public String getName(){return name;}

    /*
    * Getter for class code
    *
    * inputs: void
    * outputs: String
    * */
    public String getCode(){return code;}

    /*
     * Getter for class hours
     *
     * inputs: void
     * outputs: int
     * */
    public int getHours(){return nhours;}

    /*
     * Setter for hours, int will probably be calculated
     * using the sum of UE_classes.ObservableClass's hours
     *
     * inputs: int
     * outputs: void
     * */
    public void setHours(int hours){nhours = hours;}

    /*
     * Getter for class credits
     *
     * inputs: void
     * outputs: int
     * */
    public int getCredits(){return credits;}

    /*
     * Setter for credits, int will probably be calculated
     * using the sum of UE_classes.ObservableClass's credits
     *
     * inputs: int
     * outputs: void
     * */
    public void setCredits(int creds){credits = creds;}

    /*
    * Setter for infosheet, protected because Observer's
    * access to this should be limited
    *
    * inputs: string (path to infosheet)
    * outputs: void
    * */
    protected void setInfoSheet(String path){info_sheet = path;}

    /*
     * Getter for class infosheet
     *
     * inputs: void
     * outputs: String (path to infosheet)
     * */
    public String getInfoSheet(){ return info_sheet; }

    /* TESTING
     * Used in unit tests to modify private params
     *
     * inputs: void
     * outputs: void
     * */

    public void testSetParam(){
        nhours = 30;
        credits = 30;
        info_sheet = "base";
    }
}
