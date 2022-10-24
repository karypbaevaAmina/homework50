package kg.attractor.homework50.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

    @RequestMapping("/index")
    public String html() {
        return "index.html";
    }


    @RequestMapping("/main")
    public String html2() {
        return "main.html";
    }


}
