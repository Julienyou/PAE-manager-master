package people_side;

import ecam_side.Ecam;
import ue_classes.ObservableUe;
import ue_classes.ObserverUe;

import java.util.*;

public class StudentProgram {
    private final String year;
    private final String academic_year;
    private final String owner;
    private int ncredits;
    private Map<String, ObserverUe> content;

    public StudentProgram(String year, String acyear, String owner) {
        this.year = year;
        this.academic_year = acyear;
        this.owner = owner;
        this.ncredits = 0;
        this.content = new HashMap<String, ObserverUe>();
    }

    /**
     * Getter for academic year
     *
     * @return String
     */
    public String getAcYear(){
        return academic_year;
    }

    /**
     * Getter for content List
     *
     * @return Map<String, ObserverUe>
     */
    public Map<String, ObserverUe> getContents(){
        return content;
    }

    /**
     * Add content to content list thanks to
     * year and code. f.e.: 4MIN, SA4L
     * -> uses year and code to fetch an ObservableUe
     * from ECAM to add a new ObserverUe to content
     *
     * @param year String
     * @param code String
     */
    public void addContent(String year, String code){
        Ecam ecam = Ecam.getInstance();
        int int_year = Integer.parseInt(year.substring(0, 1));
        String orientation =  year.substring(1);

        ObservableUe ue = new ObservableUe("", "");
        if (int_year <= 3) {
            ue = ecam.getOrientation(orientation).getBachelor().getBloc(int_year).getContent(code);
        } else {
            int_year = int_year - 3;
            ue = ecam.getOrientation(orientation).getMaster().getBloc(int_year).getContent(code);
        }
        ObserverUe obs_ue = new ObserverUe(ue.getName(), code, owner);
        ue.duplicate(obs_ue);

        content.put(obs_ue.getCode(), obs_ue);
    }

    /**
     * Deletes content from the list after
     * being given a code
     *
     * @param code String
     */
    public void delContent(String code){
        for (String key: content.keySet()){
            if (key.equals(code)){
                content.remove(key);
            }
        }
    }

    /**
     * Calculates the total amount of credits
     * for a year by going through all the
     * program content and summing credits
     *
     * @return int
     */
    public int calcCredits(){
        int creds = 0;
        Iterator it = content.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            ObserverUe obs_ue = (ObserverUe)pair.getValue();
            creds += obs_ue.getCredits();
        }
        return creds;
    }

    /**
     * Calculates the total amount of hours
     * for a year by going through all the
     * program content and summing hours
     *
     * @return int
     */
    public int calcHours(){
        int hours = 0;
        for(ObserverUe obs_ue: content.values()){
            hours += obs_ue.getHours();
        }
        return hours;
    }

    /**
     * Calculates the total amount of valid
     * credits for a year
     *
     * @return int
     */
    public int calcValidCredits(){
        int v_creds = 0;
        for(ObserverUe obs_ue: content.values()){
            if (obs_ue.getValidated()){
                v_creds += obs_ue.getCredits();
            }
        }
        return v_creds;
    }

    /**
     * Get a specific UEs of the program
     *
     * @param  code String
     * @return ObserverUe
     */
    public ObserverUe getSpecificUe(String code) {
        Iterator it = content.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if (pair.getKey().equals(code)){
                return (ObserverUe)pair.getValue();
            }
        }
        return null;
    }

    /**
     * Get a list of all UEs of the program
     *
     * @return Map<String, ObserverUe>
     */
    public Map<String, ObserverUe> getUes() {
        return content;
    }

    /** TESTING
     * Inserts UEs into content for testing
     *
     */
    public void testSetParam(){
        ObserverUe ue1 = new ObserverUe("DD4L", "SA", "13152");
        ue1.setCredits(9);
        ue1.setHours(99);
        ObserverUe ue2 = new ObserverUe("DD4X", "SX", "13152");
        ue2.setCredits(8);
        ue2.setHours(88);
        ue2.validate();
        content.put("SA", ue1);
        content.put("SX", ue2);
    }
}
