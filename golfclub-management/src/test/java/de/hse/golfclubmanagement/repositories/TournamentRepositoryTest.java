package de.hse.golfclubmanagement.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import de.hse.golfclubmanagement.models.GolfCourse;
import de.hse.golfclubmanagement.models.Tournament;

@DataJpaTest
@ActiveProfiles("test")
public class TournamentRepositoryTest {

    public Date currentDate = new Date();

    @Autowired
    TournamentRepository tournamentRepository;


 

    @Test
    void testFindByName() {
        Tournament tournament = new Tournament();
        tournament.setDate(currentDate);
        tournament.setName("Esslingen Open");
        tournament.setId(1L);

        tournamentRepository.save(tournament);
        Tournament foundTournament = tournamentRepository.findByName("Esslingen Open");
        assertNotNull(foundTournament);
        assertEquals("Esslingen Open", foundTournament.getName());
        assertEquals(currentDate, foundTournament.getDate());
        assertEquals(1L, foundTournament.getId());
    }

    
}
