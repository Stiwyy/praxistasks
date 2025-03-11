package ch.bbw.tasks;

import ch.bbw.tasks.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TasksRepository tasksRepository;

    public List<Task> getTasks() {
        return tasksRepository.findAll();
    }

    public Optional<Task> getTaskById(long id){
        return tasksRepository.findById(id);
    }

    public Task saveTask(Task task) {
        return tasksRepository.save(task);
    }

    public void deleteTask(long id) {
        tasksRepository.deleteById(id);
    }

}
