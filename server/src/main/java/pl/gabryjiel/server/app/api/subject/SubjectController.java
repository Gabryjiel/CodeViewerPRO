package pl.gabryjiel.server.app.api.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> findAllSubjects() {
        return subjectService.findAll();
    }

    @GetMapping("/{subjectId}")
    public Subject getSubjectById(@PathVariable Long subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public Subject postSubject(@RequestBody Subject subject) {
        return subjectService.postSubject(subject);
    }

    @PutMapping("/{subjectId}")
    public Subject putSubject(@PathVariable Long subjectId, @RequestBody Subject subject) {
        return subjectService.putSubject(subjectId, subject);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }
}
