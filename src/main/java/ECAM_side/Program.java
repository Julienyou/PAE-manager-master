package ECAM_side;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private List<Bloc> years;

    /**
     * Constructor of the class Program
     *
     * @param years List<Bloc>
     */
    public Program(List<Bloc> years){
        this.years = new ArrayList<Bloc>(years);
    }

    /**
     * Get a specific ECAM_side.Bloc from a program
     *
     * @param  year int
     * @return ECAM_side.Bloc
     */
    public Bloc getBloc(int year){
        return years.get(year - 1);
    }

    /**
     * Add a bloc to the list years
     *
     * @param bloc ECAM_side.Bloc
     */
    public void addBloc(Bloc bloc){
        years.add(bloc);
    }
}
