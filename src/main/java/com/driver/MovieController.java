package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie") // 1.
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie Added Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director") // 2.
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<>("Director Added Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair") // 3.
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("directorName")String directorName, @RequestParam("movieName")String movieName) {
        movieService.addMovieDirectorPair(directorName, movieName);
        return new ResponseEntity<>("Director Movie pair Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}") // 4.
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String movieName) {
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}") // 5.
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String directorName) {
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}") // 6.
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName) {
        List<String> ans = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies") // 7.
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> ans = movieService.findAllMovies();
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name") // 8.
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String directorName) {
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("Deleted director", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors") // 9.
    public ResponseEntity<String> deleteAllDirectors() {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted", HttpStatus.CREATED);
    }
}
