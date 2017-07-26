package rotateit.data.repository;

import org.springframework.data.repository.Repository;
import rotateit.data.model.PullRequest;
import rotateit.data.model.User;

import java.util.List;

public interface PullRequestRepository extends Repository<PullRequest, Long> {

    List<User> findAll();
}
