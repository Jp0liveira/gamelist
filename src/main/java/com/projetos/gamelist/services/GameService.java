package com.projetos.gamelist.services;

import com.projetos.gamelist.dto.GameDTO;
import com.projetos.gamelist.dto.GameMinDTO;
import com.projetos.gamelist.entities.Game;
import com.projetos.gamelist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> resultGameList =  gameRepository.findAll();
        List<GameMinDTO> gameListDto = resultGameList.stream().map(game -> new GameMinDTO(game)).toList();
        return gameListDto;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game resultGame = gameRepository.findById(id).isPresent() ? gameRepository.findById(id).get() : null;
        GameDTO gameDto = new GameDTO(resultGame);
        return gameDto;
    }

}
