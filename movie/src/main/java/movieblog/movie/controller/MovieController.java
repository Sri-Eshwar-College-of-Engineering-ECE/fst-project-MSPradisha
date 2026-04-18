package movieblog.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import movieblog.movie.model.Movie;
import movieblog.movie.service.MovieService;

@Controller
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/")
    public String home(Model model, HttpSession session) {

        if(session.getAttribute("user") == null) {
            return "redirect:/login"; // 🔐 block access
        }

        model.addAttribute("movies", service.getAllMovies());
        return "index";
    }

    @GetMapping("/add")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "add";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute Movie movie) {
        service.saveMovie(movie);
        return "redirect:/";
    }
 // 🔴 DELETE
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        service.deleteMovie(id);
        return "redirect:/";
    }

    // 🟡 EDIT (open form)
    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable Long id, Model model) {
        Movie movie = service.getMovieById(id);
        model.addAttribute("movie", movie);
        return "add"; // reuse same form
    }
}