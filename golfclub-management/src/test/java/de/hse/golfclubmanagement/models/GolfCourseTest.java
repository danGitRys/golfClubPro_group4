package de.hse.golfclubmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GolfCourseTest {

    @Test 
    void test_golfcourse(){
        List<Hole> holes = new ArrayList<Hole>();
        holes.add(new Hole());
        GolfCourse course = new GolfCourse();
        course.setId(1L);
        course.setName("HS Esslingen Course");
        course.setLocation("Esslingen");
        course.setHoles(holes);

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
