package de.hse.golfclubmanagement.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import de.hse.golfclubmanagement.models.GolfCourse;


@ActiveProfiles("test")
@DataJpaTest
public class GolfCourseRepositoryTest {

    @Autowired
    private GolfCourseRepository golfCourseRepository;

    @BeforeEach
    public void setUp(){
        golfCourseRepository.deleteAll();
       
    }

    @Test
    void testFindByName() {
        GolfCourse course = new GolfCourse();
        course.setName("Test Course");
        course.setLocation("Test Location");
        golfCourseRepository.save(course);
        GolfCourse foundCourse = golfCourseRepository.findByName("Test Course");

        // Verify the course was found and has expected properties
         assertEquals(foundCourse,course);
        
    }
}
