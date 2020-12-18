package com.itmoprofessionals.dbcoursework.repo.film;

import com.itmoprofessionals.dbcoursework.domain.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilmRepo extends JpaRepository<Film, UUID> {
}
