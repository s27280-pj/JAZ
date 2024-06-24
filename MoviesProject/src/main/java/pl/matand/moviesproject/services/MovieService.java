package pl.matand.moviesproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.matand.moviesproject.mapper.MovieMapper;
import pl.matand.moviesproject.model.MovieRequest;
import pl.matand.moviesproject.model.MovieResponce;
import pl.matand.moviesproject.model.Movie;
import pl.matand.moviesproject.repository.MovieRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public MovieResponce createMovie(MovieRequest movieRequest) {
        Movie entity = movieMapper.toEntity(movieRequest);
        movieRepository.save(entity);
        return movieMapper.toResponce(entity);
    }

    public MovieResponce getMoviebyId(UUID id) {
        Movie movie = movieRepository.getOrThrowException(id);
        return movieMapper.toResponce(movie);
    }

    public List<MovieResponce> getAllMovies() {
        return movieRepository
                .findAll()
                .stream()
                .map(movieMapper::toResponce)
                .collect(Collectors.toList());
    }

    public MovieResponce updateMovie(UUID id, MovieRequest movieRequest) {
        Movie existingMovie = movieRepository.getOrThrowException(id);

        Movie updatedMovie = movieMapper.toEntity(movieRequest);
        updatedMovie.setId(existingMovie.getId());
        movieRepository.save(updatedMovie);

        return movieMapper.toResponce(updatedMovie);
    }

    public void deleteMovie(UUID id) {
        Movie movie = movieRepository.getOrThrowException(id);
        movieRepository.delete(movie);
    }
}
