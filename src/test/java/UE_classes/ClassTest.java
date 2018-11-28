package UE_classes;

import People_side.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ClassTest {
    Class SA4T = new Class("SA4T", "1E0101");

    @Test
    public void getName() {
        Assert.assertEquals("SA4T", SA4T.getName());
    }

    @Test
    public void getCode() {
        Assert.assertEquals("1E0101", SA4T.getCode());
    }

    @Test
    public void getNHours() {
        SA4T.testSetParam();
        Assert.assertEquals(10, SA4T.getNHours());
    }

    @Test
    public void setNHours() {
        SA4T.testSetParam();
        Assert.assertEquals(10, SA4T.getNHours());
        SA4T.setNHours(5);
        Assert.assertEquals(5, SA4T.getNHours());
    }

    @Test
    public void getTeachers() {
        int cbf_id =SA4T.testSetParam();
        Map<Integer, Teacher> teacher_list = SA4T.getTeachers();
        Teacher prof1 = teacher_list.get(cbf_id);
        Assert.assertEquals("Sebastien Combefis", prof1.getName());
        Assert.assertEquals(cbf_id, prof1.getID());
        Teacher prof2 = teacher_list.get(cbf_id + 1);
        Assert.assertEquals("Quentin Lurkin", prof2.getName());
        Assert.assertEquals(cbf_id + 1, prof2.getID());
    }
}