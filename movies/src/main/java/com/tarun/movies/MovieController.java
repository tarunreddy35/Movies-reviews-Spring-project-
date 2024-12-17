package com.tarun.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    //    @GetMapping
//    public String api(){
//        return "hello";
//    }

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        // Log the movies for debugging
        System.out.println("Retrieved movies: " + movies);

        if (movies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(movies);
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return ResponseEntity.ok(movieService.getMovieByImdbId(imdbId));
    }

}