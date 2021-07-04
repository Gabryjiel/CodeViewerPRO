package pl.gabryjiel.server.app.api.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CodeService {
    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public List<Code> getCodes() {
        return codeRepository.findAll();
    }

    public Code getCode(Long codeId) {
        Optional<Code> codeOptional = codeRepository.findById(codeId);
        if (codeOptional.isPresent()) {
            return codeOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code with id " + codeId + " was not found.");
        }
    }

    public Code postCode(Code code) {
        return codeRepository.save(code);
    }

    public Code putCode(Long codeId, Code code) {
        Optional<Code> codeOptional = codeRepository.findById(codeId);
        if (codeOptional.isPresent()) {
            Code newCode = codeOptional.get();
            newCode.setContent(code.getContent());
            return codeRepository.save(newCode);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code with id " + codeId + " was not found.");
        }
    }

    public ResponseEntity<String> deleteCode(Long codeId) {
        Optional<Code> codeOptional = codeRepository.findById(codeId);
        if (codeOptional.isPresent()) {
            codeRepository.deleteById(codeId);
            return ResponseEntity.ok("Code with id " + codeId + " was successfully removed.");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code with id " + codeId + " was not found.");
        }
    }
}