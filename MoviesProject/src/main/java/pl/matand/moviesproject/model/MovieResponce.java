package pl.matand.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.matand.moviesproject.enums.MovieCategory;

@Data
@NoArgsConstructor
public class MovieResponce {
    private String title;
    private int year;
    private MovieCategory category;
}
