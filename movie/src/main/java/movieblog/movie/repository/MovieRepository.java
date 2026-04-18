package movieblog.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import movieblog.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}