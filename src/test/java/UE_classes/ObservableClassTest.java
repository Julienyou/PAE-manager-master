package ue_classes;

import people_side.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ObservableClassTest {
    ObservableClass SA4T = new ObservableClass("SA4T", "1E0101");
    Teacher cbf = new Teacher("Sebastien", "Combefis");
    Teacher lrk = new Teacher("Quentin", "Lurkin");

    ObserverClass class1 = new ObserverClass("SA4T", "1E0101", "13152");
    ObserverClass class2 = new ObserverClass("SA4L", "1E0102", "13152");
    ObserverClass class3 = new ObserverClass("SA4X", "1E0103", "13152");


    @Test
    public void setNbrHours() {
        Assert.assertEquals(10, SA4T.getNbrHours());
        SA4T.setNbrHours(9);
        Assert.assertEquals(9, SA4T.getNbrHours());
    }

    @Test
    public void addTeacher() {
        Map<Integer, Teacher> teachers = SA4T.getTeachers();
        Assert.assertTrue(teachers.isEmpty());
        SA4T.addTeacher(cbf);
        Assert.assertFalse(teachers.isEmpty());
        SA4T.addTeacher(lrk);
        Assert.assertEquals(2, teachers.size());
        Assert.assertEquals(cbf, teachers.get(cbf.getId()));
        Assert.assertEquals(lrk, teachers.get(lrk.getId()));
    }

    @Test
    public void delTeacher() {
        Map<Integer, Teacher> teachers = SA4T.getTeachers();
        Assert.assertTrue(teachers.isEmpty());
        SA4T.addTeacher(cbf);
        SA4T.addTeacher(lrk);
        Assert.assertEquals(2, teachers.size());
        SA4T.delTeacher(cbf.getId());
        Assert.assertEquals(1, teachers.size());
        Assert.assertEquals(lrk, teachers.get(lrk.getId()));
    }

    @Test
    public void duplicate() {
        Assert.assertTrue(SA4T.getObservers().isEmpty());
        SA4T.duplicate(class1);
        Assert.assertFalse(SA4T.getObservers().isEmpty());
        Assert.assertEquals(class1.getId(), SA4T.getObservers().get(0).getId());
        Assert.assertEquals(10, class1.getNbrHours());
        Assert.assertNotSame(10, class2.getNbrHours());

        SA4T.setNbrHours(8);
        SA4T.notifyObservers();
        Assert.assertEquals(1, SA4T.getObservers().size());
        Assert.assertEquals(8, class1.getNbrHours());
        Assert.assertNotSame(8, class2.getNbrHours());
        Assert.assertNotSame(8, class3.getNbrHours());
    }

    @Test
    public void notifyObservers() {
        SA4T.duplicate(class1);
        SA4T.duplicate(class2);
        SA4T.setNbrHours(9);
        SA4T.notifyObservers();
        Assert.assertEquals(9, class1.getNbrHours());
        Assert.assertEquals(9, class2.getNbrHours());
        Assert.assertNotSame(9, class3.getNbrHours());
    }
}