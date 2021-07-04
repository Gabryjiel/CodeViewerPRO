package pl.gabryjiel.server.app.api.lesson;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> getLessonsBySubjectId(Long subjectId);
}
