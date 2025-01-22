package com.projetos.gamelist.services;

import com.projetos.gamelist.dto.GameMinDTO;
import com.projetos.gamelist.entities.Game;
import com.projetos.gamelist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll(){
        List<Game> resultGameList =  gameRepository.findAll();
        List<GameMinDTO> gameListDto = resultGameList.stream().map(game -> new GameMinDTO(game)).toList();
        return gameListDto;

    }
}
