package pl.gabryjiel.server.app.api.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(NoSuchElementException::new);
    }

    public Task postTask(Task task) {
        return taskRepository.save(task);
    }

    public Task putTask(Long taskId, Task task) {
        return taskRepository.findById(taskId)
                .map(oldTask -> taskRepository.save(oldTask.update(task)))
                .orElseThrow(NoSuchElementException::new);
    }

    public void deleteTask(Long taskId) {
        taskRepository.findById(taskId)
                .ifPresentOrElse(task -> taskRepository.deleteById(taskId),
                        () -> {throw new NoSuchElementException();});
    }

    public List<Task> getTasksByLessonId(Long lessonId) {
        return taskRepository.getTasksByLesson_Id(lessonId);
    }
}
