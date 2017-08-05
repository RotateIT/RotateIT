package rotateit;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rotateit.data.repository.UserRepository;
import rotateit.uidto.UiTeam;
import rotateit.uidto.UiUser;

@RestController()
public class ExampleControler {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/api/anyDataFromDb", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<UiUser> printAnyDataFromDb() {
        return userRepository.findAll().stream()
            .map(user -> new UiUser(user.getName(), new UiTeam(user.getTeam().getName())))
            .collect(toList());
    }
}
