package ECAM_side;

import UE_classes.ObservableUE;
import UE_classes.ObserverUE;

import java.util.HashMap;
import java.util.Map;

public class Bloc {
    private Map<String, ObservableUE> content;

    public Bloc(HashMap<String, ObservableUE> content){
        this.content = content;
    }

    /**
     * Get a specific UE from the UE hashmap
     *
     * @param   String (UE code)
     * @return  ObservableUE
     */
    public ObservableUE getContent(String code){
        return content.get(code);
    }

    /**
     * Get a specific UE from the UE hashmap
     *
     * @param  ObservableUE
     */
    public void addContent(ObservableUE ue){
        String code = ue.getCode();
        content.put(code, ue);
    }
}
