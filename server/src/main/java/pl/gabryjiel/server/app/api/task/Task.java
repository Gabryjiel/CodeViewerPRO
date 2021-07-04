package pl.gabryjiel.server.app.api.task;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import pl.gabryjiel.server.app.api.code.Code;
import pl.gabryjiel.server.app.api.lesson.Lesson;

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

    @Column(name = "task_description", columnDefinition = "text")
    private String description;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @OneToOne(mappedBy = "task")
    private Code code;

    public Task update(Task task) {
        this.setName(task.name);
        this.setLesson(task.lesson);
        return this;
    }
}
