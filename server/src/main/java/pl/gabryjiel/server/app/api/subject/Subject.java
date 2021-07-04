package pl.gabryjiel.server.app.api.subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import pl.gabryjiel.server.app.api.lesson.Lesson;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long id;

    @Column(name = "subject_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private Set<Lesson> lessons;

    public Subject update(Subject subject) {
        setName(subject.getName());
        return this;
    }
}
