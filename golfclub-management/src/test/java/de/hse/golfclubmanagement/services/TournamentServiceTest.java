package de.hse.golfclubmanagement.services;

import de.hse.golfclubmanagement.models.Tournament;
import de.hse.golfclubmanagement.repositories.TournamentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TournamentServiceTest {

    @Mock
    private TournamentRepository tournamentRepository;

    @InjectMocks
    private TournamentService tournamentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    //
    // Add tournament test scenarios
    //

    // 1. Valid tournament input
    @Test
    public void testAddValidTournament() {
        Tournament tournament = new Tournament();
        tournament.setName("Spring Open");
        Date date = new Date((new Date()).getTime() + 86400000); // date 1 day in the future
        tournament.setDate(date);

        // Equivalence class: valid tournament
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament);
        Tournament savedTournament = tournamentService.addTournament(tournament);
        assertEquals("Spring Open", savedTournament.getName(), "The saved tournament name should match");
        assertEquals(date, savedTournament.getDate(), "The saved tournament date should match");

        verify(tournamentRepository, times(1)).save(tournament);
    }

    // 2. Empty input
    @Test
    public void testAddEmptyTournament() {
        // Equivalence class: empty tournament
        assertThrows(IllegalArgumentException.class, () -> tournamentService.addTournament(null), "Should throw IllegalArgumentException for null tournament");

        verify(tournamentRepository, times(0)).save(null);
    }

    // 3. Wrong input type
    // Technically there is no need to test this because the compiler already recognizes wrong input types
    @Test
    public void testAddInvalidTournamentType() {
        String tournament = "Tournament";

        // Equivalence class: invalid input type
        assertThrows(IllegalArgumentException.class, () -> {
            Method method = TournamentService.class.getDeclaredMethod("addTournament", Tournament.class);
            method.invoke(tournamentService, tournament);
        }, "Should throw IllegalArgumentException for invalid tournament");
    }

    // 4. Invalid tournament input
    @Test
    public void testAddInvalidTournament() {
        Tournament tournament = new Tournament();
        tournament.setName("Spring Open");

        // Equivalence class: invalid tournament
        assertThrows(IllegalArgumentException.class, () -> tournamentService.addTournament(tournament), "Should throw IllegalArgumentException for invalid tournament");

        verify(tournamentRepository, times(0)).save(tournament);
    }

    // 5. Add same tournament twice
    @Test
    public void testAddTournamentTwice() {
        Tournament tournament = new Tournament();
        tournament.setName("Spring Open");
        Date date = new Date((new Date()).getTime() + 86400000); // date 1 day in the future
        tournament.setDate(date);

        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament);
        when(tournamentService.findByName(tournament.getName())).thenReturn(null).thenReturn(tournament);

        tournamentService.addTournament(tournament);
        assertThrows(IllegalStateException.class, () -> tournamentService.addTournament(tournament), "Should throw IllegalStateException for duplicate tournament");

        verify(tournamentRepository, times(1)).save(tournament);
        verify(tournamentRepository, times(2)).findByName(tournament.getName());
    }

    //
    // Get all tournaments test scenarios
    //

    // 1. List of tournaments exists
    @Test
    void testGetListOfAllTournaments() {
        List<Tournament> tournaments = new ArrayList<>();
        tournaments.add(new Tournament());
        tournaments.add(new Tournament());

        when(tournamentRepository.findAll()).thenReturn(tournaments);
        List<Tournament> result = tournamentService.getAllTournaments();
        assertEquals(2, result.size(), "Should return a list of 2 tournaments");
        verify(tournamentRepository, times(1)).findAll(); // Verify that findAll was called once
    }

    // 2. No tournaments exist, empty list
    @Test
    void testGetEmptyListOfTournaments() {
        List<Tournament> tournaments = new ArrayList<>();

        when(tournamentRepository.findAll()).thenReturn(tournaments);
        List<Tournament> result = tournamentService.getAllTournaments();
        assertEquals(0, result.size(), "Should return a list of no tournaments");
        verify(tournamentRepository, times(1)).findAll(); // Verify that findAll was called once
    }

    //
    // Find tournament by name test scenarios
    //

    // 1. Valid name input
    @Test
    void testFindByValidName() {
        Tournament tournament = new Tournament();
        tournament.setName("Spring Open");
        Date date = new Date((new Date()).getTime() + 86400000); // date 1 day in the future
        tournament.setDate(date);

        // Equivalence class: existing name (valid)
        when(tournamentRepository.findByName("Spring Open")).thenReturn(tournament);
        Tournament foundTournament = tournamentService.findByName("Spring Open");

        assertNotNull(foundTournament);
        assertEquals("Spring Open", foundTournament.getName());
        assertEquals(date, foundTournament.getDate());
        verify(tournamentRepository, times(1)).findByName("Spring Open");
    }

    // 2. Name doesn't exist as a tournament
    @Test
    void testFindByNameNotFound() {
        // Equivalence class: invalid name (doesn't exist)
        when(tournamentRepository.findByName("Nonexistent Tournament")).thenReturn(null);
        Tournament foundTournament = tournamentService.findByName("Nonexistent Tournament");

        assertNull(foundTournament);
        verify(tournamentRepository, times(1)).findByName("Nonexistent Tournament");
    }

    // 3. Empty string parameter
    @Test
    void testFindByEmptyName() {
        // Equivalence class: empty input
        assertThrows(IllegalArgumentException.class, () -> tournamentService.findByName(null), "Should throw IllegalArgumentException for empty name");

        verify(tournamentRepository, times(0)).findByName(null);
    }

    // 4. Wrong input type
    // Technically there is no need to test this because the compiler already recognizes wrong input types
    @Test
    public void testFindByInvalidNameType() {
        int name = 5;

        // Equivalence class: invalid input type
        assertThrows(IllegalArgumentException.class, () -> {
            Method method = TournamentService.class.getDeclaredMethod("findByName", String.class);
            method.invoke(tournamentService, name);
        }, "Should throw IllegalArgumentException for invalid name type");
    }
}
