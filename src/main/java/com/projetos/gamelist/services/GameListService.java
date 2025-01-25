package com.projetos.gamelist.services;

import com.projetos.gamelist.dto.GameListDTO;
import com.projetos.gamelist.entities.GameList;
import com.projetos.gamelist.repositories.GameListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> resultGameList =  gameListRepository.findAll();
        List<GameListDTO> gameListDto = resultGameList.stream().map(gameList -> new GameListDTO(gameList)).toList();
        return gameListDto;
    }

}
