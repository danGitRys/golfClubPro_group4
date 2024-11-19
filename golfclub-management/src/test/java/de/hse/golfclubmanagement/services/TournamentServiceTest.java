package de.hse.golfclubmanagement.services;

import de.hse.golfclubmanagement.models.Tournament;
import de.hse.golfclubmanagement.repositories.TournamentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TournamentServiceTest {

    @Mock
    private TournamentRepository tournamentRepository;

    @InjectMocks
    private TournamentService tournamentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testAddTournament() {
       
        Tournament tournament = new Tournament();
        tournament.setName("Spring Open");

        when(tournamentRepository.save(tournament)).thenReturn(tournament);

       
        Tournament result = tournamentService.addTournament(tournament);

        
        assertNotNull(result);
        assertEquals("Spring Open", result.getName());
        verify(tournamentRepository, times(1)).save(tournament);
    }

    @Test
    void testGetAllTournaments() {
        
        Tournament tournament1 = new Tournament();
        tournament1.setName("Spring Open");

        Tournament tournament2 = new Tournament();
        tournament2.setName("Autumn Open");

        List<Tournament> mockTournaments = Arrays.asList(tournament1, tournament2);
        when(tournamentRepository.findAll()).thenReturn(mockTournaments);

       
        List<Tournament> result = tournamentService.getAllTournaments();

       
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Spring Open", result.get(0).getName());
        verify(tournamentRepository, times(1)).findAll();
    }

    @Test
    void testFindByName() {
        
        Tournament tournament = new Tournament();
        tournament.setName("Spring Open");

        when(tournamentRepository.findByName("Spring Open")).thenReturn(tournament);

        
        Tournament result = tournamentService.findByName("Spring Open");

        
        assertNotNull(result);
        assertEquals("Spring Open", result.getName());
        verify(tournamentRepository, times(1)).findByName("Spring Open");
    }

    @Test
    void testFindByNameNotFound() {
        
        when(tournamentRepository.findByName("Nonexistent Tournament")).thenReturn(null);

        
        Tournament result = tournamentService.findByName("Nonexistent Tournament");

       
        assertNull(result);
        verify(tournamentRepository, times(1)).findByName("Nonexistent Tournament");
    }
}
