package com.driver;

import com.driver.Director;
import com.driver.Movie;
import com.driver.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie) { // 1.
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) { // 2.
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String directorName, String movieName) {
        movieRepository.addMovieDirectorPair(directorName, movieName);
    }

    public Movie getMovieByName(String movieName) {
        return movieRepository.getMovieByName(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return movieRepository.getDirectorByName(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    public List<String> findAllMovies() {
        List<Movie> movieList = movieRepository.listOfMovies();
        List<String> movieNameList = new ArrayList<>();

        for (Movie m: movieList) {
            movieNameList.add(m.getName());
        }
        return movieNameList;
    }

    public void deleteDirectorByName(String directorName) {
        List<String> list = movieRepository.deleteDirector(directorName);
        for (String name: list) {
            movieRepository.deleteMovie(name);
        }
    }

    public void deleteAllDirectors() {
        List<Director> directorList = movieRepository.listOfDirectors();
        for (Director d: directorList) {
            String name = d.getName();
            deleteDirectorByName(name);
        }
    }
}
