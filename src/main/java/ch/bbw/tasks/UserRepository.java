package ch.bbw.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.bbw.tasks.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(long id);
}
