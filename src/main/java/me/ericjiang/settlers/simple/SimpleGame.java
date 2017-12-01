package me.ericjiang.settlers.simple;

import me.ericjiang.settlers.library.game.Game;
import me.ericjiang.settlers.library.game.GameSummary;

public class SimpleGame extends Game {

    public SimpleGame(String id, String owner, String name) {
        super(id, owner, name);
    }

    @Override
    public GameSummary summarize() {
        return new SimpleGameSummary(this);
    }

}