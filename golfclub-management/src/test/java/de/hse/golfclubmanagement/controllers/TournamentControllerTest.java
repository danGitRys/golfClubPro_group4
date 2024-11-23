package de.hse.golfclubmanagement.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;  // Importing List from java.util

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import de.hse.golfclubmanagement.models.GolfCourse;
import de.hse.golfclubmanagement.models.Tournament;
import de.hse.golfclubmanagement.services.TournamentService;

public class TournamentControllerTest {

    @Mock
    private TournamentService tournamentService;

    @InjectMocks
    private TournamentController tournamentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize the mocks
    }

    Date currentDate = new Date();

    // Test for POST /api/v1/tournaments
    @Test
    void testAddTournament() {
        Tournament tournament = new Tournament();
        tournament.setDate(currentDate);
        tournament.setName("Esslingen Open");
        tournament.setId(1L);

        when(tournamentService.addTournament(any(Tournament.class))).thenReturn(tournament);
        ResponseEntity<Tournament> response = tournamentController.addTournament(tournament);

        // Check if the status code 201 (Created) is returned
        assertEquals(201, response.getStatusCodeValue(), "Response should have status 201 Created");
        assertEquals(tournament, response.getBody(), "The returned Tournament should match the saved one");

        // Verify if the method in the service was called correctly
        verify(tournamentService, times(1)).addTournament(any(Tournament.class));
    }

    // Test for GET /api/v1/tournaments
    @Test
    void testGetAllTournaments() {
        // Test data
        List<Tournament> tournaments = new ArrayList<>();
        Tournament tournament1 = new Tournament();
        tournament1.setName("Esslingen Open");
        tournament1.setDate(currentDate);
        Tournament tournament2 = new Tournament();
        tournament2.setName("Summer Classic");
        tournament2.setDate(currentDate);
        tournaments.add(tournament1);
        tournaments.add(tournament2);

        when(tournamentService.getAllTournaments()).thenReturn(tournaments);

        ResponseEntity<List<Tournament>> response = tournamentController.getAllTournaments();

        // Check the status code and the number of tournaments returned
        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertEquals(2, response.getBody().size(), "There should be 2 tournaments returned");

        // Verify if the method in the service was called correctly
        verify(tournamentService, times(1)).getAllTournaments();
    }

    // Test for GET /api/v1/tournaments/findByName with a valid name
    @Test
    void testFindTournamentByName() {
        Tournament tournament = new Tournament();
        tournament.setName("Esslingen Open");
        tournament.setDate(currentDate);

        when(tournamentService.findByName("Esslingen Open")).thenReturn(tournament);

        ResponseEntity<Tournament> response = tournamentController.findByName("Esslingen Open");

        // Check the status code and the returned tournament
        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertEquals(tournament, response.getBody(), "The returned Tournament should match the searched one");

        verify(tournamentService, times(1)).findByName("Esslingen Open");
    }

    // Test for GET /api/v1/tournaments/findByName with an invalid name
    @Test
    void testFindTournamentByNameNotFound() {
        when(tournamentService.findByName("Nonexistent Tournament")).thenReturn(null);

        ResponseEntity<Tournament> response = tournamentController.findByName("Nonexistent Tournament");

        // Check if the status code 404 (Not Found) is returned
        assertEquals(404, response.getStatusCodeValue(), "Response should have status 404 Not Found");

        verify(tournamentService, times(1)).findByName("Nonexistent Tournament");
    }
}