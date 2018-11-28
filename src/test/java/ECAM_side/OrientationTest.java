package ECAM_side;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrientationTest {
    Orientation test;

    @Before
    public void setUp() throws Exception {
        ECAM.getInstance().init();
        test = ECAM.getInstance().getOrientation("MIN");
    }

    @Test
    public void getName() {
        Assert.assertEquals("MIN", test.getName());
    }

    @Test
    public void getProgram() {
        Program bac = test.getBachelor();
        Program mas = test.getMaster();
        Assert.assertNotSame(bac, mas);
    }
}