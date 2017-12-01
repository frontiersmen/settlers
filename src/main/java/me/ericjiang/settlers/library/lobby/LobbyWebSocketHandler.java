package me.ericjiang.settlers.library.lobby;

import java.util.List;

import com.google.common.collect.Lists;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import me.ericjiang.settlers.library.Event;
import me.ericjiang.settlers.library.MultiplayerModuleWebSocketRouter;
import me.ericjiang.settlers.library.auth.Authenticator;

@WebSocket
public class LobbyWebSocketHandler extends MultiplayerModuleWebSocketRouter {

    private final Lobby<?> lobby;

    public LobbyWebSocketHandler(Lobby<?> lobby, Authenticator authenticator) {
        super(authenticator);
        this.lobby = lobby;
    }

    @Override
    protected Lobby<?> getModule(Session session) {
        return lobby;
    }

    @Override
    protected List<Class<? extends Event>> getEventTypes() {
        return Lists.newArrayList(GameCreationEvent.class);
    }
}
