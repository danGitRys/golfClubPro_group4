package de.hse.golfclubmanagement.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import de.hse.golfclubmanagement.models.GolfCourse;
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

    
}
