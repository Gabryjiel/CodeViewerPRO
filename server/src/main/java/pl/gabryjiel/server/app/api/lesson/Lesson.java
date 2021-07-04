package pl.gabryjiel.server.app.api.lesson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import pl.gabryjiel.server.app.api.subject.Subject;
import pl.gabryjiel.server.app.api.task.Task;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long id;

    @Column(name = "lesson_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "lesson")
    private Set<Task> tasks;
}
