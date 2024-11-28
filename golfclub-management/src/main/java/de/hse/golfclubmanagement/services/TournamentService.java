/**
 * Copyright (c) 2024. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <p>
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.
 * <p>
 * This code is distributed for educational purposes only, but WITHOUT
 * ANY WARRANTY; See the GNU General Public License version 3 for more
 * details (a copy is included in the LICENSE file that
 * accompanied this code).
 */
package de.hse.golfclubmanagement.services;

import de.hse.golfclubmanagement.models.Tournament;
import de.hse.golfclubmanagement.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Service class for managing Tournament entities.
 * Provides business logic for Tournament operations and communicates with the repository.
 * @author  Dennis Grewe
 * @since   0.1
 */
@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    /**
     * Adds a new Tournament entity to the database.
     *
     * @param tournament the Tournament entity to add
     * @return the saved Tournament entity
     */
    public Tournament addTournament(Tournament tournament) {

        if (tournament == null) {
            throw new IllegalArgumentException("The tournament cannot be null");
        }
        if (tournament.getName() == null || tournament.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("The tournament name should not be null or empty");
        }
        if (tournament.getDate() == null || tournament.getDate().before(new Date())) {
            throw new IllegalArgumentException("The tournament date should not be null or in the past.");
        }

        Tournament existingTournament = findByName(tournament.getName());
        if (existingTournament != null && existingTournament.getDate().equals(tournament.getDate())) {
            throw new IllegalStateException("A Tournament with the name " + tournament.getName() + " and date " + tournament.getDate() + " already exists");
        }
        return tournamentRepository.save(tournament);
    }

    /**
     * Retrieves all Tournament entities from the database.
     *
     * @return a list of all Tournament entities
     */
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    /**
     * Finds a Tournament by its name.
     *
     * @param name the name of the Tournament to find
     * @return the Tournament with the specified name, or null if not found
     */
    public Tournament findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The name cannot be null or empty");
        }
        return tournamentRepository.findByName(name);
    }
}
