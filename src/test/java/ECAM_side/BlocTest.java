package ECAM_side;

import UE_classes.ObservableUE;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class BlocTest {

    Bloc test_bloc;

    @Before
    public void setUp() throws Exception {
        ECAM.getInstance().init();
        test_bloc = ECAM.getInstance().getOrientation("MIN").getMaster().getBloc(1);
    }

    @Test
    public void getContent() {
        ObservableUE ue1 = test_bloc.getContent("SA");
        ObservableUE ue2 = test_bloc.getContent("SX");
        Assert.assertNotNull(ue1);
        Assert.assertNotNull(ue2);
        Assert.assertNotSame(ue1, ue2);
    }

    @Test
    public void addContent() {
        ObservableUE ue3 = new ObservableUE("Mathématiques", "SY");
        test_bloc.addContent(ue3);
        ObservableUE ue = test_bloc.getContent("SY");
        Assert.assertNotNull(ue);
    }
}