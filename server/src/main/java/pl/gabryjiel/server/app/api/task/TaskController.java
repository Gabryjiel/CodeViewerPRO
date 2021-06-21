package pl.gabryjiel.server.app.api.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> findAllTasks() {
        return this.taskService.findAll();
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping
    public Task postTask(@RequestBody Task task) {
        return taskService.postTask(task);
    }

    @PutMapping("/{taskId}")
    public Task putTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.putTask(taskId, task);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }
}
