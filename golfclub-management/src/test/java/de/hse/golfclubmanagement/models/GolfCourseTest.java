package de.hse.golfclubmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GolfCourseTest {

    @Test 
    void test_golfcourse(){
        //Define a mock of holes and iject the mock object in the golfcourse instance
        //List<Hole> holes = new ArrayList<Hole>();
        //holes.add(new Hole());

        Hole mockHole = Mockito.mock(Hole.class);  // here we go for a stub mock
        Hole mockHole2 = Mockito.mock(Hole.class);

        List<Hole> holes = new ArrayList<>();
        holes.add(mockHole);
        holes.add(mockHole2);

        GolfCourse course = new GolfCourse();
        course.setId(1L);
        course.setName("HS Esslingen Course");
        course.setLocation("Esslingen");
        course.setHoles(holes);
        assertEquals(holes, course.getHoles());
        assertEquals(holes.size(), course.getHoles().size());

    }


    @Test 
    public void test_integration_GettersAndSetters(){
        GolfCourse golfCourse = new GolfCourse();
        golfCourse.setId(1L);
        assertEquals(golfCourse.getId(), 1L);
        golfCourse.setName("HS Esslingen Course");
        assertEquals(golfCourse.getName(), "HS Esslingen Course");
        golfCourse.setLocation("Esslingen");
        assertEquals(golfCourse.getLocation(), "Esslingen");
    }


    @Test
    void testGetHoles() {

    }

    @Test
    void testGetId() {

    }

    @Test
    void testGetLocation() {

    }

    @Test
    void testGetName() {

    }

    @Test
    void testSetHoles() {

    }

    @Test
    void testSetId() {

    }

    @Test
    void testSetLocation() {

    }

    @Test
    void testSetName() {

    }
}
