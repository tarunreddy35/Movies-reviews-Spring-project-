package com.tarun.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public Optional<Movie> getMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }

}
