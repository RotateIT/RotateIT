package rotateit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import rotateit.data.repository.UserRepository;
import rotateit.uidto.UiPullRequest;
import rotateit.uidto.UiTeam;
import rotateit.uidto.UiUser;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController()
public class ExampleControler {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimpleWebSocketHandler webSocketHandler;

    @GetMapping(value = "/api/anyDataFromDb", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<UiUser> printAnyDataFromDb() {
        return userRepository.findAll().stream()
            .map(user -> new UiUser(user.getName(), new UiTeam(user.getTeam().getName())))
            .collect(toList());
    }

    @GetMapping(value = "/api/addUser")
    @ResponseBody
    public UiPullRequest addUser() throws JsonProcessingException {
        UiTeam team = new UiTeam("Gauss");
        UiPullRequest user = new UiPullRequest("Title from java!", "http://onet.pl", team);
        String jsonInString = MAPPER.writeValueAsString(user);
        webSocketHandler.send(new TextMessage(jsonInString));
        return user;
    }
}
