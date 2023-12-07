package edu.festu.ivankuznetsov.spring.sample.controller;

import edu.festu.ivankuznetsov.spring.sample.model.Game;
import edu.festu.ivankuznetsov.spring.sample.service.GameService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;

    }
    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("games",gameService.getGameList());
        return "index";
    }
    @PostMapping(path="/add",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addGame(Game game){
        gameService.addGame(game);
        return "redirect:/";
    }
}
