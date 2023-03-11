/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.movie;

import com.example.movie.Movie;
import com.example.movie.MovieRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    // Write your code here

    Integer unqId= 6;

    public ArrayList<Movie> getAllMovies(){
        Collection<Movie> movieLi = movieList.values();
        ArrayList<Movie> arrLi = new ArrayList<>(movieLi);
        return arrLi;
    }

    
    public Movie getMovie(int movieId){
        Movie movie = movieList.get(movieId);
        if(movie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return movie;
    }

    public Movie addMovie(Movie movie){
       movie.setMovieId(unqId);
       movieList.put(unqId,movie);
       unqId+=1;
       return movie;

    }

    public Movie updateMovie(int movieId, Movie movie){
       Movie upMovie = movieList.get(movieId);
        if(upMovie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(movie.getMovieName() != null){
            upMovie.setMovieName(movie.getMovieName());
        }
        if(movie.getLeadActor() != null){
            upMovie.setLeadActor(movie.getLeadActor());
        }
        return upMovie;

    }

    public void deleteMovie(int movieId){
        Movie upMovie = movieList.get(movieId);
        if(upMovie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            movieList.remove(movieId);
            //getAllMovies();
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        
    }
    

    


    

}
