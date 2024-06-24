package pl.matand.moviesproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.matand.moviesproject.model.MovieRequest;
import pl.matand.moviesproject.model.MovieResponce;
import pl.matand.moviesproject.services.MovieService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public MovieResponce createMovie(@RequestBody MovieRequest movieRequest) {
        return movieService.createMovie(movieRequest);
    }

    @GetMapping("/{id}")
    public MovieResponce getMovieById(@PathVariable UUID id) {
        return movieService.getMoviebyId(id);
    }

    @GetMapping
    public List<MovieResponce> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PutMapping("/{id}")
    public MovieResponce updateMovie(@PathVariable UUID id, @RequestBody MovieRequest movieRequest) {
        return movieService.updateMovie(id, movieRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable UUID id) {
        movieService.deleteMovie(id);
    }
}
