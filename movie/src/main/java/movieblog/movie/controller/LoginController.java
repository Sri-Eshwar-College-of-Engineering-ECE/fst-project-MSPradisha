package movieblog.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import movieblog.movie.model.User;

@Controller
public class LoginController {

    // show login page
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // handle login
    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session) {

        // 🔥 simple check (you can change)
        if(user.getUsername().equals("admin") && user.getPassword().equals("1234")) {
            session.setAttribute("user", user);
            return "redirect:/";
        }

        return "login"; // wrong login
    }

    // logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}