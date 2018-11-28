package ECAM_side;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private List<Bloc> years;

    public Program(List<Bloc> years){
        this.years = new ArrayList<Bloc>(years);
    }

    /*
     * Get a specific ECAM_side.Bloc from a program
     *
     * inputs: int (year)
     * outputs: ECAM_side.Bloc
     * */
    public Bloc getBloc(int year){return years.get(year - 1);}

    public void addBloc(Bloc bloc){
        years.add(bloc);
    }
}
