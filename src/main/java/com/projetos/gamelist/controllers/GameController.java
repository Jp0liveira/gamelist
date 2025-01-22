package com.projetos.gamelist.controllers;

import com.projetos.gamelist.dto.GameMinDTO;
import com.projetos.gamelist.entities.Game;
import com.projetos.gamelist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> games = gameService.findAll();
        return games;
    }

}
