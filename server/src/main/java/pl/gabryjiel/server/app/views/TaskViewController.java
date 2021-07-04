package pl.gabryjiel.server.app.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gabryjiel.server.app.api.task.Task;
import pl.gabryjiel.server.app.api.task.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskViewController {
    private final TaskService taskService;

    @Autowired
    public TaskViewController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String viewTasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("url", "tasks");
        return "tasks";
    }

    @GetMapping("/{taskId}")
    public String viewTaskById(@PathVariable Long taskId, Model model) {
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task", task);
        model.addAttribute("tasks", taskService.getTasksByLessonId(task.getLesson().getId()));
        model.addAttribute("url", "tasks");
        return "task";
    }

    @GetMapping("/create")
    public String viewCreateNewTask(Model model) {
        return "taskCreate";
    }

    @GetMapping("/{taskId}/edit")
    public String viewEditTask(@PathVariable Long taskId, Model model) {
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "taskEdit";
    }

    @PostMapping
    public String saveTask(@ModelAttribute Task task) {
        taskService.postTask(task);
        return "redirect:tasks";
    }
}
