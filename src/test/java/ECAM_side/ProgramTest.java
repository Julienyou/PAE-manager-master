package ECAM_side;

import UE_classes.ObservableUE;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ProgramTest {
    Program bac;
    Program mas;

    @Before
    public void setUp() throws Exception {
        ECAM.getInstance().init();
        bac = ECAM.getInstance().getOrientation("MIN").getBachelor();
        mas = ECAM.getInstance().getOrientation("MIN").getMaster();
    }

    @Test
    public void getBloc() {
        Assert.assertNotNull(bac.getBloc(1));
        Assert.assertNotNull(bac.getBloc(2));
        Assert.assertNotNull(bac.getBloc(3));
        Assert.assertNotNull(mas.getBloc(1));
        Assert.assertNotNull(mas.getBloc(2));
    }

    @Test
    public void addBloc() {
        mas.addBloc(new Bloc(new HashMap<String, ObservableUE>()));
        Assert.assertNotNull(mas.getBloc(3));
    }
}