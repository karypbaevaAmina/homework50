package kg.attractor.homework50.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/index")
    public String html() {
        return "src/index.html";
    }


    @RequestMapping("/regist")
    public String html2() {
        return "regist.html";
    }


}
