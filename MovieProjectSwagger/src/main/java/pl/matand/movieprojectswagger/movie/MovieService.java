package pl.matand.movieprojectswagger.movie;

import org.openapitools.model.MovieRequest;
import org.openapitools.model.MovieResponse;
import org.springframework.stereotype.Service;
import pl.matand.movieprojectswagger.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final Mapper mapper;

    public PlayerService(MovieRepository movieRepository, Mapper mapper) {
        this.movieRepository = movieRepository;
        this.mapper = mapper;
    }

    public MovieResponse addMovie(MovieRequest movie) {
        Movie entity = mapper.toEntity(movie);
        movieRepository.save(entity);
        return mapper.toResponse(entity);
    }

    public List<MovieResponse> getAllMovies() {
        return movieRepository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public MovieResponse getMovieById(UUID id) {
        Movie movie = movieRepository.getReferenceById(id);
        return mapper.toResponse(movie);
    }

    public MovieResponse updateMovie(UUID id, MovieRequest movie) {
        Movie existingMovie = movieRepository.getReferenceById(id);

        Movie updatedMovie = mapper.toEntity(movie);
        updatedMovie.setId(existingMovie.getId());

        movieRepository.save(updatedMovie);
        return mapper.toResponse(updatedMovie);
    }

    public void deleteMovie(UUID id) {
        Movie movie = movieRepository.getReferenceById(id);
        movieRepository.delete(movie);
    }
}