package com.projetos.gamelist.controllers;

import com.projetos.gamelist.dto.GameListDTO;
import com.projetos.gamelist.dto.GameMinDTO;
import com.projetos.gamelist.dto.ReplacementDTO;
import com.projetos.gamelist.services.GameListService;
import com.projetos.gamelist.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> gameListDto = gameListService.findAll();
        return gameListDto;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> gamesMinDto = gameService.findByList(listId);
        return gamesMinDto;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void findByList(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO){
        gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getDestinationIndex());
    }

}
