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
package de.hse.golfclubmanagement.controllers;

import de.hse.golfclubmanagement.models.GolfCourse;
import de.hse.golfclubmanagement.services.GolfCourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * This class tests the GolfCourseController class.
 * @author Dennis Grewe
 * @since 0.1
 */
public class GolfCourseControllerTest {

    @Mock
    private GolfCourseService golfCourseService; // Mocked service for GolfCourse

    @InjectMocks
    private GolfCourseController golfCourseController; // Controller instance with mocked service injected

    /**
     * Set up the test environment before each test method.
     * Initializes mocks and prepares the controller for testing.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    /**
     * Test adding a valid GolfCourse.
     */
    @Test
    public void testAddValidGolfCourse() {
        GolfCourse golfCourse = new GolfCourse();
        golfCourse.setName("Sunny Golf Course");
        golfCourse.setLocation("California");

        // Equivalence class: valid GolfCourse
        when(golfCourseService.saveGolfCourse(any(GolfCourse.class))).thenReturn(golfCourse);
        ResponseEntity<GolfCourse> response = golfCourseController.addGolfCourse(golfCourse);

        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertEquals(golfCourse, response.getBody(), "The returned GolfCourse should match the saved one");
    }

    /**
     * Test adding a null GolfCourse.
     */
    @Test
    public void testAddNullGolfCourse() {
        // Equivalence class: null GolfCourse
        assertThrows(IllegalArgumentException.class, () -> golfCourseController.addGolfCourse(null), "Should throw IllegalArgumentException for null GolfCourse");
    }

    /**
     * Test retrieving all GolfCourse entities.
     */
    @SuppressWarnings("null")
    @Test
    public void testGetAllGolfCourses() {
        List<GolfCourse> courses = new ArrayList<>();
        courses.add(new GolfCourse());
        courses.add(new GolfCourse());

        // Equivalence class: retrieving all courses
        when(golfCourseService.getAllGolfCourses()).thenReturn(courses);
        ResponseEntity<List<GolfCourse>> response = golfCourseController.getAllGolfCourses();

        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertNotNull(response.getBody(), "Response body should not be null");
        assertEquals(2, response.getBody().size(), "Should return a list of 2 GolfCourses");
    }

    /**
     * Test finding a GolfCourse by a valid name.
     */
    @Test
    public void testFindByNameValid() {
        GolfCourse golfCourse = new GolfCourse();
        golfCourse.setName("Sunny Golf Course");

        // Equivalence class: valid name
        when(golfCourseService.findByName("Sunny Golf Course")).thenReturn(golfCourse);
        ResponseEntity<GolfCourse> response = golfCourseController.findByName("Sunny Golf Course");

        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertEquals(golfCourse, response.getBody(), "The found GolfCourse should match the requested name");
    }

    /**
     * Test finding a GolfCourse by a non-existent name.
     */
    @Test
    public void testFindByNameNotFound() {
        // Equivalence class: name not found
        when(golfCourseService.findByName("Non-existent Course")).thenReturn(null);
        ResponseEntity<GolfCourse> response = golfCourseController.findByName("Non-existent Course");

        assertEquals(404, response.getStatusCodeValue(), "Response should have status 404 Not Found");
        assertNull(response.getBody(), "The response body should be null for a non-existent course");
    }
}
