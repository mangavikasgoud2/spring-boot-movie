package com.example.movie;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.*;

@RestController
public class MovieController{
    MovieService movieService = new MovieService();

    @GetMapping("/movies")
    public ArrayList<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }


    @GetMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable int movieId){
        return movieService.getMovie(movieId);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable int movieId, @RequestBody Movie movie){
        return movieService.updateMovie(movieId,movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable int movieId){
        movieService.deleteMovie(movieId);
    }


}

