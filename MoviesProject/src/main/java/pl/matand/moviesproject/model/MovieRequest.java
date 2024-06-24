package pl.matand.moviesproject.model;

import lombok.Data;
import pl.matand.moviesproject.enums.MovieCategory;

@Data
public class MovieRequest {
    private String title;
    private int year;
    private String director;
    private MovieCategory category;
}
