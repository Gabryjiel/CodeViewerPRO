package pl.gabryjiel.server.app.api.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return this.subjectRepository.findAll(Sort.by("id"));
    }

    public Subject getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId)
                .orElseThrow(NoSuchElementException::new);
    }

    public Subject postSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject putSubject(Long subjectId, Subject subject) {
        return subjectRepository.findById(subjectId)
                .map(oldSubject -> subjectRepository.save(oldSubject.update(subject)))
                .orElseThrow(NoSuchElementException::new);
    }

    public void deleteSubject(Long subjectId) {
        subjectRepository.findById(subjectId)
                .ifPresentOrElse(lesson -> subjectRepository.deleteById((subjectId)),
                        () -> {throw new NoSuchElementException();});
    }
}
