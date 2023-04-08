package com.driver;

import com.driver.Director;
import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    Map<String, Movie> movieDb = new HashMap<>();
    Map<String, Director> directorDb = new HashMap<>();
    Map<String, List<String>> directorMovieDb = new HashMap<>();

    public void addMovie(Movie movie) {
        String key = movie.getName();
        movieDb.put(key, movie);
    }

    public void addDirector(Director director) {
        String key = director.getName();
        directorDb.put(key, director);
    }

    public void addMovieDirectorPair(String directorName, String movieName) {
        if (!directorMovieDb.containsKey(directorName)) directorMovieDb.put(directorName, new ArrayList<>());
        directorMovieDb.get(directorName).add(movieName);
    }

    public Movie getMovieByName(String movieName) {
        return movieDb.get(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return directorDb.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        List<String> list = new ArrayList<>();
        if (directorMovieDb.containsKey(directorName)) {
            list = directorMovieDb.get(directorName);
        }
        return list;
    }

    public List<Movie> listOfMovies(){
        List<Movie> list = new ArrayList<>();
        list.addAll(movieDb.values());
        return list;
    }

    public List<Director> listOfDirectors() {
        List<Director> list = new ArrayList<>();
        for (Director d: directorDb.values()) {
            list.add(d);
        }
        return list;
    }

    public List<String> deleteDirector(String directorName) {
        directorDb.remove(directorName);
        List<String> list = directorMovieDb.get(directorName);
        directorMovieDb.remove(directorName);
        return list;
    }

    public void deleteMovie(String movieName) {
        movieDb.remove(movieName);
    }
}
