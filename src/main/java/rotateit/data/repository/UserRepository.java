package rotateit.data.repository;

import org.springframework.data.repository.Repository;
import rotateit.data.model.User;

import java.util.List;

public interface UserRepository extends Repository<User, Long> {

    List<User> findAll();
}
