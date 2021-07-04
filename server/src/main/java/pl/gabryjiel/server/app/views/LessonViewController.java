package pl.gabryjiel.server.app.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gabryjiel.server.app.api.lesson.Lesson;
import pl.gabryjiel.server.app.api.lesson.LessonService;

@Controller
@RequestMapping("/lessons")
public class LessonViewController {

    private final LessonService lessonService;

    @Autowired
    public LessonViewController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public String viewLessons(Model model) {
        model.addAttribute("lessons", lessonService.getLessons());
        model.addAttribute("url", "lessons");
        return "lessons";
    }

    @GetMapping("/{lessonId}")
    public String viewLessonById(@PathVariable Long lessonId, Model model) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        model.addAttribute("lesson", lesson);
        model.addAttribute("lessons", lessonService.getLessonsBySubjectId(lesson.getSubject().getId()));
        model.addAttribute("url", "lessons");
        return "lesson";
    }

    @GetMapping("/create")
    public String viewCreateNewLesson(Model model) {
        return "lessonCreate";
    }

    @GetMapping("/{lessonId}/edit")
    public String viewEditLesson(@PathVariable Long lessonId, Model model) {
        model.addAttribute("lesson", lessonService.getLessonById(lessonId));
        return "lessonEdit";
    }

    @PostMapping
    public String saveLesson(@ModelAttribute Lesson lesson) {
        System.out.println("TEST");
        lessonService.postLesson(lesson);
        return "redirect:lessons";
    }
}
