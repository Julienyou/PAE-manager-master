package UE_classes;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObservableUETest {
    ObservableUE DD4L = new ObservableUE("DD4L", "1E4014");

    ObserverUE ue1 = new ObserverUE("DD4L", "1E4014", "13152");
    ObserverUE ue2 = new ObserverUE("DD4L", "1E4014", "13152");
    ObserverUE ue3 = new ObserverUE("DD4L", "1E4014", "13152");

    @Test
    public void getObservers() {
        DD4L.duplicate(ue1);
        DD4L.duplicate(ue2);
        DD4L.duplicate(ue3);
        List<ObserverUE> obsr = Arrays.asList(ue1, ue2, ue3);
        Assert.assertEquals(obsr, DD4L.getObservers());
    }

    @Test
    public void getClasses() {
        DD4L.testSetParam2();
        Assert.assertEquals(2, DD4L.getClasses().size());
    }

    @Test
    public void calcHours() {
        List<ObservableClass> classes = DD4L.getClasses();
        Assert.assertEquals(0, DD4L.getHours());
        DD4L.testSetParam2();
        Assert.assertEquals(47, DD4L.getHours());
        DD4L.calcHours();
        Assert.assertEquals(20, DD4L.getHours());
    }

    @Test
    public void duplicate() {
        DD4L.testSetParam2();
        Assert.assertTrue(DD4L.getObservers().isEmpty());
        DD4L.duplicate(ue1);
        Assert.assertFalse(DD4L.getObservers().isEmpty());
        Assert.assertEquals(ue1.getId(), DD4L.getObservers().get(0).getId());
        Assert.assertEquals(47, ue1.getHours());
        Assert.assertNotSame(47, ue2.getHours());

        DD4L.setHours(8);
        DD4L.duplicate(ue1);
        Assert.assertEquals(1, DD4L.getObservers().size());
        Assert.assertEquals(8, ue1.getHours());
        Assert.assertNotSame(8, ue2.getHours());
        Assert.assertNotSame(8, ue3.getHours());
    }

    @Test
    public void notifyObserver() {
        DD4L.duplicate(ue1);
        DD4L.duplicate(ue2);
        DD4L.setCredits(9);
        Assert.assertNotSame(9, ue1.getCredits());
        Assert.assertNotSame(9, ue2.getCredits());
        DD4L.notifyObservers();
        Assert.assertEquals(9, ue1.getCredits());
        Assert.assertEquals(9, ue2.getCredits());
        Assert.assertNotSame(9, ue3.getCredits());
    }

    @Test
    public void addClass() {
        List<ObservableClass> class_list = new ArrayList<ObservableClass>();
        Assert.assertEquals(class_list, DD4L.getClasses());
        DD4L.testSetParam2();
        Assert.assertEquals(DD4L.getClasses().size(), 2);
        DD4L.addClass(new ObservableClass("SA4X", "1E0103"));
        Assert.assertEquals(DD4L.getClasses().size(), 3);
    }
}