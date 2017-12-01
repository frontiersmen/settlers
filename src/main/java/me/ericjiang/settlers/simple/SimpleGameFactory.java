package me.ericjiang.settlers.simple;

import java.util.Map;
import me.ericjiang.settlers.library.game.GameDao;
import me.ericjiang.settlers.library.game.GameFactory;

public class SimpleGameFactory extends GameFactory<SimpleGame> {

    public SimpleGameFactory(GameDao<SimpleGame> gameDao) {
        super(gameDao);
    }

    @Override
    protected SimpleGame createGameInstance(String id, String owner, Map<String, Object> attributes) {
        return new SimpleGame(id, owner, (String) attributes.get("name"));
    }

}