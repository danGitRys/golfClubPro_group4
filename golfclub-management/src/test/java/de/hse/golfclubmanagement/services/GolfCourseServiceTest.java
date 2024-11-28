/** Copyright (c) 2024. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed for educational purposes only, but WITHOUT
 * ANY WARRANTY; See the GNU General Public License version 3 for more
 * details (a copy is included in the LICENSE file that
 * accompanied this code).
 */
package de.hse.golfclubmanagement.services;

import de.hse.golfclubmanagement.models.GolfCourse;
import de.hse.golfclubmanagement.repositories.GolfCourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * This class tests the GolfCourseService class.
 * @author Dennis Grewe
 * @since 0.1
 */
public class GolfCourseServiceTest {

    @Mock
    private GolfCourseRepository golfCourseRepository; // Mocked repository for GolfCourse

    @InjectMocks
    private GolfCourseService golfCourseService; // Service instance with mocked repository injected

    /**
     * Set up the test environment before each test method.
     * Initializes mocks and prepares the service for testing.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    /**
     * Test saving a valid GolfCourse.
     */
    @Test
    public void testSaveValidGolfCourse() {
        GolfCourse golfCourse = new GolfCourse();
        golfCourse.setName("Sunny Golf Course");
        golfCourse.setLocation("California");

        // Equivalence class: valid GolfCourse
        when(golfCourseRepository.save(any(GolfCourse.class))).thenReturn(golfCourse);
        GolfCourse savedCourse = golfCourseService.saveGolfCourse(golfCourse);
        assertEquals("Sunny Golf Course", savedCourse.getName(), "The saved course name should match");
        assertEquals("California", savedCourse.getLocation(), "The saved course location should match");
    }

    /**
     * Test saving a null GolfCourse.
     */
    @Test
    public void testSaveNullGolfCourse() {
        // Equivalence class: null GolfCourse
        when(golfCourseRepository.save(null)).thenThrow(new IllegalArgumentException("GolfCourse cannot be null"));
        assertThrows(IllegalArgumentException.class, () -> golfCourseService.saveGolfCourse(null), "Should throw IllegalArgumentException for null GolfCourse");
    }

    /**
     * Test retrieving all GolfCourse entities.
     */
    @Test
    public void testGetAllGolfCourses() {
        List<GolfCourse> courses = new ArrayList<>();
        courses.add(new GolfCourse());
        courses.add(new GolfCourse());

        // Equivalence class: retrieving all courses
        when(golfCourseRepository.findAll()).thenReturn(courses);
        List<GolfCourse> result = golfCourseService.getAllGolfCourses();
        assertEquals(2, result.size(), "Should return a list of 2 GolfCourses");
        verify(golfCourseRepository, times(1)).findAll(); // Verify that findAll was called once
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
        GolfCourse foundCourse = golfCourseService.findByName("Sunny Golf Course");
        assertEquals("Sunny Golf Course", foundCourse.getName(), "The found course name should match");
    }

    /**
     * Test finding a GolfCourse by a non-existent name.
     */
    @Test
    public void testFindByNameNotFound() {
        // Equivalence class: name not found
        when(golfCourseRepository.findByName("Non-existent Course")).thenReturn(null);
        GolfCourse notFoundCourse = golfCourseService.findByName("Non-existent Course");
        assertNull(notFoundCourse, "Should return null for a non-existent course");
    }
}
