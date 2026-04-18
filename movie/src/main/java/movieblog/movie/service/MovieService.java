package movieblog.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieblog.movie.model.Movie;
import movieblog.movie.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repo;

    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    public void saveMovie(Movie movie) {
        repo.save(movie);
    }
    public void deleteMovie(Long id) {
        repo.deleteById(id);
    }

    public Movie getMovieById(Long id) {
        return repo.findById(id).orElse(null);
    }
}