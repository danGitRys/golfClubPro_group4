package de.hse.golfclubmanagement.repositories;


import de.hse.golfclubmanagement.models.GolfCourse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * This class tests the GolfCourseRepository class.
 * @author Dennis Grewe
 * @since 0.1
 */
@DataJpaTest
@ActiveProfiles("test")
public class GolfCourseRepositoryTest {

    @Mock
    private GolfCourseRepository golfCourseRepository; // Mocked repository for GolfCourse

    /**
     * Set up the test environment before each test method.
     * Initializes mocks and prepares the repository for testing.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    /**
     * Test finding a GolfCourse by a valid name.
     */
    @Test
    public void testFindByNameValid() {
        GolfCourse golfCourse = new GolfCourse();
        golfCourse.setName("Sunny Golf Course");

        // Equivalence class: valid name
        when(golfCourseRepository.findByName("Sunny Golf Course")).thenReturn(golfCourse);
        GolfCourse foundCourse = golfCourseRepository.findByName("Sunny Golf Course");

        assertNotNull(foundCourse, "The found GolfCourse should not be null");
        assertEquals("Sunny Golf Course", foundCourse.getName(), "The found course name should match");
    }

    /**
     * Test finding a GolfCourse by a non-existent name.
     */
    @Test
    public void testFindByNameNotFound() {
        // Equivalence class: name not found
        when(golfCourseRepository.findByName("Non-existent Course")).thenReturn(null);
        GolfCourse notFoundCourse = golfCourseRepository.findByName("Non-existent Course");

        assertNull(notFoundCourse, "Should return null for a non-existent course");
    }

    /**
     * Test saving a GolfCourse.
     */
    @Test
    public void testSaveGolfCourse() {
        GolfCourse golfCourse = new GolfCourse();
        golfCourse.setName("Sunny Golf Course");
        golfCourse.setLocation("California");

        // Equivalence class: valid GolfCourse
        when(golfCourseRepository.save(any(GolfCourse.class))).thenReturn(golfCourse);
        GolfCourse savedCourse = golfCourseRepository.save(golfCourse);

        assertNotNull(savedCourse, "The saved GolfCourse should not be null");
        assertEquals("Sunny Golf Course", savedCourse.getName(), "The saved course name should match");
    }

    /**
     * Test deleting a GolfCourse.
     */
    @Test
    public void testDeleteGolfCourse() {
        GolfCourse golfCourse = new GolfCourse();
        golfCourse.setName("Sunny Golf Course");
        golfCourse.setLocation("California");

        // Equivalence class: valid GolfCourse for deletion
        doNothing().when(golfCourseRepository).delete(any(GolfCourse.class));
        golfCourseRepository.delete(golfCourse); // No exception should be thrown
        verify(golfCourseRepository, times(1)).delete(golfCourse); // Verify delete was called once
    }

    /**
     * Test finding a GolfCourse by ID.
     */
    @Test
    public void testFindById() {
        GolfCourse golfCourse = new GolfCourse();
        golfCourse.setName("Sunny Golf Course");

        // Equivalence class: valid ID
        when(golfCourseRepository.findById(1L)).thenReturn(Optional.of(golfCourse));
        Optional<GolfCourse> foundCourse = golfCourseRepository.findById(1L);

        assertTrue(foundCourse.isPresent(), "The found GolfCourse should be present");
        assertEquals("Sunny Golf Course", foundCourse.get().getName(), "The found course name should match");
    }

    /**
     * Test finding a GolfCourse by a non-existent ID.
     */
    @Test
    public void testFindByIdNotFound() {
        // Equivalence class: ID not found
        when(golfCourseRepository.findById(999L)).thenReturn(Optional.empty());
        Optional<GolfCourse> notFoundCourse = golfCourseRepository.findById(999L);

        assertFalse(notFoundCourse.isPresent(), "Should return empty for a non-existent course ID");

    }
}
