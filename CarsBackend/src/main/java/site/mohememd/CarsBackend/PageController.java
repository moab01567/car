package site.mohememd.CarsBackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Handles routes for "/", "/login", and "/main"
    @GetMapping({"/", "/login", "/main"})
    public String getIndexPage() {
        return "/index.html";
    }
}
