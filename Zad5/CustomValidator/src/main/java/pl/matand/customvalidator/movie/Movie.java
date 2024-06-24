package pl.matand.movieprojectswagger.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.matand.movieprojectswagger.movie.category.MovieCategory;


import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue()
    private UUID id;

    private String title;
    private int year;
    private String director;

    @Enumerated
    private MovieCategory category;
}
