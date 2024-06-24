package pl.matand.moviesproject.mapper;
import org.mapstruct.*;
import pl.matand.moviesproject.model.Movie;
import pl.matand.moviesproject.model.MovieRequest;
import pl.matand.moviesproject.model.MovieResponce;

import  java.util.List;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface MovieMapper {
    @Mapping(target = "id", ignore = true)
    Movie toEntity(MovieRequest request);
    MovieResponce toResponce(Movie movie);
}
