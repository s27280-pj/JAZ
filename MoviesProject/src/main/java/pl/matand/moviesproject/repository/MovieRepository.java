package pl.matand.moviesproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityNotFoundException;
import pl.matand.moviesproject.model.Movie;


import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    default Movie getOrThrowException(UUID id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException("Movie not found"));
    }
}
