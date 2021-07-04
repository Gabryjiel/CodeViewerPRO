package pl.gabryjiel.server.app.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
}
