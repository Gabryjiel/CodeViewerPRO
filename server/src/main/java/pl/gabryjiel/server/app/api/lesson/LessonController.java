package pl.gabryjiel.server.app.api.lesson;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public List<Lesson> getLessons() {
        return lessonService.getLessons();
    }

    @GetMapping("/{lessonId}")
    public Lesson getLessonById(@PathVariable Long lessonId) {
        return lessonService.getLessonById(lessonId);
    }

    @PostMapping
    public Lesson postLesson(@RequestBody Lesson lesson) {
        return lessonService.postLesson(lesson);
    }

    @PutMapping("/{lessonId}")
    public Lesson putLesson(@PathVariable Long lessonId, @RequestBody Lesson lesson) {
        return lessonService.putLesson(lessonId, lesson);
    }

    @DeleteMapping("/{lessonId}")
    public ResponseEntity<String> deleteLesson(@PathVariable Long lessonId) {
        lessonService.deleteLesson(lessonId);
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }
}
