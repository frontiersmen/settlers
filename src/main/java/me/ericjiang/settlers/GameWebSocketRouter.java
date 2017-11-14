package me.ericjiang.settlers;

import java.util.List;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import com.google.common.collect.Lists;

@WebSocket
public class GameWebSocketRouter extends MultiplayerModuleWebSocketRouter {

    private Lobby lobby;

    public GameWebSocketRouter(Lobby lobby) {
        this.lobby = lobby;
    }

    @Override
    protected Game getModule(Session session) {
        String gameId = getQueryParameterString(session, "gameId");
        return lobby.getGame(gameId);
    }

    @Override
    protected List<Class<Event>> getEventTypes() {
        return Lists.newArrayList();
    }
}
