package pl.gabryjiel.server.app.api.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getLessons() {
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(Long lessonId) {
        return lessonRepository.findById(lessonId)
                .orElseThrow(NoSuchElementException::new);
    }

    public Lesson postLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson putLesson(Long lessonId, Lesson lesson) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (lessonOptional.isPresent()) {
            Lesson newLesson = lessonOptional.get();
            newLesson.setName(lesson.getName());
            return lessonRepository.save(newLesson);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void deleteLesson(Long lessonId) {
        lessonRepository.findById(lessonId)
                .ifPresentOrElse(lesson -> lessonRepository.deleteById((lessonId)),
                        () -> {throw new NoSuchElementException();});
    }
}
