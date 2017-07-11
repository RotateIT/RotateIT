package rotate.it.data.repository;

import org.springframework.data.repository.Repository;
import rotate.it.data.model.User;

import java.util.List;

public interface UserRepository extends Repository<User, Long> {
    List<User> findAll();
}
