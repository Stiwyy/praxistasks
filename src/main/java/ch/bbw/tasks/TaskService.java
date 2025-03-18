package ch.bbw.tasks;

import ch.bbw.tasks.model.Task;
import ch.bbw.tasks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> getTasks() {
        return tasksRepository.findAll();
    }

    public Optional<Task> getTaskById(long id){
        return tasksRepository.findById(id);
    }

    public Task saveTask(Task task, long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User nicht gefunden"));
        task.setUser(user);
        return tasksRepository.save(task);
    }

    public void deleteTask(long id) {
        tasksRepository.deleteById(id);
    }
}
