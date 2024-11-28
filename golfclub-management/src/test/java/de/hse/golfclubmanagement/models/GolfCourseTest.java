
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
package de.hse.golfclubmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

package de.hse.golfclubmanagement.models;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


/**
 * This class tests the GolfCourse class.
 * @author Dennis Grewe
 * @since 0.1
 */
public class GolfCourseTest {

    @Test
    public void testSetId() {
        GolfCourse golfCourse = new GolfCourse();

        // Boundary value: valid positive ID
        golfCourse.setId(1L);
        assertEquals(1L, golfCourse.getId(), "The ID should be set to 1L");

        // Boundary value: valid zero ID
        golfCourse.setId(0L);
        assertEquals(0L, golfCourse.getId(), "The ID should be set to 0L");

        // Boundary value: valid negative ID (if applicable)
        golfCourse.setId(-1L);
        assertEquals(-1L, golfCourse.getId(), "The ID should be set to -1L");
    }

    @Test
    public void testSetName() {
        GolfCourse golfCourse = new GolfCourse();

        // Equivalence class: valid name
        golfCourse.setName("Sunny Golf Course");
        assertEquals("Sunny Golf Course", golfCourse.getName(), "The name should be 'Sunny Golf Course'");

        // Equivalence class: empty name
        golfCourse.setName("");
        assertEquals("", golfCourse.getName(), "The name should be an empty string");

        // Equivalence class: null name
        golfCourse.setName(null);
        assertNull(golfCourse.getName(), "The name should be null");
    }

    @Test
    public void testSetLocation() {
        GolfCourse golfCourse = new GolfCourse();

        // Equivalence class: valid location
        golfCourse.setLocation("California");
        assertEquals("California", golfCourse.getLocation(), "The location should be 'California'");

        // Equivalence class: empty location
        golfCourse.setLocation("");
        assertEquals("", golfCourse.getLocation(), "The location should be an empty string");

        // Equivalence class: null location
        golfCourse.setLocation(null);
        assertNull(golfCourse.getLocation(), "The location should be null");
    }

    @Test
    public void testSetHoles() {
        GolfCourse golfCourse = new GolfCourse();

        // Equivalence class: valid holes list
        List<Hole> holes = new ArrayList<>();
        holes.add(new Hole());
        golfCourse.setHoles(holes);
        assertEquals(holes, golfCourse.getHoles(), "The holes list should match the set holes");

        // Equivalence class: empty holes list
        golfCourse.setHoles(new ArrayList<>());
        assertTrue(golfCourse.getHoles().isEmpty(), "The holes list should be empty");

        // Equivalence class: null holes list
        golfCourse.setHoles(null);
        assertNull(golfCourse.getHoles(), "The holes list should be null");
    }


    @Test
    public void test_mock_test_for_holes() {
        GolfCourse golfCourse = new GolfCourse();

        // Test ID
        golfCourse.setId(1L);
        assertEquals(1L, golfCourse.getId());

        // Test Name
        golfCourse.setName("Sunny Golf Course");
        assertEquals("Sunny Golf Course", golfCourse.getName());

        // Test Location
        golfCourse.setLocation("California");
        assertEquals("California", golfCourse.getLocation());

        // Define mock objects
        Hole mockHole = Mockito.mock(Hole.class);   // here: we go for a STUB (mock)
        Hole mockHole2 = Mockito.mock(Hole.class);
        // create mock representations
        List<Hole> holes = new ArrayList<>();
        holes.add(mockHole);
        holes.add(mockHole2);

        // inject mock representations to SUT -> golfcourse
        golfCourse.setHoles(holes);
        assertEquals(holes, golfCourse.getHoles());
        assertEquals(holes.size(), golfCourse.getHoles().size());
    }


}
