package pl.gabryjiel.server.app.api.task;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "task_name")
    private String name;

    @Column(name = "lesson_id")
    private Long lessonId;

    public Task update(Task task) {
        this.setName(task.name);
        this.setLessonId(task.lessonId);
        return this;
    }
}
