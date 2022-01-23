package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {
    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/jokes",""})
    public String getJokes(Model model) {
        model.addAttribute("randomJoke", this.jokeService.getRandomJokes());
        return "jokes";
    }
    public String returnRandomJoke() {
        return this.jokeService.getRandomJokes();
    }
}
