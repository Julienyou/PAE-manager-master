package ue_classes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObserverClassTest {
    ObserverClass SA4T = new ObserverClass("SA4T", "1E0101", "13152");
    ObserverClass SA4L = new ObserverClass("SA4L", "1E0102", "13152");

    @Test
    public void getId() {
        int id1 = SA4T.getId();
        int id2 = SA4L.getId();
        Assert.assertNotSame(id1, id2);
    }

    @Test
    public void getOwner() {
        Assert.assertEquals("13152", SA4T.getOwner());
    }

    @Test
    public void validate() {
        Assert.assertFalse(SA4T.getValidate());
        SA4T.validate();
        Assert.assertTrue(SA4T.getValidate());
    }

    @Test
    public void update() {
        SA4T.update(3);
        Assert.assertEquals(3, SA4T.getNbrHours());
        SA4T.update(5);
        Assert.assertEquals(5, SA4T.getNbrHours());
    }
}