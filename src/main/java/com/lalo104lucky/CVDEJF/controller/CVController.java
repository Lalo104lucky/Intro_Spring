package com.lalo104lucky.CVDEJF.controller;

import com.lalo104lucky.CVDEJF.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/cv")
@RequiredArgsConstructor
public class CVController {

    private final Person persona;

    @GetMapping({"/", "", "/index"})
    public String index(Model model) {
//        Person person = new Person("Diego", "Jaimez", "Desarrollador");
//        model.addAttribute("name", "Die");
//        model.addAttribute("person", person);
        model.addAttribute("property", persona.getFirstName());
        return "index";
    }

    //@GetMapping("/lalo")
    @RequestMapping(value = "/lalo", method = RequestMethod.GET)
    public String lalo() {
        return "lalo";
    }
}
