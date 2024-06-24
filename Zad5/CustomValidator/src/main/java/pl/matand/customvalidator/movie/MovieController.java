package pl.matand.movieprojectswagger.movie;

import org.openapitools.api.MoviesApi;
import org.openapitools.model.MovieRequest;
import org.openapitools.model.MovieResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class MovieController implements MoviesApi {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public ResponseEntity<MovieResponce> addMovie(MovieRequest movieRequest){
        return ResponseEntity.ok(movieService.addMovie(movieRequest));
    }


    @Override
    public ResponseEntity<Void> deleteMovie(UUID id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @Override
    public ResponseEntity<MovieResponse> getMovieById(UUID id) {
        return ResponseEntity.ok(MovieService.getMovieById(id));
    }

    @Override
    public ResponseEntity<MovieResponse> updatePlayer(UUID id, MovieRequest movieRequest) {
        return ResponseEntity.ok(movieService.updateMovie(id, movieRequest));
    }
}
