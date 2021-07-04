package pl.gabryjiel.server.app.api.code;

import lombok.Getter;
import lombok.Setter;
import pl.gabryjiel.server.app.api.task.Task;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private Long id;

    @Column(name = "code_content", columnDefinition = "text")
    private String content;

    @OneToOne(optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
}
