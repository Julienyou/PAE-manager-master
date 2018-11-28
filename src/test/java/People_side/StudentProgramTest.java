package People_side;

import ECAM_side.ECAM;
import UE_classes.ObserverUE;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StudentProgramTest {
    StudentProgram prog2018 = new StudentProgram("4MA","2018", "13152");

    @Test
    public void getAcYear() {
        Assert.assertEquals(prog2018.getAcYear(), "2018");
    }

    @Test
    public void getContents() {
        Map<String, ObserverUE> content = prog2018.getContents();
        Assert.assertTrue(content.isEmpty());
        prog2018.testSetParam();
        content = prog2018.getContents();
        Assert.assertEquals(content.get("SA").getName(), "DD4L");
        Assert.assertEquals(content.get("SX").getName(), "DD4X");
    }

    @Test
    public void addContent() {
        Map<String, ObserverUE> content = prog2018.getContents();
        Assert.assertTrue(content.isEmpty());
        ECAM.getInstance().init();
        prog2018.addContent("4MIN", "SA");
        Assert.assertFalse(content.isEmpty());
        Assert.assertEquals(prog2018.getUES().size(), 1);
        Assert.assertEquals(prog2018.getUES().get("SA").getName(), "DD");
    }

    @Test
    public void delContent() {
        ECAM.getInstance().init();
        prog2018.addContent("4MIN", "SA");
        prog2018.addContent("4MIN", "SX");
        Assert.assertEquals(prog2018.getContents().size(), 2);
        prog2018.delContent("SA");
        Assert.assertEquals(prog2018.getContents().size(), 1);
        Assert.assertEquals(prog2018.getContents().get("SX").getName(), "DX");
    }

    @Test
    public void calcCredits() {
        prog2018.testSetParam();
        Assert.assertEquals(prog2018.calcCredits(), 17);
    }

    @Test
    public void calcHours() {
        prog2018.testSetParam();
        Assert.assertEquals(prog2018.calcHours(), 187);
    }

    @Test
    public void calcValidCredits() {
        prog2018.testSetParam();
        Assert.assertEquals(prog2018.calcValidCredits(), 8);
    }

    @Test
    public void getSpecificUE() {
        prog2018.addContent("4MIN", "SA");
        prog2018.addContent("4MIN", "SX");
        Assert.assertEquals(prog2018.getSpecificUE("SX").getName(), "DX");
    }

    @Test
    public void getUES() {
        prog2018.addContent("4MIN", "SA");
        prog2018.addContent("4MIN", "SX");
        Assert.assertEquals(prog2018.getUES().size(), 2);
    }
}