
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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the Hole class.
 * @author Dennis Grewe
 * @since 0.1
 */
public class HoleTest {

    @Test
    public void testSetId() {
        Hole hole = new Hole();

        // Boundary value: valid positive ID
        hole.setId(1L);
        assertEquals(1L, hole.getId(), "The ID should be set to 1L");

        // Boundary value: valid zero ID
        hole.setId(0L);
        assertEquals(0L, hole.getId(), "The ID should be set to 0L");

        // Boundary value: valid negative ID (if applicable)
        hole.setId(-1L);
        assertEquals(-1L, hole.getId(), "The ID should be set to -1L");
    }

    @Test
    public void testSetNumber() {
        Hole hole = new Hole();

        // Equivalence class: valid hole number
        hole.setNummer(1);
        assertEquals(1, hole.getNumber(), "The hole number should be set to 1");

        // Boundary value: minimum hole number
        hole.setNummer(0);
        assertEquals(0, hole.getNumber(), "The hole number should be set to 0");

        // Boundary value: negative hole number (if applicable)
        hole.setNummer(-1);
        assertEquals(-1, hole.getNumber(), "The hole number should be set to -1");
    }

    @Test
    public void testSetLength() {
        Hole hole = new Hole();

        // Equivalence class: valid length
        hole.setLength(150);
        assertEquals(150, hole.getLength(), "The length should be set to 150");

        // Boundary value: minimum length
        hole.setLength(0);
        assertEquals(0, hole.getLength(), "The length should be set to 0");

        // Boundary value: negative length (should be handled)
        hole.setLength(-50);
        assertEquals(-50, hole.getLength(), "The length should be set to -50"); // Assuming negative lengths are allowed
    }

    @Test
    public void testSetPar() {
        Hole hole = new Hole();

        // Equivalence class: valid par value
        hole.setPar(3);
        assertEquals(3, hole.getPar(), "The par value should be set to 3");

        // Boundary value: minimum par value
        hole.setPar(1);
        assertEquals(1, hole.getPar(), "The par value should be set to 1");

        // Boundary value: negative par value (should be handled)
        hole.setPar(-1);
        assertEquals(-1, hole.getPar(), "The par value should be set to -1"); // Assuming negative par values are allowed
    }

    @Test
    public void testSetGolfCourse() {
        Hole hole = new Hole();
        GolfCourse golfCourse = new GolfCourse();

        // Equivalence class: valid golf course
        hole.setGolfCourse(golfCourse);
        assertEquals(golfCourse, hole.getGolfcourse(), "The golf course should match the set golf course");

        // Equivalence class: null golf course
        hole.setGolfCourse(null);
        assertNull(hole.getGolfcourse(), "The golf course should be null");

    }
}
