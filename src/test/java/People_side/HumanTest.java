package People_side;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {

    @Test
    public void getName() {
        Human Matt_Smith = new Human("Matt", "Smith");
        String name = Matt_Smith.getName();

        Assert.assertEquals("Matt Smith", name);
    }
}