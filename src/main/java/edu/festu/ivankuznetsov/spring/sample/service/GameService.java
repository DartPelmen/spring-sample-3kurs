package edu.festu.ivankuznetsov.spring.sample.service;

import edu.festu.ivankuznetsov.spring.sample.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    List<Game> gameList;
    public GameService(){
        gameList = new ArrayList<>();
        gameList.add(new Game("CHESS"));
        gameList.add(new Game("FOOTBALL"));

    }

    public List<Game> getGameList() {
        return gameList;
    }
    public Boolean addGame(Game game){
        if(game == null || game.getName() == null){
            return false;
        }
        else {
            gameList.add(game);
            return true;
        }
    }

    public Boolean addGame(String name){
            gameList.add(new Game(name));
            return true;
        }

    public Boolean deleteGame(Game game){
        return gameList
                .removeIf(e->e.getName()
                        .equals(game.getName()));
    }
    public Boolean updateGame(Game game){
        var maybeGame = gameList.stream()
                .filter(e->e.getId().equals(game.getId()))
                .findAny();
        if(maybeGame.isPresent()){
            var g = gameList.indexOf(maybeGame.get());
            gameList.set(g,game);
            return true;
        }
        else{
            return false;
        }
    }
}
