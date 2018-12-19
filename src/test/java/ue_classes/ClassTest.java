package ue_classes;

import people_side.Teacher;
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
    public void getNbrHours() {
        SA4T.testSetParam();
        Assert.assertEquals(10, SA4T.getNbrHours());
    }

    @Test
    public void setNbrHours() {
        SA4T.testSetParam();
        Assert.assertEquals(10, SA4T.getNbrHours());
        SA4T.setNbrHours(5);
        Assert.assertEquals(5, SA4T.getNbrHours());
    }

    @Test
    public void getTeachers() {
        int cbf_id =SA4T.testSetParam();
        Map<Integer, Teacher> teacher_list = SA4T.getTeachers();
        Teacher prof1 = teacher_list.get(cbf_id);
        Assert.assertEquals("Sebastien Combefis", prof1.getName());
        Assert.assertEquals(cbf_id, prof1.getId());
        Teacher prof2 = teacher_list.get(cbf_id + 1);
        Assert.assertEquals("Quentin Lurkin", prof2.getName());
        Assert.assertEquals(cbf_id + 1, prof2.getId());
    }
}