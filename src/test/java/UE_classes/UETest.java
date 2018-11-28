package UE_classes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UETest {
    private UE DD4L = new UE("DD4L", "1E4014");

    @Test
    public void getName() {
        String name = DD4L.getName();
        Assert.assertEquals("DD4L", name);
    }

    @Test
    public void getCode() {
        String code = DD4L.getCode();
        Assert.assertEquals("1E4014", code);
    }

    @Test
    public void getHours() {
        DD4L.testSetParam();
        int hours = DD4L.getHours();
        Assert.assertEquals(30, hours);
    }

    @Test
    public void setHours() {
        DD4L.setHours(42);
        Assert.assertEquals(42, DD4L.getHours());
    }

    @Test
    public void getCredits() {
        DD4L.testSetParam();
        int creds = DD4L.getCredits();
        Assert.assertEquals(30, creds);
    }

    @Test
    public void setCredits() {
        DD4L.setCredits(42);
        Assert.assertEquals(42, DD4L.getCredits());
    }

    @Test
    public void setInfoSheet() {
        DD4L.setInfoSheet("dev/urandom");
        String infS = DD4L.getInfoSheet();
        Assert.assertEquals("dev/urandom", infS);
    }

    @Test
    public void getInfoSheet() {
        DD4L.testSetParam();
        String infS = DD4L.getInfoSheet();
        Assert.assertEquals("base", infS);
    }
}