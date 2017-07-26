package rotateit;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@Component
public class SimpleWebSocketHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> connectedSessions = newHashMap();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        connectedSessions.put(session.getId(), session);
    }

    public void send(TextMessage message) {
        handleTextMessage(null, message);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, final TextMessage message) {
        connectedSessions.values().forEach(connectedSession -> {
            try {
                connectedSession.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        connectedSessions.remove(session.getId());
    }
}
