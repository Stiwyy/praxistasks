package ch.bbw.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.bbw.tasks.model.Task;

import java.util.Optional;

public interface TasksRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByDescription(String description);
    Optional<Task> findByCompleted(boolean completed);
    Optional<Task> findById(long id);
}
