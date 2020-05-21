package task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.zip.InflaterOutputStream;

public class MoviesExplorer {

    private final List<Movie> movies;
    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public MoviesExplorer(InputStream dataInput) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(dataInput));
        ) {
            movies = reader.lines()
                    .map(Movie::createMovie)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns all the movies loaded from the dataset.
     **/
    public Collection<Movie> getMovies() {
        return Collections.unmodifiableCollection(movies);
    }

    public long countMoviesReleasedInYear(int year) {
        return movies.stream()
                .filter(movie -> movie.getYear() == year)
                .count();
    }

    public Movie findFirstMovieWithTitle(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().contains(title))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Collection<Actor> getAllActors() {
        return movies.stream()
                .flatMap(movie -> movie.getActors().stream())
                .collect(Collectors.toList());
    }

    public int getFirstYear() {
//        return movies.stream()
//                .map(Movie::getYear)
//                .min(Comparator.comparingInt(year -> year))
//                .get();
//        return movies.stream()
//                .min(Comparator.comparingInt(Movie::getYear))
//                .get()
//                .getYear();

        return movies.stream()
                .mapToInt(Movie::getYear)
                .min()
                .getAsInt();
    }

    public Collection<Movie> getAllMoviesByActor(Actor actor) {
        return movies.stream()
                .filter(movie -> movie.getActors().contains(actor))
                .collect(Collectors.toList());
    }

    public Collection<Movie> getMoviesSortedByReleaseYear() {
        return movies.stream()
                .sorted(Comparator.comparingInt(Movie::getYear))
                .collect(Collectors.toList());
    }

    public int findYearWithLeastNumberOfReleasedMovies() {
//        Map<Integer, Long> moviesCoundByYear = movies.stream()
//                .collect(Collectors.toMap(Movie::getYear, movie -> 1L, Long::sum));
//
//        return moviesCoundByYear.entrySet().stream()
//                .min(Comparator.comparingLong(Map.Entry::getValue))
//                .get()
//                .getKey();

        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getYear, Collectors.counting()))
                .entrySet().stream()
                .min(Comparator.comparingLong(Map.Entry::getValue))
                .get()
                .getKey();

    }

    public Movie findMovieWithGreatestNumberOfActors() {
        return movies.stream()
                .max(Comparator.comparingLong(movie -> movie.getActors().size()))
                .get();
    }
}
