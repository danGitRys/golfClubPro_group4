package de.hse.golfclubmanagement.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

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
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    Date currentDate = new Date();

    @Test
    void testAddTournament() {

        Tournament tournament = new Tournament();
        tournament.setDate(currentDate);
        tournament.setName("Esslingen Open");
        tournament.setId(1L);

         when(tournamentService.addTournament(any(Tournament.class))).thenReturn(tournament);
        ResponseEntity<Tournament> response = tournamentController.addTournament(tournament);

        assertEquals(200, response.getStatusCodeValue(), "Response should have status 200 OK");
        assertEquals(tournament, response.getBody(), "The returned GolfCourse should match the saved one");


    }

    @Test
    void testFindByName() {

    }

    @Test
    void testGetAllTournaments() {

    }
}
