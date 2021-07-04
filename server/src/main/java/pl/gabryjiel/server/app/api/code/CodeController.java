package pl.gabryjiel.server.app.api.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/codes")
public class CodeController {
    private final CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping()
    public List<Code> findAllCodes() {
        return codeService.getCodes();
    }

    @GetMapping("/{codeId}")
    public Code getCodeById(@PathVariable Long codeId) {
        return codeService.getCode(codeId);
    }

    @PostMapping
    public Code postCode(@RequestBody Code code) {
        return this.codeService.postCode(code);
    }

    @PutMapping("/{codeId}")
    public Code putCode(@PathVariable Long codeId, @RequestBody Code code) {
        return codeService.putCode(codeId, code);
    }

    @DeleteMapping("/{codeId}")
    public ResponseEntity<String> deleteCode(@PathVariable Long codeId) {
        return codeService.deleteCode(codeId);
    }
}
