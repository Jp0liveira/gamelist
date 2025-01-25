package com.projetos.gamelist.services;

import com.projetos.gamelist.dto.GameListDTO;
import com.projetos.gamelist.entities.GameList;
import com.projetos.gamelist.projections.GameMinProjection;
import com.projetos.gamelist.repositories.GameListRepository;
import com.projetos.gamelist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;

    private final GameRepository gameRepository;

    public GameListService(GameListRepository gameListRepository, GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> resultGameList =  gameListRepository.findAll();
        List<GameListDTO> gameListDto = resultGameList.stream().map(gameList -> new GameListDTO(gameList)).toList();
        return gameListDto;
    }

    @Transactional
    public void move(Long listId, Integer sourceIndex, Integer destinationIndex){
        List<GameMinProjection> gameMinProjectionList = gameRepository.searchByList(listId);
        GameMinProjection gameMinProjection = gameMinProjectionList.get(sourceIndex);
        gameMinProjectionList.add(destinationIndex, gameMinProjection);

        Integer min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        Integer max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

       for(Integer i = min; i <= max; i++){
          gameListRepository.updateBelongingPosition(listId, gameMinProjectionList.get(i).getId(), i);
       }
    }

}
