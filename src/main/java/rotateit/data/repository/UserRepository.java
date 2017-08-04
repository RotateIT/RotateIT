package rotateit.data.repository;

import java.util.List;
import org.springframework.data.repository.Repository;
import rotateit.data.model.User;

public interface UserRepository extends Repository<User, Long> {

    List<User> findAll();
}
