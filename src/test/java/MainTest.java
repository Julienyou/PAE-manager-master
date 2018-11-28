import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    Main main = new Main();

    @Test
    public void main() {
        String[] args = new String[1];
        args[0] = "testing";
        main.main(args);
        Assert.assertTrue(true);
    }
}