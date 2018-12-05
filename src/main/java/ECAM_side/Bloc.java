package ECAM_side;

import UE_classes.ObservableUe;
import UE_classes.ObserverUE;

import java.util.HashMap;
import java.util.Map;

public class Bloc {
    private Map<String, ObservableUe> content;

    public Bloc(HashMap<String, ObservableUe> content){
        this.content = content;
    }

    /**
     * Get a specific UE from the UE hashmap
     *
     * @param  code String
     * @return ObservableUe
     */
    public ObservableUe getContent(String code){
        return content.get(code);
    }

    /**
     * Get a specific UE from the UE hashmap
     *
     * @param ue ObservableUe
     */
    public void addContent(ObservableUe ue){
        String code = ue.getCode();
        content.put(code, ue);
    }
}
