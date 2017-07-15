package rotateit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rotateit.data.model.User;
import rotateit.data.repository.UserRepository;

@RestController
public class ExampleControler {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    @ResponseBody
    public String printAnyDataFromDb() {
        User user = userRepository.findAll().get(0);
        return user.toString();
    }
}
