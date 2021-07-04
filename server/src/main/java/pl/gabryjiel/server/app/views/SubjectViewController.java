package pl.gabryjiel.server.app.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gabryjiel.server.app.api.subject.Subject;
import pl.gabryjiel.server.app.api.subject.SubjectService;

import java.net.http.HttpClient;

@Controller
@RequestMapping("/subjects")
public class SubjectViewController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectViewController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public String viewSubjects(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        model.addAttribute("url", "subjects");
        return "subjects";
    }

    @GetMapping("/{subjectId}")
    public String viewSubjectById(@PathVariable Long subjectId, Model model) {
        model.addAttribute("subject", subjectService.getSubjectById(subjectId));
        model.addAttribute("subjects", subjectService.findAll());
        model.addAttribute("url", "subjects");
        return "subject";
    }

    @GetMapping("/create")
    public String createNewSubject(Model model) {
        model.addAttribute("subject", new Subject());
        return "subjectCreate";
    }

    @PostMapping
    public String saveProject(@ModelAttribute Subject subject) {
        subjectService.postSubject(subject);
        return "redirect:subjects";
    }

    @GetMapping("/{subjectId}/edit")
    public String editSubject(Model model, @PathVariable Long subjectId) {
        model.addAttribute("subject", subjectService.getSubjectById(subjectId));
        return "subjectEdit";
    }
}
