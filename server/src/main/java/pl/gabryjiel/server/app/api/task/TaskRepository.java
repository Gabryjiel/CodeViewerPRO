package pl.gabryjiel.server.app.api.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getTasksByLesson_Id(Long lesson_id);
}
