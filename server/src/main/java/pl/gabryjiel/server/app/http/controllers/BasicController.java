package pl.gabryjiel.server.app.http.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/api")
    public String home() {
        return "<html><body><h1>@GetMapping(\"/\")</h1></body></html>";
    }

    @GetMapping("/api/page")
    public String page() {
        return "<html><body><h1>@GetMapping(\"/page\")</h1></body></html>";
    }
}
