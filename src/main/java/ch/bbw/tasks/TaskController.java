package ch.bbw.tasks;

import ch.bbw.tasks.model.Task;
import ch.bbw.tasks.model.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@CrossOrigin("*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable long id) {
        return taskService.getTaskById(id)
                .orElseThrow(() -> new RuntimeException("Task mit ID " + id + " nicht gefunden"));
    }

    @PostMapping
    public Task saveTask(@RequestBody TaskDTO taskDTO) {
        Task task = new Task();
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.isCompleted());
        return taskService.saveTask(task, taskDTO.getUserId());
    }
}
