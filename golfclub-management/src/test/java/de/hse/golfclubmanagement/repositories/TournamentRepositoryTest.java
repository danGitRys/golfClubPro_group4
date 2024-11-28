package de.hse.golfclubmanagement.repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import de.hse.golfclubmanagement.models.Tournament;

@DataJpaTest
@ActiveProfiles("test")
public class TournamentRepositoryTest {

    public Date currentDate = new Date();

    @Mock
    TournamentRepository tournamentRepository;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testFindByName() {
        Tournament tournament = new Tournament();
        tournament.setDate(currentDate);
        tournament.setName("Esslingen Open");
        tournament.setId(1L);

        when(tournamentRepository.findByName("Esslingen Open")).thenReturn(tournament);
        Tournament foundTournament = tournamentRepository.findByName("Esslingen Open");
        assertNotNull(foundTournament);
        assertEquals("Esslingen Open", foundTournament.getName());
    }

    @Test
    public void testFindByNameNotFound() {
        // Equivalence class: name not found
        when(tournamentRepository.findByName("Non-existent Course")).thenReturn(null);
        Tournament notFoundTournament = tournamentRepository.findByName("Non-existent Course");
        assertNull(notFoundTournament, "Should return null for a non-existent course");
    }

    @Test
    public void testSaveTournament() {
        Tournament tournament = new Tournament();
        tournament.setName("Summer Tournament");
        tournament.setDate(currentDate);
        tournament.setId(2L);

        // Equivalence class: valid GolfCourse
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(tournament);
        Tournament savedTournament = tournamentRepository.save(tournament);


        assertNotNull(savedTournament, "The saved tournament should not be null");
        assertEquals("Summer Tournament", savedTournament.getName(), "The saved tournament name should match");
    }

    @Test
    public void testDeleteTournament() {
        Tournament tournament = new Tournament();
        tournament.setName("Winter Tournament");
        tournament.setDate(currentDate);
        tournament.setId(3L);

        doNothing().when(tournamentRepository).delete(any(Tournament.class));
        tournamentRepository.delete(tournament); // No exception should be thrown
        verify(tournamentRepository, times(1)).delete(tournament); // Verify delete was called once
    }

    @Test
    public void testFindById() {
        Tournament tournament = new Tournament();
        tournament.setName("Winter Tournament");
        tournament.setDate(currentDate);
        tournament.setId(3L);

        // Equivalence class: valid ID
        when(tournamentRepository.findById(3L)).thenReturn(Optional.of(tournament));
        Optional<Tournament> foundTournament = tournamentRepository.findById(3L);

        assertTrue(foundTournament.isPresent(), "The found tournament should be present");
        assertEquals("Winter Tournament", foundTournament.get().getName(), "The found tournament name should match");
    }

    /**
     * Test finding a tournament by a non-existent ID.
     */
    @Test
    public void testFindByIdNotFound() {
        // Equivalence class: ID not found
        when(tournamentRepository.findById(999L)).thenReturn(Optional.empty());
        Optional<Tournament> notFoundCourse = tournamentRepository.findById(999L);

        assertFalse(notFoundCourse.isPresent(), "Should return empty for a non-existent course ID");
    }
}
