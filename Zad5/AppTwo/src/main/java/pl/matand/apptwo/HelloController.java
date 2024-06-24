package pl.matand.apptwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {

    @GetMapping("/helloPass")
    public String getHelloMessagePass() {
        return "Cześć to ja";
    }
    @GetMapping("/helloFail")
    public String getHelloMessageFail() {
        return "Cześć to ja - zle";
    }
}