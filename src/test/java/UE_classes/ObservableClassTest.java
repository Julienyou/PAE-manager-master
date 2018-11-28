package UE_classes;

import People_side.Teacher;
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
    public void setNHours() {
        Assert.assertEquals(10, SA4T.getNHours());
        SA4T.setNHours(9);
        Assert.assertEquals(9, SA4T.getNHours());
    }

    @Test
    public void addTeacher() {
        Map<Integer, Teacher> teachers = SA4T.getTeachers();
        Assert.assertTrue(teachers.isEmpty());
        SA4T.addTeacher(cbf);
        Assert.assertFalse(teachers.isEmpty());
        SA4T.addTeacher(lrk);
        Assert.assertEquals(2, teachers.size());
        Assert.assertEquals(cbf, teachers.get(cbf.getID()));
        Assert.assertEquals(lrk, teachers.get(lrk.getID()));
    }

    @Test
    public void delTeacher() {
        Map<Integer, Teacher> teachers = SA4T.getTeachers();
        Assert.assertTrue(teachers.isEmpty());
        SA4T.addTeacher(cbf);
        SA4T.addTeacher(lrk);
        Assert.assertEquals(2, teachers.size());
        SA4T.delTeacher(cbf.getID());
        Assert.assertEquals(1, teachers.size());
        Assert.assertEquals(lrk, teachers.get(lrk.getID()));
    }

    @Test
    public void duplicate() {
        Assert.assertTrue(SA4T.getObservers().isEmpty());
        SA4T.duplicate(class1);
        Assert.assertFalse(SA4T.getObservers().isEmpty());
        Assert.assertEquals(class1.getID(), SA4T.getObservers().get(0).getID());
        Assert.assertEquals(10, class1.getNHours());
        Assert.assertNotSame(10, class2.getNHours());

        SA4T.setNHours(8);
        SA4T.duplicate(class1);
        Assert.assertEquals(1, SA4T.getObservers().size());
        Assert.assertEquals(8, class1.getNHours());
        Assert.assertNotSame(8, class2.getNHours());
        Assert.assertNotSame(8, class3.getNHours());
    }

    @Test
    public void notifyObservers() {
        SA4T.duplicate(class1);
        SA4T.duplicate(class2);
        SA4T.setNHours(9);
        SA4T.notifyObservers();
        Assert.assertEquals(9, class1.getNHours());
        Assert.assertEquals(9, class2.getNHours());
        Assert.assertNotSame(9, class3.getNHours());
    }
}