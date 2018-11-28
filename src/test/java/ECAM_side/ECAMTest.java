package ECAM_side;

import People_side.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ECAMTest {

    ECAM ecam;
    @Before
    public void setUp() throws Exception {
        ecam = ECAM.getInstance();
        ecam.init();
    }

    @Test
    public void getInstance() {
        Assert.assertEquals("ECAM", ecam.getClass().getSimpleName());
    }

    @Test
    public void getOrientation() {
        Orientation orn = ecam.getOrientation("MIN");
        Assert.assertEquals("MIN", orn.getName());
    }

    @Test
    public void addTeacher() {
    }

    @Test
    public void student() {
        Student std = new Student("Matt", "Smith", 11);
        ecam.addStudent(std);
        Student matt = ecam.getStudent("11");
        assertEquals(std, matt);
    }

    @Test
    public void addOrientation() {
        Program bac_mas = new Program(new ArrayList<Bloc>());
        Orientation orn = new Orientation("GEO", bac_mas, bac_mas);
        ecam.addOrientation("GEO", orn);
    }

    @Test
    public void init() {
        Assert.assertEquals("DD4L", ecam.getOrientation("MIN").getMaster().
                getBloc(1).getContent("SA").getClasses().get(0).getName());
    }
}