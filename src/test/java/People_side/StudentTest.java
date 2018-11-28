package People_side;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private Student MS = new Student("Matt", "Smith", 11);

    @Test
    public void getID() {
        int matricule = MS.getID();
        Assert.assertEquals(11, matricule);
    }

    @Test
    public void getStatus() {
        Assert.assertEquals(MS.getStatus(""), false);
    }

    @Test
    public void getProgram() {
        MS.newProgram("4MA", "2018");
        Assert.assertEquals(MS.getProgram().getAcYear(), "2018");
        MS.newProgram("3BA", "2017");
        Assert.assertEquals(MS.getProgram().getAcYear(), "2017");
    }

    @Test
    public void getCredits() {
        MS.newProgram("4MA", "2018");
        MS.getProgram().testSetParam();
        Assert.assertEquals(MS.getCredits(),17);
    }

    @Test
    public void getHours() {
        MS.newProgram("4MA", "2018");
        MS.getProgram().testSetParam();
        Assert.assertEquals(MS.getHours(),187);
    }

    @Test
    public void getValidCredits() {
        MS.newProgram("4MA", "2018");
        MS.getProgram().testSetParam();
        Assert.assertEquals(MS.getValidCredits(),8);
    }

    @Test
    public void newProgram() {
    }
}